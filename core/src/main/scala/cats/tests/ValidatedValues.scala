package cats.tests

import cats.data.Validated
import cats.data.Validated.{Invalid, Valid}
import org.scalactic.source.Position
import org.scalatest.exceptions.TestFailedException

trait ValidatedValues {
  implicit class ValueForValidated[E, A](result: Validated[E, A])(implicit pos: Position) {

    /**
     * @return the value of this Validated if it is Valid, else fail the test
     */
    def value: A = result match {
      case Invalid(e: Throwable) => throw new TestFailedException(_ => Some(s"Validation failed"), Some(e), pos)
      case Invalid(e)            => throw new TestFailedException(_ => Some(s"Validation failed with $e"), None, pos)
      case Valid(a)              => a
    }
  }
}
object ValidatedValues extends ValidatedValues

