package lachdrache.ast

class ElementaryWithParenthesesExpressionAST extends ElementaryExpressionAST {
  override def number: Parser[Expr] = super.number | "("~>expr<~")"
}
