package com.benntoo.example

import doobie.imports._
import scalaz.concurrent.Task


case class Config(
  repo: Repositories,
  service: Services,
  xa: Transactor[Task],
  cfg: AppConfig
)

case class Repositories(foo: Int)
case class Services(foo: Int)
case class AppConfig(
  port: Int
  //facebook Keys
)
