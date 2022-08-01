package fp.iasi.demo

import scala.annotation.tailrec

@main def recursive(): Unit = {

  def sum(x: Int): Int = if (x > 0) x + sum(x - 1) else 0

  println(sum(5))

  def factorial(x: Int): Int = if (x > 1) x * factorial(x - 1) else 1

  println(factorial(3))

  def anotherFactorial(n: Int): BigInt = {

    // having the call to itself as the last expression, permits Scala to preserve the stack during recursive calls
    // TAIL RECURSION - use recursive calls as the LAST expression
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, accumulator * x)
    }

    factorialHelper(n, 1)
  }

  println(anotherFactorial(5000))

  def fibonacci(x: Int): Int = {
    if (x == 0 || x == 1) x
    else fibonacci(x - 2) + fibonacci(x - 1)
  }

  println(fibonacci(3))

  def tail_fibonacci(n: Int): BigInt = {

    @tailrec
    def fibHelper(n: Int, previous: BigInt, actual: BigInt): BigInt = {
      if (n == 0) previous
      else {
        if (n == 1) actual
        else fibHelper(n - 1, actual, previous + actual)
      }
    }

    fibHelper(n, 0, 1)
  }

  println(tail_fibonacci(3))
}
