package lachdrache.morecombinators

import util.parsing.combinator.JavaTokenParsers

/**
 * Input starts with a number which says how many elements follow.
 *
 * The {{{into}}} method is useful for that which can also be written as {{{>>}}}
 */
class IntoExperiment extends JavaTokenParsers {

  def lst: Parser[List[String]] = num >> { n => repN(n, ident) }
  def num: Parser[Int] = wholeNumber ^^ (_.toInt)

  def apply(input: String): List[String] = parseAll(lst, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, in) => throw new IllegalArgumentException(s"Parsing error: $msg")
  }

}
