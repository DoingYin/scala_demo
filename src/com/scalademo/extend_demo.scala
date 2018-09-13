package com.scalademo

object extend_demo {

}
class Person (var name:String) {
  private var age = 18
}

//继承于Person，主构造函数继承Person的name属性
class Student(var no:Int, name: String) extends Person(name:String) {
  private val score = 60.0
}

object testExetend {
  def main(args: Array[String]): Unit = {
    val p:Person = new Student(1, "ack")
    var s:Student = null
    if (p.isInstanceOf[Student]) {
      s = p.asInstanceOf[Student]
    }

    /* val s1:Student = new Person
     var p1:Person = null
     if (s1.isInstanceOf[Person]) {
       p1 = s1.asInstanceOf[Student]
     }*/

    println(p.getClass == classOf[Person])
    println(s.getClass == classOf[Student])
  }
}
