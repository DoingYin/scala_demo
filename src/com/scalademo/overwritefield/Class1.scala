package com.scalademo.overwritefield

import com.scalademo.overwritefield.Class1.Student

import scala.collection.mutable.ArrayBuffer

object Class1 {
  class Student(val name:String)
}

class Class1 {
  val students = new ArrayBuffer[Student]()
  def register(name:String): Student = {
    new Student(name)
  }
}

object test1 {
  def main(args: Array[String]): Unit = {
    val c1 = new Class1
    val leo = c1.register("leo")
    c1.students += leo

    val c2 = new Class1
    val jack = c2.register("jack")
    c2.students += jack
    c2.students += leo
  }
}
