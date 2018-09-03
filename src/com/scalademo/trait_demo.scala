package com.scalademo

trait trait_demoTrait {
  def sayHello(name:String)
}

trait makeFriendsTrait {
  def makeFriend(p:Strienger)
}

class Strienger(val name:String) extends trait_demoTrait with makeFriendsTrait with Serializable {
  def sayHello(name:String) = println("Hello," + name)
  def makeFriend(p:Strienger) = println("My name is "+name + ", your name is "+ p.name)
}

object testTrait{
  def main(args: Array[String]): Unit = {
    val strienger = new Strienger("jack")
    val me = new Strienger("mike")
    me.sayHello("jack")
    me.makeFriend(strienger)
  }
}
