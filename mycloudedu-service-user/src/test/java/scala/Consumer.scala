package scala

/**
  * Created by e诺
  * on 2017/5/24
  * Time 上午11:03
  */


class Animal {}

class Bird extends Animal {}

class Consumer[+T](t: T) {
  def get: T = t

  def use[U >: T](u: U): Unit = {
    println(u)
  }
}

class Provider[-T](t: T) {

  def use(t: T): Unit = {
    println(t)
  }
}

class Document {
  var param1 = ""
  var param2 = ""
  var param3 = ""
  var param4 = ""
  var param5 = ""

  def setParam1(param1: String): this.type = {
    this.param1=param1
    this
  }
  def setParam2(param2: String): this.type  = {
    this.param2=param2
    this
  }
  def setParam3(param3: String): this.type  = {
    this.param3=param3
    this
  }
  def setParam4(param4: String): this.type  = {
    this.param4=param4
    this
  }
  def setParam5(param5: String): this.type  = {
    this.param5=param5
    this
  }
}

class Book extends Document{
  var chapter=""
  def setChapter(chapter:String):this.type ={
    this.chapter=chapter
    this
  }
}
