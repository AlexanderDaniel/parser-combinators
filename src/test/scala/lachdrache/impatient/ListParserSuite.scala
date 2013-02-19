package lachdrache.impatient

import org.scalatest.FunSuite

class ListParserSuite extends FunSuite {
  val eval = new ListParser

  test("empty list") {
    assert(eval("()") === List())
  }

  test("list with one element") {
    assert(eval("(1)") === List(1))
  }

  test("list with two elements") {
    assert(eval("(1,2)") === List(1, 2))
  }

  test("list with three elements") {
    assert(eval("(100,99,-1)") === List(100, 99, -1))
  }

  test("has to start with parenthesis") {
    intercept[IllegalArgumentException] {
      eval("100")
    }
  }

}
