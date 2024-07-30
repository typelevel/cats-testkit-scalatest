package cats.tests

import cats.data.{NonEmptyChain, NonEmptyList, NonEmptySeq, NonEmptyVector}
import org.scalactic.Equality
import org.scalatest.enablers.Sequencing

import scala.collection.GenTraversable

trait CatsSequencing {

  implicit def sequencingNatureOfNel[E: Equality](implicit delegate: Sequencing[List[E]]): Sequencing[NonEmptyList[E]] =
    new Sequencing[NonEmptyList[E]] {

      def containsInOrder(seq: NonEmptyList[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrder(seq.toList, elements)

      def containsInOrderOnly(seq: NonEmptyList[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrderOnly(seq.toList, elements)

      def containsTheSameElementsInOrderAs(seq: NonEmptyList[E], elements: GenTraversable[Any]): Boolean =
        delegate.containsTheSameElementsInOrderAs(seq.toList, elements)
    }

  implicit def sequencingNatureOfNec[E: Equality](implicit delegate: Sequencing[List[E]]): Sequencing[NonEmptyChain[E]] =
    new Sequencing[NonEmptyChain[E]] {

      def containsInOrder(seq: NonEmptyChain[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrder(seq.toChain.toList, elements)

      def containsInOrderOnly(seq: NonEmptyChain[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrderOnly(seq.toChain.toList, elements)

      def containsTheSameElementsInOrderAs(seq: NonEmptyChain[E], elements: GenTraversable[Any]): Boolean =
        delegate.containsTheSameElementsInOrderAs(seq.toChain.toList, elements)
    }

  implicit def sequencingNatureOfNeSeq[E: Equality](implicit delegate: Sequencing[Seq[E]]): Sequencing[NonEmptySeq[E]] =
    new Sequencing[NonEmptySeq[E]] {

      def containsInOrder(seq: NonEmptySeq[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrder(seq.toSeq, elements)

      def containsInOrderOnly(seq: NonEmptySeq[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrderOnly(seq.toSeq, elements)

      def containsTheSameElementsInOrderAs(seq: NonEmptySeq[E], elements: GenTraversable[Any]): Boolean =
        delegate.containsTheSameElementsInOrderAs(seq.toSeq, elements)
    }

  implicit def sequencingNatureOfNev[E: Equality](implicit delegate: Sequencing[Vector[E]]): Sequencing[NonEmptyVector[E]] =
    new Sequencing[NonEmptyVector[E]] {

      def containsInOrder(seq: NonEmptyVector[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrder(seq.toVector, elements)

      def containsInOrderOnly(seq: NonEmptyVector[E], elements: scala.collection.Seq[Any]): Boolean =
        delegate.containsInOrderOnly(seq.toVector, elements)

      def containsTheSameElementsInOrderAs(seq: NonEmptyVector[E], elements: GenTraversable[Any]): Boolean =
        delegate.containsTheSameElementsInOrderAs(seq.toVector, elements)
    }
}

object CatsSequencing extends CatsSequencing