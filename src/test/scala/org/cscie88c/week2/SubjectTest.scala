package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

class SubjectTest extends StandardTest {
  "Subject Tests" when {
    "CSV Constructor tests" should {
      "Subject Test 1" in {
        val subject = Subject("1,Physics,true")
        subject.id shouldBe 1
        subject.name shouldBe "Physics"
        subject.isStem shouldBe true
      }
      "Subject Test 2" in {
        val subject = Subject("39,Writing,false")
        subject.id shouldBe 39
        subject.name shouldBe "Writing"
        subject.isStem shouldBe false
      }
    }
  }
}
