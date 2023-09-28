package org.cscie88c.week2

class UtilFunctions {
  def maximum(a: Int, b: Int): Int = {
    if (a > b) {
      return a
    }
    b
  }

  def average(a: Int, b: Int): Double = {
    (a + b) / 2.0
  }

}
