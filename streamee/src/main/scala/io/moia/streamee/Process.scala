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

import akka.stream.scaladsl.FlowWithContext
import scala.concurrent.Promise

object Process {

  /**
    * Factory for an identity [[ProcessStage]] which can be used as an entry point for creating
    * processes.
    *
    * @tparam Req request type
    * @tparam Res response type
    */
  def apply[Req, Res](): ProcessStage[Req, Req, Res] =
    FlowWithContext[Promise[Res], Req]
}
