package value
import expression._
case class Chars(val value: String) extends Literal {
  def <(other: Chars) = this.value < other.value
  def ==(other: Chars) = this.value.equals(other.value)
  def substring(x: Integer, y: Integer = Integer(this.value.length())) = Chars(this.value.substring(x.value,y.value))
  def +(other: Chars) = Chars(this.value + other.value)
  override def toString = this.value
}