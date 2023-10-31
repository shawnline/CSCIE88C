package org.cscie88c.week8

import com.typesafe.scalalogging.{LazyLogging, Logger}

import scala.util.{Failure, Success, Try}
import scala.io.Source

// run using: sbt "runMain org.cscie88c.week8.SimpleApp1 <args>"
object SimpleApp1 extends LazyLogging {

  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
    Try {
      LazyList.from(Source.fromResource(fileName).getLines())
    }.toOption

  def monthLines(month: String)(lines: LazyList[String]): LazyList[String] =
    lines.filter(_.contains(month))

  def main(args: Array[String]): Unit = {
    val month = "Jan"
    if (args.length < 1)
      println("Path to data file is required!")
    else
      lineStreamFromFile(args(0)) match {
        case Some(a) =>
          println(s"Transactions in ${args(0)}: ${monthLines(month)(a).length}")
        case None => println(s"No Transactions found for $month")
      }
  }
}
