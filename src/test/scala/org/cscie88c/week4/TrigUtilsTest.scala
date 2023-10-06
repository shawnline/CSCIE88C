package org.cscie88c.week4

import org.cscie88c.testutils.StandardTest

class TrigUtilsTest extends StandardTest {

  "TrigUtils" when {
    "calling sin" should {
      "return the correct value for 0" in {
        TrigUtils.sinDegrees(0) shouldEqual 0.0 +- 1e-16
      }
      "return the correct value for 90" in {
        TrigUtils.sinDegrees(90) shouldEqual 1.0 +- 1e-16
      }
    }
    "calling cos" should {
      "return the correct value for 0" in {
        TrigUtils.cosDegrees(0) shouldEqual 1.0 +- 1e-16
      }
      "return the correct value for 90" in {
        TrigUtils.cosDegrees(90) shouldEqual 0.0 +- 1e-16
      }
    }
    "calling squared" should {
      "Return the correct value for 0" in {
        TrigUtils.squared(0) shouldBe 0
      }
      "Return the correct value for 90" in {
        TrigUtils.squared(90) shouldBe 8100
      }
      "Return the correct value for -30" in {
        TrigUtils.squared(-30) shouldBe 900
      }
    }

    // write tests for cos and squared below
  }
}
