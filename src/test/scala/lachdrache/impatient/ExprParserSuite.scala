package lachdrache.impatient

import org.scalatest.FunSuite

class ExprParserSuite extends ExprParser with FunSuite {
  val eval = new ExprParser

  test("number") {
    assert(eval("4") === 4)
  }

  test("subtraction") {
    assert(eval("4-1") === 3)
  }

  test("subtraction is right-associative :-(") {
    assert(eval("10-3-2") === 9)
  }
}
