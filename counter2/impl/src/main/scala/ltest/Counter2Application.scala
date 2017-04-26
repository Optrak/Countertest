package ltest

import com.lightbend.lagom.scaladsl.client.LagomServiceClientComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire.wire
import com.typesafe.conductr.bundlelib.lagom.scaladsl.ConductRApplicationComponents
import play.api.libs.ws.ahc.AhcWSComponents

import scala.concurrent.ExecutionContext

/**
  * Created by tim on 26/04/17.
  */

trait Counter2Components extends LagomServerComponents
  with CassandraPersistenceComponents
  with LagomServiceClientComponents {
  implicit def executionContext: ExecutionContext

  override lazy val lagomServer = LagomServer.forServices(bindService[Counter2Service].to(wire[Counter2ServiceImpl]))
  override lazy val jsonSerializerRegistry = CounterSerializerRegistry
  persistentEntityRegistry.register((wire[Counter2Store]))
}

abstract class Counter2Application(context: LagomApplicationContext)
  extends LagomApplication(context)
    with Counter2Components
    with CassandraPersistenceComponents
    with AhcWSComponents {

}

class Counter2Loader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext): LagomApplication =
    new Counter2Application(context) with ConductRApplicationComponents


  override def loadDevMode(context: LagomApplicationContext): LagomApplication = {
    new Counter2Application(context ) with LagomDevModeComponents
  }
}

