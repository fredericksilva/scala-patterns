package examples

import akka.actor._
import scala.collection.mutable.Map

//# base_trait
trait ReceiveCompositingActor extends Actor {
  lazy val receivePartials = Map.empty[Int, Receive]

  val StartOfReceiveChain = 0
  val EndOfReceiveChain = 10000

  def becomeNew(key: Int, behaviour: Receive) {
    receivePartials += (key -> behaviour)
    context.become(composeReceive)
  }

  def composeReceive: Receive = {
    receivePartials.toSeq.sortBy {
      case (key, _) ⇒ key
    }.map {
      case (_, value) ⇒ value
    }.reduceLeft { (a, b) ⇒ a orElse b }
  }

  override def preStart() {
    super.preStart()
    context.become(composeReceive)
  }

  final def receive: Receive = Actor.emptyBehavior
}
//#

//# hello_handler
trait HelloHandler { this: ReceiveCompositingActor ⇒
  val HelloReceiver = 10
  def helloHandler: Receive = {
    case "Hello" ⇒ sender ! "Hi"
  }

  receivePartials += (HelloReceiver -> helloHandler)
}
//#

//# bye_handler
trait ByeHandler { this: ReceiveCompositingActor ⇒
  val ByeReceiver = 20
  def byeHandler: Receive = {
    case "Bye" ⇒ sender ! "Good bye"
  }

  receivePartials += (ByeReceiver -> byeHandler)
}
//#

//# final_actor
class FinalActor extends ReceiveCompositingActor
    with HelloHandler
    with ByeHandler {
  val AlternateReceiver = 50

  def alternateHello: Receive = {
    case "Hello" ⇒ sender ! "A new answer"
  }

  def alternateHandler: Receive = {
    case "ChangeAnswer" ⇒ becomeNew(HelloReceiver, alternateHello)
  }

  receivePartials += (AlternateReceiver -> alternateHandler)
}
//#