package lachdrache.ast

sealed trait Expr
case class Num(n: Int) extends Expr
case class Op(operator: String, left: Expr, right: Expr) extends Expr
