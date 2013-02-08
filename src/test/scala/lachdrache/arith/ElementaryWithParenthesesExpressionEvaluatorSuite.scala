package lachdrache.arith

class ElementaryWithParenthesesExpressionEvaluatorSuite extends ElementaryExpressionEvaluatorSuite {

  override val eval = new ElementaryWithParenthesesExpressionEvaluator

  test("parentheses around number") {
    assert(eval("(3)") === 3)
  }

  test("parentheses around add") {
    assert(eval("10*(2+3)") === 50)
  }

  test("parentheses around sub") {
    assert(eval("32/(3-1)") === 16)
  }

  test("combination") {
    assert(eval("(3+2)*(2+3) - 5*(10-5)") === 0)
  }

}
