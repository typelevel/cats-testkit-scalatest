package cats.tests

import cats.kernel.laws.discipline.EqTests

class BasicTest extends CatsSuite {
  checkAll("Int", EqTests[Int].eqv)

  test("Equals Checks"){
    val s = ""
    // Using ===
    s === s
  }
}