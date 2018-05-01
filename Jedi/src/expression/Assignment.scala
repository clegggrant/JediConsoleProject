package expression
import context._
import value._

case class Assignment(val variable: Identifier, val update: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    if(!variable.execute(env).isInstanceOf[Variable])
      throw new TypeException("Can only assign to variables")
    else
      variable.execute(env).asInstanceOf[Variable].content = update.execute(env)
    Notification.DONE
  }
}