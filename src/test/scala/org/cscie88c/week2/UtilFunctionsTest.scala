package org.cscie88c.week2

import org.cscie88c.testutils.StandardTest

class UtilFunctionsTest extends StandardTest {
  val functions = new UtilFunctions()
  "Average Tests" should {
    "Average test 1" in {
      functions.average(4, 8) shouldBe 6
    }
    "Average test 2" in {
      functions.average(7, 4) shouldBe 5.5
    }
    "Average test 3" in {
      functions.average(11, 84) shouldBe 47.5
    }
    "Average Test 4" in {
      functions.average(-400, 31) shouldBe -184.5
    }
  }
  "Maximum Tests" should {
    "Maximum Test 1" in {
      functions.maximum(0, 3) shouldBe 3
    }
    "Maximum Test 2" in {
      functions.maximum(-300, -200) shouldBe -200
    }
    "Maximum Test 3" in {
      functions.maximum(4595, 2) shouldBe 4595
    }
    "Maximum Test 4" in {
      functions.maximum(-500, 24346) shouldBe 24346
    }
  }
}
