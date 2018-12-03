import org.scalatest.FunSuite

class MainTest extends FunSuite {
  test("Main.triple") {
    assert(Main.triple(3) === 9)
    assert(Main.triple(4) === 12)
  }
}
