package fp.iasi.demo

enum MyList[+T] {
  case Empty
  case Element(value: T)

  def isEmpty: Boolean = this match
    case MyList.Empty => true
    case MyList.Element(_) => false
}


// tree
enum BinaryTree[T] {
  case Leaf(value: T)
  case Node(left: BinaryTree[T], right: BinaryTree[T])
}

@main def generics(): Unit = {
  val list = MyList.Element(1)
  println(list.isEmpty)
  println(MyList.Empty.isEmpty)
}