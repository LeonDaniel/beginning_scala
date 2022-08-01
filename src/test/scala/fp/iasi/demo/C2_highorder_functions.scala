package fp.iasi.demo

@main def main = {
  def execute(x: Int, operation: Int => Int): Int = operation(x)

  execute(9, (x: Int) => x + 1)

  def calculator(x: Int, y: Int, operation: (Int, Int) => Int): Int = operation(x, y)

  val sum = (x: Int, y: Int) => x + y
  println(calculator(4, 5, sum))

  println(calculator(x = 1, y = 2, operation = (x: Int, y: Int) => x + y))

  def operation(name: String): (Int, Int) => Int = {
    if (name == "add") (x: Int, y: Int) => x + y else (x: Int, y: Int) => x - y
  }

}
