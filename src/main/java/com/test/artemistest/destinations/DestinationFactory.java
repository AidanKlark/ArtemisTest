package com.test.artemistest.destinations;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DestinationFactory {

    private final String destinationOne = "one_q";
    private final String destinationTwo = "two_q";
    private final String destinationThree = "three_q";

    public String getDest(String out) {
        Map<String, String> dest = new HashMap<>();

        dest.put(destinationOne, destinationOne);
        dest.put(destinationTwo, destinationTwo);
        dest.put(destinationThree, destinationThree);

        return dest.get(out);
    }
}
