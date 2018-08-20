package com.scalademo

object arr_demo {


  def testArr(): Unit = {
    val arr: Array[Int] = Array(1, 2, 3, 4)

    //数组通过yield的转换
    println("yield转换：")
    val arr1 = for (a <- arr) yield a * 2
    for (a1 <- arr1) {
      print(a1 +" ")
    }
    println()
    //if守卫，转换数组
    println("if 守卫：")
    val arr2 = for (a <- arr if a % 2 == 1) yield a
    for (a2 <- arr2) {
      print(a2 + " ")
    }
    println()

    //通过函数式编程转换
    println("函数式编程：")
    val arr3: Array[Int] = arr.filter(_ % 2 == 0).map(_*2)
    for (a3 <- arr3) {
      print(a3 + " ")
    }
  }

  def main(args: Array[String]): Unit = {
    testArr()
  }
}
