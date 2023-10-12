package org.cscie88c.week5

import org.cscie88c.testutils.{StandardTest}
import FunctionUtils.CustomerTransaction

// run using: sbt "testOnly org.cscie88c.week5.FunctionUtilsTest"
class FunctionUtilsTest extends StandardTest {
  "FunctionUtils" when {
    // Problem 1 unit tests
    "calling colorToCode" should {
      "return the correct value for white" in {
        FunctionUtils.colorToCode("white") shouldBe (255, 255, 255)
      }
      "return the correct value for lime" in {
        FunctionUtils.colorToCode("lime") shouldBe (0, 255, 0)
      }

      "return the correct value for black" in {
        FunctionUtils.colorToCode("black") shouldBe (0, 0, 0)
      }

      "return the correct value for red" in {
        FunctionUtils.colorToCode("red") shouldBe (255, 0, 0)
      }

      "return the correct value for blue" in {
        FunctionUtils.colorToCode("blue") shouldBe (0, 0, 255)
      }

      "return the correct value for yellow" in {
        FunctionUtils.colorToCode("yellow") shouldBe (255, 255, 0)
      }
    }

    "calling fizzBuzzString" should {
      "return FizzBuzz for a multiple of 3 and 5" in {
        FunctionUtils.fizzBuzzString(510) shouldBe "FizzBuzz"
      }
      "return Buzz for a multiple of 5 not 3" in {
        FunctionUtils.fizzBuzzString(505) shouldBe "Buzz"
      }
      "return Fizz for a multiple of 3 not 5" in {
        FunctionUtils.fizzBuzzString(513) shouldBe "Fizz"
      }
      "return 512 for a multiple of neither 3 nor 5" in {
        FunctionUtils.fizzBuzzString(512) shouldBe "512"
      }
    }

    "calling fizzBuzz" should {
      "return the correct value for 6" in {
        FunctionUtils.fizzBuzz(6) shouldBe List(
          "1",
          "2",
          "Fizz",
          "4",
          "Buzz",
          "Fizz"
        )
      }
    }

    // Problem 2 unit tests
    "calling tanDegrees" should {
      "not work for 90 degrees" in {
        FunctionUtils.tanDegrees.isDefinedAt(90) shouldBe false
      }
      "not work for -90 degrees" in {
        FunctionUtils.tanDegrees.isDefinedAt(-90) shouldBe false
      }
      "return the correct value for 0" in {
        FunctionUtils.tanDegrees(0) shouldBe 0.0 +- 1e-12
      }
      "return the correct value for 45" in {
        FunctionUtils.tanDegrees(45) shouldBe 1.0 +- 1e-12
      }
      "return the correct value for 180" in {
        FunctionUtils.tanDegrees(180) shouldBe 0.0 +- 1e-12
      }
      "return the correct value for 360" in {
        FunctionUtils.tanDegrees(360) shouldBe 0.0 +- 1e-12
      }
    }
    "calling totalHighValueTransactions" should {
      "Return the right sum for 3 items" in {
        FunctionUtils.totalHighValueTransactions(
          List(
            CustomerTransaction("", "", 99),
            CustomerTransaction("", "", 110),
            CustomerTransaction("", "", 1000),
            CustomerTransaction("", "", 150),
            CustomerTransaction("", "", 30)
          )
        ) shouldBe 1260
      }
      "Return the right sum for 0 items" in {
        FunctionUtils.totalHighValueTransactions(
          List(
            CustomerTransaction("", "", 99),
            CustomerTransaction("", "", 70),
            CustomerTransaction("", "", 34),
            CustomerTransaction("", "", 20),
            CustomerTransaction("", "", 30)
          )
        ) shouldBe 0
      }
      "Return the right sum for 5 elements" in {
        FunctionUtils.totalHighValueTransactions(
          List(
            CustomerTransaction("", "", 199),
            CustomerTransaction("", "", 110),
            CustomerTransaction("", "", 1000),
            CustomerTransaction("", "", 150),
            CustomerTransaction("", "", 300)
          )
        ) shouldBe 1759
      }
    }
    // Problem 3 unit tests
    "calling flip2" should {
      "Return the right value" in {
        FunctionUtils.flip2(math.pow)(5, 2) shouldBe 32.0
      }
    }
    "calling sampleList" should {
      "Return the right value for strings" in {
        FunctionUtils.sampleList(
          List("A", "B", "C", "D", "E", "F", "G", "H")
        ) shouldBe List("A", "B", "C", "D", "E")
      }
      "Return the right value for ints" in {
        FunctionUtils.sampleList(
          List(1, 3, 5, 7, 9, 11, 13, 15, 17)
        ) shouldBe List(1, 3, 5, 7, 9)
      }
    }
    // Bonus unit tests
  }

}
