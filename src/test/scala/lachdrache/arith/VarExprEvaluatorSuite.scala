package lachdrache.arith

class VarExprEvaluatorSuite extends NoBacktrackingExprEvaluatorSuite {
  override val eval = new VarExprEvaluator

  test("one simple assignment with an expression at the end") {
    assert(eval("a=3 a") === 3)
  }

  test("two assignments") {
    assert(eval("a=3 b=2 a+b") === 5)
  }

  test("four assignments") {
    assert(eval("a=3 b=2 c=a+b d=c*100 d/5") === 100)
  }
  
  test("uninitialized variables should be zero") {
    assert(eval("x") === 0)
  }

  test("you can reassign variables") {
    assert(eval("a=3 a=-1 a") === -1)
  }

  test("you may not even use any of the variables in your last expr") {
    assert(eval("a=3 13") === 13)
  }

  test("TODO") {
    assert(eval("a") === 0)
  }

}
