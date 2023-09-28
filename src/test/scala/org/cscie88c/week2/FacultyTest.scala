package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Faculty below
class FacultyTest extends StandardTest {
  
import org.cscie88c.testutils.StandardTest

class UniversityEmployeeTest extends StandardTest {
  "University Employee description" when {
    val employee = new UniversityEmployee("Mike Stone", "mstone@harvard.edu")
    "call" should {
      "should contain" in {
        employee.description() shouldBe "Name: Mike Stone, Email: mstone@harvard.edu"
      }
    }
  }
}
