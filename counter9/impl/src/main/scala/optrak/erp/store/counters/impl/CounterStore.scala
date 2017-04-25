package optrak.erp.store.counters.impl

import akka.Done
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity
import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import grizzled.slf4j.Logging
import optrak.erp.store.counters.impl.CounterCommands.{CounterCommand, Next}
import optrak.erp.store.counters.impl.CounterEvents.{CounterEvent, CounterUpdated}

import scala.collection.immutable.Seq

/**
  * Created by tim on 26/03/17.
  * Copyright Tim Pigden, Hertford UK
  */
class CounterStore extends PersistentEntity {
  override type Command = CounterCommand
  override type Event = CounterEvent
  override type State = Int

  override def initialState = 0

  override def behavior: Behavior = {
    Actions().onCommand[Next.type, Int] {
      case (Next, ctx, state) =>
        val newValue = state + 1
        ctx.thenPersist(CounterUpdated(newValue))(_ => ctx.reply(newValue))
    }.onEvent {
      case (CounterUpdated(n), state) => n
    }
  }
}

object CounterStoreSerializerRegistry extends JsonSerializerRegistry {
  override def serializers: Seq[JsonSerializer[_]] = Seq(
//    JsonSerializer[CounterUpdated],
//    //JsonSerializer[Next.type]
  )
}





