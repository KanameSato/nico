package nico

import nico.bf._

case class Nico(reverseOperations: List[Operation]) {
  def ^(op: Operation): Nico = copy(op :: reverseOperations)

  def toBFString: String = reverseOperations.reverse.map(_.bf).mkString
  def execute: Unit = BF.execute(BF.parse(toBFString))
}

object Nico {
  val start: Nico = Nico(Nil)
}
