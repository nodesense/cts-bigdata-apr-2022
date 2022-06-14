object S022_PatternMatching extends  App {
  // similar to switch case in other lang
  // switch case is statement, that doesn't return result
  // scala has match case, which is expression, that returns result

  val n = 11

  val result = n % 2 match {
    case 0 => "Even" //   return value
    case 1 => "Odd" // return value
  }

  println("N is ", result)

  case class Order(category: String, amount: Double)
  case class WholeSaleOrder(category: String, amount: Double)

  def getDiscount(order: Object): Double = order match {
    // order: ORder, order is variable, Order is data type, if guard
    // order should be of ORder type, if order.category == Book
    case order: Order if order.category == "Book" => 30.0
    case order:Order if order.category == "Medicine" => 20.0
    case  order:Order if  order.amount > 10000 => 10.0
    case order:Order => 1.0
    // _ says amount can be anything
    case WholeSaleOrder("Stationaries", _) => 3.0
    case order: WholeSaleOrder => 2

    // none of them, here we use _  for default
    case _ => 0.0 // any other types
  }

  val bookOrder = Order("Book", 100)
  val medicineOrder = Order("Medicine", 300)
  val order = Order("Home", 20000)
  val order2 = Order("Bike", 10)

  val d1 = getDiscount(bookOrder)
  println(d1)
  val d2 = getDiscount(medicineOrder)
  println(d2)
  val d3 = getDiscount(order)
  println(d3)
  val d4 = getDiscount(order2)
  println(d4)

  val d5 = getDiscount("How are you") // match to _ => returns 0
  println(d5)



  val d6 = getDiscount(WholeSaleOrder("", 1000))
  println(d6)


  val d7 = getDiscount(WholeSaleOrder("Stationaries", 1000))
  println(d7)

}
