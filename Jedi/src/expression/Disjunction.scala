package expression
import context._
import value._

case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    if(operands.size < 2) throw new TypeException("Disjunctions need at least 2 arguments")
    val operands2 = operands.map(_.execute(env)).filter(_.isInstanceOf[Boole])
    if(operands2.size != operands.size) throw new TypeException("Disjunctions require boolean expressions")
    def helper(result: Boole, unseen: List[Value]): Boole = {
      if(unseen == Nil) result else if(unseen.head.isInstanceOf[Boole] && unseen.head.asInstanceOf[Boole].value) helper(Boole(true), Nil) else helper(result, unseen.tail)
    }
    helper(Boole(false), operands2)
  }
}