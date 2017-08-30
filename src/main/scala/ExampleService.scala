package com.benntoo.example

import scalaz.concurrent.Task
import org.http4s.dsl._
import org.http4s.server._
import org.http4s._
import org.http4s.headers._
import org.http4s.MediaType._

import java.io.File

import scala.concurrent._
import scalaz._

import scalatags.Text.all._

object TestService {
  import Models._
  def getService(config: Config)(implicit ec: ExecutionContext = ExecutionContext.global): HttpService = HttpService {
    case GET -> Root =>
      Ok("pong configured value is" ++ config.cfg.port.toString)
    case GET -> Root / "second-endpoint" =>
      Task.delay(Response(Status.Ok))
    case GET -> Root / "danke" =>
      Task.delay(Response(Status.Ok))
    case GET -> Root/ "hello" =>
      Ok().withBody(renderPage(config)).withContentType(Some(`Content-Type`(`text/html`)))
  }

  def service(config: Config)(implicit ec: ExecutionContext = ExecutionContext.global): HttpService =
    Router(
      "" -> testService,
      "/configured" -> getService(config)
    )

  def renderPage(config: Config): String = {
    html(body(h2("I SAID, LOOK MA NO TEMPLATES"))).toString
  }

  def testService(implicit ec: ExecutionContext = ExecutionContext.global) = HttpService {
    case GET -> Root =>
      Ok("pong")
  }
}
