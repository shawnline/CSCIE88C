package org.cscie88c.week2

final case class Student(
    var id: Short,
    var firstName: String,
    var lastName: String,
    var email: String,
    var gender: String,
    var country: String
)

object Student {
  def apply(csvRow: String): Student = {
    val fields = csvRow.split(",")
    Student(
      id = fields(0).toShort,
      firstName = fields(1),
      lastName = fields(2),
      email = fields(3),
      gender = fields(4),
      country = fields(5)
    )

  }
  val allStudents: List[Student] = List(
    Student(1, "Emmy", "Conrart", "econrart0@gizmodo.com", "Male", "China"),
    Student(
      2,
      "Marin",
      "Blasoni",
      "mblasoni1@edublogs.org",
      "Female",
      "United States"
    ),
    Student(3, "Jesse", "Chismon", "jchismon2@hostgator.com", "Male", "China"),
    Student(
      4,
      "Delmore",
      "Scriver",
      "dscriver3@boston.com",
      "Male",
      "United States"
    ),
    Student(
      5,
      "Jocelyn",
      "Blaxlande",
      "jblaxlande4@europa.eu",
      "Female",
      "China"
    )
  )
  def studentNamesByCountry(country: String): List[String] = {
    allStudents
      .filter(_.country == country)
      .map(student => student.firstName + " " + student.lastName)
  }
  def studentTotalsByCountry(country: String): Int = {
    allStudents.count(_.country == country)
  }
}
