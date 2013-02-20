package lachdrache.ast

/**
 * Calculator supporting variables and assignments. Unassigned variables evaluate to zero.
 *
 * The idea is from [[http://www.horstmann.com/scala/ Scala for the Impatient]] chapter 19, exercise 8
 *
 * @see [[lachdrache.arith.VarExprEvaluator]]
 */

class VarExprAST extends PowerExprAST {

  /** Several assignments and one expr at the end */
  def program: Parser[Expr] = rep(assignment) ~ expr ^^ {
    case Nil ~ result => result
    case assignments ~ result => Program(assignments, result)
  }

  def assignment: Parser[Var] = ident ~ "=" ~ expr ^^ {
    case name ~ "=" ~ expr => Var(name, expr)
  }

  /** Usage (reference) of variable */
  def use: Parser[Use] = ident ^^ {
    case name => Use(name)
  }

  override def number = wholeNumber ^^ (s => Num(s.toInt)) | "("~>expr<~")" | use

  override def apply(input: String): Expr = {
    parseAll(program, input) match {
      case Success(result, _) => result
      case NoSuccess(msg, next) => throw new IllegalArgumentException(s"$msg but found '${next.first}' at column ${next.pos.column}")
    }
  }

}
