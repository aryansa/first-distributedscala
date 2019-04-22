package worker

import java.util.concurrent.ThreadLocalRandom

import akka.actor.{Actor, Props}

import scala.concurrent.duration._

/**
  * Work executor is the actor actually performing the work.
  */
object WorkExecutor {
  def props = Props(new WorkExecutor)

  case class DoWork(n: BigInt)
  case class WorkComplete(result: Set[BigInt])
}

class WorkExecutor extends Actor {
  import WorkExecutor._
  import context.dispatcher

  def receive = {
    case DoWork(n: BigInt) =>
      var part = new Part(n,1000)
      part.updateBoll
      part.serPrime
//      val primenum = part.getPrime
      var result = part.getPrime
//      for (i<-0 until primenum.size() ) result = result+" "+primenum.get(i)+""


      // simulate that the processing time varies
      val randomProcessingTime = ThreadLocalRandom.current.nextInt(1, 3).seconds
      context.system.scheduler.scheduleOnce(randomProcessingTime, sender(), WorkComplete(result))
  }

}