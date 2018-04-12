package expression
import context._
case class Identifier(val name: String) extends Expression {
  override def toString = name;
  def execute(env: Environment) = {
      if(env.get(this).nonEmpty) env.get(this).get else null
  }
}