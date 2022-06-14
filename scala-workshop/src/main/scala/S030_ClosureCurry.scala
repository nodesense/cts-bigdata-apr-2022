object S030_ClosureCurry extends  App {
  // Curry function, a function that returns another function
  // Closure is a functional state, where a function mainain state itself

  // implement a sequence generator
  // 1, 2, 3,
  // 100, 110, 120....
  // start value , step value
  def seq (start: Int, step: Int)  = {
    // closure, maintain a state
    // value of the counter is maintained inside this function
    // visiblity pattern ,
    // counter is used inside incr function, then incr is returned back to caller
    // seq1 and seq100by10 reference the incr function.. counter is visible until reference of seq1,
    // seq100by10 available
    var counter = start // a state with in a function
    val incr = () => {
      val current = counter
      counter += step
      current
    }

    incr // return a function, is known curry
  }

  val seq1 = seq(1, 1) // counter value maintained insdie seq
  val seq100by10 = seq(100, 10) // counter value maintained insdie seq

  println("seq1", seq1()) // 1
  println("seq1", seq1()) // 2
  println("seq1", seq1()) // 3

  println("seq100by10", seq100by10()) // 100
  println("seq100by10", seq100by10()) // 110
  println("seq100by10", seq100by10()) // 120


}
