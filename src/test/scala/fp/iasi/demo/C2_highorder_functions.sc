//def inc(x: Int, operation: Int => Int): Int = operation(x)
//inc(1, _ + 1)

//class MyInt {
//  def plus(z: MyInt): MyInt = ???
//  def +(x: MyInt): MyInt = ???
//}
//val a: MyInt = ???
//val b: MyInt = ???
//a plus b
//val c: MyInt = a + b
////eta expansion
//def times10(i: Int) = i * 10   // a method
//List(1, 2, 3).map(times10)
//def calculator(x: Int, y: Int, operation: (Int, Int) => Int): Int = operation(x, y)

def map[A,B](a: List[a], f:A =>B): List[B] =
  a.map(f)

def bind[A,B](a:List[A], f: A => List[B]):List[B] =
  map(a, f).flatten

// function composition
//val f: Int => String = x => x.toString
//val g: String => BigDecimal = x => BigDecimal(x)

//val int2bigdecimal: Int => BigDecimal = g.compose(f)
//val int2bigdecimalAnd: Int => BigDecimal = f.andThen(g)
//int2bigdecimal(1)
//int2bigdecimalAnd(5)
// write a function that receives a string as a parameter and
// returns the sum function if the string is "add" and the subtraction function otherwise
