object S026_Options extends App {
  def toInt(input: String) = {
    input.toInt
  }

  // Option: Get Something or None, get teh number or get None
  // Option[Int], [] represent generic, Int is type
  def toNumInt(input: String):Option[Int] = {
    try {
     Some(input.toInt) // return Some int 100
    }catch {
      case _ => None // return none NA
    }
  }

  val x = toInt("100")
  println("X", x)

 // val y = toInt("NA") // throw exception , that halt the application,

 // no exception thrown outside function
  val xx: Option[Int] = toNumInt("100")
  println("xx", xx)
  if (xx.isDefined) { // trues mean xx has value
    println("XX value is ", xx.get) // get will get Int 100
  }

  // no exception, instaed returns None
  val yy: Option[Int] = toNumInt("NA")
  println("YY", yy)
  println("yy isDefiend", yy.isDefined) // false
  if (yy.isEmpty) { // true
    println("no value in yy")
  }


  // For Comprehension , to deal the success/errors without if else condition like isDefined or isEmpty
  // ignore the errors like None
  for { r <- toNumInt("100")} {
    println ("R is ", r) // print   100
  }

  for { rr <- toNumInt("NA")} {
    println("RR", rr) // this code never execute, toNumInt returns None,
  }

}
