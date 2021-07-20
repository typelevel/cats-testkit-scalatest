package cats.tests

import cats.data.Validated
import cats.data.Validated.{Invalid, Valid}
import org.scalatest.Assertions.fail

trait ValidatedValues {
  implicit class ValueForValidated[E, A](result: Validated[E, A]) {

    /**
     * @return the value of this Validated if it is Valid, else fail the test
     */
    def value: A = result match {
      case Invalid(e) => fail(s"Validation failed with $e")
      case Valid(a)   => a
    }
  }
}
object ValidatedValues extends ValidatedValues

