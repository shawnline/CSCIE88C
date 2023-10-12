package org.cscie88c.week5

import java.util.UUID
import scala.util.Random

object Streams {
  val rnd = new Random()
  def uuid: String = UUID.randomUUID.toString.replaceAll("-", "")

  case class Dog(name: String, age: Int, hasCurrentShots: Boolean)

  val mult5: LazyList[Int] = LazyList.iterate(5, 19)(a => a + 5)

  val randIntStream: LazyList[Int] = LazyList.continually(rnd.between(0, 15))

  val dogs: LazyList[Dog] =
    LazyList.continually(
      Dog("dog-" + uuid, randIntStream.head, rnd.nextBoolean())
    )

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] =
    dogs.filter(_.hasCurrentShots)

  def averageHealthyAge(allDogs: LazyList[Dog], sampleSize: Int): Double = {
    var sample = sampleSize
    if (allDogs.size > sample) {
      sample =
        allDogs.size // Make sure we are within list size
    }
    if (sampleSize < 1) {
      return 0
    }

    val a = healthyDogs(allDogs.take(sampleSize))
    a.map(_.age).sum / a.size
  }
}
