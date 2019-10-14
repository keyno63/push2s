package com.github.push2s

trait ApnsChannelPoolMetricsListener {

  def handleConnectionAdded(): Unit
  def handleConnectionRemoved(): Unit
  def handleConnectionCreationFailed(): Unit

}
