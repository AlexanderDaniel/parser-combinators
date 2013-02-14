package lachdrache.ast

import org.scalatest.FunSuite

class AddSubExpressionASTSuite extends FunSuite {
  val eval = new AddSubExpressionAST

  test("number") {
    assert(eval("3") === Num(3))
  }

  test("two numbers with +") {
    assert(eval("3+2") === Op("+", Num(3), Num(2)))
  }

  test("two numbers with -") {
    assert(eval("10-9") === Op("-", Num(10), Num(9)))
  }

  test("three numbers with +") {
    assert(eval("1+2+3") === Op("+", Op("+", Num(1), Num(2)), Num(3)))
  }

  test("three numbers with -") {
    assert(eval("3-2-1") === Op("-", Op("-", Num(3), Num(2)), Num(1)))
  }

}
