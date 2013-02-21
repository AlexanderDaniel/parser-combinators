package lachdrache.morecombinators

import org.scalatest.FunSuite

class IntoExperimentSuite extends FunSuite {
  val eval = new IntoExperiment

  test("list with 0 elements") {
    assert(eval("0") === List())
  }

  test("list with 1 element") {
    assert(eval("1 scala") === List("scala"))
  }

  test("list with 3 elements") {
    assert(eval("3 scala is awesome") === List("scala", "is", "awesome"))
  }

  test("less elements available than expected") {
    intercept[IllegalArgumentException] {
      eval("2 justOne")
    }
  }

  test("more elements available than expected") {
    intercept[IllegalArgumentException] {
      eval("1 one andAnother")
    }
  }

}
