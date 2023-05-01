import CheckOut.{availableDiscount, calCost}
import Constants.{appleName, breadName, priceMap, soupName}
import org.scalatest.funsuite.AnyFunSuiteLike

class CheckOutTest extends AnyFunSuiteLike {

  test("testCalCost") {
    val testData: Map[String, BigDecimal] = Map(
      appleName -> priceMap(appleName), soupName -> priceMap(soupName) * 3
    )
    val cost = calCost(testData)
    val expectedCost = priceMap(appleName) + priceMap(soupName) * 3

    assert(cost == expectedCost, "The calculation is incorrect")
  }

  test("testAvailableDiscount") {
    val appleData: Map[String, BigDecimal] = Map(
      appleName -> priceMap(appleName)
    )
    val soupData: Map[String, BigDecimal] = Map(
      soupName -> priceMap(soupName) * 3,  breadName -> priceMap(breadName) * 2
    )


    val appleDiscount = availableDiscount(appleData)
    val soupDiscount = availableDiscount(soupData)

    val appleExpected = priceMap(appleName) * 0.9
    val breadExpected = priceMap(breadName) * 1.5

    assert(appleDiscount.getOrElse(appleName,0.0) == appleExpected, "The apple discount isn't working")
    assert(soupDiscount.getOrElse(breadName,0.0) == breadExpected,"There should be no discount")

  }
}
