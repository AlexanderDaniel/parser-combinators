package lachdrache.arith

import org.scalatest.FunSuite

class AddSubExpressionEvaluatorSuite extends FunSuite {

  val eval = AddSubExpressionEvaluator

  test("the number 3") {
    assert(eval("3") === 3)
  }

  test("the number 13") {
    assert(eval("13") === 13)
  }

  test("a negative number") {
    assert(eval("-12") === -12)
  }

  test("the number 0") {
    assert(eval("0") === 0)
  }

  test("the number -0") {
    assert(eval("-0") === 0)
  }

  test("adding two numbers") {
    assert(eval("2+3") === 5)
  }

  test("adding three numbers") {
    assert(eval("2 + 3 + 5") === 10)
  }

  test("subtract two numbers") {
    assert(eval("5-2") === 3)
  }

  test("subtract three numbers") {
    assert(eval("15-5-2") === 8)
  }

  test("mixed add and sub") {
    assert(eval("3+7-10+15+5-7") === 13)
  }

  test("just whitespace should yield an IllegalArgumentException") {
    intercept[IllegalArgumentException] {
      eval("   ")
    }
  }

  test("number with leading 0") {
    assert(eval("019") === 19)
  }

  test("negative number with leading 0") {
    assert(eval("-013") === -13)
  }

}
