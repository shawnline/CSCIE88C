package org.cscie88c.week4

import org.cscie88c.testutils.StandardTest

class ListUtilsTest extends StandardTest {
  "ListUtils" when {
    "calling ones" should {
      "return the correct value" in {
        val a = ListUtils.ones(400)
        a.length shouldBe 400
        a.forall(_ == 1) shouldBe true
      }
    }
    "calling zeroes" should {
      "return the correct value" in {
        val a = ListUtils.zeros(400)
        a.length shouldBe 400
        a.forall(_ == 0) shouldBe true
      }
    }
    "calling charCounts" should {
      "return the correct value for Hello world" in {
        val a = ListUtils.charCounts("Hello world")
        a.getOrElse('H', 0) shouldBe 1
        a.getOrElse('e', 0) shouldBe 1
        a.getOrElse('l', 0) shouldBe 3
        a.getOrElse('o', 0) shouldBe 2
        a.getOrElse('w', 0) shouldBe 1
        a.getOrElse('r', 0) shouldBe 1
        a.getOrElse('d', 0) shouldBe 1
        a.keys.exists(_ == ' ') shouldBe false
      }
      "return the correct value for The Quick Brown Fox Jumps Over the Lazy Dog" in {
        val a =
          ListUtils.charCounts("the quick brown fox jumps over the lazy dog")
        a.keys.exists(_ == ' ') shouldBe false
        for (i: Char <- 'a' to 'z') {
          a.keys.exists(_ == i) shouldBe true
        }
      }
    }
    "calling topN" should {
      "Return the top N characters correctly" in {
        ListUtils.topN(2)(
          ListUtils.charCounts("hello world")
        ) shouldBe ListUtils.charCounts("llloo")
      }
    }

    // write unit tests for zeroes, and other functions here
  }

}
