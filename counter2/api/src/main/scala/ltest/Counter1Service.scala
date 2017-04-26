package ltest

/**
  * Created by tim on 26/04/17.
  */
trait Counter2Service extends CounterService {
  override def counterName: String = "2"
}
