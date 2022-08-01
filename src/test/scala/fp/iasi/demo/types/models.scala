package fp.iasi.demo.types

opaque type Name = String
object Name {
  def apply(v: String): Name = v
}

case class Person(name: Name, address: String)
