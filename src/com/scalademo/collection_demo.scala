package com.scalademo

import scala.collection.{immutable, mutable}

object collection_demo {

  //递归遍历list的元素，可以在递归函数中操作元素
  def listDemo(lst: List[Int]): Unit = {
    if (lst != Nil) {
      println(lst.head)
      listDemo(lst.tail)
    }
  }

  //可变集合LinkedList, 每个元素乘以2
  def linkedListDemo() = {
    val list = scala.collection.mutable.LinkedList(1, 2, 3, 4, 5)
    var currentList = list
    while (currentList != Nil) {
      currentList.elem = currentList.elem * 2
      currentList = currentList.next
    }
    list
  }

  //将list中的元素，从第一个开始隔一个就乘以2
  def linkedListDemo2() = {
    val list = scala.collection.mutable.LinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var currentList = list
    var first = true
    while (currentList != Nil && currentList.next != Nil) {
      if (first) {
        currentList.elem = currentList.elem * 2
        first = false
      }
      currentList = currentList.next.next
      if (currentList != Nil) {
        currentList.elem = currentList.elem * 2
      }
    }
    list
  }

  //set集合是不能存放重复元素的，会自动过滤掉重复的元素
  def setDemo() = {
    var set = Set(1, 2, 3, 4, 5)
    set += 1
    set += 4
    set += 6

    set
  }

  //保存元素插入的顺序
  def linkedHashSetDemo() = {
    val hashSet = new scala.collection.mutable.LinkedHashSet[Int]
    hashSet += 1
    hashSet += 2
    hashSet += 3
    hashSet += 4
    hashSet
  }

  //list集合排序
  /*def sortedSetDemo():mutable.SortedSet[String] {
    mutable.SortedSet("orange", "apple", "banana")
  }*/

  //统计文本内的单词数量
  def countWord(): Unit = {
    val line1 = scala.io.Source.fromFile("E:\\IdeaWorkspace\\scala_demo\\src\\com\\scalademo\\text\\text1.txt", "UTF-8").mkString
    val line2 = scala.io.Source.fromFile("E:\\IdeaWorkspace\\scala_demo\\src\\com\\scalademo\\text\\text2.txt", "UTF-8").mkString
    val list = List(line1, line2)
    list.foreach(a => print(a + " "))
    val nums = list.flatMap(_.split(" ")).map((_, 1)).map(_._2).reduceLeft(_ + _)
    println("一共有："+ nums +"个单词")

    val line = line1 +" "+ line2
    println(line)
    val param = list.flatMap(_.split(" ")).map((_, 1))
    param.foreach(println(_))

  }

  def main(args: Array[String]): Unit = {
    var list = List(1, 2, 3, 4, 5)
    listDemo(list)
    val list2 = linkedListDemo()
    list2.foreach(a => {
      println(a, "b")
    })
    val list3 = linkedListDemo2()
    list3.foreach(a => {
      println("*" * a)
    })

    val set = setDemo()
    set.foreach(print(_))

    println("\n保存插入顺序:")
    val hashSet = linkedHashSetDemo()
    hashSet.foreach(print(_))

    val setlist = List(2, 3, 1, 4, 5, 0)
    //val sortSet = sortedSetDemo()
   // sortSet.foreach(print(_))

    val s = scala.collection.mutable.SortedSet("orange", "apple", "banana")
    s.foreach(println(_))
    countWord()
  }
}
