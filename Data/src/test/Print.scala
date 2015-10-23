package test

/**
 * Created by wkgcass on 15/10/23.
 */
class Print {
  def Print(o: Any) = {
    print(o)
    this
  }

  def PrintTab(o: Any) = Print(o).Print('\t')

  def Println(o: Any) = {
    println(o)
    this
  }

  def Println() = {
    println
    this
  }
}
