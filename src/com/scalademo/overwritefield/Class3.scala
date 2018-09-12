package com.scalademo.overwritefield

class Class3(name:String) {
  outer =>
  class Student3(name:String) {
    def introduceSelf = "Hello, I'm "+ name +", I'm very happy to join to "+ outer.name
  }
  def register(name:String):Student3 = {
    new Student3(name)
  }
}

object test3 {
  def main(args: Array[String]): Unit = {
    val c1 = new Class3("class1")
    val mike = c1.register("mike")
    println(mike.introduceSelf)
  }
}
