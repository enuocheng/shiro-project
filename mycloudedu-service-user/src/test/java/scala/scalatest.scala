package scala

import scala.actors._
import scala.actors.Actor._

/**
  * Created by e诺
  * on 2017/5/18
  * Time 上午9:18
  */
object scalatest {
  def main(args: Array[String]): Unit = {
    val caller = self
    val accumulator = actor {
      var continue = true
      var sum = 0
      loopWhile(continue) {
        reactWithin(500) {
          case number: Int => sum += number
          case TIMEOUT =>
            continue = false
            caller ! sum
        }
      }
    }
    accumulator ! 1
    accumulator ! 2
    accumulator ! 3
    receiveWithin(1000) {
      case result => println("Total is " + result)
    }
  }
}


