package lachdrache.arith

class ElementaryExpressionEvaluator extends AddSubExpressionEvaluator {

  override def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ {
    case n ~ signNumberList => n + toNumbers(signNumberList).sum
  }

  def term: Parser[Int] = number ~ rep(("*" | "/") ~ number) ^^ {
    case n0 ~ lst => lst.foldLeft(n0) {
      case (z, "*" ~ n) => z*n
      case (z, "/" ~ n) => z/n
    }
  }

}
