package expression

import context._ 
import value._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = {
    val arguments = operands.map(_.execute(env))
    try{
      val maybeClosure = operator.execute(env)
      if(!maybeClosure.isInstanceOf[Closure]) throw new TypeException("Not a closure")
      val closure = maybeClosure.asInstanceOf[Closure]
      closure(arguments)
    } catch {
      case e: UndefinedException => alu.execute(operator, arguments)
    }
  }
}