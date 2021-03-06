## First Steps in Scala

#### with

#### Octav Zaharia
#### &
#### Daniel Leon

### 2022

## Scala


- Scala is a mixed paradigm programming language

- Scala is a statically-typed programming language

- Scala is strong typed

- Scala is not new, it appeared in 2003

- Scala was created by Martin Odersky


## What is Functional Programming (FP)


### FP is a programming paradigm where programs are built by composing functions


## Concepts

- Data is separated from operations

- Values are immutable

- First class functions & Higher order functions

- Pure functions (math functions)

- Recursion

- Data structures

- You can encapsulate but you don't have to

- Same as in Mathematics, operations (ie +,-) are defined on sets.

- Sets are types (ie. Int, String, etc) and operations are functions

## Comparison

### Not FP

```javascript
const numList = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let result = 0;
for (let i = 0; i < numList.length; i++) {
  if (numList[i] % 2 === 0) {
    result += numList[i] * 10;
  }
}
```

### FP way

```javascript
const result = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
               .filter(n => n % 2 === 0)
               .map(a => a * 10)
               .reduce((a, b) => a + b);
```

## However


###Imperative doesn't exclude FP

#### Haskell

```haskell
nameDo :: IO ()
nameDo = do putStr "What is your first name? "
            first <- getLine
            putStr "And your last name? "
            last <- getLine
            let full = first ++ " " ++ last
            putStrLn ("Pleased to meet you, " ++ full ++ "!")
```

#### Scala

```scala
def getOrderDetails(orderId: Int): Future[OrderDetails] =
  for {
    order <- getOrder(orderId) 
    user <- getUser(order.userId)
    product <- getProduct(order.productId)
  } yield OrderDetails(order, user, product)
```

[Wikipedia is wrong](https://en.wikipedia.org/wiki/Functional_programming)


## Back to Scala. Defining values


- Values have types

- Types are verified at compile time

```scala
val n: Int = 1 

val hex: Int = 0xFF

val l: Long = 1L

val hexLong: Int = 0xFFL

val f: Float = 1.0F 

val d: Double = 1.0

val ch: Char = 'A'

val name: String = "John"

val trueOrFalse: Boolean = False

val intArray: Array[Int] = Array(1,2,3)

val intArray: Tree[string] = ???
```

## Type inference


- Scala is an inferred language

- We can avoid writing types when the compiler is fine with it :)

```scala
val a = 1

val l = 1L

val name = "John"
```

## Strings

```scala
val simple = "42"

val escape = "My name is \"...\""

val multiline = """More
  lines
  string"""

val myNameIs = s"My name is $name"

val tooOld = s"I am ${2022-1980} years old"

val helloWorldJohn = s"""${"Hello" + " " + "World"} John!"""
```

## Expressions vs Statements


- everything is an expression, except when is not

```scala
val result = if(true) 1 else 2
```

## Function & Methods

### Functions defined as values

```scala
val sum: (Int, Int) => Int = (x, y) => x + y
val sum = (x:Int, y:Int) => x + y  //inferred
sum(2, 3)
```

### Methods

```scala
def sum(x: Int, y: Int): Int = x + y
def sum(x: Int, y: Int) = x + y //inferred
sum(2, 3)

def fullName(firstName: String, lastName: String = "") = s"$firstName $lastName"
fullName("John") // --> "John "
fullName("John", "de Goes") // --> "John de Goes"
fullName(firstName = "John") //named parameters

//variadic functions
def incAndSum(m: Int*): Int = m.map(_ + 2).sum
incAndSum(1)
incAndSum(1, 2, 3)
incAndSum((1 to 10): _*)

```

### From method to function

```scala
def inc(x: Int) = x + 1

val incVal = inc _
```

## Currying

#### *Currying* - the process of converting a function with multiple parameters into a sequence of functions with only one parameter 

####from Haskell Curry, mathematician

#### Methods (multiple sets of parameters)

```scala
def add(x: Int)(y: Int) = x + y

def inc: Int => Int = add(1)
```

#### Functions

```scala
val add: Int => Int => Int = x => y => x + y

val inc: Int => Int = add(1)
```

### Advanced - Currying vs Partial Application

#### What is Partial Application?

## Composition

**Function composition is an operation that takes two functions *f: A -> B* and *g: B -> C* and produces a function *h: A -> C* that *h(x) = g(f(x))*.**
**In this operation, the function *g* is applied to the result of applying the function *f* to *x*.**

### In Scala 

**compose**

```scala
import scala.math.BigDecimal

val f: Int => String = _.toString
val g: String => BigDecimal = BigDecimal(_)
val h: Int => BigDecimal = g.compose(h)
```

**andThen**

```scala
import scala.math.BigDecimal

val f: Int => String = _.toString
val g: String => BigDecimal = BigDecimal(_)
val h: Int => BigDecimal = f.andThen(g)
```

## First class functions & Higher order functions (HOF) 

#### A language is defined as having first class functions when functions are treated like any other value
#### A HOF is a function that will accept as parameter another function or return another function as a result

```scala
//Function as parameters
val inc = (x: Int) => x + 1
val incAll = (a: Int, b: Int, c: Int, f: Int => Int) => (f(a), f(b), f(c))
incAll(1, 2, 3, inc)

// Returned functions
val calculator: Char => (Int, Int) => Int = op =>
  if(op == '*') (x, y) => x * y
  else if (op == '-') (x, y) => x - y
  else _ + _ //shortcut

val mult: (Int, Int) => Int = calculator('*')
mult(2,3) //--> 6
calculator('-')(2, 3)
calculator('+')(2, 3)

//eta expansion
def times10(i: Int) = i * 10   // a method
List(1, 2, 3).map(times10)     // List(10,20,30)
```

#### Advanced - Implement

```scala
def map[A](a: List[A], f: A => B): List[B] = ???
def bind[A](a: List[A], f: A => List[B]): List[B] = ???
```

## Generic functions & methods (parameter polymorphism)

```scala
val sort0: [T] => Array[T] => Array[T] = [T] => (x: Array[T]) => x

val sort1 = [T] => (x: Array[T]) => x

def sort2[T](arr: Array[T]): Array[T] = arr

def sort3[T](arr: Array[T]) = arr
```

#### Advanced 

#### Given a generic type F of form F[_] how does `map` looks like how about `bind`?

#### Rank2Types (RankNTypes)

```scala
def applySomething[A, B, C](tuple: (B,C), something: A => A) = {
  println(something(tuple._1))
  println(something(tuple._2))
} //doesn't compile

def applySomething_[A, B, C](tuple: (B,C), something: [A] => A => A) = {
  println(something(tuple._1))
  println(something(tuple._2))
} //cool!!!
```


## Recursive functions

#### No special syntax

```scala
def fib1(n: Long): Long = n match {
  case 0 | 1 => n
  case _ => fib1(n - 1) + fib1(n - 2)
}

def fibTR(num: Int): BigInt = {
  @scala.annotation.tailrec
  def fibFcn(n: Int, acc1: BigInt, acc2: BigInt): BigInt = n match {
    case 0 => acc1
    case 1 => acc2
    case _ => fibFcn(n - 1, acc2, acc1 + acc2)
  }

  fibFcn(num, 0, 1)
}
```

## Advanced - Trampolines

```scala
def even(i: Int): Boolean = i match {
  case 0 => true
  case _ => odd(i - 1)
}

def odd(i: Int): Boolean = i match {
  case 0 => false
  case _ => even(i - 1)
}

scala> even(5000)
res3: Boolean = true

scala> even(50000)
java.lang.StackOverflowError
at Trampolines$Stack$.odd(trampolines.scala:14)
at Trampolines$Stack$.even(trampolines.scala:9)
at Trampolines$Stack$.odd(trampolines.scala:14)
at Trampolines$Stack$.even(trampolines.scala:9)
...
at Trampolines$Stack$.even(trampolines.scala:9)
at Trampolines$Stack$.odd(trampolines.scala:14)
```

## Solution

```scala
sealed trait EvenOdd
case class Done(result: Boolean) extends EvenOdd
case class Even(value: Int) extends EvenOdd
case class Odd(value: Int) extends EvenOdd

def even(i: Int): EvenOdd = i match {
  case 0 => Done(true)
  case _ => Odd(i - 1)
}

def odd(i: Int): EvenOdd = i match {
  case 0 => Done(false)
  case _ => Even(i - 1)
}

@tailrec
def run(evenOdd: EvenOdd): Boolean = evenOdd match {
  case Done(result) => result
  case Even(value) => run(even(value))
  case Odd(value) => run(odd(value))
}

scala> run(even(5000000))
res1: Boolean = true  
```

##  Partial functions

#### When a function is not able to produce a return for every single variable input data given to it then that function is termed as Partial function. 
#### It can determine an output for a subset of some practicable inputs only. It can only be applied partially to the stated inputs.

- Partial functions are beneficent in understanding many inconsistent kind of Scala functions.
- It can be interpreted by utilizing case statements.
- It is a Trait, which needs two methods namely isDefinedAt and apply to be implemented.

```scala
val div: PartialFunction[(Int, Int), Double] = {
  case (n, i) if i != 0 => n / i
}

div(12, 3)

div(12, 0)
```

## Types

 ![Types](https://media.geeksforgeeks.org/wp-content/uploads/20200331185642/Scala-Hierarchy.png)

- Types can be created with: `class`, `case class`, `trait`, `enum` , `type`, `opaque type`

```scala
//Examples

trait MyType

class MyClass

abstract class MyClass

case class User(firstName: String, lastName: String)

enum Dice {
  One, Two, Three, Four, Five, Six
}

trait Repository[T] /// what is the type ?

sealed trait OnlyInThisFile

case class Pair[A, B](first: A, second: B)

type IamAnAliasFor = String

```


## Top and Bottom type

  - Top type - `Any`
  - Bottom type - `Nothing`

```scala

enum Opt[T] {
  case Value[T](x: T) extends Opt[T]
  case NoValue[T] extends Opt[T] ///???
  case NoValue extends Opt[Nothing]
}


val a: Opt[String] = Opt.Value("")
val n: Opt[String] = Opt.NoValue


-- [E007] Type Mismatch Error: -------------------------------------------------
1 |val n: Opt[String] = Opt.NoValue
  |                     ^^^^^^^^^^^
  |                     Found:    (Opt.NoValue : Opt[Nothing])
  |                     Required: Opt[String]
  |
  | longer explanation available when compiling with `-explain`
1 error found

enum Opt[+T] {
  case Value[T](x: T) extends Opt[T]
  case NoValue extends Opt[Nothing]
}


val a: Opt[String] = Opt.Value("")
val n: Opt[String] = Opt.NoValue
```

## ADTs

- Sum Types (tagged union, variant, choice type, discriminated union, disjoint union, coproduct)
- Product Types(records)

## Sum Types 

```scala
enum Color(val rgb: Int):
  case Red   extends Color(0xFF0000)
  case Green extends Color(0x00FF00)
  case Blue  extends Color(0x0000FF)
  case Mix(mix: Int) extends Color(mix)

enum Either[+L, +R] {
  case Left[L,R](value: L) extends Either[L, R]
  case Right[L,R](value: R) extends Either[L, R]
}

enum Nat:
  case Zero
  case Succ(n: Nat)
      
enum List[+A]:
  case Nil
  case Cons(head: A, tail: List[A])
```

## Union types

```scala
def choose(b: Boolean): String | Int = 
  if(b) "string" else 42

println(choose(true)) // -> "string"
println(choose(false)) // -> 42
```

### Advanced - GADTs

```scala

enum Box[T](contents: T):
  case IntBox(n: Int) extends Box[Int](n)
  case BoolBox(b: Boolean) extends Box[Boolean](b)

def extract[T](b: Box[T]): T = b match //this function is magic
  case IntBox(n)  => n + 1
  case BoolBox(b) => !b
```

## Product Types 

```scala
case class House(color: Color, door: Door, walls: List[Wall], windows: List[Window])
```

### Constructors - apply

```scala
object House {
   def apply(color: Color) = House(color, Door(), List(Wall(), Wall()), List(Window())
}

val house1 = House(Color("red"))
val house2 = House(Color("black"), Door(), List(Wall(), Wall(), Wall()), List(Window(), Window())

//copy constructors
val house3 = house2.copy(color = Color("blue))
val house4 = house2.copy(color = Color("blue), windows = List())
```

## Intersection types

```scala
trait Resettable:
  def reset(): Unit

trait Growable[A]:
  def add(a: A): Unit

def f(x: Resettable & Growable[String]): Unit =
  x.reset()
  x.add("first")
```

## Opaque types

```scala
object types {
  opaque type UserId = Long

  object UserId {
    def apply(value: Long): UserId = value
  }
}

import types.*

case class User(id: UserId, name: String)

val user = User(123L, "Beth") //doesn't compile

/*
1 |val user = User(123L, "Beth")
  |                ^^^^
  |                Found:    (123L : Long)
  |                Required: types.UserId
  |
  | longer explanation available when compiling with `-explain`
1 error found
*/

val user = User(UserId(123L), "Beth") // compiles

```

## Pattern Matching
 - match on values
 - match on types
 - destructuring
 - guards

```scala
n match {
  case 1 => println("The answer is 1")
  case 2 => println("The answer is 2")
  case _ => println("The answer is 42")
}

sealed trait Device
case class Phone(model: String) extends Device:
  def screenOff = "Turning screen off"

case class Computer(model: String) extends Device:
  def screenSaverOn = "Turning screen saver on..."


def sleep(device: Device): String = device match
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn

opt match {
  case Some(i) => i + 2
  case None => 4
}

def speak(p: Person) = p match {
    case Person(name) if name == "Fred" => println("Yubba dubba doo")
    case Person(name) if name == "Bam Bam" => println("Bam bam!")
    case _ => println("Watch the Flintstones!")
}
```

## Modeling

```scala
case class Pizza(
  crustSize: CrustSize,
  crustType: CrustType,
  toppings: Seq[Topping]
)

// the companion object of case class Pizza
object Pizza:
  // the implementation of `pizzaPrice` from above
  def price(p: Pizza): Double = ...

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

// the companion object of enumeration Topping
object Topping:
  // the implementation of `toppingPrice` above
  def price(t: Topping): Double = t match
    case Cheese | Onions => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75
```

## Advanced - Tree

```scala
sealed abstract class Tree[+T]

case class Node[+T](
  value: T, 
  left: Tree[T] = End, 
  right: Tree[T] = End) extends Tree[T] {
  override def toString = 
   "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
}

case object End extends Tree[Nothing] {
  override def toString = ""
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

def traverseTree[T](root: Tree[T]): String = 
    root match {
      case Node(v, left, right) => s"${traverseTree(left)} ${traverseTree(right)}"
      case End => root.toString
    }
```


## Collections


- `Sequences` are a sequential collection of elements and may be indexed (like an array) or linear (like a linked list)
- `Maps` contain a collection of key/value pairs, like a Java Map, Python dictionary, or Ruby Hash
- `Sets` are an unordered collection of unique elements

#### Operations 

- creating
- accessing
- iterating
- transformations
- filtering
- grouping
- aggregations
- searching
- folding

```scala
val aList = List(1,2,3)
val anotherList = "My" :: "name" :: "is" :: Nil //magic "operators"
val seq = Seq("Mama", "are", "mere") //mutable|immutable
val vec = Vector(90, 23, 122) //generic indexed immutable collection
val range = List.range(1, 10) //defining a range
val map = Map (("k1", "v1"), ("k2", "v2"), ("k3", "v3")) //map is just a bunch of tuples
val sameMap = Map ("k1" -> "v1","k2" -> "v2","k3" -> "v3") //more operator magic

//generic mutable collection
import scala.collection.mutable.ArrayBuffer
val buf = new ArrayBuffer[Int](100_000)
```

## Iterating

```scala
class Col[A] {
  def foreach[B](f: A => B): Unit = ???
}

val lst = List(1,2,3)
lst.foreach(x => println(x) //lst foreach println

val m = Map(...)
m foreach {
    case (k,v) => println(s"$k=$v")
}
```

## Accessing

```scala
val lst = List(1 to 20: _*)

lst.isEmpty //lst.nonEmpty
lst.head //lst.headOption
lst.tail
lst.init
lst.last //lst.lastOption
lst.slice(1,4)
lst.take(3) //lst.takeWhile(_ % 2 == 0)
lst.drop(10) //lst.dropWhil(_ % 2 == 0)
```

## Transformations

```scala
class Col[A] {
  def map[B](f: A => B): Col[B] = ???
}

val lst = List(1,2,3)
lst.map(x => x + 1) //lst map (_ + 1)
```

## Filtering

```scala
class Col[A] {
  def filter(f: A => Boolean): Col[A] = ???
}

val lst = List(1,2,3)
lst.filter(_ % 2 == 0)
lst filter isPrime
```

## Grouping 

```scala
class Col[A] {
  def groupBy[K](f: A => K): Map[K, Col[A]] = ???
}

val lst = List("The", "quick", "brown", "fox", 
                "jumps", "over", "the", "lazy", "dog")

lst.groupBy(_.length) 

//Map(5 -> List(quick, brown, jumps), 
//    4 -> List(over, lazy),     
//    3 -> List(The, fox, the, dog))

lst.groupBy(_.head) foreach println
```

### Aggregations

```scala
val lst = List(1,2,3,4,5)

lst.sum
lst.product
lst.min
lst.max
lst.size //lst.length
```

## Searching

```scala
val lst = List(1,2,3,4,5,6)

lst.find(_ > 3) //Some(4)
lst.count (_ > 3) //3
lst.forall(_ < 7) //true
lst.exists(_ > 42) //false
```

## Folding

```scala
class Col[A] {
  def foldLeft[B](z: B)(op: (B, A) => B): B
  def reduceLeft[B >: A](op: (B, A) => B): B
}

val lst = List("The", "quick", "brown", "fox", 
                "jumps", "over", "the", "lazy", "dog")

lst.foldLeft(0)((a, el) => a + el.length)
lst.foldLeft("")((a, el) => a ++ el)


List.range(1, 100).foldLeft(0)(_ + _)
List.range(1, 100).reduceLeft(_ + _)

//foldRight, reduceRight

lst.reduceRight( (a,b) => a ++ b) //Thequickbrownfoxjumpsoverthelazydog

//reduces and folds have same results when the `op` function is associative, 
//ie. (a op b) op c == a op (b op c)
```

## Stuff to do

- Find the last element of a list
- Find the last but one element of the list
- Find the Kth element of a list.
- Find the number of elements of a list.
- Reverse a list
- Is the list a palindrome
- Eliminate consecutive duplicates of list elements
- Duplicate the elements of a list.
- Remove the Kth element from a list.
- Insert an element at a given position into a list
- Find if a number is prime

## Abstractions - map

```scala
class Box[A] {
  def map[B](f: A => B): Box[B]
}

def randomOpt(): Option[Int] = {
  val v = Random.nextInt(10)
  if(v<5) None else Some(v)
}

//if it has value add 1 if not leave it None

randomOpt().map(_ + 1)

val lst: List[Int] = List(1,2,3)

lst.map( _ + 1)

val eit: Either[String, Int] = Right(23)
eit.map (_ + 1)

val future: Future[Int] = Future.successful(42)

future.map(_ + 1)
```

## Abstractions - flatMap

```scala
def randomOpt(): Option[Int] = {
  val v = Random.nextInt(10)
  if(v < 5) None else Some(v)
}

def sqrtOpt(v: Int): Option[Double] = 
  if(v < 0) None else Some(Math.sqrt(v))
  
val result: Option[Option[Double]] = randomOpt().map { r =>
  sqrtOpt(r)
} // ???

val result: Option[Double] = randomOpt().flatMap { r =>
  sqrtOpt(r)
} 

//syntactic sugar for ^^
val result = for {
  r <- randomOpt()
  s <- sqrtOpt(r)
} yield s

```

## Abstractions - extension methods

```scala
case class Circle(x: Double, y: Double, radius: Double)

extension (c: Circle)
  def circumference: Double = c.radius * math.Pi * 2

val circle = Circle(...)

println(circle.circumference)


extension (s: String)
  def empty = ""

val s = "a very big value"

println(s.empty) // -> 
```

## Abstractions - type classes

### A type class is an abstract, parameterized type that lets you add new behavior to any closed data type without using sub-typing. 

#### No magic

```scala
trait Show[A]:
  def show(a: A): String

class ShowInt extends Show[Int]:
  def show(a: Int) = s"The number is ${a}!"

def toHtml[A](a: A)(showA: Show[A]): String =
  "<p>" + showA.show(a) + "</p>"
```

## A bit of magic

```scala

//def len(a: A): Int = ???

case class Person(firstName: String, lastName: String)

//def len(s: String): Int = s.length
//len(Person("Queen", "Elisabeth")) ???

//we can do better
trait Show[A] {
  def show(a: A): String
}

given Show[String] with
  def show(s: String) = s
  
given Show[Person] with
  def show(p: Person) = s"${p.firstName} ${p.lastName}"

def len[A: Show](a: A): Int =
  summon[Show[A]]
    .show(a)
    .length

len(Person("Queen", "Elisabeth")) // -> 15
```

## More magic

```scala

case class Person(firstName: String, lastName: String)

trait Show[A]:
  extension (a: A) def show: String

given Show[String] with
  extension (s: String) def show = s

given Show[Person] with
  extension (p: Person) def show = s"${p.firstName} ${p.lastName}"

def len[A: Show](a: A) = a.show.length

len(Person("Queen", "Elisabeth")) // -> 15
```

## Dependent types

```scala
trait Key { 
  type Value 
}

trait DB {
  def get(k: Key): Option[k.Value] // a dependent method
}

object Name extends Key { type Value = String }
object Age extends Key { type Value = Int }

val db: DB = ...
val res1: Option[String] = db.get(Name)
val res2: Option[Int] = db.get(Age)
```






