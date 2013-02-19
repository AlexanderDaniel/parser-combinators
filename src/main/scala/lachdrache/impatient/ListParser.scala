package lachdrache.impatient

import util.parsing.combinator.JavaTokenParsers

/**
 * Exercise 3 from [[http://www.horstmann.com/scala/ Scala for the Impatient]] chapter 19
 */
class ListParser extends JavaTokenParsers {

  def lst: Parser[List[Int]] = "("~>repsep(num, ",")<~")"
  def num: Parser[Int] = wholeNumber ^^ (_.toInt)

  def apply(input: String): List[Int] = parseAll(lst, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, in) => throw new IllegalArgumentException(s"Parsing error: $msg")
  }

}
