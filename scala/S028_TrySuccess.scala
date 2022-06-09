import scala.util.{Try, Success, Failure}

object S028_TrySuccess extends  App {
  // Both Option and Either, we don't take the actual exception
  // Try - Take either Success or Failure, success shall have result , Failure shall have exception captured
  def toInt(input: String) = {
    Try (input.toInt) // return either success or failure
  }

  val x = toInt("100")
  println("x is", x, x.isSuccess)

  val y = toInt("NA")
  println("y is ", y, y.isFailure)

  // for comprehension
  for {r <- toInt("100")} {
    println("R ", r) // will print
  }

  for {rr <- toInt("NA")} {
    println("RR ", rr) // won't print
  }

}
