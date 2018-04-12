package expression
import context._
import value._

case class Declaration(val identifier: Identifier, val expression: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    env(identifier) = expression.execute(env)
    Notification.OK
  }
}