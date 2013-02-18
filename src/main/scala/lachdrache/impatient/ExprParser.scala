package lachdrache.impatient

import util.parsing.combinator.RegexParsers

/**
 * Example from [[http://www.horstmann.com/scala/ Scala for the Impatient]] chapter 19, section 3.
 *
 * The unit tests demonstrate that subtraction is right-associative. This can be fixed by using {{{rep}}} instead of
 * {{{opt}}} like in [[lachdrache.arith.AddSubExpressionEvaluator]]
 */
class ExprParser extends RegexParsers {
  val number = "[0-9]+".r

  def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
    case t ~ None => t
    case t ~ Some("+" ~ e) => t + e
    case t ~ Some("-" ~ e) => t - e
  }

  def term: Parser[Int] = factor ~ rep("*" ~ factor) ^^ {
    case f ~ r => f * r.map(_._2).product
  }

  def factor: Parser[Int] = number ^^ { _.toInt } | "(" ~ expr ~ ")" ^^ {
    case _ ~ e ~ _ => e
  }

  def apply(input: String): Int = parseAll(expr, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, in) => throw new IllegalArgumentException(s"Parsing error: $msg. Input: $in")
  }

}
