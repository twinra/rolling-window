package com.github.twinra.fyber.window

import scala.util.{Failure, Success, Try}

case class PriceRatioRecord(timestamp: Long, priceRatio: Double)

object PriceRatioRecord {
  private val pattern = """(.+)\s(.+)""".r
  def parse(line: String): PriceRatioRecord = {
    Try {
      val pair = pattern.findAllMatchIn(line).map(m => (m.group(1), m.group(2))).toList.head
      PriceRatioRecord(pair._1.toLong, pair._2.toDouble)
    } match {
      case Success(record) => record
      case Failure(ex) => throw new RuntimeException(s"$line is malformed", ex)
    }
  }

  val zero = PriceRatioRecord(0, 0)
}
