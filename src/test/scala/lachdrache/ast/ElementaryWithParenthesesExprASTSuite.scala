package lachdrache.ast

class ElementaryWithParenthesesExprASTSuite extends ElementaryExprASTSuite {
  override val eval = new ParenthesesExprAST

  test("number in parentheses") {
    assert(eval("(3)") === Num(3))
  }

  test("expression in parentheses") {
    assert(eval("3*(2+1)") === Op("*", Num(3), Op("+", Num(2), Num(1))))
  }
}
