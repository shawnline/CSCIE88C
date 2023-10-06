package org.cscie88c.week4

object FunctionUtils {

  def applyNtimes(n: Int)(x: Int)(f: Int => Int): Int = {
    var a = x
    for (_ <- 1 to n)
      a = f(a)
    a
  }

  def myPositivePower(x: Int, n: Int): Int = applyNtimes(n - 1)(x)(_ * x)

  def deferredExecutor(name: String)(f: Int => Int): Int => Int = {
    def ret(x: Int): Int = {
      print("running on deferred executor " + name + " with value " + x)
      f(x)
    }
    ret
  }
}
