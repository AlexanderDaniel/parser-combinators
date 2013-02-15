package lachdrache.ast

class ElementaryWithParenthesesExpressionASTSuite extends ElementaryExpressionASTSuite {
  override val eval = new ElementaryWithParenthesesExpressionAST

  test("number in parentheses") {
    assert(eval("(3)") === Num(3))
  }

  test("expression in parentheses") {
    assert(eval("3*(2+1)") === Op("*", Num(3), Op("+", Num(2), Num(1))))
  }
}
