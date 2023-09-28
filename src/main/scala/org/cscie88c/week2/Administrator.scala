package org.cscie88c.week2

class Administrator(
    nameIn: String = "",
    emailIn: String = "",
    budgetIn: Long = 0
) extends UniversityEmployee(nameIn, emailIn) {
  val budget: Long = budgetIn
  override def description(): String = {
    super.description() + ", Budget: $" + budget.toString
  }
}
