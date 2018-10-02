package com.assignment.dataaccess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

/**
 * This interface defines the method used to get and store the orders
 * 
 * We can have various impls of these depending on where we want to save, For example, Reading data from DB and stores back in DB Can leverage
 * {@link JdbcTemplateAutoConfiguration}
 * 
 * @author Sid
 *
 */
public interface OrderAccess {

    /**
     * Gets the pizza order from the input, and keeps it sorted in a TreeMap
     * 
     * @throws Exception
     */
    TreeMap<String, List<Date>> getPizzaOrder(String fileName) throws Exception;

    /**
     * Saves the sorted pizza order for reference
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    void writePizzaOrder(TreeMap<String, List<Date>> sortedPizzas, String output) throws IOException;
}
