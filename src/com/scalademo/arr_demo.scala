package com.scalademo

import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

object arr_demo {


  def testArr(): Unit = {
    val arr: Array[Int] = Array(1, 2, 3, 4)

    //数组通过yield的转换
    println("yield转换：")
    val arr1 = for (a <- arr) yield a * 2
    for (a1 <- arr1) {
      print(a1 + " ")
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
    val arr3: Array[Int] = arr.filter(_ % 2 == 0).map(_ * 2)
    for (a3 <- arr3) {
      print(a3 + " ")
    }
  }

  def arrUpdate(): Unit = {
    //构建数组
    val arr = ArrayBuffer[Int]()
    arr += (1, 2, 3, 4, 5, -1, -4, -5, 9)

    //集合拼接
    val ab = Array(11, 12, 13)
    val ab1 = Array(21, 22, 23)
    arr ++= ab
    println(arr.toString())

    //合并数组
    import Array._
    var arr3 = concat(ab1, ab)
    println("合并数组：")
    for (a <- arr3) {
      print(a + " ")
    }

    print("\n数组长度：" + arr.length + "\n")
    val arr1 = for (a <- arr if a > 0) yield a
    for (a <- arr1) {
      print(a)
    }

    println("\n数组移除,移除所有的负数")
    val keepIndexes: immutable.Seq[Int] = for (i <- 0 until arr.length if arr(i) >= 0) yield {
      i
    }

    //将筛选好的数组重新赋给原来的数组
    for (i <- 0 until keepIndexes.length) {
      arr(i) = arr(keepIndexes(i))
    }

    //通过长度，去掉后几位元素
    arr.trimEnd(arr.length - keepIndexes.length)
    println(arr.toString())

    //计算array中的所有值之和
    var sum = 0;
    for (a <- arr) {
      sum += a
    }
    println("list值之和：" + sum)

    //计算array中的最大值
    var max = arr(0)
    for (a <- arr) {
      if (a > max) {
        max = a
      }
    }
    println("array中的最大值为：" + max)

    //计算array中的最小值
    var min = arr(0)
    for (a <- arr) {
      if (a < min) {
        min = a
      }
    }
    println("array中的最小值为：" + min)

    //清空数组
    arr.clear()
    println(arr.toString())
  }

  //数组的方法测试
  def arrFunc(): Unit = {

    //apply方法
    val arr = Array(1, 2, 3)

    //iterate方法生成数组
    val arr2: Array[Int] = Array.iterate(10, 10)(a => a + 1)
    println("方法iterate生成数组:" + arr2.toString)
    for (a <- arr2) {
      print(a + " ")
    }

    //fill方法
    val arr3 = Array.fill(5)(2)
    println("\n方法fill:" + arr3.toString)
    for (a <- arr3) {
      print(a + " ")
    }

    //二维数组
    print("\n二维数组\n")
    val arr4 = Array.fill(5, 4)(3, 2)
    for (a <- arr4) {
      for (a1 <- a) {
        print(a1 + " ")
      }
      println()
    }

    //创建指定区间内的数组
    println("\n指定区间内的数组:\n")
    val arr5 = Array.range(0, 100, 5)
    for (a <- arr5) {
      print(a + " ")
    }

    //tabulate创建数组， 默认从0开始，a+n标识从n开始
    println("\ntabulate 数组：")
    val arr6 = Array.tabulate(5)(a => a + 10)
    for (a <- arr6) {
      print(a + " ")
    }
  }

  def main(args: Array[String]): Unit = {
    //testArr()
    //arrUpdate()
    arrFunc()
  }
}
