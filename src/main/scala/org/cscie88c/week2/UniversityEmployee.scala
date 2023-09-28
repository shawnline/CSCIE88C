package org.cscie88c.week2

class UniversityEmployee(nameIn: String = "", emailIn: String = "") {

  var name: String = nameIn
  var email: String = emailIn
  def description(): String = {
    "Name: " + name + ", Email: " + email
  }

}
