## Overview

This project simulates a warehouse, which is able to hold up to 50 different objects. It was originally supposed to use a hash table data structure, but since we haven't covered that before Thanksgiving break, our class settled on using a priority queue data structure instead. It anyway probably worked better, since the sink and swim methods make sorting hell of a lot easier.

## Files Overview

### Java Files

This project uses 8 Java files, with 5 of them specifically being to simulate the warehouse.

* `Product`: 
  * Contains the product ID, name, stock, date of last purchase, demand, and overall popularity. The demand is simply the sum of the initial demand for the product and the number purchased.
  * Getters and setters are provided, as well as special methods to update the stock and demand by some positive or negative amount.
  * You cannot manually set the popularity, but it is automatically calculated and updated as the sum of the last purchase day and current demand.
  * __DO NOT__ edit this file.
  
* `Sector`:
  * Contains an array of Products which forms a valid min heap based on popularities, as well as the current size of the sector (defined as the number of Products in it).
  * On `Product`s array we ignore index 0 just like in class. Then at any moment, the indices containing valid Products range from 1 to currentSize inclusive.
  * Contains helpful methods to add a Product to the end of the sector, set some index, delete the last Product, get the Product at some index and get the current size.
  * The `Sector` class alone isn’t a fully implemented min-heap. However, you’re provided a method to swap the Products at 2 indices, a method to apply the swim algorithm from class on some index, and a method to apply the sink algorithm from class on some index.
  * __DO NOT__ edit this file.
  
* `Warehouse`:
  * Contains an array of 10 `Sector`s, with index i representing sector i.
  * Contains methods to fill in for every sub-problem in the assignment.
  
* `AddProduct`:
  * Used to test the `Warehouse`s add method.

* `DeleteProduct`:
  * Used to test the `Warehouse`s delete method.
  
* `Restock`:
  * Used to test the `Warehouse`s restock method.
  
* `PurchaseProduct`:
  * Used to test the `Warehouse`s product method.
  
* `Everything`:
  * Used to test the `Warehouse`s add, restock, delete, and purchase methods.
  
### Input Files

For testing purposes, we have provided 7 input files for testing `Warehouses`s methods. 3 of them are for adding the products.

* `AddToEnd`:
  * The input file will be formatted as follows:
    * An integer __n__ representing the number of products to add
    * __n__ lines, each containing the following in this order (space separated):
      * The current day
      * The product ID
      * The product name (guaranteed not to have spaces)
      * The initial stock
      * The initial demand
  * The sector index being added to is the last digit of the product's ID.

* `FixHeap`:
  * The current `addProduct` is fine, but as of now it just appends to the end of the sector. We want to maintain a min-heap structure based on popularity at all times.
  * Format is exactly the same as `AddToEnd`.
  
* `AddProduct`:
  * The current `addProduct` works fine until one of the sectors goes over capacity. We want to delete the least popular element when we are trying to add in a new one, so we can continue adding new products.
  * The method __ONLY__ performs this operation if necessary. In other words, it does nothing __UNLESS__ the sector we want to insert into is currently at full capacity (has 5 products already).
  * Format is exactly the same as `AddToEnd`.
  
* `Restock`:
  * Takes in a product ID and some amount to restock, and updates the stock of that item in the Warehouse accordingly. If the item does not exist in the Warehouse it does nothing.
  * The input file will be formatted as follows:
    * An integer n representing the number of queries
    * n lines, each containing either an add query or a restock query
    * Add queries will be of the following format:
      * Start with the word "add"
      * The current day
      * The product ID
      * The product name (guaranteed not have spaces)
      * The initial stock
      * The initial demand
    * Restock queries will be of the following format:
      * Start with the word "restock"
      * The product ID to restock
      * The amount to restock
  
* `DeleteProduct`:
  * Takes in a product ID, then removes that product from your Warehouse. The product will not necessarily be the least popular item in its sector. If the item does not exist in the Warehouse, do nothing.
  * The input file will be formatted as follows:
    * An integer n representing the number of queries
    * n lines, each containing either an add query or a delete query
    * Add queries similar to that of `Restock`
    * Delete queries will be of the following format:
      * Start with the word "delete"
      * The product ID to delete
      
* `PurchaseProduct`:
  * Takes in an ID, a day of purchase, and some amount purchased, then simulates the purchase order.
  * When an item is purchased, its last purchase day is updated to the current day, its stock is decreased by the amount purchased, and its demand is increased by the amount purchased.
  * If the item representing the given ID doesn't exist, do nothing.
  * If the purchase amount is more than the available stock, do nothing.
  * The input file will be formatted as follows:
    * An integer n representing the number of queries
    * n lines, each containing either an add query or a purchase query
    * Add queries similar to that of `Restock`
    * Purhcase queries will be of the following format:
      * Start with the word "purchase"
      * The current day
      * The The product ID to purchase
      * The amount purchased
      
* `Everything`:
  * Used for simulating all possible methods
  * The input will be formatted as follows:
    * An integer n representing the number of queries
    * n lines, each containing either an add, restock, purchase, or delete query
    * Formats will be same as their other input files
    
## Running the Code

To run the code:
* To compile: `javac -d bin src/warehouse/*.java`
* To execute: `java -cp bin warehouse.x x.in x.out`

where x is the part of warehouse you wish the test and its respective input file. 

Feel free to make your own input files for testing the methods. So long as they match the formats, the code should run smooth as butter.
