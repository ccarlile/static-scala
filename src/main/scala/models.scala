package com.benntoo.example

import scalaz._
import scalaz.concurrent.Task

object Models {
  type ApplicationK[A] = Kleisli[Task, Config, A]
}
