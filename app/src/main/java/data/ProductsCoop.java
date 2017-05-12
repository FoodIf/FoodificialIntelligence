package data;

import java.util.ArrayList;

/**
 * Created by Johan on 2017-05-12.
 */

public class ProductsCoop {
    private ArrayList<String> products;

    public ProductsCoop(){
        products = new ArrayList<>();
        addProducts();
    }
    public void addProducts(){
        products.add("Ketchup Heinz 1000g|22.95");
        products.add("Ketchup Felix 1000g|21.50");
        products.add("Tomater kvist 1000g|34.95");
        products.add("Tomater eco 500g|32.95");
        products.add("Tomatpuré 200g|9.80");
        products.add("Tomatpuré krav 200g|13.95");
        products.add("Mellanmjölk Arla 1000ml|9.10");
        products.add("Mellanmjölk Änglamark 1000ml|10.60");
        products.add("Smör Arla 500g|36.50");
        products.add("Smör Änglamark eko 500g|41.50");
        products.add("Kycklingfilé frusen kronfågel 1000g|87.95");
        products.add("Pytt i panna 1000g|37.50");
        products.add("Blåbär Fryst 225g|23.95");
        products.add("Kalles Kaviar 300g|26.50");
        products.add("Snickers 2-pack 75g|9.95");
        products.add("Ost Präst mellan 700g|65.10");
        products.add("Filmjölk Laktosfri Arla 1000g|19.50");
        products.add("Lax gravad 200g|53.95");
        products.add("Bröd Carlssons fyrkant 700g|22.95");
        products.add("Falukorv Scan 800g|28.95");
        products.add("Gifflar Kanel 280g|19.50");
        products.add("Bearnaise Lohmanders 500ml|38.90");
        products.add("Toalettpapper ultra soft 8p|37.50");
        products.add("Chips Dill 275g|19.50");
        products.add("Bregott Extrasaltat 600g|33.95");
    }
}
