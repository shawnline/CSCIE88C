package org.cscie88c.week6

import org.cscie88c.testutils.StandardTest
import org.scalacheck.Prop.forAll

class AddableTypeclassTest extends StandardTest {

  "AddableAggregator" should {
    "sum a list of integers" in {
      forAll { (x: List[Int]) =>
        AddableAggregator.sumWithAddable(x) == x.sum
      }
      AddableAggregator.sumWithAddable(List(1, 42, 15, 7, 12)) shouldBe 77
    }
    "sum a list of booleans" in {
      AddableAggregator.sumWithAddable(List(false, false, false)) shouldBe false
      AddableAggregator.sumWithAddable(List(false, false, true)) shouldBe true
      forAll { (x: List[Boolean]) =>
        AddableAggregator.sumWithAddable(x) == x.contains(true)
      }
    }
    "sum a list of employees" in {
      AddableAggregator.sumWithAddable(
        List(
          Employee("a", 1, 1),
          Employee("cgbfd", 133, 432),
          Employee("wfeg", 4636, 235)
        )
      ) shouldBe Employee("acgbfdwfeg", 4770, 668)
    }
  }
}
