package fp.iasi.demo

class C1FunctionsSuite extends org.scalatest.funsuite.AnyFunSuite {

  def inc(x: Int): Int = x + 1
  val increment: Int => Int = (x:Int) => x + 1
  def add(x: Int, y: Int): Int = ???


  test("inc test that succeeds") {
    val obtained = inc(10)
    val expected = 11
    assert(obtained == expected)
  }

  test("method and functions are equivalent") {
    assert(inc(1) == increment(1))
  }

  test("add test that succeeds") {
    val obtained = add(1,1)

    assert(obtained == 2)
  }
}
