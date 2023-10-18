package org.cscie88c.week6

import org.cscie88c.testutils.StandardTest

class EmployeeTest extends StandardTest {
  "Employee" should {

    "have a default sort order" in {
      Employee.defaultSortEmployees(
        List(
          Employee("c", 35463, 3456543),
          Employee("a", 323545, 323524),
          Employee("e", 352334, 33542),
          Employee("z", 3536, 33463)
        )
      ) shouldBe List(
        Employee("a", 323545, 323524),
        Employee("c", 35463, 3456543),
        Employee("e", 352334, 33542),
        Employee("z", 3536, 33463)
      )
      Employee.defaultSortEmployees(
        List(
          Employee("fsbfbf", 32, 43),
          Employee("rtegsd", 3255, 2346521),
          Employee("34twgr", 2413, 73543),
          Employee("egrheth", 352643, 735442235),
          Employee("gehrwyeagdb", 5764213, 32615),
          Employee("agehrneghrsfb", 36424, 648753)
        )
      ) shouldBe List(
        Employee("34twgr", 2413, 73543),
        Employee("agehrneghrsfb", 36424, 648753),
        Employee("egrheth", 352643, 735442235),
        Employee("fsbfbf", 32, 43),
        Employee("gehrwyeagdb", 5764213, 32615),
        Employee("rtegsd", 3255, 2346521)
      )
    }

    "sort employees by salary" in {
      Employee.sortEmployeesBySalary(
        List(
          Employee("c", 35463, 3456543),
          Employee("a", 323545, 323524),
          Employee("e", 352334, 33542),
          Employee("z", 3536, 33463)
        )
      ) shouldBe List(
        Employee("c", 35463, 3456543),
        Employee("a", 323545, 323524),
        Employee("e", 352334, 33542),
        Employee("z", 3536, 33463)
      )
      Employee.sortEmployeesBySalary(
        List(
          Employee("fsbfbf", 32, 43),
          Employee("rtegsd", 3255, 2346521),
          Employee("34twgr", 2413, 73543),
          Employee("egrheth", 352643, 735442235),
          Employee("gehrwyeagdb", 5764213, 32615),
          Employee("agehrneghrsfb", 36424, 648753)
        )
      ) shouldBe List(
        Employee("egrheth", 352643, 735442235),
        Employee("rtegsd", 3255, 2346521),
        Employee("agehrneghrsfb", 36424, 648753),
        Employee("34twgr", 2413, 73543),
        Employee("gehrwyeagdb", 5764213, 32615),
        Employee("fsbfbf", 32, 43)
      )
    }
  }
}
