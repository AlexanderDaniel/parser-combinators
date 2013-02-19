package lachdrache.arith

class ParenthesesExprEvaluator extends ElementaryExprEvaluator {
  override def number: Parser[Int] = super.number | "("~>expr<~")"
}
