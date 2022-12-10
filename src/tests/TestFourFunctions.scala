package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFourFunctions extends FunSuite{

  val EPSILON : Double = 0.000001

  def equalDoubles(value1 : Double, value2 : Double) : Boolean = (value1 - value2).abs < EPSILON


  test("Test Addition: "){
    val calculator : Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.numberPressed(9)
    calculator.addPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(2)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 181), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.addPressed()
    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.numberPressed(2)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 17.1), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(8)
    calculator.numberPressed(8)
    calculator.numberPressed(9)
    calculator.numberPressed(6)
    calculator.numberPressed(1)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 88961), calculator.displayNumber())
  }

  test("Test Subtraction: "){
    val calculator : Calculator = new Calculator()

    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.subtractPressed()
    calculator.numberPressed(9)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 3.0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(8)
    calculator.numberPressed(9)
    calculator.subtractPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(2)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), -3.0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.subtractPressed()
    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.numberPressed(2)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), -1.3), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(1)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.subtractPressed()
    calculator.numberPressed(3)
    calculator.decimalPressed()
    calculator.numberPressed(7)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 6.5), calculator.displayNumber())


  }

  test("Test Multiplication: "){
    val calculator : Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.numberPressed(6)
    calculator.multiplyPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(2)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 4472.0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.multiplyPressed()
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(2)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 16.06), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(8)
    calculator.numberPressed(8)
    calculator.multiplyPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(6)
    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(7)
    calculator.numberPressed(6)
    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 84592.288), calculator.displayNumber())
  }

  test("Test Division: "){

    val calculator : Calculator = new Calculator()

    calculator.numberPressed(9)
    calculator.numberPressed(6)
    calculator.dividePressed()
    calculator.numberPressed(4)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 24.0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(6)
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.dividePressed()
    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(3)
    calculator.numberPressed(4)
    calculator.numberPressed(5)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 5.10328), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(8)
    calculator.numberPressed(8)
    calculator.dividePressed()
    calculator.numberPressed(9)
    calculator.numberPressed(6)
    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(7)
    calculator.numberPressed(6)

    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 0.091544), calculator.displayNumber())
    calculator.clearPressed()
  }

  //Extra Test:
  test("Extra") {
    val calculator: Calculator = new Calculator
    //Initial State:
    calculator.numberPressed(1)
    calculator.numberPressed(4)
    assert(equalDoubles(calculator.displayNumber(), 14), calculator.displayNumber())
    calculator.addPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    assert(equalDoubles(calculator.displayNumber(), 12), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 26.0), calculator.displayNumber())

    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.decimalPressed()
    assert(equalDoubles(calculator.displayNumber(), .1), calculator.displayNumber())
  }

  test("Another Test: 3"){
    val calculator: Calculator = new Calculator
    calculator.clearPressed()

    assert(equalDoubles(calculator.displayNumber(), 0.0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(0)
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.numberPressed(3)
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.multiplyPressed()
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 4938.4), calculator.displayNumber())
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(9)
    calculator.numberPressed(1)
    // assert(equalDoubles(calculator.displayNumber(), 591.0), calculator.displayNumber())
    calculator.subtractPressed()
    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(3)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 5528.17), calculator.displayNumber())
    calculator.clearPressed()
  }

  test("Test Extras"){
    val calculator : Calculator = new Calculator

    calculator.numberPressed(9)
    calculator.numberPressed(0)
    calculator.addPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 102.0), calculator.displayNumber())

    calculator.numberPressed(7)

    assert(equalDoubles(calculator.displayNumber(), 7.0), calculator.displayNumber())
    calculator.clearPressed()
  }
}
