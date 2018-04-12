package expression
import context._
import value._

class Declaration extends SpecialForm {
  def execute(env: Environment) = Notification.OK  
}