package nico

sealed trait Operation {
  val bf: String
}

object o extends Operation { val bf = "+" }
object u extends Operation { val bf = "-" }
object c extends Operation { val bf = ">" }
object e extends Operation { val bf = "<" }
object v extends Operation { val bf = "." }
object a extends Operation { val bf = "," }
object p extends Operation { val bf = "[" }
object q extends Operation { val bf = "]" }

object end extends Operation { val bf = "" }
object endline extends Operation { val bf = "" }
