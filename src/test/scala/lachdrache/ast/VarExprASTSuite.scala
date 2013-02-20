package lachdrache.ast

class VarExprASTSuite extends PowerExprASTSuite {
  override val eval = new VarExprAST

  test("simple assignment which is not used in the final expr") {
    assert(eval( """x=3
                   |13""".stripMargin) === Program(List(Var("x", Num(3))), Num(13)))
  }

  test("simple assignment which is used in the final expr") {
    assert(eval( """x=3
                   |x""".stripMargin) === Program(List(Var("x", Num(3))), Use("x")))
  }

  test("multiple assignments") {
    assert(eval( """x=3
                   |y=4
                   |x+y""".stripMargin) === Program(List(Var("x", Num(3)), Var("y", Num(4))), Op("+", Use("x"), Use("y"))))
  }

}
