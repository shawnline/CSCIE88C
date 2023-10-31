package org.cscie88c.week8

import com.typesafe.scalalogging.LazyLogging

import scala.util.Try
import scala.io.Source
import org.cscie88c.config.ConfigUtils
import pureconfig.generic.auto._

// write case class here

// run with: sbt "runMain org.cscie88c.week8.SimpleApp2"
object SimpleApp2 extends LazyLogging {

  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
    Try {
      LazyList.from(Source.fromResource(fileName).getLines())
    }.toOption

  def monthLines(month: String)(lines: LazyList[String]): LazyList[String] =
    lines.filter(_.contains(month))

  case class SimpleApp2Config(
      fileName: String,
      month: String
  )

  def main(args: Array[String]): Unit = {
    val config =
      ConfigUtils.loadAppConfig[SimpleApp2Config]("org.cscie88c.simple-app-2")
    lineStreamFromFile(config.fileName) match {
      case Some(a) =>
        println(
          s"Transactions in ${config.month}: ${monthLines(config.month)(a).length}"
        )
      case None => println(s"No Transactions found for ${config.month}")
    }
  }
}
