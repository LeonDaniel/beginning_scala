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
```

### From method to function

```scala

def inc(x: Int) = x + 1

val incVal = inc _

```

### Currying

#### *Currying* - the process of converting a function with multiple parameters into a sequence of functions with only one parameter 

*from Haskell Curry, mathematician*

#### Methods (multiple sets of parameters)

```scala

def add(x: Int)(y: Int) = x + y

def inc = add(1)

```
**Result**

```
def add(x: Int)(y: Int): Int

def inc: Int => Int
```

#### Functions

```scala

val add: Int => Int => Int = x => y => x + y

add(1)

```

**Result**

```
val add: Int => Int => Int = Lambda$2981/0x00000008016d03e0@7c73542f

val inc: Int => Int = Lambda$2982/0x00000008016d0b78@5266b6c3
```

### Advanced

#### Currying vs Partial Application

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

- #### A language is defined as having first class functions when functions are treated like any other value
- #### A HOF is a function that will accept as parameter another function or return another function as a result



#### Function as parameters

```scala

val inc = (x: Int) => x + 1

val incAll = (a: Int, b: Int, c: Int, f: Int => Int) => (f(a), f(b), f(c))

incAll(1, 2, 3, inc)

```

#### Returned functions

```scala

val calculator: Char => (Int, Int) => Int = op =>
  if(op == '*') (x, y) => x * y
  else if (op == '-') (x, y) => x - y
  else _ + _ //shortcut

val mult: (Int, Int) => Int = calculator('*')

mult(2,3) //--> 6

calculator('-')(2, 3)

calculator('+')(2, 3)

```

### Advanced

#### Implement

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

### Advanced 

#### Given a generic type F of form F[_] how does `map` looks like how about `bind`?

#### Rank2Types (RankNTypes)

```Scala
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

### Advanced

#### Trampolines

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
at Trampolines$Stack$.odd(trampolines.scala:14)
at Trampolines$Stack$.even(trampolines.scala:9)
...
at Trampolines$Stack$.even(trampolines.scala:9)
at Trampolines$Stack$.odd(trampolines.scala:14)
```

#### Solution

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
### Advanced

### Partial functions


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



## ADT

## Smart constructors

## Type alias & Opaque

## Pattern Matching
 - switch
 - types
 - destructuring
 - guards

## Collections

## Abstractions

