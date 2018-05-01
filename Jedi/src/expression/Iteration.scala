package expression
import context._
import value._

case class Iteration(val condition: Expression, val body: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    if(!condition.execute(env).isInstanceOf[Boole])
      throw new TypeException("Conditions must be Boole expressions")
    else {
      while(condition.execute(env).asInstanceOf[Boole].value)
        body.execute(env)
    }
    Notification.DONE
  }
}