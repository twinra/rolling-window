package com.github.twinra.fyber.window

import org.scalatest.{FlatSpec, Matchers}

class RollingWindowTest extends FlatSpec with Matchers {
  it should "calc max, min and sum in window properly" in {
    val records = List(PriceRatioRecord(1, 1.5), PriceRatioRecord(1, 1.4), PriceRatioRecord(1, 1.6))
    val window = new RollingWindow(1, records)

    window.min should be (1.4)
    window.max should be (1.6)
    window.sum should be (4.5)
  }

  it should "exclude outdated records on window shift" in {
    val records = List(PriceRatioRecord(99, 1.0), PriceRatioRecord(100, 1.0), PriceRatioRecord(101, 1.0))
    val window = new RollingWindow(100, records).shift(PriceRatioRecord(200, 1.0))

    window.measuresNumber should be (2)
  }

  it should "set new record as last one" in {
    val records = List(PriceRatioRecord(99, 1.0), PriceRatioRecord(100, 1.0))
    val window = new RollingWindow(100, records).shift(PriceRatioRecord(100, 2.0))

    window.lastTime should be (100)
    window.lastValue should be (2.0)
  }
}
