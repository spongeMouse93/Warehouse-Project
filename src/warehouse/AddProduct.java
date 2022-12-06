package warehouse;

import java.util.*;
import java.io.*;

//Used to test the warehouse add product method
public class AddProduct{
  public static void main(String[] args){
    if (args.length < 2){
      System.err.println("Execute: java AddProduct <INput file> <OUTput file>");
      return;
    }
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Warehouse w = new Warehouse();
    try{
      sc = new Scanner(new File(args[0]), "UTF-8");
      sc.useLocale(Locale.US);
    }catch (IOException e){
      e.printStackTrace();
    }
    try{
      out = new PrintWriter(new FileOutputStream(new File(args[1])), true);
    }catch (IOException e){
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
      int day = sc.nextInt(), id = sc.nextInt();
      String name = sc.next();
      int stock = sc.nextInt(), demand = sc.nextInt();
      w.addProduct(id, name, stock, day, demand);
    }
    out.println(w);
    out.flush();
  }
}
