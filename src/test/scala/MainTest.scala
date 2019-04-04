import Main.{Leaf, Rabbit, Root}
import org.scalatest.{FlatSpec, Matchers}

class MainTest  extends FlatSpec with Matchers {
  "MD5 method" should "hash like md5 online" in {
    Rabbit.calculateMD5Hash("par") should be("d018268506e2868537a478629b59e7c1")
  }

  "Get Lines method" should "process file" in {
    Rabbit.getLinesFromFile.head should be("a")
  }


  "Tree-Root class" should "getWord like a phrase" in {
    val h2 = Leaf("y")
    val h3 = Leaf("Daca")

    val tree = Root("Toma", List(h2,h3),"ydaca".toCharArray)
    tree.getWord should be("Toma y Daca")
  }
}
