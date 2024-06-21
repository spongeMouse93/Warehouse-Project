package warehouse;

import java.util.*;
import java.io.*;

public class DeleteProduct{
  public static void main(String[] args){
    if (args.length != 2){
      System.err.println("Execute: java DeleteProduct <INput file> <OUTput file>");
      return;
    }
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Warehouse w = new Warehouse();
    try{
      sc = new Scanner(new File(args[0]));
      sc.useLocale(Locale.US);
    }catch (IOException e){
      System.err.println("Could not find input file.");
      return;
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
      if (command.equals("add")){
        int day = sc.nextInt(), id = sc.nextInt();
        String name = sc.next();
        int stock = sc.nextInt(), demand = sc.nextInt();
        w.addProduct(id, name, stock, day, demand);
      }else{
        int id = sc.nextInt();
        w.deleteProduct(id);
      }
    }
    out.println(w);
    out.flush();
 }
}
