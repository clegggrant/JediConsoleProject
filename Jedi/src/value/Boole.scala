package value
import expression._
case class Boole(val value: Boolean) extends Literal {
  def &&(other: Boole) = Boole(this.value && other.value)
  def ||(other: Boole) = Boole(this.value || other.value) 
  def unary_! = Boole(!this.value)
  override def toString = this.value.toString
}