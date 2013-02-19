package lachdrache.arith

class BetterErrMsgExprEvaluator extends NoBacktrackingExprEvaluator {
  override def apply(input: String): Int = parseAll(expr, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, next) =>
      throw new IllegalArgumentException(s"$msg but found '${next.first}' at column ${next.pos.column}")
  }

  override def number: Parser[Int] =
    super.number | "(" ~> expr <~ ")" | failure(s"Number or parenthesis expected")

}
