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

trait Counter1Components extends LagomServerComponents
  with CassandraPersistenceComponents
  with LagomServiceClientComponents {
  implicit def executionContext: ExecutionContext

  override lazy val lagomServer = LagomServer.forServices(bindService[Counter1Service].to(wire[Counter1ServiceImpl]))
  override lazy val jsonSerializerRegistry = CounterSerializerRegistry
  persistentEntityRegistry.register((wire[Counter1Store]))
}

abstract class Counter1Application(context: LagomApplicationContext)
  extends LagomApplication(context)
    with Counter1Components
    with CassandraPersistenceComponents
    with AhcWSComponents {

}

class Counter1Loader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext): LagomApplication =
    new Counter1Application(context) with ConductRApplicationComponents


  override def loadDevMode(context: LagomApplicationContext): LagomApplication = {
    new Counter1Application(context ) with LagomDevModeComponents
  }
}

