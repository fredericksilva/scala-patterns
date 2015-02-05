package examples

import org.specs2.mutable._
import Utils._

class Reference extends Specification {
  "samplecode" in compileOnly {
    "Hello world" must have size (11)
  }
}