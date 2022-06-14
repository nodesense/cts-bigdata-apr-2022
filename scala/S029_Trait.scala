object S029_Trait extends  App {
  // Trait is known as interface in java/c++
  // we cannot create instance for trait
  // Useful to define polymorphic behaviour for object

  trait Engine {
    // declaration, not implementation, however scala allows default implementation
    def start(): Boolean;
    def stop():Boolean;
  }

  trait Drivable {
    def left(): Unit;
    def right(): Unit;
  }

  // first trait should be extends and other traits should with
  class Car extends Engine with Drivable {
    // implmenet all the methods of Engine and Drivable here
    var isOn = false
    def start(): Boolean = {
      isOn = true
      isOn // true
    }
    def stop(): Boolean = {
      isOn = false
      isOn
    }
    def left () = println("turn left ")
    def right()  = println("turn right")

  }

  val car = new Car()
  car.start()

  // engine is reference to car instance, but engin only can use its method
  val engine: Engine = car
  engine.start() // stop()
  // no left or right for engine

  val d: Drivable = car
  d.left() // or d.right()
  // no start or stop
}
