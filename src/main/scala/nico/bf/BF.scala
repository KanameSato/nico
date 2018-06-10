package nico.bf

case class BF(mem: Vector[Byte], ptr: Int) {
  def value: Byte = mem(ptr)
  def update(f: Byte => Byte): BF = copy(mem = mem.updated(ptr, f(this.value)))
}
