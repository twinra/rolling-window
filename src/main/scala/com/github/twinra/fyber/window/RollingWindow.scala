package com.github.twinra.fyber.window

class RollingWindow (size: Long, records: List[PriceRatioRecord]) {

  private val prices = records.map(_.priceRatio)

  def shift(record: PriceRatioRecord): RollingWindow =
    new RollingWindow(size, record :: records.filter(_.timestamp > record.timestamp - size))

  lazy val lastTime: Long = records.head.timestamp

  lazy val lastValue: Double = records.head.priceRatio

  val measuresNumber: Int = records.size

  lazy val max: Double = prices.max

  lazy val min: Double = prices.min

  val sum: Double = prices.sum
}

object RollingWindow {
  def empty(size: Long) = new RollingWindow(size, List.empty)
}