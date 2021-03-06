package com.assignment.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dataaccess.OrderAccess;
import com.assignment.dataaccess.impl.OrderAccessImpl;

/**
 * Class that services the pizza sorting and converts the dates to human readable formats. Handler for the {@link RestController} in FUTURE
 * 
 * @author Sid
 *
 */
@Component
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

        if (1 < args.length) {
            String input = args[0];
            System.out.println("Parsing from input file name: " + input);
            String output = args[1];

            sortedPizzas = orderAccess.getPizzaOrder(input);

            //Displaying on console
            display(sortedPizzas);

            //Storing in a TextFile
            System.out.println("Printing into output file: " + output);
            orderAccess.writePizzaOrder(sortedPizzas, output);
        } else {
            System.out.println("Atleast 2 arguments the input file and the output file is required to begin : ");
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
}
