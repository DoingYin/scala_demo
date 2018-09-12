package com.scalademo.overwritefield

import scala.collection.mutable.ArrayBuffer

class Class {
  class Student(val name:String) {}
  val students = new ArrayBuffer[Student]()
  def register(name:String) = {
    new Student(name)
  }
}
object test {
  def main(args: Array[String]): Unit = {
    /*val c1 = new Class
    val mike = c1.register("mike")
    c1.students += mike

    val c2 = new Class
    c2.students += mike*/
  }
}
