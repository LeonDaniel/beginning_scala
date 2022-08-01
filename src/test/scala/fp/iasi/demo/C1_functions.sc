// method - no return as everything is a expression in Scala
//def inc(x: Int): Int = x + 1
//inc(5)


// function as a value
//val increment: Int => Int = (x: Int) => x + 1
//increment(5)

// 2 argument function
//def add(x: Int, y: Int): Int = ???

// default parameters
//def multiply(x: Int, factor: Int = 1): Nothing = ???

//def addition(x: Int)(y: Int) = x + y
//val t= addition(1)
//t(2)

def f(x: Int, y:Int, z: Int): Int = x *y
val g: (Int, Int) => Int = f(1, _, _)

// generic function
//def identity[T](t: T): T = t
//val id = [T] => (t: T) => t