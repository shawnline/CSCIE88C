package org.cscie88c.week6

import org.cscie88c.testutils.StandardTest

class KafkaProducerTest extends StandardTest {
  "KafkaClient" should {
    "send a message to the default topic" in {
      val a = KafkaClient.sendStatusEvent("Hi!")
      a.contains("Hi!") shouldBe true
      a.contains("default-topic") shouldBe true
    }
  }
}
