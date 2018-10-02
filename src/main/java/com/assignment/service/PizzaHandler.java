package com.assignment.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.assignment.dataaccess.OrderAccess;
import com.assignment.dataaccess.impl.OrderAccessImpl;

/**
 * Class that services the pizza sorting and converts the dates to human readable formats. Handler for the rest controller in FUTURE
 * 
 * @author Sid
 *
 */
public class PizzaHandler {

    private OrderAccess orderAccess = new OrderAccessImpl();

    /**
     * The arguments can later come as a body in a http POST call. In that case we would need a rest controller defined which hands down the list to
     * the sorter. This structure should allow us to get the input flexibly
     * 
     * @param args
     * @throws Exception
     */
    public void sort(String[] args) throws Exception {
        System.out.println("Enter the input file name and the output file name");
        TreeMap<String, List<Date>> sortedPizzas;

        if (0 < args.length) {
            String input = args[0];
            System.out.println("Parsing from input file name: " + input);
            String output = args[1];

            sortedPizzas = orderAccess.getPizzaOrder(input);

            //Displaying on console
            display(sortedPizzas);

            //Storing in a TextFile
            System.out.println("Printing into output file: " + output);
            orderAccess.writePizzaOrder(sortedPizzas, output);
        }
    }

    private static void display(TreeMap<String, List<Date>> sortedPizzas) {
        System.out.println("Order" + "\t" + " Time ");
        for (Map.Entry<String, List<Date>> entry : sortedPizzas.entrySet()) {
            String key = entry.getKey();
            for (Date date : entry.getValue()) {
                System.out.println(key + "\t" + date);
            }
        }
    }

    private static void writeToFile(TreeMap<String, Date> sortedPizzas, String output) throws IOException {

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(output))));
        out.write("Order" + "\t" + " Time ");
        out.newLine();
        for (Map.Entry<String, Date> entry : sortedPizzas.entrySet()) {
            out.write(entry.getKey() + "\t" + entry.getValue());
            out.newLine();
        }
        out.close();
    }
}
