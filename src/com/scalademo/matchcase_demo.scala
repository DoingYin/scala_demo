package com.scalademo

import java.io.FileNotFoundException

object matchcase_demo {

  //字符串模式匹配
  def judgeGrade(grade:String): Unit = {
    grade match {
      case "A" => println("Excellent")
      case "B" => println("Good")
      case "C" => println("just so so")
      case _ => println("you need work hard!")
    }
  }

  //字符串模式匹配if守卫
  def judgeGrade(name:String, grade:String): Unit = {
    grade match {
      case "A" => println(name + " you are Excellent")
      case "B" => println(name + " you are Good")
      case "C" if name=="leo" => println(name + " you need to study hard")
      case _ if name == "mark" => println(name + " you got a big progress")
      case _ => println(name + " your grade is sou bad, you must study hard")
    }
  }

  //模式匹配变量赋值
  def judgeGraade_(name:String, grade:String): Unit = {
    grade match {
      case "A" => println(name + " you are Excellent, your grade is " + grade)
      case "B" => println(name + " you are Good, your grade is " + grade)
      case "C" if name=="leo" => println(name + " you need to study hard, your grade is C")
      case _grade if name == "mark" => println(name + " you got a big progress your grade is "+ _grade)
      case _grade => println(name + " you need to study hard, your grade is " + _grade)
    }
  }

  //对类型的模式匹配
  def processException(exc:Exception): Unit = {
    exc match {
      case e2:IndexOutOfBoundsException => println(e2)
      case e3:NoSuchFieldException => println(e3)
      case e4:FileNotFoundException => println(e4.getMessage)
      case _exc => println(_exc)
    }
  }

  //对Array和List集合中的元素进行匹配
  def arrayMatch(arr:Array[String]): Unit = {
    arr match {
      case Array("leo") => println("Hello , leo")
      case Array(girl1, girl2, girl3) => println("Hi, nice to meet you. I know you "+ girl1 +","+ girl2 +","+ girl3)
      case Array("leo", _*) => println("Hi, leo, please introduce your friends to me.")
      case _ => println("hey, Who are you?")
    }
  }

  //Nil表示后面没有元素了，只有固定数量的元素
  def listMatch(list:List[String]): Unit = {
    list match {
      case "leo"::Nil => println("Hello, leo.")
      case girl1:: girl2 :: girl3 :: Nil => println("Hi, nice to meet you , I know you "+ girl1 +","+ girl2 +","+ girl3)
      case "leo" :: tail => println("Hi , leo. please introduce your friends to me .")
      case _ => println("hey, Who are you?")
    }
  }

  class Animal
  case class Dog(name:String, color:String) extends Animal
  case class Cat(name:String, color:String) extends Animal
  def classMatch(a:Animal): Unit = {
    a match {
      case Dog(name: String, color: String) => println("This animal is dog, his name is "+ name +" and the color is "+ color)
      case Cat(name, color) => println("This animal is cat, his name is "+ name +" and the color is "+ color)
      case _ => println("I don't know something about this animal.")
    }
  }

  //option与模式匹配的使用，成绩查询
  val grades = Map("jack" -> "A", "leo" -> "B", "sum" -> "B")
  def getGrade(name:String): Unit ={
    val grade = grades.get(name)
    grade match {
      case Some(grade) => println("the name is "+ name + " and grade is "+ grade)
      case None => println("system not found about "+ name + "'s infomation")
    }
  }

  def main(args: Array[String]): Unit = {
   // judgeGrade("B")
   // judgeGrade("mark", "D")
   // judgeGraade_("mark", "C")
    /*processException(new IndexOutOfBoundsException)
    processException(new NoSuchFieldException())
    processException(new FileNotFoundException("没有找到对应的文件"))
    processException(new ArrayStoreException())*/
    //val arr = new Array[String]("leo")
    /*arrayMatch(Array("leo"))
    arrayMatch(Array("merry", "cendy", "kary"))
    arrayMatch(Array("leo", "cendy", "kary", "jack"))*/
    //listMatch(List("tom", "jack", "walloce", "jodren"))
    /*classMatch(new Dog("sum", "white"))
    classMatch(new Cat("tom", color = "yellow"))
    classMatch(new Animal)*/

    getGrade("tom")
  }
}
