package expression
import context._
import value._

case class Conjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    if(operands.size < 2) throw new TypeException("Conjunctions need at least 2 arguments")
   
    def helper(result: Boole, unseen: List[Expression]): Boole = {
      if(unseen == Nil) result 
      else 
        if(!unseen.head.execute(env).isInstanceOf[Boole])
          throw new TypeException("Conjunctions require Boolean expressiosn")
        else
          if(unseen.head.execute(env).isInstanceOf[Boole] && !unseen.head.execute(env).asInstanceOf[Boole].value) helper(Boole(false), Nil) 
          else helper(result, unseen.tail)
    }
    helper(Boole(true), operands)
  }
}

object Conjunction extends App{
  val env = new Environment
  Conjunction(List(FunCall(Identifier("more"), List(Integer(3),Integer(4))), Boole(false), Boole(true))).execute(env)
}