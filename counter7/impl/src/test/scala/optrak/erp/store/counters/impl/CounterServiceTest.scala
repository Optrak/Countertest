/*
package optrak.erp.store.counters.impl

import java.time.{LocalDateTime, Month, ZoneId}

import akka.Done
import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.ServiceTest
import optrak.erp.core.ErpCore.JsonExtensions
import optrak.erp.coremodel.Orders.{OrderCosts, OrderDates}
import optrak.erp.entitymodel.CommonEntityTestData._
import optrak.erp.entitymodel.OrderEntities.FromToValue
import optrak.erp.store.counters.api.CounterService
import optrak.scalautils.core.{NonEmptyMap, NonEmptySet}
import org.scalatest.{AsyncWordSpec, BeforeAndAfterAll, Matchers}

/**
  * Created by Hemmy on 22/03/17.
  */
class CounterServiceTest extends AsyncWordSpec with Matchers with BeforeAndAfterAll {

  private val server = ServiceTest.startServer(
    ServiceTest.defaultSetup
      .withCassandra(true)
  ) { ctx =>
    new CounterApplication(ctx) with LocalServiceLocator
  }

  val client = server.serviceClient.implement[CounterService]

  override protected def afterAll() = server.stop()

  "CountersService" should {

    "allow add to a new counter" in {
      for {
        createdCounter1 <- client.nextCounter("tenant1", "serivce1").invoke()
        createdCounter2 <- client.nextCounter("tenant1", "serivce1").invoke()
        createdCounterx1 <- client.nextCounter("tenant1", "x").invoke()
      } yield {
        createdCounter1 should ===(1)
        createdCounter2 should ===(2)
        createdCounterx1 should ===(1)
      }
    }
  }
}
*/
