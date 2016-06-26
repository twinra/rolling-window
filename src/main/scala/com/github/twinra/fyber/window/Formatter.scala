package com.github.twinra.fyber.window

import java.text.DecimalFormat

object Formatter {

  val header: String = {
    val space = " "
    val columns = List("T" -> 10, "V" -> 7, "N" -> 2, "RS" -> 8, "MaxV" -> 7, "MinV" -> 7)
    columns.map { case (k, v) => k + space * (v - k.length) }.mkString(space)
  }

  private val formatter = new DecimalFormat("#.#####")
  private def format(v: Double) = formatter.format(v)

  def format(rw: RollingWindow): String = {
    "%d %-7s %-2d %-8s %-7s %-7s".format(
      rw.lastTime,
      format(rw.lastValue),
      rw.measuresNumber,
      format(rw.sum),
      format(rw.min),
      format(rw.max)
    )
  }
}
