package com.scalademo

class obj_demo {
  private var name = "mike"
  var age = 18
  var job = "student"

  //辅助构造函数
  def this(name:String, age:Int, job:String) {
    this()
    this.name = name
    this.age = age
    this.job = job
  }

  def getName = this.name
  def setName(name: String) = {
    this.name = name
  }

  def obj_demo(name: String, age:Int, job:String): Unit = {
    this.name = name
    this.age = age
    this.job = job
  }

  def sayHello(name:String): Unit = {
    println("Hi "+ name +",I'm "+ this.name + " I was "+ this.age +" and as a "+ this.job)
  }

}

class person(drink:String, eat:String) {
  def action(): Unit = {
    println("everyone is vary happy in "+ this.drink + " and "+ this.eat)
  }
}

class adult(someone:String) extends person("water", "food") {
  def doEve(): Unit = {
    println(someone + " is addicted in dreak")
  }
}

class student(clazz:String, name:String, no:Int) {
  def ownner(): Unit = {
    println(clazz + "--" + name + ":"+ no)
  }
}

object test {
  def main(args: Array[String]): Unit = {
    val demo = new obj_demo()
    demo.age = 20
    demo.job = "teacher"
    demo.setName("marry")
    demo.sayHello("jack")

    println("--------------分割线-------------------")

    val demo1 = new obj_demo("jack", 23, "nurse")
    demo1.sayHello("marry")

    println("--------------分割线-------------------")
    val student = new student("三年二班", "周杰伦", 41)
    student.ownner()
    val student1 = new student("初三（8）班", "walloce", 32)
    student1.ownner()

    println("--------------分割线-------------------")
    val person = new person("water", "hanburger")
    person.action()

    val adult = new adult("adult man")
    adult.doEve()
    adult.action()
  }
}




