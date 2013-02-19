package lachdrache.arith

/**
 * Also supports pow with operator {{{^}}} which should be right-associative.
 *
 * The idea is from [[http://www.horstmann.com/scala/ Scala for the Impatient]] exercise 2 in chapter 19.
 */
class PowerExprEvaluator extends ParenthesesExprEvaluator {

  override def term: Parser[Int] = pow ~ rep(("*" | "/") ~ pow) ^^ product

  def pow: Parser[Int] = number ~ rep("^"~>number) ^^ power

  def power(in: ~[Int, List[Int]]): Int = in match {
    case n0 ~ lst => (n0 :: lst).foldRight(1) {
      case (n, z) => math.pow(n, z).toInt
    }
  }
}
