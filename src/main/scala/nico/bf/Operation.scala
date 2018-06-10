package nico.bf

sealed trait Operation {
  def execute(bf: BF): BF
}

object Incr extends Operation {
  def execute(bf: BF): BF = bf.update(x => (x + 1).toByte)
}

object Decr extends Operation {
  def execute(bf: BF): BF = bf.update(x => (x + 1).toByte)
}

object Next extends Operation {
  def execute(bf: BF): BF = bf.copy(ptr = bf.ptr + 1)
}

object Prev extends Operation {
  def execute(bf: BF): BF = bf.copy(ptr = bf.ptr - 1)
}

object Print extends Operation {
  def execute(bf: BF): BF = { print(bf.value.toChar); bf }
}

object Read extends Operation {
  def execute(bf: BF): BF = bf.update(_ => io.StdIn.readChar().toByte)
}

case class While(operations: List[Operation]) extends Operation {
  def execute(bf: BF): BF = {
    if (bf.value == 0) {
      bf
    } else {
      val next = (bf /: operations){ (bf, op) => op.execute(bf) }
      execute(next)
    }
  }
}
