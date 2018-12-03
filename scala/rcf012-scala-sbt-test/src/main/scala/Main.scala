/*
 * Notes on setting up SBT in IntelliJ:
 *   1. Ensure that the SBT project is clicked when importing.
 *   2. Add a new SBT run configuration (run/edit conf...) with `~run` command.
 *
 *   docs.scala-lang.org/getting-started-intellij-track
 */

object Main extends App{
  println("Hello, World!")
  println("Test?")

  def triple(x: Int) = {
    x * 3
  }

}
