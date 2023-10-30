package org.cscie88c.week7

import scala.io.Source
import scala.util.Try

final case class CustomerTransaction(
    customerId: String,
    transactionDate: String,
    transactionAmount: Double
)

object CustomerTransaction {
  def apply(csvString: String): Option[CustomerTransaction] = {
    val fields = csvString.split(",")
    Try(CustomerTransaction(fields(0), fields(1), fields(2).toDouble)).toOption
  }

  def readFromCSVFile(fileName: String): List[CustomerTransaction] =
    Try(
      Source
        .fromResource(fileName)
        .getLines()
    ).getOrElse(List[String]())
      .map(CustomerTransaction.apply)
      .collect { case Some(a) =>
        a
      }
      .toList

}
