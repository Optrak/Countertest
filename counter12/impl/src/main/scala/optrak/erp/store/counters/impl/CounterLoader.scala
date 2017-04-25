package optrak.erp.store.counters.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.client.LagomServiceClientComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire.wire
import optrak.erp.store.counters.api.CounterService
import play.api.libs.ws.ahc.AhcWSComponents

import scala.concurrent.ExecutionContext
import com.typesafe.conductr.bundlelib.lagom.scaladsl.ConductRApplicationComponents
import com.typesafe.conductr.bundlelib.lagom.scaladsl.ConductRApplicationComponents


/**
  * Created by Hemmy on 14/03/17.
  */

trait CounterComponents extends LagomServerComponents
  with CassandraPersistenceComponents
  with LagomServiceClientComponents {
  implicit def executionContext: ExecutionContext

  override lazy val lagomServer = LagomServer.forServices(bindService[CounterService].to(wire[CounterServiceImpl]))
  override lazy val jsonSerializerRegistry = CounterStoreSerializerRegistry
  persistentEntityRegistry.register((wire[CounterStore]))
}

class CounterLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext): LagomApplication =
    new CounterApplication(context) with ConductRApplicationComponents


  override def loadDevMode(context: LagomApplicationContext): LagomApplication = {
    new CounterApplication(context ) with LagomDevModeComponents
  }
}


abstract class CounterApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with CounterComponents
    with CassandraPersistenceComponents
    with AhcWSComponents {

}
