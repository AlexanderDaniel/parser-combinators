package lachdrache.stackoverflow

import org.scalatest.FunSuite

class MyParserSuite extends FunSuite {
  val eval = new MyParser

  test("just a var") {
    assert(eval("var x=value") === List())
  }

  test("accessing stored var") {
    assert(eval(
      """var x=value
        |x""".stripMargin) === List("value"))
  }

  test("let's get crazy: defining a variable named var") {
    assert(eval(
      """var var=crazy
        | var""".stripMargin) === List("crazy"))
  }
}
