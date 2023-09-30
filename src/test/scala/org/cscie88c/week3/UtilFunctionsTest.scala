package org.cscie88c.week3

import org.cscie88c.testutils.{StandardTest}

class UtilFunctionsTest extends StandardTest {
  "UtilFunctions" when {
    "with pythTriplesUpto100" should {
      "verify elements in list are pythagorean triples" in {
        val a = new UtilFunctions()
        a.pythTest(
          a.pythTriplesUpto100.head._1,
          a.pythTriplesUpto100.head._2,
          a.pythTriplesUpto100.head._3
        ) shouldBe true
        a.pythTest(
          a.pythTriplesUpto100(11)._1,
          a.pythTriplesUpto100(11)._2,
          a.pythTriplesUpto100(11)._3
        ) shouldBe true
        a.pythTest(
          a.pythTriplesUpto100(17)._1,
          a.pythTriplesUpto100(17)._2,
          a.pythTriplesUpto100(17)._3
        ) shouldBe true

      }
    }
  }
}
