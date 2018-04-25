package expression
import context._
import value._

case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    if(operands.size < 2) throw new TypeException("Disjunctions need at least 2 arguments")
    def helper(result: Boole, unseen: List[Expression]): Boole = {
      if(unseen == Nil) result 
      else
        if(!unseen.head.execute(env).isInstanceOf[Boole])
          throw new TypeException("Disjunctions require Boole expressions")
        else
          if(unseen.head.isInstanceOf[Boole] && unseen.head.execute(env).asInstanceOf[Boole].value) helper(Boole(true), Nil) 
          else helper(result, unseen.tail)
    }
    helper(Boole(false), operands)
  }
}