package org.cscie88c.week5

object FunctionUtils {

  case class CustomerTransaction(
      customerId: String,
      transactionDate: String,
      transactionAmount: Double
  )

  // Problem 1
  def colorToCode(color: String): (Int, Int, Int) = color.toLowerCase match {
    case "black"  => (0, 0, 0)
    case "white"  => (255, 255, 255)
    case "red"    => (255, 0, 0)
    case "lime"   => (0, 255, 0)
    case "blue"   => (0, 0, 255)
    case "yellow" => (255, 255, 0)
  }

  def fizzBuzzString(n: Int): String = n match {
    case _ if n % 3 == 0 && n % 5 == 0 => "FizzBuzz"
    case _ if n % 3 == 0               => "Fizz"
    case _ if n % 5 == 0               => "Buzz"
    case _                             => n.toString
  }

  def fizzBuzz(n: Int): List[String] = (1 to n).map(fizzBuzzString).toList

  // Problem 2
  def tanDegrees: PartialFunction[Double, Double] = {
    case x if x != 90 && x != -90 => Math.tan(Math.toRadians(x))
  }

  def totalHighValueTransactions(
      transactionList: List[CustomerTransaction]
  ): Double = transactionList
    .collect({ case a if a.transactionAmount > 100 => a.transactionAmount })
    .sum

  // Problem 3
  def flip2[A, B, C](f: (A, B) => C): (B, A) => C = {
    def returnFn(first: B, second: A): C = f(second, first)
    returnFn
  }

  // Write a generic function sampleList parameterized by type A, that returns the first 5 elements of a list of type A.
  def sampleList[A](inputList: List[A]): List[A] = inputList.take(5)

  def deferredExecutor[A, B](name: String)(f: A => B): A => B = {
    def ret(x: A): B = {
      print("running on deferred executor " + name + " with value " + x)
      f(x)
    }
    ret
  }
}
