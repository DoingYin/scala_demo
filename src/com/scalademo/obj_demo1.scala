package com.scalademo

class obj_demo1 {
  private var name = "jone"
  private var job = "student"
  private var age = 19

  def this(name: String, job: String, age: Int) {
    this()
    this.name = name
    this.job = job
    this.age = age
    println("constructor is doing !  ..., constructor was done!")
  }

  def getName = this.name

  def setName(name: String) = {
    this.name = name
  }

  def getJob = this.job

  def setJob(job: String) = {
    this.job = job
  }

  def getAge = this.age

  def setAge(age: Int) = {
    this.age = age
  }

  def working(): Unit = {
    println(this.name + " is a worker as " + this.job + ", and is " + this.age + " the eyenum are "+ obj_demo1.eyenum)
  }
}

object obj_demo1 {

  private val eyenum = 2

  def hello(clazz:obj_demo1): Unit = {
    println("Hello , I'm companion object" + clazz.name + "->" + clazz.job + "-->" + clazz.age)
  }

  def main(args: Array[String]): Unit = {
    val demo1 = new obj_demo1()
    demo1.working()

    val demo2 = new obj_demo1("mike", "teacher", 28)
    demo2.setAge(31)
    demo2.setJob("skiller")
    demo2.working()

    val clazz = new obj_demo1
    hello(clazz:obj_demo1)
  }
}