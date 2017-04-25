package optrak.erp.store.counters.impl

import java.time.Instant

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.api.transport.NotFound
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry
import optrak.erp.entitymodel.DataSets.{ServiceName, TenantId}
import optrak.erp.store.counters.api.CounterService
import optrak.erp.store.counters.impl.CounterCommands.Next

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by tim on 26/03/17.
  * Copyright Tim Pigden, Hertford UK
  */
class CounterServiceImpl(registry: PersistentEntityRegistry)
                        (implicit ec: ExecutionContext) extends CounterService {
  /**
    * increments internal counter and adds one
    */
  override def nextCounter(tenantId: TenantId, serviceName: ServiceName): ServiceCall[NotUsed, Int] = ServiceCall { _ =>
    for {
      next <- registry.refFor[CounterStore](s"$tenantId:$serviceName").ask(Next)
    } yield next
  }
}

