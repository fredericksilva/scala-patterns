import akka.actor._
import akka.testkit._
import java.util.concurrent.atomic.AtomicInteger
import org.scalatest._

//# unique_names
object TestSystemCounter {
  private val sysId = new AtomicInteger()
  def nextSysId() = sysId.incrementAndGet()
}
//#

//# pattern
trait BaseSpec extends fixture.WordSpec with Matchers {
  import TestSystemCounter._

  type Fixture <: AkkaFixture
  val specType: String
  type FixtureParam = Fixture

  class AkkaFixture extends TestKit(
    ActorSystem(s"$specType-${nextSysId()}"))
    with ImplicitSender

  def createAkkaFixture(): Fixture

  override def withFixture(test: OneArgTest) = {
    val sys = createAkkaFixture()
    try test(sys)
    finally sys.system.shutdown()
  }
}

//# actor_under_test
class EchoActor extends Actor {
  def receive = {
    case m ⇒ sender ! m
  }
}
//#

//# type_def
abstract class SequentialAkkaSpecWithIsolatedFixture
    extends BaseSpec {
  val specType = "Seq"
}

abstract class ParallelAkkaSpec extends BaseSpec
    with ParallelTestExecution {
  val specType = "Par"
}
//#

//# actor_spec
class EchoActorSpec extends ParallelAkkaSpec {
  "Echo actor" should {

    "echo 1" in { f ⇒
      import f._

      echoActor ! "1"

      expectMsg("1")
    }

    "echo 2" in { f ⇒
      import f._

      echoActor ! "2"

      expectMsg("2")
    }
  }

  class EchoFixture extends AkkaFixture {
    val echoActor = system.actorOf(Props[EchoActor], "Echo")
  }

  type Fixture = EchoFixture
  def createAkkaFixture(): Fixture = new EchoFixture
}
//#