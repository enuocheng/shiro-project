package scala.io
import scala.io._
/**
  * Created by e诺
  * on 2017/5/26
  * Time 下午5:50
  */
object ReadScalaIO {
  def main(args: Array[String]): Unit = {
    val sour = Source.fromFile("/Users/cmz/Downloads/教师信息模板.xlsx","UTF-8")
    val string = sour.mkString
    println(string)
  }
}
