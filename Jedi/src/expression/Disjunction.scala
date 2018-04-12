package expression
import context._
import value._

class Disjunction extends SpecialForm {
  def execute(env: Environment) = Notification.OK  
}