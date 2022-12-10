package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFullFunctionality extends FunSuite{
  val EPSILON: Double = 0.000001

  val calculator : Calculator = new Calculator()

  def equalDoubles(value1: Double, value2: Double): Boolean = (value1 - value2).abs < EPSILON

  test("Multi-Addition Test (No decimal point)"){
    //Addition
    calculator.numberPressed(9)
    calculator.numberPressed(9)
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(6)
    calculator.numberPressed(3)
    calculator.addPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(0)
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 727.0), calculator.displayNumber())

    calculator.clearPressed()
  }

  test("Test Addition + Equal Button (W/ Decimal Points)"){

    calculator.numberPressed(9)
    calculator.numberPressed(7)
    calculator.addPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.numberPressed(7)
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 0.372), calculator.displayNumber())
  }

  test("Multiple Operations with decimals"){
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
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(9)
    calculator.numberPressed(1)
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
    calculator.numberPressed(9)
    calculator.numberPressed(0)
    calculator.addPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 102.0), calculator.displayNumber())

    calculator.numberPressed(7)

    assert(equalDoubles(calculator.displayNumber(), 7.0), calculator.displayNumber())

    this.calculator.clearPressed()
  }

  test("Extra Test 1"){
    this.calculator.numberPressed(3)
    this.calculator.decimalPressed()
    this.calculator.multiplyPressed()
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 8), calculator.displayNumber())

    calculator.clearPressed()

    this.calculator.numberPressed(4)
    this.calculator.numberPressed(5)
    this.calculator.numberPressed(3)

    this.calculator.multiplyPressed()
    this.calculator.addPressed()
    this.calculator.equalsPressed()

    this.calculator.numberPressed(1)
    this.calculator.numberPressed(2)

    this.calculator.addPressed()

    this.calculator.numberPressed(7)
    this.calculator.decimalPressed()
    this.calculator.decimalPressed()
    this.calculator.decimalPressed()
    this.calculator.decimalPressed()
    this.calculator.numberPressed(5)
    this.calculator.equalsPressed()

    assert(equalDoubles(this.calculator.displayNumber(), 472.5), this.calculator.displayNumber())

    this.calculator.clearPressed()

  }

  test("Test 001 Extrass"){
    this.calculator.numberPressed(1)
    this.calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(this.calculator.displayNumber(), 12), this.calculator.displayNumber())

    this.calculator.addPressed()
    this.calculator.numberPressed(2)
    this.calculator.numberPressed(3)
    this.calculator.decimalPressed()
    this.calculator.numberPressed(4)
    this.calculator.equalsPressed()
    assert(equalDoubles(this.calculator.displayNumber(), 35.4), this.calculator.displayNumber())

    this.calculator.numberPressed(7)
    this.calculator.decimalPressed()
    this.calculator.equalsPressed()
    // val f = 7.
    assert(equalDoubles(this.calculator.displayNumber(), 7.0), this.calculator.displayNumber())

    this.calculator.equalsPressed()
    assert(equalDoubles(this.calculator.displayNumber(), 7.0), this.calculator.displayNumber())

    this.calculator.clearPressed()

    assert(equalDoubles(this.calculator.displayNumber(), 0.0), this.calculator.displayNumber())
  }

}
