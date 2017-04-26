package ltest

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry
import ltest.CounterCommands.Next

import scala.concurrent.ExecutionContext

/**
  * Created by tim on 26/03/17.
  * Copyright Tim Pigden, Hertford UK
  */
class Counter1ServiceImpl(registry: PersistentEntityRegistry)
                          (implicit ec: ExecutionContext) extends Counter1Service {
  /**
    * increments internal counter and adds one
    */
  override def nextCounter(tenantId: String, serviceName: String): ServiceCall[NotUsed, Int] = ServiceCall { _ =>
    for {
      next <- registry.refFor[Counter1Store](s"$tenantId:$serviceName").ask(Next)
    } yield next
  }
}

