package lachdrache.arith

class BetterErrMsgExprEvaluatorSuite extends NoBacktrackingExprEvaluatorSuite {
  override val eval = new BetterErrMsgExprEvaluator

  test("just chars with NoBacktrackingExprEvaluator which has no special err msgs") {
    val e = intercept[IllegalArgumentException] {
      (new NoBacktrackingExprEvaluator)("abc")
    }
    assert(e.getMessage === "Parsing error: `(' expected but `a' found")
  }

  test("just char with better err msg") {
    val e = intercept[IllegalArgumentException] {
      eval("abc")
    }
    assert(e.getMessage === "Number or parenthesis expected but found 'a' at column 1")
  }

  test("number + justChars") {
    val e = intercept[IllegalArgumentException] {
      eval("3+y")
    }
    assert(e.getMessage === "Number or parenthesis expected but found 'y' at column 3")
  }

}
