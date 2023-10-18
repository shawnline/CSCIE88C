package org.cscie88c.week6

final case class Employee(name: String, age: Int, salary: Int)

object Employee {

  implicit val employeeOrdering: Ordering[Employee] = Ordering.by(_.name)

  implicit val addable: AddableTypeclass[Employee] =
    (a: Employee, b: Employee) =>
      Employee(a.name.concat(b.name), a.age + b.age, a.salary + b.salary)
  def defaultSortEmployees(employees: List[Employee]): List[Employee] =
    employees.sorted

  def sortEmployeesBySalary(employees: List[Employee]): List[Employee] = {
    val ordering = Ordering.by[Employee, Int](_.salary)(Ordering.Int.reverse)
    employees.sorted(ordering)
  }

}
