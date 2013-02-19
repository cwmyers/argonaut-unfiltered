package argonaut.unfiltered

import unfiltered.request._

import argonaut._, Argonaut._

object JsonBody {
  /**
   * See argonaut.ParseWrap for API details.
   */
  def apply[T](r: HttpRequest[T]) =
    new ParseWrap(r, new Parse[HttpRequest[T]] {
      def parse(req: HttpRequest[T]) = JsonParser.parse(Body.string(req))
    })
}
