package ltest

import play.api.libs.json.{Format, Json}
;

/**
  * Created by Hemmy on 21/03/17.
  */
object CounterEvents {

  sealed trait CounterEvent


  case class CounterUpdated(newNumber: Int) extends CounterEvent

  implicit val format: Format[CounterUpdated] = Json.format

}
