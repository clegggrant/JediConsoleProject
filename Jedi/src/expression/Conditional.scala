package expression
import context._
import value._

class Conditional extends SpecialForm {
  def execute(env: Environment) = Notification.OK
}