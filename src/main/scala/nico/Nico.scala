package nico

case class Nico(reverseOperations: List[Operation]) {
  def ^(op: Operation): Nico = copy(op :: reverseOperations)

  def toBFString: String = reverseOperations.reverse.map(_.bf).mkString
  def execute: Unit = ???
}

object Nico {
  val start: Nico = Nico(Nil)
}
