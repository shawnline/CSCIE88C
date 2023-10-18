package org.cscie88c.week4

object TrigUtils {

  // https://www.scala-lang.org/api/2.13.6/scala/math/index.html
  // use the function literal syntax for sin and cosx
  val sinDegrees: Double => Double = x => math.sin(math.toRadians(x))
    val cosDegrees: Double => Double = x => math.cos(math.toRadians(x))

  // use the placeholder syntax for squared
  val squared: Double => Double = math.pow(_, 2)

}
