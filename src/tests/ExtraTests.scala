package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class ExtraTests extends FunSuite{
  val EPSILON: Double = 0.000001

  val calculator : Calculator = new Calculator()

  def equalDoubles(value1: Double, value2: Double): Boolean = (value1 - value2).abs < EPSILON

  test("Test 001"){
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
