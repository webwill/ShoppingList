import Constants.priceMap



object Items {

  def apply(shopping: Array[String]) = {



    println()

    val items: Map[String,BigDecimal]  = shopping.map(s => s.toLowerCase).groupBy(identity).map(i=> (i._1,priceMap.getOrElse(i._1,BigDecimal(0.0)) * i._2.length))

    println(items)

    items

  }



}
