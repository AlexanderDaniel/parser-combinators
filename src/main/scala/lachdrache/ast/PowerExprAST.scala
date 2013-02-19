package lachdrache.ast

class PowerExprAST extends ParenthesesExprAST {

  override def term: Parser[Expr] = pow ~ rep(("*" | "/") ~ pow) ^^ buildOps

  def pow: Parser[Expr] = number ~ rep("^"~>number) ^^ {
    case n0 ~ lst => {
      val v = (n0 :: lst).toVector
      v.init.foldRight(v.last) {
        case (n, z) => Op("^", n, z)
      }
    }
  }
}
