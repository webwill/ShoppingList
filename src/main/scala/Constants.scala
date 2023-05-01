object Constants {

  private val appleCost:BigDecimal = 1.00
  private val soupCost:BigDecimal = 0.65
  private val breadCost:BigDecimal = 0.80
  private val milkCost:BigDecimal = 1.30


  val appleName: String = "apple"
  val soupName: String = "soup"
  val breadName: String = "bread"
  val milkName: String = "milk"


  val priceMap: Map[String,BigDecimal]  = Map(
    appleName -> appleCost,
    soupName -> soupCost,
    breadName -> breadCost,
    milkName -> milkCost,
  )

}
