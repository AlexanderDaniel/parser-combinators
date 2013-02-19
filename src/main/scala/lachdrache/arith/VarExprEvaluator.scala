package lachdrache.arith

/**
 * Calculator supporting variables and assignments. Unassigned variables evaluate to zero.
 *
 * The implementation uses a mutable map for keeping track of the variables :-(
 */
class VarExprEvaluator extends NoBacktrackingExprEvaluator {

  private val vars = scala.collection.mutable.Map[String, Int]()

  /** Several assignments and one expr at the end */
  def program: Parser[Int] = rep(assignment) ~ expr ^^ {
    case lst~result => result
  }

  override def number: Parser[Int] = super.number | "("~>expr<~")" | name ^^ {
    case name => vars.getOrElse(name, 0)
  }

  def assignment: Parser[Unit] = name~"="~expr ^^ {
    case name~"="~result => vars(name) = result
  }

  def name: Parser[String] = """[a-z]+""".r

  override def apply(input: String): Int = {
    vars.clear()
    parseAll(program, input) match {
      case Success(result, _) => result
      case NoSuccess(msg, next) =>
        throw new IllegalArgumentException(s"$msg but found '${next.first}' at column ${next.pos.column}")
    }
  }

}
