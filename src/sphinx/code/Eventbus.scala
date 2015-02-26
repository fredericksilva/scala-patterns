package examples

import akka.actor._
import akka.event.{ ActorEventBus, LookupClassification }

//# eventbus_pattern
object EventBusForActors {
  val classify: Any ⇒ Class[_] = { event ⇒ event.getClass }
}

class EventBusForActors[EventType, ClassifierType](
  classifier: EventType ⇒ ClassifierType = EventBusForActors.classify)(implicit e: DefaultsTo[EventType, Any],
                                                                       c: DefaultsTo[ClassifierType, Class[_]])
    extends ActorEventBus with LookupClassification {
  type Event = EventType
  type Classifier = ClassifierType

  protected def classify(event: Event): Classifier = {
    classifier(event)
  }
  protected def mapSize(): Int = 32
  protected def publish(event: Event,
                        subscriber: Subscriber): Unit = {
    subscriber ! event
  }
}
//#
object PostOffice {
  case class RegisterListener(actor: ActorRef)
  //# setup
  class PostNotification
  case object LetterNotification extends PostNotification
  case object PackageNotification extends PostNotification
  //#
}

//# postofficea
class PostOfficeA extends Actor {
  import PostOffice._

  val bus = new EventBusForActors()

  def receive = {
    case RegisterListener(customer) ⇒ bus.subscribe(customer, LetterNotification.getClass)
    case "new batch with letters"   ⇒ bus.publish(LetterNotification)
    case "new batch with packages"  ⇒ bus.publish(PackageNotification)
  }
}
//#

//# postofficeb
class PostOfficeB extends Actor {
  import PostOffice._

  val bus = new EventBusForActors[PostNotification, Boolean]({
    notification: PostNotification ⇒
      notification match {
        case LetterNotification  ⇒ true
        case PackageNotification ⇒ false
      }
  })

  def receive = {
    case RegisterListener(customer) ⇒ bus.subscribe(customer, true)
    case "new batch with letters"   ⇒ bus.publish(LetterNotification)
    case "new batch with packages"  ⇒ bus.publish(PackageNotification)
  }
}
//#