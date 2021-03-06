/*
 * Copyright 2018 MOIA GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.moia.streamee

import scala.concurrent.duration.DurationInt
import utest._

object ExpiringPromiseTests extends ActorTestSuite {
  import testKit._

  override def tests: Tests =
    Tests {
      'expire - {
        val timeout = 100.milliseconds
        val promise = ExpiringPromise[String](timeout, "hint")
        promise.future.failed.map(e => assert(e == PromiseExpired(timeout, "hint")))
      }

      'expireNot - {
        val timeout = 100.milliseconds
        val promise = ExpiringPromise[String](timeout)
        promise.trySuccess("success")
        promise.future.map(s => assert(s == "success"))
      }
    }
}
