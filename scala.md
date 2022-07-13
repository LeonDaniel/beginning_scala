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


    - value functions
    - methods
    - composition
    - sets of parameters

## Higher order functions


### Function as parameters

### Returned functions

## Scala Hello World

```scala
def main(args: Array[String]) = 
  println("Hello world!")
```
