package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Faculty below
class FacultyTest extends StandardTest {
  "Faculty Test" when {
    "Mike Stone Test" when {
      val name = "James Henry"
      val email = "jhenry@harvard.edu"
      val courseId = "History101"
      val employee =
        new Faculty(name, email, courseId)
      "contains name" in {
        employee.description() contains name
      }
      "contains email" in {
        employee.description() contains email
      }
      "contains course ID" in {
        employee.description() contains courseId
      }
    }
    "Professor Test" when {
      val name = "Edward Sumitra"
      val email = "esumitra@fas.harvard.edu"
      val courseId = "CSCIE-88C"
      val employee =
        new Faculty(name, email, courseId)
      "contains name" in {
        employee.description() contains name
      }
      "contains email" in {
        employee.description() contains email
      }
      "contains course ID" in {
        employee.description() contains courseId
      }
    }
  }
}
