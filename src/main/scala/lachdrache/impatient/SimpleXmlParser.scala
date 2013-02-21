package lachdrache.impatient

import util.parsing.combinator.RegexParsers

/**
 * Parsers a simple XML and returns [[scala.xml.Elem]] value
 *
 * The challenge is that the name of the start tag and the end tag must match. One solution is to
 * use the {{{^?}}} operator with a partial function:
 * {{{
 * def el: Parser[scala.xml.Elem] = startTag ~ txt ~ endTag ^? {
 *   case startTag~txt~endTag if startTag==endTag => buildXmlElem(startTag, txt)
 * }
 * }}}
 * Cay Horstmann suggests in [[http://www.horstmann.com/scala/ Scala for the Impatient]] chapter 19, exercise 5
 * to use {{{into}}} and {{{accept}}}.
 */
class SimpleXmlParser extends RegexParsers {

  def el: Parser[scala.xml.Elem] = startTag ~ txt ~ endTag ^? {
    case startTag~txt~endTag if startTag==endTag => buildXmlElem(startTag, txt)
  }

  def startTag: Parser[String] = "<"~>tagName<~">"
  def endTag: Parser[String] = "</"~>tagName<~">"

  def txt: Parser[String] = """[^<]*""".r
  def tagName: Parser[String] = """[a-zA-Z]+""".r

  def buildXmlElem(tag: String, txt: String): scala.xml.Elem = {
    <el>{txt}</el>.copy(label = tag)
  }
  def apply(input: String): scala.xml.Elem = parseAll(el, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, in) => throw new IllegalArgumentException(s"Parsing error: $msg")
  }

}
