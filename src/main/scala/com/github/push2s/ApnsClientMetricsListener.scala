package com.github.push2s

trait ApnsClientMetricsListener {
  def handleWriteFailure(apnsClient: ApnsClient, notificationId: Long): Unit = {
  }

  def handleNotificationSent(apnsClient: ApnsClient, notificationId: Long): Unit = {
  }

  def handleNotificationAccepted(apnsClient: ApnsClient, notificationId: Long): Unit = {
  }

  def handleNotificationRejected(apnsClient: ApnsClient, notificationId: Long): Unit = {
  }

  def handleConnectionAdded(apnsClient: ApnsClient): Unit = {
  }

  def handleConnectionRemoved(apnsClient: ApnsClient): Unit = {
  }

  def handleConnectionCreationFailed(apnsClient: ApnsClient): Unit = {
  }


}
