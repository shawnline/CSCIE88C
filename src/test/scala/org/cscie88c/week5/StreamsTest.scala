package org.cscie88c.week5

import org.cscie88c.testutils.{StandardTest}

class StreamsTest extends StandardTest {

  "Mult5" should {
    "return the correct value" in {
      Streams.mult5.toList shouldBe List(5, 10, 15, 20, 25, 30, 35, 40, 45, 50,
        55, 60, 65, 70, 75, 80, 85, 90, 95)
    }
  }
  // Bonus problem unit tests
  "HealthyDogs" should {
    "Return the correct value for 5 dogs" in
      Streams
        .healthyDogs(Streams.dogs.take(5))
        .foreach(_.hasCurrentShots shouldBe true)
    "Return the correct value for 20 dogs" in
      Streams
        .healthyDogs(Streams.dogs.take(20))
        .foreach(_.hasCurrentShots shouldBe true)

  }
  "AverageHealthyAge" should {
    "Return the correct value for 5 all healthy dogs" in {
      val b = Streams.healthyDogs(Streams.dogs).take(5)
      Streams.averageHealthyAge(b, 5) shouldBe b.map(_.age).sum / 5.0
    }
    "Return the correct value for 5 some healthy dogs" in {
      val b = Streams.dogs.take(5)
      val c = b.filter(_.hasCurrentShots)
      Streams.averageHealthyAge(b, 5) shouldBe c.map(_.age).sum / c.size
    }
    "Return the correct value for 20 all healthy dogs" in {
      val b = Streams.healthyDogs(Streams.dogs).take(20)
      Streams.averageHealthyAge(b, 20) shouldBe b.map(_.age).sum / 20.0
    }
    "Return the correct value for 20 some healthy dogs" in {
      val b = Streams.dogs.take(20)
      val c = b.filter(_.hasCurrentShots)
      Streams.averageHealthyAge(b, 20) shouldBe c.map(_.age).sum / c.size
    }
  }
}
