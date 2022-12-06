package warehouse;

import java.util.*;
import java.io.*;

public class Everything{
  public static void main(String[] args){
    if (args.length < 2){
      System.err.println("Execute: java Everything <INput file> <OUTput file>");
    }
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Warehouse w = new Warehouse();
    try{
      sc = new Scanner(new File(args[0]));
      sc.useLocale(Locale.US);
    }catch (IOException e){
      e.printStackTrace();
    }
    try{
      out = new PrintWriter(new FileOutputStream(new File(args[1])), true);
    }catch (IOException e1){
      try{
        File f = new File(args[1]);
        f.createNewFile();
        out = new PrintWriter(new FileOutputStream(f), true);
      }catch (IOException e2){
        e2.printStackTrace();
      }
    }
    int numCommands = sc.nextInt();
    for (int i = 1; i <= numCommands; i++){
      String command = sc.next();
      switch (command){
        case "add":
          int day = sc.nextInt(), id = sc.nextInt();
          String name = sc.next();
          int stock = sc.nextInt(), demand = sc.nextInt();
          w.addProduct(id, name, stock, day, demand);
          break;
        case "restock":
          int id2 = sc.nextInt(), amount = sc.nextInt();
          w.restockProduct(id2, amount);
          break;
        case "purchase":
          int day2 = sc.nextInt(), id3 = sc.nextInt(), purchased = sc.nextInt();
          w.purchaseProduct(day2, id3, purchased);
          break;
        default:
          int id4 = sc.nextInt();
          w.deleteProduct(id4);
      }
    }
    out.println(w);
    out.flush();
  }
}
