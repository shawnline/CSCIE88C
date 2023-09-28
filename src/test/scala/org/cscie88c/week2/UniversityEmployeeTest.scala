package org.cscie88c.week2

import org.cscie88c.testutils.StandardTest

class UniversityEmployeeTest extends StandardTest {
  "University Employee description" when {
    "Mike Stone Test" should {
      val name = "Mike Stone"
      val email = "mstone@harvard.edu"
      val employee = new UniversityEmployee(name, email)
      "contains name" in {
        employee.description() contains name
      }
      "contains email" in {
        employee.description() contains email
      }
    }
    "Professor Test" should {
      val name = "Edward Sumitra"
      val email = "esumitra@fas.harvard.edu"
      val employee = new UniversityEmployee(name, email)
      "contains name" in {
        employee.description() contains name
      }
      "contains email" in {
        employee.description() contains email
      }
    }
  }
}
