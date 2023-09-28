package org.cscie88c.week2

import org.cscie88c.testutils.StandardTest

class AdministratorTest extends StandardTest {
  "Mike Stone Test" when {
    val name = "Mike Stone"
    val email = "mstone@harvard.edu"
    val budget = 1500800
    val employee =
      new Administrator(name, email, budget)
    "contains name" in {
      employee.description() contains name
    }
    "contains email" in {
      employee.description() contains email
    }
    "contains budget" in {
      employee.description() contains budget.toString
    }
  }
  "Professor Test" when {
    val name = "Edward Sumitra"
    val email = "esumitra@fas.harvard.edu"
    val budget = 2500883
    val employee =
      new Administrator(name, email, budget)
    "contains name" in {
      employee.description() contains name
    }
    "contains email" in {
      employee.description() contains email
    }
    "contains budget" in {
      employee.description() contains budget.toString
    }
  }
}
