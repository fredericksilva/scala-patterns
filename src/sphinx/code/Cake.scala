package examples

import org.specs2.mutable._
import Utils._

class Cake extends Specification {
  class Bean

  "smell" in compileOnly {
    class DarkBeanProvider

    class EspressoMachine(userRepository: DarkBeanProvider) {
      def makeCoffee = ???
    }

    val coffeeMaker = new EspressoMachine(new DarkBeanProvider)

    coffeeMaker.makeCoffee
  }

  "solution" in compileOnly {
    object EspressoMachine extends CoffeeMaker
      with DarkBeanProvider

    class CoffeeMaker {
      this: BeanProvider ⇒

      def makeCoffee = ??? // Call the getBean function
    }

    trait BeanProvider {
      def getBean: Bean
    }

    trait DarkBeanProvider extends BeanProvider {
      def getBean = ???
    }

    val coffeeMaker = EspressoMachine
    coffeeMaker.makeCoffee
  }
}