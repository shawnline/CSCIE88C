package org.cscie88c.week7

import scala.util.{Success, Try}

object OptionUtils {

  def fileCharCount(fileName: String): Try[Long] = Try(
    scala.io.Source.fromResource(fileName).length
  )

  def charCountAsString(fileName: String): String =
    fileCharCount(fileName) match {
      case Success(c) => f"number of characters: $c"
      case _          => "error opening file"
    }
  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
    Try(
      LazyList.from(scala.io.Source.fromResource(fileName).getLines())
    ).toOption
}
