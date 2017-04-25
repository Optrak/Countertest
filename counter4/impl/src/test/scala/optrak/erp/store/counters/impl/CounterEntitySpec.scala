/*
package optrak.erp.store.counters.impl

import akka.actor.ActorSystem
import com.lightbend.lagom.scaladsl.playjson.JsonSerializerRegistry
import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.{PersistentEntityTestDriver, ServiceTest}
import optrak.erp.entitymodel.CommonEntityTestData._
import optrak.erp.store.counters.api.CounterService
import optrak.erp.store.counters.impl.CounterCommands.{CounterCommand, Next}
import optrak.erp.store.counters.impl.CounterEvents.{CounterEvent, CounterUpdated}
import org.scalatest.{AsyncWordSpec, BeforeAndAfterAll, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by Hemmy on 14/03/17.
  */
class CounterEntitySpec extends AsyncWordSpec with Matchers with BeforeAndAfterAll {

  val system = ActorSystem("CounterEntitySec", JsonSerializerRegistry.actorSystemSetupFor(CounterSerializerRegistry))

  val entityId = "from:to"


  lazy val server = ServiceTest.startServer(ServiceTest.defaultSetup) { ctx =>
    new CounterApplication(ctx) with LocalServiceLocator
  }


  lazy val client = server.serviceClient.implement[CounterService]

  private def withDriver[T](block: PersistentEntityTestDriver[CounterCommand, CounterEvent, Int] => T): T = {
    val driver = new PersistentEntityTestDriver(system, new CounterStore, entityId)
    try {
      block(driver)
    } finally {
      driver.getAllIssues shouldBe empty
      ()
    }
  }


  "Counter" should {
    "Add and update entity" in withDriver { driver =>
      val outcome = driver.run(Next)
      outcome.events should contain only CounterUpdated(1)
      outcome.state should ===(1)

      val outcome2 = driver.run(Next)
      outcome2.events should contain only CounterUpdated(2)
      outcome2.state should ===(2)
    }
  }
  override protected def beforeAll() = {
    server
    ()
  }

  override protected def afterAll() = {
    Await.ready(system.terminate, 10 seconds)
    server.stop()
  }

}



*/
