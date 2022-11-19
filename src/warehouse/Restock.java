package warehouse;

import java.util.*;
import java.io.*;

public class Restock{
  public static void main(String[] args){
    Warehouse w = new Warehouse();
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    try {
        sc = new Scanner(new File(args[0]), "UTF-8");
        sc.useLocale(Locale.US);
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        out = new PrintWriter(new FileOutputStream(new File(args[1])), true);
    } catch (IOException e) {
        try {
            File f = new File(args[1]);
            f.createNewFile();
            out = new PrintWriter(new FileOutputStream(f), true);
        } catch (IOException e2) {
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
        int id = sc.nextInt(), amount = sc.nextInt();
        w.restockProduct(id, amount);
      }
    }
    out.println(w);
    out.flush();
  }
}
