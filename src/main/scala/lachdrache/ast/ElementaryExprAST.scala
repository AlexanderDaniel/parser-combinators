package lachdrache.ast

class ElementaryExprAST extends AddSubExprAST {

  override def expr: Parser[Expr] = term ~ rep(("+" | "-") ~ term) ^^ buildOps

  def term: Parser[Expr] = number ~ rep(("*" | "/") ~ number) ^^ buildOps

}
