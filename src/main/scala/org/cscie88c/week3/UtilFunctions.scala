package org.cscie88c.week3

class UtilFunctions {

  def mult2(x: Int, y: Int): Int = x * y

  def pythTest(x: Int, y: Int, z: Int): Boolean = {
    (x ^ 2) + (y ^ 2) == (z ^ 2)
  }

  val pythTriplesUpto100: List[(Int, Int, Int)] = {
    for {
      i <- 1 to 100
      j <- i to 100
      k <- j to 100
      if (pythTest(i, j, k))
    } yield (i, j, k)
  }.toList
}
