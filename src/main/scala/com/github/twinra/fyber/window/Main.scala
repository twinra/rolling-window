package com.github.twinra.fyber.window

import java.io.File

import Formatter._

import scala.io.Source

object Main {
  def main(args: Array[String]) {
    args.headOption.filter(new File(_).exists()) match {
      case None =>
        println("Please, pass path to existing file as an argument")
      case Some(fileName) =>
        println(header)
        println("-" * header.length)
        var rw = RollingWindow.empty(60)
        Source.fromFile(fileName).getLines().foreach { line =>
          val record = PriceRatioRecord.parse(line)
          rw = rw.shift(record)
          println(format(rw))
        }
    }
  }
}

