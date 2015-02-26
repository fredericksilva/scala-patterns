package examples

//# phantom_type
sealed class DefaultsTo[A, B]

trait LowPriorityDefaultsTo {
  implicit def overrideDefault[A, B] = new DefaultsTo[A, B]
}

object DefaultsTo extends LowPriorityDefaultsTo {
  implicit def default[B] = new DefaultsTo[B, B]
}
//#

object Common {
  def doFind(registrationNumber: String) = ???
}

object Fail {
  import Common._

  //# without_pattern
  abstract class Vehicle
  class Car extends Vehicle

  def find[T <: Vehicle](registrationNumber: String): T =
    doFind(registrationNumber).asInstanceOf[T]

  val car = find("88-BC-33")
  //#
}

object Worked {
  import Common._

  abstract class Vehicle
  class Car extends Vehicle

  // format: OFF
  //# with_pattern

  def find[T <: Vehicle](registrationNumber: String)
                        (implicit e: DefaultsTo[T, Vehicle]): T =
    doFind(registrationNumber).asInstanceOf[T]

  val car2 = find("88-BC-33")
  //#
  // format: ON
}
