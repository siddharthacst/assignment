package com.assignment.service;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assignment.dataaccess.OrderAccess;

public class PizzaHandlerTest {

    @Mock
    private OrderAccess access;

    private PizzaHandler service;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        service = new PizzaHandler();
    }

    @Test
    public void testSort() throws Exception {
        String infile = "sample_data_ordered.txt";
        String outFile = "sorted_data.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

    @Test(expected = FileNotFoundException.class)
    public void testSortExceptionFileNotfound() throws Exception {
        String infile = "fictitous.txt";
        String outFile = "sorted_data.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

    @Test
    public void testBadFormatSkipsLine() throws Exception {
        String infile = "badtext.txt";
        String outFile = "sorted_data.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

    @Test
    public void testBadDateFormatSkipsLine() throws Exception {
        String infile = "badtext.txt";
        String outFile = "sorted_data.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

}
