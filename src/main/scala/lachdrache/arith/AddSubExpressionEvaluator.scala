package lachdrache.arith

import util.parsing.combinator.JavaTokenParsers

/**
 * Very simple parser combinator which can handle arithmetic expressions with addition and subtraction
 *
 * Please see test suite for examples
 */
object AddSubExpressionEvaluator extends JavaTokenParsers {
  def apply(input: String): Int = parseAll(expr, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, in) => throw new IllegalArgumentException(s"Parsing error: $msg. Input: $in")
  }

  def expr: Parser[Int] = number ~ rep(("+" | "-") ~ number) ^^ {
    case n ~ signNumberList => n + toNumbers(signNumberList).sum
  }

  def number: Parser[Int] = wholeNumber ^^ (_.toInt)

  def toNumbers(signNumber: List[~[String, Int]]): List[Int] = signNumber map {
    case "+" ~ n => n
    case "-" ~ n => -n
  }

}
