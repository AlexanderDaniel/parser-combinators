package lachdrache.ast

class PowerExpressionASTSuite extends ElementaryWithParenthesesExpressionASTSuite {
  override val eval = new PowerExpressionAST

  test("3^2") {
    assert(eval("2^3") === Op("^", Num(2), Num(3)))
  }
}
