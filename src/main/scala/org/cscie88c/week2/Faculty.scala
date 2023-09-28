package org.cscie88c.week2

class Faculty(
    nameIn: String = "",
    emailIn: String = "",
    courseIdIn: String = ""
) extends UniversityEmployee(nameIn, emailIn) {
  val courseId: String = courseIdIn
  override def description(): String = {
    Faculty.super.description() + ", Course: " + courseId
  }
}
