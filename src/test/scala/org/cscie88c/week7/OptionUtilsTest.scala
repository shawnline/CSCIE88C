package org.cscie88c.week7

import org.cscie88c.testutils.StandardTest

import scala.util.Success

class OptionUtilsTest extends StandardTest {
  "OptionUtils" when {
    "calling fileCharCount" should {
      "return the correct number of characters in a valid file" in {
        OptionUtils
          .fileCharCount(
            "data/dirty-retail-data-sample.csv"
          )
          .get shouldBe 195
      }
    }
    "calling charCountAsString" should {
      "return the correct value" in {
        OptionUtils
          .charCountAsString(
            "data/dirty-retail-data-sample.csv"
          ) shouldBe "number of characters: 195"
        OptionUtils
          .charCountAsString(
            "data/dirty-retail-data-sample.csv-x"
          ) shouldBe "error opening file"
      }
    }
    "calling lineStreamFromFile" should {
      "return the correct value" in {
        OptionUtils
          .lineStreamFromFile(
            "data/dirty-retail-data-sample.csv"
          ) shouldBe Some(
          LazyList(
            "customer_id,trans_date,tran_amount",
            "CS5295,11-Feb-13,35",
            "CS4768,15-Mar-15,39",
            "CS2122,26-Feb-13,52x",
            "CS1217,16-Nov-11,99",
            "CS1850,20-Nov-13,78",
            "CS5539,26-Mar-14,81y",
            "CS2724,06-Feb-12,93",
            "CS590230-Jan-1589"
          )
        )
        OptionUtils
          .lineStreamFromFile(
            "data/dirty-retail-data-sample333.csv"
          ) shouldBe None
      }
    }
  }

}
