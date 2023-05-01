import Constants._

import scala.math

object CheckOut {

  def apply (items: Map[String,BigDecimal]) ={

   print("Subtotal: £" + calCost(items))

   val itemsDiscounted = availableDiscount(items)

   printf("Total Price: £ %.2f", (calCost(itemsDiscounted)))
  }


  def availableDiscount(items: Map[String,BigDecimal]):Map[String,BigDecimal]= {

    var discountMessage = ""

     val breadDiscount: Map[String,BigDecimal] = {
       if (items.getOrElse(soupName,BigDecimal(0.0)) >= priceMap(soupName)* BigDecimal(2) && items.getOrElse(breadName,BigDecimal(0.0)) != BigDecimal(0.0)) {
         discountMessage = discountMessage  +"\nBought two soup get 50% off a loaf of bread"

         items.updated(breadName, items.get(breadName).get - (priceMap(breadName)/2))

       } else items
     }

      val appleDiscount = if (breadDiscount.getOrElse(appleName,BigDecimal(0.0)) > BigDecimal(0.0)){
        discountMessage = discountMessage + "\n10% off Apple"
        breadDiscount.updated(appleName,items(appleName) * BigDecimal(0.9))
      } else breadDiscount

    if (!discountMessage.isEmpty)
      println(discountMessage)
    else println("\n(No Offers Available)")

    appleDiscount

  }


  def calCost(items: Map[String,BigDecimal]):BigDecimal = {
     items.foldLeft(BigDecimal(0.00))(_+_._2)

  }



}
