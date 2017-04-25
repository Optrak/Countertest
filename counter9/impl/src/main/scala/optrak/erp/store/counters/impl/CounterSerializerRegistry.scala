//package optrak.erp.store.counters.impl
//
//import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
//import optrak.erp.store.counters.impl.CounterEvents._
//import CounterCommands._
//import com.optrak.countertest.impl.CountertestState
//import play.api.libs.json.{Format, Json}
////import optrak.scalautils.json.JsonImplicits._
////import optrak.lagom.utils.PlayJson4s._
//
//import scala.collection.immutable.Seq
//
///**
//  * Created by Hemmy on 14/03/17.
//  */
//object CounterSerializerRegistry extends JsonSerializerRegistry {
//
//
//  override def serializers: Seq[JsonSerializer[_]] = Seq(
//
//  implicit val format: Format[CounterUpdated] = Json.format
//
//  )
//}
