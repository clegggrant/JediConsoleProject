package expression
import context._
import value._

case class Conditional(val cond: Expression, val cons: Expression, val alt: Expression = null) extends SpecialForm {
  def execute(env: Environment) = {
    if(cond.execute(env).asInstanceOf[Boole].value) cons.execute(env)
    else if(alt == null) Notification.UNSPECIFIED else alt.execute(env)
  }
}