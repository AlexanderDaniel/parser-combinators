package lachdrache.ast

import util.parsing.combinator.JavaTokenParsers

class AddSubExpressionAST extends JavaTokenParsers {
  def apply(input: String): Expr = parseAll(expr, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, in) => throw new IllegalArgumentException(s"Parsing error: $msg. Input: $in")
  }

  def expr: Parser[Expr] = number ~ rep(("+" | "-") ~ number) ^^ {
    case n0 ~ l => l.foldLeft(n0) {
      case (z, op~n) => Op(op, z, n)
    }
  }

  def number: Parser[Expr] = wholeNumber ^^ (s => Num(s.toInt))

}
