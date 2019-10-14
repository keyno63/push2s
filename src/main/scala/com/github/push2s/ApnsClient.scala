package com.github.push2s

import java.net.InetSocketAddress

import com.github.push2s.auth.ApnsSigningKey
import io.netty.channel.EventLoopGroup
import io.netty.handler.codec.http2.Http2FrameLogger
import io.netty.handler.ssl._

class ApnsClient(apnsServerAddress: InetSocketAddress, sslContext: SslContext
                 , signingKey: ApnsSigningKey, connectTimeoutMillis: Int
                 , idlePingIntervalMillis: Long, gracefulShutdownTimeoutMillis: Long
                 , concurrentConnections: Int, metricsListener: ApnsClientMetricsListener
                 , frameLogger: Http2FrameLogger, eventLoopGroup: EventLoopGroup
                ){

}
