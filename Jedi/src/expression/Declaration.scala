package expression
import context._
import value._

case class Declaration(val identifier: Any, val expression: Any) extends SpecialForm {
  def execute(env: Environment) = {
    env(new Identifier(identifier.toString)) = expression.asInstanceOf[Expression].execute(env)
    Notification.OK
  }
}