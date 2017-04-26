package ltest

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * Created by tim on 11/03/17.
  * Copyright Tim Pigden, Hertford UK
  * Abstract base clase for the "real" counter services
  */
trait CounterService extends Service {

  /**
    * increments internal counter and adds one
    */
  def nextCounter(tenantId: String, serviceName: String): ServiceCall[NotUsed, Int]

  def counterName : String

  override final def descriptor = {
    import Service._

    named(s"counters$counterName").withCalls (
      pathCall(s"/counter$counterName/next/:tenantId/:service", nextCounter  _ )

    ).withAutoAcl(true)
  }
}
