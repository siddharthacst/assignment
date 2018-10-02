package com.assignment.dataaccess.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.junit.Test;

import com.assignment.dataaccess.OrderAccess;

public class OrderAccessImplTest {

    OrderAccess orderAccess = new OrderAccessImpl();

    @Test
    public void testWritePizzaOrder() throws IOException {
        TreeMap<String, List<Date>> map = new TreeMap<>();
        orderAccess.writePizzaOrder(map, "sorted_data.txt");
    }

    @Test
    public void testGetPizzaOrder() throws Exception {
        orderAccess.getPizzaOrder("sample_data_ordered.txt");
    }
}
