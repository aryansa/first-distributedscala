package worker

import java.util

class Part(firstt: BigInt, n: Int) {
  private var first = firstt;
  private var lenth = n;
  private var booleans = new Array[Boolean](n)
  private var priem : Set[BigInt] = Set();

  def updateBoll: Unit =  {
    var number:BigInt = 0
    var j =2
    for (i <- 0 until booleans.length) {
      j = 2;
      if (booleans(i) == false) {
        number = i + getFirst;
        while ( {
          j <= sqt(number)+1
        }) {
          if (number % j == 0) {
            booleans(i) = true
          }
          j = j + 1;
        }
      }
    }
  }

  def getBoll: Array[Boolean] = booleans
  def getPrime : Set[BigInt] = priem
  def serPrime: Unit = for (i <- 0 until n) if (booleans(i) == false ) priem += (i + first)

  def getLenth: Int = this.lenth

  def getLast: BigInt = this.first + lenth

  def getFirst: BigInt = this.first

  def getNumber(n: Int): BigInt = first + n
  def sqt(n: BigInt): BigDecimal = {
    val d = BigDecimal(n)
    var a = BigDecimal(1.0)
    var b = d
    while (b - a >= 0) {
      val mid = (a + b) / 2
      if (mid * mid - d > 0) b = mid - 0.0001 //adjust down
      else a = mid + 0.0001 //adjust up
    }
    b
  }

}

