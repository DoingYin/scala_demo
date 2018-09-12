package com.scalademo

import scala.util.control.Breaks.break

object typeParam_demo {

  //使用泛型，在创建Student对象的时候再设置类型
  class Student[T](val localid:T) {
    def getSchoolid(hukouid:T) = println("S - "+ hukouid +"-" + localid)
  }

  //使用泛型，在调用的时候判断
  def getCard[T](content: T) = {
    if(content.isInstanceOf[Int]) "card: 001, " + content
    else if(content.isInstanceOf[String]) "card: this is your card, " + content
    else "card: " + content
  }

  def breakfor(): Unit = {
    var flag = true
    var sum = 0
    for (i <- 0 until 10 if flag) {
      sum += i
      if (i == 5) {
        println(sum)
        break
      }
    }
  }

  def main(args: Array[String]): Unit = {
    /*val leo = new Student[Int](111)
    leo.getSchoolid(232)
    val mick = new Student[String]("111")
    mick.getSchoolid("222")*/

    /*println(getCard[Int](12312))
    println(getCard("hello card"))*/

    breakfor()
  }
}
