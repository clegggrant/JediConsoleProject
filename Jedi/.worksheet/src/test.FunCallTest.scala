package test

import context._
import expression._
import value._

object FunCallTest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(131); 
  println("Welcome to the Scala worksheet");$skip(46); 
  
  val globalEnvironment2 = new Environment;System.out.println("""globalEnvironment2  : context.Environment = """ + $show(globalEnvironment2 ));$skip(47); 
  val operands2 = List(Integer(6), Integer(7));System.out.println("""operands2  : List[value.Integer] = """ + $show(operands2 ));$skip(50); 
  var exp = FunCall(Identifier("add"), operands2);System.out.println("""exp  : expression.FunCall = """ + $show(exp ));$skip(43); 
  println(exp.execute(globalEnvironment2));$skip(47); 
  exp = FunCall(Identifier("less"), operands2);$skip(43); 
  println(exp.execute(globalEnvironment2));$skip(46); 
  exp = FunCall(Identifier("mul"), operands2);$skip(43); 
  println(exp.execute(globalEnvironment2))}
}
