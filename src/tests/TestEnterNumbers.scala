package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestEnterNumbers extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  // Example test case
  test("Enter Numbers Test") {
    val calculator: Calculator = new Calculator()

    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())

    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.numberPressed(5)

    assert(equalDoubles(calculator.displayNumber(), 125.0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(1)
    calculator.numberPressed(3)
    assert(equalDoubles(calculator.displayNumber(), 13),  calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(1)
    assert(equalDoubles(calculator.displayNumber(), 1), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    assert(equalDoubles(calculator.displayNumber(), 1.2), calculator.displayNumber())

    calculator.clearPressed()

    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(9)
    assert(equalDoubles(calculator.displayNumber(), 0.9), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(1)
    assert(equalDoubles(calculator.displayNumber(), 1), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(2)
    assert(equalDoubles(calculator.displayNumber(), 2), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(3)
    assert(equalDoubles(calculator.displayNumber(), 3), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(4)
    assert(equalDoubles(calculator.displayNumber(), 4), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(5)
    assert(equalDoubles(calculator.displayNumber(), 5), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(6)
    assert(equalDoubles(calculator.displayNumber(), 6), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(7)
    assert(equalDoubles(calculator.displayNumber(), 7), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(8)
    assert(equalDoubles(calculator.displayNumber(), 8), calculator.displayNumber())
    calculator.clearPressed()
    calculator.numberPressed(9)
    assert(equalDoubles(calculator.displayNumber(), 9), calculator.displayNumber())
    calculator.clearPressed()


    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(2)
    calculator.numberPressed(2)
    calculator.numberPressed(2)
    calculator.numberPressed(2)
    assert(equalDoubles(calculator.displayNumber(), 1.22222), calculator.displayNumber())
    calculator.clearPressed()
    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(0)
    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(1)
    assert(equalDoubles(calculator.displayNumber(), 0.1), calculator.displayNumber())

    calculator.clearPressed()

    calculator.decimalPressed()
    calculator.numberPressed(2)
    assert(equalDoubles(calculator.displayNumber(), 0.2), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(0)
    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    assert(equalDoubles(calculator.displayNumber(), 1.000), calculator.displayNumber())
    calculator.numberPressed(1)
    assert(equalDoubles(calculator.displayNumber(), 1.0001), calculator.displayNumber())
  }

  test("Extra"){
    val calculator : Calculator = new Calculator

    calculator.numberPressed(0)
    assert(calculator.displayNumber() == 0, calculator.displayNumber())

    calculator.clearPressed()

    calculator.numberPressed(1)
    assert(calculator.displayNumber() == 1, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(2)
    assert(calculator.displayNumber() == 2, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(3)
    assert(calculator.displayNumber() == 3, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(4)
    assert(calculator.displayNumber() == 4, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(5)
    assert(calculator.displayNumber() == 5, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(6)
    assert(calculator.displayNumber() == 6, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(7)
    assert(calculator.displayNumber() == 7, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(8)
    assert(calculator.displayNumber() == 8, calculator.displayNumber())
    calculator.clearPressed()

    calculator.numberPressed(9)
    assert(calculator.displayNumber() == 9, calculator.displayNumber())
    calculator.clearPressed()


  }

}
