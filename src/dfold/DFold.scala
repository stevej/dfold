
def exampleUse {
  val sum: Int = DFold.foldr[Int]((_ + _), List(1, 2, 3))
  println("foldr[Int]((_ + _), List(1, 2, 3))")
  println(sum)

  val rv = DFold.map[Int, List[Int]]((_ * 2), List(1, 2, 3))
  println("map[Int, List[Int]]((_ * 2), List(1, 2, 3))")
  println(rv)
}

object DFold {
  def foldr[T, U](f: (T, U) => U, start: U, ts: List[T]) : U = ts match {
    case Nil => start
    case x :: xs => f (x, foldr (f, start, xs))
  }

  def sum[T](numbers: List[T]) = foldr[T, T]((_ + _), 0, numbers)

  def product[T](numbers: List[T]) = foldr[T, T]((_ * _), 1, numbers)

  def and[T](bools: List[T]) = foldr[T, T]((_ && _), true, bools)

  def or[T](bools: List[T]) = foldr[T, T]((_ || _), false, bools)

  // returns a list with f() run against each element.
  def map[T](f: T => T, xs: List[T]): List[T] = foldr[T, List[T]]((f(_) :: _), Nil, xs)
}
