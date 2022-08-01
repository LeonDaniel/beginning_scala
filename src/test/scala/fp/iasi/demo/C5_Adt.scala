package fp.iasi.demo

// class example with apply
class Person(name: String) {
  def sayMyName(): Unit = println(name)
}

object Person {
  def apply(i: Int) = new Person(i.toString)
}
case class Test()

// product type - case class
// sum types - enums,generic enums,  either, union types A|B

@main def adt(): Unit = {
  new Person("Yolo").sayMyName()
  Person(1).sayMyName()
}