package com.bext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListLab {

    public ListLab() {
        List<Integer> listIntegerA = new ArrayList<>();
        listIntegerA.add(1);
        listIntegerA.add(2);
        listIntegerA.add(2);
        listIntegerA.add(3);
        listIntegerA.add(10);
        listIntegerA.add(11);
        listIntegerA.add(11);
        listIntegerA.add(11);
        listIntegerA.add(15);
        listIntegerA.add(30);
        listIntegerA.add(33);
        System.out.println(listIntegerA);
        //[1, 2, 2, 3, 10, 11, 11, 11, 15, 30, 33]

        List<Integer> listIntegerB = Arrays.asList(100, 110, 123, 12, 12, 10, 10, 11, 11, 200, 300);
        System.out.println(listIntegerB);
        //[100, 110, 123, 12, 12, 10, 10, 11, 11, 200, 300]

        System.out.println( listIntegerA.stream().filter(e -> listIntegerB.contains(e)).collect(Collectors.toList()));
        List<Integer> listIntersectionAyB = listIntegerA.stream().filter(listIntegerB::contains).collect(Collectors.toList());
        System.out.println(listIntersectionAyB);
        //[10, 11, 11, 11]

        System.out.println( listIntegerA.stream().distinct().filter(listIntegerB::contains).collect(Collectors.toList()) );
        //[10, 11]

        List<Integer> listIntersectionByA = listIntegerB.stream().filter(listIntegerA::contains).collect(Collectors.toList());
        System.out.println(listIntersectionByA);
        //[10, 10, 11, 11]



    }
}
