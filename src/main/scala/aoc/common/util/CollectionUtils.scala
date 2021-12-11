package aoc.common.util

object CollectionUtils {

  implicit class RichList[T](list: List[T]) {

    def reverseIf(cond: Boolean): List[T] = {
      if (cond) list.reverse else list
    }

    def splitWhen(p: T => Boolean): List[List[T]] = {
      List.unfold(list) {
        case Nil => None
        case l if !p(l.head) => Some(l.span(o => !p(o)))
        case _ :: tail => Some(tail.span(o => !p(o)))
      }
    }

    def times(n: Int): List[T] = {
      list.flatMap { List.fill(n)(_) }
    }
  }
}
