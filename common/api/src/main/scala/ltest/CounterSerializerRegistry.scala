package ltest

import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import ltest.CounterCommands.Next
import ltest.CounterEvents.CounterUpdated

import scala.collection.immutable.Seq

/**
  * Created by Hemmy on 14/03/17.
  */
object CounterSerializerRegistry extends JsonSerializerRegistry {


  override def serializers: Seq[JsonSerializer[_]] = Seq(
    JsonSerializer[CounterUpdated],
    JsonSerializer[Next.type]
  )
}
