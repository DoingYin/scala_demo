package com.scalademo

object func_demo {

  //函数
  def sayHello(name:String): Unit = {
    println("Hello "+ name)
  }

  //将函数作为参数
  def getFunc(func:(String) => Unit, name:String) = {
    func(name)
  }

  //将函数作为返回值,返回参数为name的匿名参数
  def getGreetingFunc(msg:String) = (name:String) => println(msg + ", " + name)

  //将函数作为参数
  def greeting(func:(String) => Unit, name:String) = func(name)

  //带返回值的函数作为参数
  def triple(func:(Int) => Int) = { func(5)}

  def main(args: Array[String]): Unit = {

    val result = triple(5 * _)
    println(result)

    //匿名函数作为参数
    greeting((name:String) => println("Hello," +name), "Merry")

    val sayHelloFunc = sayHello _
    sayHelloFunc("mike")

    val sayHelloFunc1 = (name:String) => println("Hello "+ name)
    sayHelloFunc1("jack")

    getFunc(sayHelloFunc, "walloce")

    val getGreeFunc = getGreetingFunc("Hello")
    getGreeFunc("Alen")

    /**
      * 常用的高阶函数
      */
    //map:对传入的每个元素进行映射，返回每个处理后的元素
    Array(1, 2, 3, 4, 5).map(2 * _).foreach(println(_))

    //foreach：对传入的每个元素都进行处理，没有返回值
    (1 to 10).map("*"*_).foreach(println(_))

    //filter:对传入的每个元素进行条件判断处理，返回true的留下，否则过滤掉
    (1 to 10).filter( _ % 2 == 0).foreach(println(_))

    //reduceLeft:从左侧元素开始，进行reduce操作
    val sum = (1 to 10).reduceLeft(_ + _)
    println(sum)

    val sum1 = (1 to 20).reduce(_ + _)
    println(sum1)

    //softwith:对元素进行两两对比排序
    val arr = Array(1,4,2,4,5,0).sortWith(_ < _)
    println(arr.foreach(print(_)))

    def getGreetingFunc1(msg: String) = (name: String) => println(msg + ", " + name)
    val greetingFuncHello = getGreetingFunc1("hello")
    val greetingFuncHi = getGreetingFunc1("hi")

    getGreetingFunc1("Hi")("mike")

    greetingFuncHello("tom")
    greetingFuncHi("sum")

    def sumInt1(a:Int, b:Int) = a + b
    println(sumInt1(1, 3))

    def sumInt2(a:Int) = (b:Int) => a + b
    val sumInt21 = sumInt2(1)
    println(sumInt21(4), sumInt2(2)(4))

    def sumInt3(a:Int)(b:Int) = a + b
    println(sumInt3(5)(5))

    def greeting1(name: String) = {
      def sayHello(name: String):String = {
        return "Hello, " + name
      }
      sayHello(name)
    }
    val msg = greeting1("jack")
    println(msg)
  }

}
