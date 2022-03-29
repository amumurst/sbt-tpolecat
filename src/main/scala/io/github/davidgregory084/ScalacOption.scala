/*
 * Copyright 2022 David Gregory
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

package io.github.davidgregory084

case class ScalacOption(
  tokens: List[String],
  isSupported: ScalaVersion => Boolean = _ => true
) {
  // We don't want to use `isSupported` in hashCode
  override def hashCode(): Int =
    41 * tokens.hashCode

  // We don't want to compare `isSupported` for equality
  override def equals(other: Any): Boolean =
    other match {
      case that: ScalacOption => this.tokens == that.tokens
      case _                  => false
    }
}
