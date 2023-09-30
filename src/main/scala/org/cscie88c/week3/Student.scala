package org.cscie88c.week3

final case class Student(
    name: String,
    email: String,
    subject: String,
    score: Int
) {
  def description: String =
    s"name: ${name}, email: ${email}, subject: ${subject}, score: ${score}"
}

object Student {
  def validateEmail(student: Student): Boolean = {
    student.email.contains('@')
  }

  def averageScoreBySubject(
      subject: String,
      studentList: List[Student]
  ): Double = {
    val a = studentList.filter(_.subject == subject).collect(_.score)
    a.sum / a.size
  }

  def averageScoreByStudent(
      student: Student,
      studentList: List[Student]
  ): Double = {
    val a = studentList.filter(_.name == student.name).collect(_.score)
    a.sum / a.size
  }
}
