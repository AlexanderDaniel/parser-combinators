package lachdrache.arith

/**
 * Using the non-back-tracking sequential composition operator {{{~!}}} instead of the standard sequential composition
 * operator {{{~}}}.
 *
 * Note: Unfortunately there are no non-back-tracking versions of {{{~>}}} and {{{<~}}} available.
 */
class NoBacktrackingExprEvaluator extends PowerExprEvaluator {

  override def expr: Parser[Int] = term ~! rep(("+" | "-") ~! term) ^^ sum
  override def term: Parser[Int] = pow ~! rep(("*" | "/") ~! pow) ^^ product
  override def pow: Parser[Int] = number ~! rep("^"~>number) ^^ power

}
