Examples using Scala's parser combinators
=========================================

Simple examples using Scala's parser combinators:

* AddSubExpressionEvaluator can calculate the result of arithmetic expressions with addition and subtraction, e.g. `3+7-10+15+5-7`
* ElementaryExpressionEvaluator can do elementary arithmetic, e.g. `3 + 5*2 - 100/10 + 2*2*2*2`
* ElementaryWithParenthesesExpressionEvaluator can do elementary arithmetic with parenthesis, e.g. `(3+2)*(2+3) - 5*(10-5)`

Resources
=========
* [Parsers Scaladoc](http://www.scala-lang.org/api/current/index.html#scala.util.parsing.combinator.Parsers)
* [RegexParsers Scaladoc](http://www.scala-lang.org/api/current/index.html#scala.util.parsing.combinator.RegexParsers) with a nice example similar to ElementaryWithParenthesesExpressionEvaluator
* [Programming in Scala](http://www.artima.com/shop/programming_in_scala) chapter 33
* [Scala for the Impatient](http://www.horstmann.com/scala/) chapter 19
* [Functional Programming in Scala](http://manning.com/bjarnason/) chapter 9
* [The Magic Behind Parser Combinators](http://www.codecommit.com/blog/scala/the-magic-behind-parser-combinators) blog post by Daniel Spiewak
* [Scala eXchange 2012: Daniel Spiewak on Functional Compilers: From CFG to EXE](http://skillsmatter.com/podcast/scala/functional-compilers-from-cfg-to-exe)
* [Parser combinators (Wikipedia)](http://en.wikipedia.org/wiki/Parser_combinator)
* [Context-free grammar (Wikipedia)](http://en.wikipedia.org/wiki/Context-free_grammar)
* [LL parsing (Wikipedia)](http://en.wikipedia.org/wiki/LL_parsing)
* [Recursive descent parser (Wikipedia)](http://en.wikipedia.org/wiki/Recursive_descent)
