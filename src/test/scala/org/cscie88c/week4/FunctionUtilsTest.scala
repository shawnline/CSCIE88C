package org.cscie88c.week4

import org.cscie88c.testutils.StandardTest

class FunctionUtilsTest extends StandardTest {

  "FunctionUtils" when {
    def add5(x: Int): Int = {
      x + 5
    }
    "calling applyNtimes" should {
      "return the correct value" in {
        FunctionUtils.applyNtimes(3)(0)(add5) shouldBe 15
        FunctionUtils.applyNtimes(4)(3)(add5) shouldBe 23
        FunctionUtils.applyNtimes(5)(17)(add5) shouldBe 42
      }
    }
    "calling myPositivePower" should {
      "return the correct value" in {
        FunctionUtils.myPositivePower(3, 7) shouldBe Math.pow(3, 7).toInt
        FunctionUtils.myPositivePower(2, 14) shouldBe Math.pow(2, 14).toInt
      }
    }
    "calling deferred executor" should {
      "return the correct value" in {
        FunctionUtils.deferredExecutor("CPU Pool")(add5)(4) shouldBe 9
      }
    }

    // write unit tests for other functions here
  }

}
