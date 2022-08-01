package fp.iasi.demo

class C7_pattern_matching extends org.scalatest.funsuite.AnyFunSuiteLike {
  // ca switch - values
  // pe tipuri -
  // destructuring - guards

  //use tree from generics
}

def printTree[T](tree: BinaryTree[T]): Unit = tree match
  case BinaryTree.Leaf(value) => println(value)
  case BinaryTree.Node(left, right) =>
    printTree(left)
    printTree(right)

@main def patternMatching(): Unit = {
  val number = Option(7)

  number match {
    case None => println("oh no! anyway...")
    case Some(x) => println(x)
    case Some(x) if x % 2 == 0 => println("")
  }

}
