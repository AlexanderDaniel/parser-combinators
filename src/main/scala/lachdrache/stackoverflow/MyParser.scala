package lachdrache.stackoverflow

import util.parsing.combinator.JavaTokenParsers
import collection.immutable.HashMap

/**
 * Based on question [[http://stackoverflow.com/questions/4939830/how-to-make-scala-parser-fail]]
 */
class MyParser extends JavaTokenParsers {
  var m = new HashMap[String,String]

  def prog: Parser[List[String]] = rep(stored_val ^^ (s => Some(s)) | store ^^^ (None)) ^^ {
    case lst => lst.filterNot(_.isEmpty).map(_.get)
  }

  def store: Parser[Unit] = ("var" ~> ident <~ "=") ~ ident ^^ {
    case k ~ v => m += k -> v
  }
  def stored_val: Parser[String] = ident ^? {
    case k if m.contains(k) => m(k)
  }

  def apply(input: String): List[String] = parseAll(prog, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, in) => throw new IllegalArgumentException(s"Parsing error: $msg. Input: $in")
  }

}