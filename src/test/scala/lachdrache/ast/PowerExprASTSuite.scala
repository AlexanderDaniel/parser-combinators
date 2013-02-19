package lachdrache.ast

class PowerExprASTSuite extends ElementaryWithParenthesesExprASTSuite {
  override val eval = new PowerExprAST

  test("3^2") {
    assert(eval("2^3") === Op("^", Num(2), Num(3)))
  }
}
