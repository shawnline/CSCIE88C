package org.cscie88c.week7

import scala.concurrent.Future
import scala.util.{Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.parallel.CollectionConverters._

object FutureUtils {

  val rnd = new Random()

  def creditScoreAPI(applicantId: Int): Future[Int] = Future(
    Random.between(300, 800)
  )

  def printCreditScore(applicantId: Int): Unit =
    creditScoreAPI(applicantId).onComplete({
      case Success(value) =>
        print(f"The credit score for $applicantId is $value")
      case _ => print(f"Cannot get credit score for $applicantId at this time")
    })

  def passedCreditCheck(applicantId: Int): Future[Boolean] =
    creditScoreAPI(applicantId).map(_ > 600)

  def futureFactorial(n: Int): Future[Int] =
    n match {
      case _ if 1 < n =>
        futureFactorial(n - 1).map(_ * n)
      case _ => Future(1)
    }

  def futurePermuations(n: Int, r: Int): Future[Int] = for {
    num <- futureFactorial(n)
    den <- futureFactorial(n - r)
  } yield (num.toDouble / den.toDouble).toInt

  def asyncAverageCreditScore(idList: List[Int]): Future[Double] =
    Future
      .sequence(idList.map(creditScoreAPI))
      .map(b => b.sum.toDouble / b.size.toDouble)

  def slowMultiplication(x: Long, y: Long): Long = {
    Thread.sleep(1000)
    x * y
  }

  def concurrentFactorial(n: Long): Long = n match {
    case _ if 1 < n =>
      (1.toLong to n).par.reduce((a: Long, b: Long) => slowMultiplication(a, b))
    case _ => 1
  }

  def sequentialFactorial(n: Long): Long = n match {
    case _ if 1 < n =>
      (1.toLong to n).reduce((a: Long, b: Long) => slowMultiplication(a, b))
    case _ => 1
  }

}
