package com.assignment.dataaccess.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.assignment.dataaccess.OrderAccess;

public class OrderAccessImpl implements OrderAccess {

    /**
     * Here we will read the input line by line and build a {@link TreeMap} which will maintain the {@link Entry}s in sorted order
     */
    @Override
    public TreeMap<String, List<Date>> getPizzaOrder(String fileName) throws Exception {

        TreeMap<String, List<Date>> map = new TreeMap<String, List<Date>>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String line;
        //Assuming first line is description skipping it. May need to check specifically later
        reader.readLine();

        while ((line = reader.readLine()) != null) {

            //Assuming clean data input for the file,
            //May need to clean up if not present
            System.out.println(line);

            //Consider only the non blank lines
            if (line.trim().length() > 0) {
                //Split line by one or more spaces
                String[] slices = line.split("\\s+");
                if (slices.length == 2) {//Process the pizzas which come with order and time
                    if (slices[0] != null && !slices[0].trim().isEmpty()) {
                        try {
                            //Epoch time in Long can be changed into human readable format.
                            List<Date> dates = map.get(slices[0]);
                            if (dates == null) {
                                dates = new ArrayList<Date>();
                                dates.add(new Date(Long.parseLong(slices[1])));
                                map.put(slices[0], dates);
                            } else {
                                dates.add(new Date(Long.parseLong(slices[1])));
                                map.put(slices[0], dates);
                            }

                        } catch (NumberFormatException e) {
                            //Print the error message and go ahead with the next line
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Skipping this line as only one column found");
                    }
                } else {
                    System.out.println("Skipping this line as only one column found");
                }
            } else {
                System.out.println("line is empty.");
            }
        }

        reader.close();

        return map;
    }

    @Override
    public void writePizzaOrder(TreeMap<String, List<Date>> sortedPizzas, String output) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(output))));
        out.write("Order" + "\t" + " Time ");
        out.newLine();
        //TreeMap.entrySet returns the entries sorted by the keys for the TreeMap
        for (Map.Entry<String, List<Date>> entry : sortedPizzas.entrySet()) {
            for (Date date : entry.getValue()) {
                out.write(entry.getKey() + "\t" + date);
                out.newLine();
            }
        }
        out.close();

    }

    /**
     * Can be used to pass to {@link TreeMap} to make sure they are printed in order
     */

    private Comparator caseInsensitive = new Comparator<String>() {
        public int compare(String o1, String o2) {
            return o1.toLowerCase().compareTo(o2.toLowerCase());
        }
    };

}
