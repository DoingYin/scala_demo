package com.scalademo.file

import scala.io.Source

object file_demo {

  //使用Source.getLines返回迭代器
  def getLines1(path:String): Unit = {
    println("Source.getLines:")
    val data = Source.fromFile(path, "UTF-8")
    val lineIterator = data.getLines();
    for (line <- lineIterator) println(line)
  }

  //将Source.getLines返回的迭代器转换成数组
  def getLines2(path:String): Unit = {
    println("Source.getLines to Array:")
    val data = Source.fromFile(path, "UTF-8")
    val arr = data.getLines().toArray
    for (line <- arr) println(line)
  }

  //调用Source.mkString读取所有的内容
  def getContent(path:String): Unit = {
    println("Source.mkString:")
    val data = Source.fromFile(path, "UTF-8")
    val content = data.mkString
    println(content)
  }

  //获取内容中的字符
  def getChar(path:String): Unit = {
    val data = Source.fromFile(path, "UTF-8")
    for (c <- data) println(c)
  }

  //通过url获取数据
  def getFromUrl(url:String): Unit = {
    val data = Source.fromURL(url, "UTF-8")
    println(data.mkString)
  }

  def main(args: Array[String]): Unit = {
    val path = "E:\\IdeaWorkspace\\scala_demo\\src\\com\\scalademo\\text\\text1.txt"
    /*getLines1(path)
    getLines2(path)
    getContent(path)*/
    //getChar(path)
    getFromUrl("http://www.baidu.com")
  }
}
