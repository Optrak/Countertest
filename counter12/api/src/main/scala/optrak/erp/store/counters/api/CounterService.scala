package optrak.erp.store.counters.api

import java.time.Instant

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import optrak.erp.entitymodel.DataSets.{ServiceName, TenantId}

/**
  * Created by tim on 11/03/17.
  * Copyright Tim Pigden, Hertford UK
  */
trait CounterService extends Service {

  /**
    * increments internal counter and adds one
    */
  def nextCounter(tenantId: TenantId, serviceName: ServiceName): ServiceCall[NotUsed, Int]

  override final def descriptor = {
    import Service._

    named("counters12").withCalls (
      pathCall("/optrak.erp.counter12/next/:tenantId/:service", nextCounter  _ )

    ).withAutoAcl(true)
  }
}

