
enum Optional[+T] {
  case None
  case Some(value: T)
}

val myOptional: Optional[String] = Optional.Some("yolo")
val myEmptyOptional: Optional[String] = Optional.None
Optional.None
