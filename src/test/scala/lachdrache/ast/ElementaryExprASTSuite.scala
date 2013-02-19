package lachdrache.ast

class ElementaryExprASTSuite extends AddSubExprASTSuite {
  override val eval = new ElementaryExprAST

  test("multiplication") {
    assert(eval("3*2") === Op("*", Num(3), Num(2)))
  }

  test("division") {
    assert(eval("10/2") === Op("/", Num(10), Num(2)))
  }

  test("precedence") {
    assert(eval("1+2*3") === Op("+", Num(1), Op("*", Num(2), Num(3))))
  }

  test("multiplication with 3 terms") {
    assert(eval("1*2*3") === Op("*", Op("*", Num(1), Num(2)), Num(3)))
  }
}
