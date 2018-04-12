package value

class Notification (val note: String) extends Value{
  override def toString = note
}
 object Notification{
   val DONE = new Notification("done")
   val OK = new Notification("ok")
   val UNSPECIFIED = new Notification("unspecified")
   def apply(note: String) = new Notification(note)
  }