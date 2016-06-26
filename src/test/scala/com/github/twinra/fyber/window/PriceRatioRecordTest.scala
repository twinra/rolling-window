package com.github.twinra.fyber.window

import org.scalatest.{FlatSpec, Matchers}

class PriceRatioRecordTest extends FlatSpec with Matchers {

  it should "parse PriceRatioRecords with space delimeter" in {
    val (ts, pr) = (1355270609L, 1.80215)
    PriceRatioRecord.parse(s"$ts $pr") should equal (PriceRatioRecord(ts, pr))
  }


  it should "parse PriceRatioRecords with tab delimeter" in {
    val (ts, pr) = (1411270609L, 1.79215)
    PriceRatioRecord.parse(s"$ts $pr") should equal (PriceRatioRecord(ts, pr))
  }
}
