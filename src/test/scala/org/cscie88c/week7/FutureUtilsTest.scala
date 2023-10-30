package org.cscie88c.week7

import org.cscie88c.testutils.FuturesTest

import java.util.Calendar
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

class FutureUtilsTest extends FuturesTest {

  "Any future function" should {
    "return a future assertion" in {
      def futureAdd2(x: Int) = Future(x + 2)
      futureAdd2(5).map { x =>
        x shouldBe 7
      }
    }
  }

  "FutureFunctions" when {
    "calling future factorial" should {
      "return the correct value" in {
        FutureUtils.futureFactorial(4).map(_ shouldBe 24)
      }
    }
    "calling futurePermutations" should {
      "return the right value" in {
        FutureUtils.futurePermuations(10, 4).map(_ shouldBe 5040)
      }
    }
    "calling creditScoreAPI" should {
      "return a credit score greater than 300 and less than 800" in {
        FutureUtils.creditScoreAPI(30).map(a => a > 300 & a < 800 shouldBe true)
      }
    }
    "calling async average credit score" should {
      "return the correct value" in {
        FutureUtils
          .asyncAverageCreditScore(List(100, 200, 300, 400, 500))
          .map(a => a > 300 & a < 800 shouldBe true)
      }
    }
    "calling sequential factorial" should {
      "return the correct value for sequential factorial" in {
        val startTime = Calendar.getInstance().getTime
        val a = FutureUtils.sequentialFactorial(5)
        val timeDelta = Calendar.getInstance().getTime
        println(f"Sequential Time: ${timeDelta.getTime - startTime.getTime}")
        a shouldBe 120
      }
    }
    "calling concurrent factorial" should {
      "return the correct value for sequential factorial" in {
        val startTime = Calendar.getInstance().getTime
        val a = FutureUtils.concurrentFactorial(5)
        val timeDelta = Calendar.getInstance().getTime
        println(f"Concurrent Time: ${timeDelta.getTime - startTime.getTime}")
        a shouldBe 120
      }
    }
    "Calling print credit score" should {
      "Print the right info" in {
        FutureUtils.printCreditScore(340)
        true shouldBe true
      }
    }
    "Passed credit check" should {
      "Return the right info" in {
        FutureUtils.passedCreditCheck(556).map(_ shouldBe true)
      }
    }
  }
}
