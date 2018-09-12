package com.scalademo.overwritefield

import scala.collection.mutable.ArrayBuffer

class Class2 {
  class Student2(val name:String)
  val students = new ArrayBuffer[Class2#Student2]()
  def register(name:String) = {
    new Student2(name)
  }
}

object test2 {
  def main(args: Array[String]): Unit = {
    val c2 = new Class2
    val walloce = c2.register("walloce")
    c2.students += walloce
    val c3 = new Class2
    val tony = c3.register("tony")
    c2.students += tony
    c3.students += walloce
  }
}
