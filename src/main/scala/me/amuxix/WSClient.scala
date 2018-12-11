package me.amuxix
import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.github.benmanes.caffeine.cache.{Caffeine, Ticker}
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import play.api.libs.ws.ahc.cache.{Cache, EffectiveURIKey, ResponseEntry}

import scala.concurrent.{ExecutionContext, Future}

object WSClient {
  def wsClient(implicit ec: ExecutionContext): (ActorSystem, StandaloneAhcWSClient) = {
    // Create Akka system for thread and streaming management
    implicit val system = ActorSystem()
    system.registerOnTermination {
      System.exit(0)
    }
    implicit val materializer = ActorMaterializer()

    // Create the standalone WS client
    // no argument defaults to a AhcWSClientConfig created from
    // "AhcWSClientConfigFactory.forConfig(ConfigFactory.load, this.getClass.getClassLoader)"
    class CaffeineHttpCache extends Cache {
      val underlying = Caffeine.newBuilder()
        .ticker(Ticker.systemTicker())
        .expireAfterWrite(365, TimeUnit.DAYS)
        .build[EffectiveURIKey, ResponseEntry]()

      override def remove(key: EffectiveURIKey) = Future.successful(Option(underlying.invalidate(key)))
      override def put(key: EffectiveURIKey, entry: ResponseEntry) = Future.successful(underlying.put(key, entry))
      override def get(key: EffectiveURIKey) = Future.successful(Option(underlying.getIfPresent(key)))
      override def close(): Unit = underlying.cleanUp()
    }
    val cache = new CaffeineHttpCache()
    //val client = StandaloneAhcWSClient(httpCache = Some(new AhcHttpCache(cache)))
    val client = StandaloneAhcWSClient(httpCache = None)
    (system, client)
  }
}
