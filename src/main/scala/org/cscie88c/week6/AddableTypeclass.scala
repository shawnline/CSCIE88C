package org.cscie88c.week6

// Write a generic trait AddableTypeclass parameterized by type A
trait AddableTypeclass[A] {
  def addTwoValues(a: A, b: A): A
}

object AddableTypeclass {

  implicit val intAddableTypeclass: AddableTypeclass[Int] = (a: Int, b: Int) =>
    a + b

  implicit val boolAddableTypeclass: AddableTypeclass[Boolean] =
    (a: Boolean, b: Boolean) => a || b

}

object AddableAggregator {
  def sumWithAddable[A](list: List[A])(implicit
      addable: AddableTypeclass[A]
  ): A = list.reduce(addable.addTwoValues)
}
