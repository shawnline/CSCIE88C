package org.cscie88c.week3

import org.cscie88c.testutils.{StandardTest}

class StudentTest extends StandardTest {
  "Student Management System" when {
    "creating a student" should {
      "have properties - name, email, subject and score" in {
        val testStudent =
          Student("Shawn Joseph", "shj006@g.harvard.edu", "CSCI E-88C", 100)
        testStudent.name shouldBe "Shawn Joseph"
        testStudent.email shouldBe "shj006@g.harvard.edu"
        testStudent.subject shouldBe "CSCI E-88C"
        testStudent.score shouldBe 100
      }
    }
    "validate email" should {
      "successfully validate the email" in {
        val testStudent =
          Student("Shawn Joseph", "shj006@g.harvard.edu", "CSCI E-88C", 100)
        Student.validateEmail(testStudent) shouldBe true
      }
      "fail to validate the email" in {
        val testStudent =
          Student("Shawn Joseph", "shj006-g.harvard.edu", "CSCI E-88C", 100)
        Student.validateEmail(testStudent) shouldBe false
      }
    }
    "Student list tests" should {
      // Use the following list
      val studentShawnTest =
        Student("Shawn Joseph", "shj006@g.harvard.edu", "CSCI E-88C", 100)
      val studentJohnTest =
        Student("John Smith", "john.smith@gmail.com", "CSCI E-87A", 84)
      val studentList = List(
        studentShawnTest,
        studentJohnTest,
        Student("Shawn Joseph", "shj006@g.harvard.edu", "CSCI E-87A", 94),
        Student("John Smith", "john.smith@gmail.com", "CSCI E-88C", 90)
      )
      "Average score by student" should {
        "Return the correct score for Shawn" in {
          Student.averageScoreByStudent(
            studentShawnTest,
            studentList
          ) shouldBe 97
        }
        "Return the correct score for John" in {
          Student.averageScoreByStudent(
            studentJohnTest,
            studentList
          ) shouldBe 87
        }
      }
      "Average score by subject" should {
        "Return the correct score for CSCI E-88C" in {
          Student.averageScoreBySubject("CSCI E-88C", studentList) shouldBe 95
        }
        "Return the correct score for John" in {
          Student.averageScoreBySubject("CSCI E-87A", studentList) shouldBe 89
        }
      }
    }
    // write more tests to verify items in acceptance criteria
  }
}
