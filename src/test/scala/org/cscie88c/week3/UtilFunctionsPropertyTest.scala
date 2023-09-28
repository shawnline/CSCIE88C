package org.cscie88c.week3

import org.scalacheck.Prop.{forAll, propBoolean}
import org.scalacheck.{Gen, Properties}
import org.cscie88c.week3.UtilFunctions
import org.scalatest.matchers.should.Matchers.a

object UtilFunctionsPropertyTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {
  val functions = new UtilFunctions()
  test("mult2 result test") {
    forAll { (x: Int, y: Int) =>
      UtilFunctions.mult2(x, y) shouldBe x * y
    }
  }
  property("Distributive Property Works") = forAll { (a: Int, b: Int, c: Int) =>
    functions.mult2(a, b + c) == (functions.mult2(a, b) + functions.mult2(a, c))
  }
  val triplesGen: Gen[(Int, Int, Int)] = {
    val functions = new UtilFunctions()
    functions.pythTriplesUpto100(Gen.choose(0, 99).sample.get)
  }
  property(
    "If (x, y, z) is a pythagorean triple, then (y, x, z) is also a pythagorean triple"
  ) = forAll(triplesGen) { (a: (Int, Int, Int)) =>
    functions.pythTest(a._2, a._1, a._3)
  }
}
