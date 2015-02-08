package examples

import org.specs2.mutable._
import Utils._

//# codeblock
class A
class B {
  def xyz() = ???
  // hide this line with comments
  def abc() = ???
}
//#

class C {
  val x: Int = 0 //codeline
}

//# codeblock
class D
//#

class E {
  val y: Int = 0 //codeline
}

class Specs extends Specification {
  "spec" in compileOnly {
    object G
  }
}

class G {
  def method_definition(x: Int, y: Int) = { ??? }
  implicit val value_definition: Int = 0
}
