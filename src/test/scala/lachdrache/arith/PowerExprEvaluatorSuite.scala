package lachdrache.arith

class PowerExprEvaluatorSuite extends ElementaryWithParenthesesExprEvaluatorSuite {
  override val eval = new PowerExprEvaluator

  test("2^3") {
    assert(eval("2^3") === 8)
  }
  
  test("4^2^3") {
    assert(eval("4^2^3") === eval("4^(2^3)"))
  }

  test("operator precedence: + and ^") {
    assert(eval("10+2^2") === eval("10+(2^2)"))
  }

  test("operator precedence: * and ^") {
    assert(eval("3*2^2") === eval("3*(2^2)"))
  }

  test("operator precedence: +, * and ^") {
    assert(eval("7+3*2^2") === eval("7+(3*(2^2))"))
  }

}
