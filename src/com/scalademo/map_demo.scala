package com.scalademo

import scala.collection.mutable

object map_demo {

  def MapTest(): Unit = {

    //创建不可变的map
    val person1: Map[String, Any] = Map("name" -> "jack", "age" -> 18, "sex" -> "男")
    println(person1("name"))
    //person1("name") = "mack"
    // println(person1("name"))

    //创建可变map
    val animal = scala.collection.mutable.Map("mack" -> 18, "jack" -> 20, "mine" -> 19)
    animal("jack") = 33
    println(animal("jack"))

    val animals = scala.collection.mutable.Map(("mouse", 10), ("house", 3), ("pig", 7))
    for (elem <- animals) {
      println(elem._1 + " -> " + elem._2)
    }

    //创建HashMap
    var ages = new scala.collection.mutable.HashMap[String, Int]()

    //添加元素
    ages += ("leo" -> 18, "mike" -> 20, "jams" -> 17)

    //移除元素
    ages -= "leo"
    println(ages.toString())

    //根据键判断元素是否存在
    if (ages.contains("leo")) ages("leo") else ages

    //根据键获取，不存在则返回默认的值
    val mikeAge = ages.getOrElse("leo", 10)
    println("mikeAge:" + mikeAge)

    //添加元素
    ages += ("leo" -> 33, "walloce" -> 25)

    val ages2 = ages + ("mike" -> 33)
    println(ages2.toString())

    //map遍历
    println("for循环遍历1：")
    for ((key, value) <- ages2) {
      println(key + "->" + value)
    }

    //遍历map的key
    println("for循环遍历2：")
    for (key <- ages2.keySet) {
      print(key + " ")
    }

    //遍历map的value
    println("\nfor循环遍历3：")
    for (value <- ages2.values) {
      print(value + " ")
    }

    //yield反转生成新的map
    println("\nyield反转：")
    val ages3 = for ((key, value) <- ages2) yield (value, key)
    println(ages3.toString())
  }

  def TupleTest(): Unit = {
    //创建不可变的元组
    val tup1 = Tuple3("jack", "jeny", "suny")
    println(tup1.toString())
    println("取出元组中的元素：", tup1._1)

    //zip操作
    println("zip操作：")
    val name = Array("jack", "jeny", "suny")
    val age = Array(15, 19, 13)

    val nameAge = name.zip(age)
    for ((name, age) <- nameAge) {
      println(name + "->" + age)
    }
  }

  def main(args: Array[String]): Unit = {
    //MapTest()
    //TupleTest()
    //println(1)

    //Map一对一映射操作
    val scoreMap = Map("jack" -> 90, "walloce" -> 80, "sum" ->60)
    val names = List("jack", "walloce", "sum")
    val result = names.map(scoreMap(_))

    //flatMap操作，一对多映射
    val flatscoreMap = Map("jack" -> List(90, 78, 75), "walloce" -> List(86, 64, 97), "sum" -> List(60, 55, 78))
    println(names.map(flatscoreMap(_)))
    println(names.flatMap(flatscoreMap(_)))

    //collect操作，结合偏函数使用
    val re = "abc".collect{
      case 'a' => 1
      case 'b' => 3
      case 'c' => 5
    }
    println(re)

    //reduce操作,reduceRight:(1-(2-(3-(4-5))))
    val list = List(1, 2, 3, 4, 5)
    var re1 = list.reduceLeft(_ + _)
    re1 = list.reduceLeft(_ - _)
    re1 = list.reduceRight(_ - _)
    println(re1)
    println((1-(2-(3-(4-5)))))

    //fold操作
    //初始值为20，从右边开始减：(1-(2-(3-(4-(5-20)))))
    var re2 = list.foldRight(20)(_ - _)
    re2 = list.foldLeft(20)(_ - _)
    println(re2)
    println((1-(2-(3-(4-(5-20))))))
  }
}
