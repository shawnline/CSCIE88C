package org.cscie88c.week6

import org.cscie88c.testutils.StandardTest
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

class AddableTraitTest extends StandardTest {

  "plus" should {

    "add two MyInt values correctly" in {
      val a: Gen[MyInt] = for {
        intGen <- Gen.long suchThat (_ < Int.MaxValue)
      } yield MyInt(intGen.toInt)
      forAll(a, a) { (a: MyInt, b: MyInt) =>
        a.plus(a).value == a.value + b.value
      }
      MyInt(4).plus(MyInt(17)) shouldBe MyInt(21)
    }

    "add two MyBool values correctly" in {
      // These are all possible inputs
      MyBool(true).plus(MyBool(true)) shouldBe MyBool(true)
      MyBool(false).plus(MyBool(true)) shouldBe MyBool(true)
      MyBool(true).plus(MyBool(false)) shouldBe MyBool(true)
      MyBool(false).plus(MyBool(false)) shouldBe MyBool(false)
    }
  }
}
