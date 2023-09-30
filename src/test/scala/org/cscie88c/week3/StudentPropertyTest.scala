package org.cscie88c.week3
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class StudentPropertyTest
    extends AnyFunSuite
    with Matchers
    with ScalaCheckPropertyChecks {

  val studentGen: Gen[Student] = for {
    emailPrefix <- Gen.alphaStr
    emailSuffix <- Gen.alphaStr
    name <- Gen.alphaStr
    score <- Gen.choose(0, 100)
    subject <- Gen.alphaStr
  } yield Student(name, s"$emailPrefix@$emailSuffix", subject, score)

  // complete the student list generator below if attempting bonus problem
  // val studentListGen: Gen[List[Student]] = ???

  test("description contains name and email") {
    forAll(studentGen) { (a: Student) =>
      true
    }
  }
}
