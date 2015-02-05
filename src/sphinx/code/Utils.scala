package examples

object Utils {
  def compileOnly[U](block: ⇒ U) = new org.specs2.specification.Scope {}
}