package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

class StudentTest extends StandardTest {
  "CSV Constructor Tests" should {
    "Student Test 1" in {
      val student = Student("4,Hello,Goodbye,person@email.com,Female,France")
      student.id shouldBe 4
      student.firstName shouldBe "Hello"
      student.lastName shouldBe "Goodbye"
      student.email shouldBe "person@email.com"
      student.country shouldBe "France"
    }
    "Student Test 2" in {
      val student = Student("49,Shawn,Joseph,shj006@g.harvard.edu,Male,USA")
      student.id shouldBe 49
      student.firstName shouldBe "Shawn"
      student.lastName shouldBe "Joseph"
      student.email shouldBe "shj006@g.harvard.edu"
      student.country shouldBe "USA"
    }
  }
  "Student Name Tests" should {
    "Student Name Test 1" in {
      Student.studentNamesByCountry("China") shouldBe List(
        "Emmy Conrart",
        "Jesse Chismon",
        "Jocelyn Blaxlande"
      )
    }
    "Student Name Test 2" in {
      Student.studentNamesByCountry("United States") shouldBe List(
        "Marin Blasoni",
        "Delmore Scriver"
      )
    }
    "Student Name Test 3" in {
      Student.studentNamesByCountry("Korea") shouldBe List()
    }
  }
  "Student Totals Tests" should {
    "Student Totals Test 1" in {
      Student.studentTotalsByCountry("China") shouldBe 3
    }
    "Student Totals Test 2" in {
      Student.studentTotalsByCountry("United States") shouldBe 2
    }
    "Student Totals Test 3" in {
      Student.studentTotalsByCountry("Japan") shouldBe 0
    }
  }
}
