package warehouse;

import java.util.*;
import java.io.*;

public class PurchaseProduct {
    public static void main(String[] args) {
        if (args.length < 2){
            System.err.println("Execute: java PurchaseProduct <INput file> <OUTput file>");
            return;
        }
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(new File(args[0]), "UTF-8");
            sc.useLocale(Locale.US);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter out = new PrintWriter(System.out);
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
        Warehouse w = new Warehouse();
        int numCommands = sc.nextInt();
        for (int i = 1; i <= numCommands; i++) {
            String command = sc.next();
            if (command.equals("add")) {
                int day = sc.nextInt(), id = sc.nextInt();
                String name = sc.next();
                int stock = sc.nextInt(), demand = sc.nextInt();
                w.addProduct(id, name, stock, day, demand);
            } else {
                int day = sc.nextInt(), id = sc.nextInt(), purchased = sc.nextInt();
                w.purchaseProduct(id, day, purchased);
            }
        }
        out.println(w);
        out.flush();
    }
}
