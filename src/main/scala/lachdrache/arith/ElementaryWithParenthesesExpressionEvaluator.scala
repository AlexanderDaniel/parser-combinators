package lachdrache.arith

class ElementaryWithParenthesesExpressionEvaluator extends ElementaryExpressionEvaluator {
  override def number: Parser[Int] = super.number | "("~>expr<~")"
}
