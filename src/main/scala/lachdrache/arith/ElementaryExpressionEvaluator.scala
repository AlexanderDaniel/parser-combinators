package lachdrache.arith

class ElementaryExpressionEvaluator extends AddSubExpressionEvaluator {

  override def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ sum

  def term: Parser[Int] = number ~ rep(("*" | "/") ~ number) ^^ product

  def product(in: ~[Int, List[~[String, Int]]]): Int = in match {
    case n0~sgnNumLst => sgnNumLst.foldLeft(n0) {
      case (z, "*"~n) => z*n
      case (z, "/"~n) => z/n
    }
  }

}
