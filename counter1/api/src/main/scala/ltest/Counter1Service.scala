package ltest

/**
  * Created by tim on 26/04/17.
  */
trait Counter1Service extends CounterService {
  override def counterName: String = "1"
}
