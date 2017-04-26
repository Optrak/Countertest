package ltest

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity
import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import ltest.CounterCommands.{CounterCommand, Next}
import ltest.CounterEvents.{CounterEvent, CounterUpdated}

import scala.collection.immutable.Seq

/**
  * Created by tim on 26/03/17.
  * Copyright Tim Pigden, Hertford UK
  */
trait CounterStore extends PersistentEntity {
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

