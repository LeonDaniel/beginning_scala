package fp.iasi.demo

class C2HighOrderFunctionsSuite extends org.scalatest.funsuite.AnyFunSuite {

  def execute(x: Int, operation: Int => Int): Int = operation(x)

  def binaryOperation(x: Int, y: Int, operation: (Int, Int) => Int): Int = ???

  test("calls functions with another function as parameter") {
    assert(execute(4, (x: Int) => x + 1) == 5)
    assert(execute(5, _ + 1) == 6)
  }

  test("calls binary operations correctly") {
    assert(binaryOperation(1, 4, (x: Int, y: Int) => x + y) == 5)
    assert(binaryOperation(1, 4, _ + _) == 5)

    assert(binaryOperation(5, 2, _ - _) == 1)
  }
}
