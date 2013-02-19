package lachdrache.arith

class ElementaryExprEvaluatorSuite extends AddSubExprEvaluatorSuite {

  override val eval = new ElementaryExprEvaluator

  test("addition") {
    assert(eval("13+7") === 20)
  }

  test("subtraction") {
    assert(eval("13-7") === 6)
  }

  test("multiplication of two numbers") {
    assert(eval("5*3") === 15)
  }

  test("multiplication of three numbers") {
    assert(eval("5*3*10") === 150)
  }

  test("division") {
    assert(eval("10/2") === 5)
  }

  test("mixing mul and div") {
    assert(eval("10*2/4") === 5)
  }

  test("division ignores remainder") {
    assert(eval("10/3") === 3)
  }

  test("precedence of mul") {
    assert(eval("2+3*3") === 11)
  }

  test("precedence of div") {
    assert(eval("2+20/2") === 12)
  }

  test("larger expression") {
    assert(eval("3 + 5*2 - 100/10 + 2*2*2*2") === 19)
  }

}
