package cats.tests

import cats.data.Validated
import cats.kernel.laws.discipline.EqTests
import org.scalatest.exceptions.TestFailedException

class BasicTest extends CatsSuite with ValidatedValues {
  checkAll("Int", EqTests[Int].eqv)

  test("Equals Checks"){
    val s = ""
    // Using ===
    s === s
  }

  test("Validated Values") {
    Validated.valid("foo").value shouldEqual "foo"
    assertThrows[TestFailedException](Validated.invalid("boom").value)
  }
}