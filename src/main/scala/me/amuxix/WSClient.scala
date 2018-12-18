package me.amuxix

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws.ahc.StandaloneAhcWSClient

object WSClient {
  def wsClient: (ActorSystem, StandaloneAhcWSClient) = {
    // Create Akka system for thread and streaming management
    implicit val system = ActorSystem()
    system.registerOnTermination {
      System.exit(0)
    }
    implicit val materializer = ActorMaterializer()

    val client = StandaloneAhcWSClient(httpCache = None)
    (system, client)
  }
}
