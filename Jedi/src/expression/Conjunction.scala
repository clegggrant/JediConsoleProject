package expression
import context._
import value._

class Conjunction extends SpecialForm {
  def execute(env: Environment) = Notification.OK
}