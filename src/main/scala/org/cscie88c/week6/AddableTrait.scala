package org.cscie88c.week6

// define the trait AddableTrait with parameterized type A below
trait AddableTrait[A] {
  def plus(other: A): A
}

// define the case class MyInt that implements AddableTrait for MyInt type below
case class MyInt(value: Int) extends AddableTrait[MyInt] {
  override def plus(other: MyInt): MyInt = MyInt.apply(value + other.value)

  def apply(a: Int): MyInt = MyInt(a)
}

// define the case class MyBool that implements AddableTrait for MyBool type below
case class MyBool(value: Boolean) extends AddableTrait[MyBool] {
  override def plus(other: MyBool): MyBool = MyBool.apply(value || other.value)

  def apply(a: Boolean): MyBool = MyBool(a)
}
