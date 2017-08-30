package com.benntoo.example

import scalaz.concurrent.Task
import org.http4s._
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.server.{ServerApp, Server}
import doobie.imports._
import scalaz._, Scalaz._

object DemoServer extends ServerApp {
  import Models._
  val repos = Repositories(1)
  val services = Services(1)
  val config = AppConfig(1)
  val transactor = DriverManagerTransactor[Task]("org.postgresql.driver", "jdbc:postgresql:world","postgres","")
  val cfg = Config(repos, services, transactor, config)

  override def server(args: List[String]): Task[Server] =
    startServer(TestService.service(cfg))

  // def createService(config: Config): HttpService
  // def createConfig(): Task[Config]
  // createConfig andThen createService andThen startServer

  def startServer(service: HttpService): Task[Server] =
    BlazeBuilder
      .bindHttp(8080)
      .mountService(service, "/")
      .start
}
