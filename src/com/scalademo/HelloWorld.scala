package com.scalademo

object HelloWorld {

  class HelloWorld {
    def test1(): Unit = {
      println("Hello black kids!")
    }
  }

  def test(): Unit = {
    println("Hello White kids!")
  }

  def arr(): Unit = {
    val arr = Array("a", "b", "c")
    /*arr.flatMap(_ => (_,1){

    })*/
    arr.iterator.foreach(obj => {
      print(obj + "  ")
    })
  }

  def multi(): Unit = {
    println("九九乘法口诀：")
    for (i <- 1 to 9) {
      for (j <- 1 to i) {
        print(i + "*" + j + "=" + i * j + "  ")
      }
      println()
    }
  }

  def main(args: Array[String]): Unit = {
    test()
    //arr()
    //multi()
    var helloWorld = new HelloWorld()
    helloWorld.test1()
    println("Hello World!")
  }
}
