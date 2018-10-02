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

    //Tests the main functionality
    @Test
    public void testSort() throws Exception {
        String infile = "sample_data_ordered.txt";
        String outFile = "sorted_data.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

    //File not found handled gracefully
    @Test(expected = FileNotFoundException.class)
    public void testSortExceptionFileNotfound() throws Exception {
        String infile = "fictitous.txt";
        String outFile = "fictitious_sorted_data.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

    @Test //Bad data format will skip that line
    public void testBadFormatSkipsLine() throws Exception {
        String infile = "badlines.txt";
        String outFile = "sorted_data_bad.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

    @Test //On bad date format we. For example alphanumeric value or negative date values will gracefully handle and skip that line
    public void testBadDateFormatSkipsLine() throws Exception {
        String infile = "badtext.txt";
        String outFile = "sorted_data_bad_date.txt";
        service.sort((String[]) Arrays.asList(infile, outFile).toArray());
    }

}
