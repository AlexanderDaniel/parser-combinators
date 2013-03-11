Examples using Scala's parser combinators
=========================================

Simple examples using Scala's parser combinators:

* AddSubExprEvaluator can calculate the result of arithmetic expressions with addition and subtraction, e.g. `3+7-10+15+5-7`
* ElementaryExprEvaluator can do elementary arithmetic, e.g. `3 + 5*2 - 100/10 + 2*2*2*2`
* ParenthesesExprEvaluator can do elementary arithmetic with parenthesis, e.g. `(3+2)*(2+3) - 5*(10-5)`
* PowerExprEvaluator also support the power operation with the `^` operator, e.g. `7+3*2^2`

There are corresponding parsers which build abstract syntax trees (AST) instead of calculating the result: AddSubExprAST,
ElementaryExprAST, ParenthesesExprAST and PowerExprAST

NoBacktrackingExprEvaluator uses the non-back-tracking sequential composition operator `~!` instead of the
standard sequential composition `~`.

IntoExperiment uses the `into` combinator which can also be written as `>>` to parse a list which is prefixed with the number
of expected elements.

The [ScoreSheetParser](https://github.com/AlexanderDaniel/bowling-kata/blob/master/src/main/scala/lachdrache/bowling/parser/ScoreSheetParser.scala) in the
[bowling-kata](https://github.com/AlexanderDaniel/bowling-kata) repo parsers a bowling score sheet.

Resources
=========
* [Parsers Scaladoc](http://www.scala-lang.org/api/current/index.html#scala.util.parsing.combinator.Parsers)
* [RegexParsers Scaladoc](http://www.scala-lang.org/api/current/index.html#scala.util.parsing.combinator.RegexParsers) with a nice example similar to ElementaryWithParenthesesExpressionEvaluator
* [Scala Parser Combinators](http://jim-mcbeath.blogspot.co.at/2008/09/scala-parser-combinators.html) by Jim McBeath is a good read
* [Programming in Scala](http://www.artima.com/shop/programming_in_scala) chapter 33
* [Scala for the Impatient](http://www.horstmann.com/scala/) chapter 19
* [Functional Programming in Scala](http://manning.com/bjarnason/) chapter 9
* [The Magic Behind Parser Combinators](http://www.codecommit.com/blog/scala/the-magic-behind-parser-combinators) blog post by Daniel Spiewak
* [Scala eXchange 2012: Daniel Spiewak on Functional Compilers: From CFG to EXE](http://skillsmatter.com/podcast/scala/functional-compilers-from-cfg-to-exe)
* [Parser combinators (Wikipedia)](https://en.wikipedia.org/wiki/Parser_combinator)
* [Context-free grammar (Wikipedia)](https://en.wikipedia.org/wiki/Context-free_grammar)
* [LL parsing (Wikipedia)](https://en.wikipedia.org/wiki/LL_parsing)
* [Recursive descent parser (Wikipedia)](https://en.wikipedia.org/wiki/Recursive_descent)
* [EBNF (Wikipedia)](https://en.wikipedia.org/wiki/Ebnf)
* [Play uses parser combinators for parsing the templates](https://github.com/playframework/Play20/blob/master/framework/src/templates-compiler/src/main/scala/play/templates/ScalaTemplateCompiler.scala). Thanks to [Manuel Bernhardt](https://twitter.com/elmanu) for the link
* [parboiled uses Parsing expression grammars (PEGs) instead of EBNF](https://github.com/sirthias/parboiled/wiki). Thanks to Patrick Martini for sharing