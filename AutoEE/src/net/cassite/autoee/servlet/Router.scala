package net.cassite.autoee.servlet

import net.cassite.autoee.App

/**
 * @author wkgcass
 */
class Router(private val app: App) {
  import Method._

  private val routes = Map[Method, scala.collection.mutable.Map[String, (HttpArgs) => Unit]](
    Delete -> new scala.collection.mutable.HashMap[String, (HttpArgs => Unit)],
    Post -> new scala.collection.mutable.HashMap[String, (HttpArgs => Unit)],
    Get -> new scala.collection.mutable.HashMap[String, (HttpArgs => Unit)],
    Head -> new scala.collection.mutable.HashMap[String, (HttpArgs => Unit)],
    Options -> new scala.collection.mutable.HashMap[String, (HttpArgs => Unit)],
    Put -> new scala.collection.mutable.HashMap[String, (HttpArgs => Unit)],
    Trace -> new scala.collection.mutable.HashMap[String, (HttpArgs => Unit)])

  def update(route: String, func: (HttpArgs) => Unit) = Match(Array(Delete, Get, Head, Options, Post, Put, Trace), route, func)

  def get(route: String, func: (HttpArgs) => Unit) = Match(Array(Get), route, func)

  def post(route: String, func: (HttpArgs) => Unit) = Match(Array(Post), route, func)

  def Match(methods: Array[Method], route: String, func: (HttpArgs) => Unit): Unit = methods.foreach { method => routes(method)(route) = func }

}