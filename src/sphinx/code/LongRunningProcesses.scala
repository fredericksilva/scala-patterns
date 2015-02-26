import akka.actor._
import scala.concurrent.duration._
import akka.util._
import akka.pattern._
import scala.concurrent.ExecutionContext.Implicits.global

object Telephonist {
  case class AllWorkIsDone(responses: List[Response])
  case class CallFailed(error: String)
  case object GetPhoneNumbers
  case class Call(number: PhoneNumber)
  case class CustomerResponse(response: Response)
  case class PhoneNumbers(phoneNumbers: List[PhoneNumber])
  type PhoneNumber = String
  type Response = String
  val NoResponses = List.empty
}

//# sequence
class Telephonist(phone: ActorRef, boss: ActorRef) extends Actor {
  import Telephonist._
  implicit val askTimeout = Timeout(5.seconds)

  case class CallNextCustomer(numbersToCall: List[PhoneNumber], responses: List[Response])

  def receive = {
    case PhoneNumbers(numbers)                      ⇒ self ! CallNextCustomer(numbers, NoResponses)
    case CallNextCustomer(Nil, responses)           ⇒ boss ! AllWorkIsDone(responses)
    case CallNextCustomer(numbersToCall, responses) ⇒ doNextCall(numbersToCall, responses)
    case m: CallFailed                              ⇒ boss ! m
  }

  def doNextCall(numbersToCall: List[PhoneNumber], responses: List[Response]) = {
    (phone ? Call(numbersToCall.head))
      .map {
        case CustomerResponse(response) ⇒ CallNextCustomer(
          numbersToCall.tail,
          responses :+ response)
      }.recover {
        case e ⇒ CallFailed(e.toString)
      } pipeTo self
  }
}
//#