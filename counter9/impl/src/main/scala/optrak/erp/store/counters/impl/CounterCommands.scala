package optrak.erp.store.counters.impl

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import play.api.libs.json.{Format, Json}

/**
  * Created by Hemmy on 21/03/17.
  */
object CounterCommands {

  sealed trait CounterCommand

  case object Next extends CounterCommand with ReplyType[Int]

}
