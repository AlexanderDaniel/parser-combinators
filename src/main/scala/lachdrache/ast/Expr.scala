package lachdrache.ast

sealed trait Expr
case class Num(n: Int) extends Expr
case class Op(operator: String, left: Expr, right: Expr) extends Expr
case class Var(name: String, value: Expr) extends Expr
/** Usage of variable */
case class Use(name: String) extends Expr
/** Program with multiple assignments and one expr at the end */
case class Program(vars: List[Var], expr: Expr) extends Expr
