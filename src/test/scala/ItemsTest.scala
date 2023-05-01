import Constants.{appleName, priceMap}
import org.scalatest.funsuite.AnyFunSuiteLike

class ItemsTest extends AnyFunSuiteLike {

  test("testApply") {

    val array:Array[String] = Array("Apple","apple")
    val nonItemsArray: Array[String] = Array("Fruit","Meat")

    val apples = Items(array)
    val nonItems = Items(nonItemsArray)

    assert(apples.getOrElse(appleName,0.0) == priceMap(appleName)*2,"There is a problem with the uppercase/lower case ")
    assert(nonItems.getOrElse("fruits",0.0) == 0.0,"There is a problem with non shop items")
  }

}
