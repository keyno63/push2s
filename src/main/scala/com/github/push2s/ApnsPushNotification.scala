package com.github.push2s

import java.util.{Date, UUID}

import io.netty.util.concurrent.Future

trait ApnsPushNotification {

}

trait PushNotificationFuture[T <: ApnsPushNotification, V] extends Future[V] {
  def getPushNotification: T
}

trait PushNotificationResponse[T <: ApnsPushNotification] {
  def getPushNotification: T
  def isAccepted: Boolean
  def getApnsId: UUID
  def getRejectionReason: String
  def getTokenInvalidationTimestamp: Date
}