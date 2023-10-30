package org.cscie88c.week7

import org.cscie88c.testutils.StandardTest

class CustomerTransactionTest extends StandardTest {
  "CustomerTransaction" should {
    "Apply method should not work" in {
      CustomerTransaction.apply("") shouldBe None
    }
    "Apply method should work" in {
      CustomerTransaction
        .apply("A,A,1.754")
        .get shouldBe CustomerTransaction("A", "A", 1.754)
    }
    "load and clean raw CSV data file" in {
      CustomerTransaction
        .readFromCSVFile("data/dirty-retail-data-sample.csv")
        .length shouldBe 5
    }
    "fail to load CSV data file" in {
      CustomerTransaction
        .readFromCSVFile("data/dirty-retail-data-sample33.csv")
        .length shouldBe 0
    }
  }
}
