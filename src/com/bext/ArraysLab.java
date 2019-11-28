package com.bext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArraysLab {
    public ArraysLab() {
        int arrint[] = {10, 20, 30, 40, 50, 60, 70};
        int[] arrint2 = new int[8];
        int[] arrint3 = new int[]{1, 2, 3};
        String arrstr[] = {"cero", "uno", "dos", "tres", "cuatro"};
        String[] arrstr2 = {"cero", "uno", "dos", "tres", "cuatro"};
        String[] arrstr3 = new String[]{"cero", "uno", "dos", "tres", "cuatro"};

        String[][] arrarrStr = {{"cero", "uno", "dos", "tres", "cuatro"},
                {"alfa", "beta", "gamma", "delta", "epsilon"},
                {"000", "1111", "2222", "33333", "44444"}};
        Arrays.stream( arrarrStr).forEach( arrStr -> Arrays.stream( arrStr).forEach( s->System.out.print(s+" ") ) );
        System.out.println();
        Arrays.stream( arrarrStr).forEach( arrStr -> System.out.println(Arrays.stream( arrStr).map( s-> s.concat(" ")).collect(Collectors.toList()) ) );

        displayArrInt(arrint);
        displayArrInt(arrint2);
        displayArrInt(arrint3);

        Arrays.fill(arrint2, 123);
        displayArrInt(arrint2);

        System.out.println(Arrays.binarySearch(arrint, 40));   // 3
        System.out.println( "arrstr[ new Random().nextInt( arrstr.length) ] : " + arrstr[ new Random().nextInt( arrstr.length) ]);

        System.out.println("Fill witn Random");
        arrIntFillRandom(arrint);
        displayArrInt(arrint);
        Arrays.sort(arrint);
        displayArrInt(arrint);

        int[] arrint4 = Arrays.copyOf(arrint, arrint.length + 10);
        displayArrInt(arrint4);

        System.out.println(Arrays.equals(arrint, arrint2));
        System.out.println(Arrays.hashCode(arrint));
        System.out.println(Arrays.toString(arrint));

        // List<Integer>   <- int[]

        List<Integer> listInteger = new ArrayList<>();
        for (int i = 0; i < arrint.length; i++) {
            listInteger.add(arrint[i]);
        }
        System.out.println(listInteger.toString() + " size: " + listInteger.size());

        List<Integer> listInt2 = Arrays.asList(2, 3, 4, 5);
        System.out.println(listInt2.toString() + " size: " + listInt2.size());

        //List<String>
        List<String> listStr2 = Arrays.asList("luis", "juan");
        System.out.println(listStr2.toString());
    }

    private void displayArrInt(int[] arrint) {
        for (int i = 0; i < arrint.length; i++) {
            System.out.print(arrint[i] + ", ");
        }
        System.out.println();
    }

    private void arrIntFillRandom(int[] arrint) {
        for (int i = 0; i < arrint.length; i++){
            arrint[i] = (int) Math.round((Math.random() * 100));
        }
    }

}
