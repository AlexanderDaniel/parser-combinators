package lachdrache.ast

class ParenthesesExprAST extends ElementaryExprAST {
  override def number: Parser[Expr] = super.number | "("~>expr<~")"
}
