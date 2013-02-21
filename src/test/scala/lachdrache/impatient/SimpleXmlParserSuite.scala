package lachdrache.impatient

import org.scalatest.FunSuite

class SimpleXmlParserSuite extends FunSuite {
  val eval = new SimpleXmlParser
  
  test("one el") {
    assert(eval("<root>scala</root>") === <root>scala</root>)
  }

  test("one el where closing tag does not match the opening tag") {
    intercept[IllegalArgumentException] {
      eval("<root>scala</rot>")
    }
  }

  test("nested elements")(pending)

  test("attributes")(pending)

  test("escaped chars in XML")(pending)

}
