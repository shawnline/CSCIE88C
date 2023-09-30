package org.cscie88c.week3

import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

object UtilFunctionsPropertyTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {
  val functions = new UtilFunctions()
  test("mult2 result test") {
    forAll { (x: Int, y: Int) =>
      functions.mult2(x, y) shouldBe x * y
    }
  }
  test("Distributive Property Works") {
    forAll { (a: Int, b: Int, c: Int) =>
      functions
        .mult2(a, b + c) == (functions.mult2(a, b) + functions.mult2(a, c))
    }
  }
  val triplesGen: Gen[(Int, Int, Int)] = {
    val functions = new UtilFunctions()
    functions.pythTriplesUpto100(Gen.choose(0, 99).sample.get)
  }
  test(
    "If (x, y, z) is a pythagorean triple, then (y, x, z) is also a pythagorean triple"
  ) {
    forAll(triplesGen) { (a: (Int, Int, Int)) =>
      functions.pythTest(a._2, a._1, a._3)
    }
  }
}
