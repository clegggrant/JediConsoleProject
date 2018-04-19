package expression
import context._
import value._

case class Block(val expressions: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    val tempEnv = new Environment(env)
    expressions.map(_.execute(tempEnv)).last
  }
}