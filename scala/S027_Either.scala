object S027_Either extends App {
  // Either - this or that / left or right
  // use ful for error handling
  // Convention - how people use Either construct
  // Left - error, not exception
  // Right - result


  def toInt(input: String): Either[String, Int] = {
      try {
        Right(input.toInt)
      }catch {
        case _ => Left(s"Sorry $input cannot be converted to int")
      }
  }

  val x = toInt("100")
  println ("x", x)

  if (x.isRight) { // we got result
    println("x value ", x.right.get)
  }

  val y = toInt("NA")
  println("Y", y)

  // for comprehension to deal Either
  for {r <- toInt("100")} {
     println("r value is ", r.toInt) // shall run since toInt returned right
  }

  // for comprehension use {} or ()
  for (rr <- toInt("NA")) {
    print("rr ", rr) // this will not execute since toInt returned left
  }
}
