package lachdrache.ast

class ElementaryExpressionAST extends AddSubExpressionAST {

  override def expr: Parser[Expr] = term ~ rep(("+" | "-") ~ term) ^^ buildOps

  def term: Parser[Expr] = number ~ rep(("*" | "/") ~ number) ^^ buildOps

}
