package com.scalademo

object partial_demo {
  def getStudentGrade:PartialFunction[String, Int] = {
    case "leo" => 90
    case "mike" => 80
    case "walloce" => 65
    case _ => 0
  }

  def main(args: Array[String]): Unit = {
    println(getStudentGrade("jack"))

    val str = "a b c de"
    val strarr = str.split(" ")
    for (a <- strarr) println(a)
  }
}
