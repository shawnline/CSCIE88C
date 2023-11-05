package org.cscie88c.week2

case class Subject(
    id: Short,
    name: String,
    isStem: Boolean
)

object Subject {
  def apply(csvRow: String): Subject = {
    val fields = csvRow.split(",")
    Subject(
      id = fields(0).toShort,
      name = fields(1),
      isStem = fields(2).toBoolean
    )
  }
<<<<<<< HEAD
  val allSubjects: List[Subject] = List(
    Subject(1, "Physics", isStem = true),
    Subject(2, "Chemistry", isStem = true),
    Subject(3, "Math", isStem = true),
    Subject(4, "English", isStem = false)
  )
  def stemSubjects: List[Subject] = {
    allSubjects.filter(_.isStem)
  }
=======
    val allSubjects: List[Subject] = List(
      Subject(1, "Physics", isStem = true),
      Subject(2, "Chemistry", isStem = true),
      Subject(3, "Math", isStem = true),
      Subject(4, "English", isStem = false)
    )
    def stemSubjects: List[Subject] = {
      allSubjects.filter(_.isStem)
    }
>>>>>>> d8937e8 (Fixed merge conflict)
}
