package com.github.push2s

import java.net.InetSocketAddress

import com.github.push2s.auth.ApnsSigningKey
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.handler.codec.http2.Http2FrameLogger
import io.netty.handler.ssl._
import io.netty.util.concurrent.{Future, GlobalEventExecutor, SucceededFuture}

protected class ApnsClient(apnsServerAddress: InetSocketAddress, sslContext: SslContext
                 , signingKey: ApnsSigningKey, connectTimeoutMillis: Int
                 , idlePingIntervalMillis: Long, gracefulShutdownTimeoutMillis: Long
                 , concurrentConnections: Int, m: ApnsClientMetricsListener
                 , frameLogger: Http2FrameLogger, eventLoopGroup: EventLoopGroup
                ){

  // constructor
  private var shouldShutDownEventLoopGroup: Boolean = false

  private val this.eventLoopGroup: EventLoopGroup = eventLoopGroup match {
    case v: EventLoopGroup =>
      shouldShutDownEventLoopGroup = true
      v
    case _ => new NioEventLoopGroup(1)
  }

  private val metricsListener = if (m != null) m else new ApnsClient.NoopApnsClientMetricsListener

  private val channelPoolMetricsListener = new ApnsChannelPoolMetricsListener {
    override def handleConnectionAdded(): Unit =
      metricsListener.handleConnectionAdded(apnsClient = ApnsClient.this)
    override def handleConnectionRemoved(): Unit =
      metricsListener.handleConnectionRemoved(apnsClient = ApnsClient.this)
    override def handleConnectionCreationFailed(): Unit =
      metricsListener.handleConnectionCreationFailed(apnsClient = ApnsClient.this)
  }

  // method
  def sendNotification[T <: ApnsPushNotification] (notification: T): PushNotificationFuture[T, PushNotificationResponse[T]] = {
    var responseFuture = null
    responseFuture
  }

  def close() : Future[Void] = {
    val closeFuture: Future[Void] = new SucceededFuture[Void](GlobalEventExecutor.INSTANCE, null)
    closeFuture
  }

}

object ApnsClient {

  private class NoopApnsClientMetricsListener extends ApnsClientMetricsListener {
    override def handleWriteFailure(apnsClient: ApnsClient, notificationId: Long): Unit = {
    }

    override def handleNotificationSent(apnsClient: ApnsClient, notificationId: Long): Unit = {
    }

    override def handleNotificationAccepted(apnsClient: ApnsClient, notificationId: Long): Unit = {
    }

    override def handleNotificationRejected(apnsClient: ApnsClient, notificationId: Long): Unit = {
    }

    override def handleConnectionAdded(apnsClient: ApnsClient): Unit = {
    }

    override def handleConnectionRemoved(apnsClient: ApnsClient): Unit = {
    }

    override def handleConnectionCreationFailed(apnsClient: ApnsClient): Unit = {
    }
  }

}
