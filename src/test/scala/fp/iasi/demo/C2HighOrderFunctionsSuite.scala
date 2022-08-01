package fp.iasi.demo

class C2HighOrderFunctionsSuite extends org.scalatest.funsuite.AnyFunSuite {

  def execute(x: Int, operation: Int => Int): Int = operation(x)

  def calculator(x: Int, y: Int, operation: (Int, Int) => Int): Int = ???

  val f: Int => String = x => x.toString
  val g: String => BigDecimal = x => BigDecimal(x)

  val int2bigdecimal: Int => BigDecimal = g.compose(f)
  val int2bigdecimalAnd: Int => BigDecimal = f.andThen(g)
 
  test("calls functions with another function as parameter") {
    assert(execute(4, (x: Int) => x + 1) == 5)

    val inc = (x: Int) => x + 1
    assert(execute(5, inc) == 6)
  }

  test("calls binary operations correctly") {
    assert(calculator(1, 4, (x: Int, y: Int) => x + y) == 5)
    assert(calculator(1, 4, _ + _) == 5)

    assert(calculator(5, 2, _ - _) == 1)
  }
}
