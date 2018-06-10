package nico.bf

case class BF(mem: Vector[Byte], ptr: Int) {
  def value: Byte = mem(ptr)
  def update(f: Byte => Byte): BF = copy(mem = mem.updated(ptr, f(this.value)))
}

object BF {
  def parse(s: String): List[Operation] = parse(s.toList)

  def parse(list: List[Char], reverseLog: List[Operation] = Nil): List[Operation] = list match {
    case Nil     => reverseLog.reverse
    case (x::xs) if x == '+' => parse(xs, Incr  :: reverseLog)
    case (x::xs) if x == '-' => parse(xs, Decr  :: reverseLog)
    case (x::xs) if x == '>' => parse(xs, Next  :: reverseLog)
    case (x::xs) if x == '<' => parse(xs, Prev  :: reverseLog)
    case (x::xs) if x == '.' => parse(xs, Print :: reverseLog)
    case (x::xs) if x == ',' => parse(xs, Read  :: reverseLog)
    case (x::xs) if x == '[' => 
      val (block, over) = splitLevel(xs)
      parse(over, While(parse(block)) :: reverseLog)
  }

  private def splitLevel(list: List[Char], level: Int = 0, reverseLog: List[Char] = Nil)
                                                               :(List[Char], List[Char]) = list match {
    case Nil => throw new Exception("']' not found")
    case (x::xs) if x == ']' && level == 0 => (reverseLog.reverse, xs)
    case (x::xs) if x == ']'               => splitLevel(xs, level - 1, reverseLog)
    case (x::xs)                           => splitLevel(xs, level, reverseLog)
  }
}
