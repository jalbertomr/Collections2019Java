package com.bext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListLab {

    public ArrayListLab() {
        int intPrimitive = 12;
        Integer intObj = 130;
        double doublePrimitive = 234.33;
        Double doubleObj = 5434.654;

        intPrimitive = (int) doublePrimitive;
        intPrimitive = doubleObj.intValue();
        intPrimitive = (int) Math.round(doubleObj);

        intPrimitive = intObj.intValue();

        // Lists
        int[] arrint = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        System.out.println(arrint.length);
        List<Integer> listInt = new ArrayList<>(); //                    ArrayList
        //List<Integer> listInt = Arrays.asList( 2, 3, 4, 7, 34, 21); // List
        for (int i = 0; i < arrint.length; i++){
            listInt.add( arrint[i]);
        }

        Integer[] arrInteger = { 23,54,2,24,65,33,23,66,98,65};
        List<Integer> listInt2 = new ArrayList<Integer>( Arrays.asList( arrInteger ) );

        displayListIntFor(listInt);
        displayListIterator(listInt);
        displayListStream(listInt);
        System.out.println("listInt2");
        displayListIntFor(listInt2);

        System.out.println("arrint[0]: " + arrint[0] );
        System.out.println("listInt.get(0): " + listInt.get(0));
        //remove
        listInt.remove( new Integer(3)); // remove object Integer 3
        displayListIntFor(listInt);
        listInt.remove( listInt.size() - 1 );  // remove index, the last element
        displayListIntFor(listInt);

        List<String> listStrA = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            listStrA.add( String.valueOf( i ) );
            listStrA.add( Integer.toString( i ));
            displayListIterator( listStrA);
        }

/*
        List<String> listStr = Arrays.asList("A","E","I","O","U"); //List
        displayListIterator(listStr);
        listStr.remove("A");     //can not be accessed
*/
        //List.add() ArrayList.add()
        List<String> listStr = new ArrayList<>();
        listStr.add("A"); listStr.add("B");listStr.add("A");listStr.add("C");listStr.add("A");
        listStr.add("D"); listStr.add("A");listStr.add("E");listStr.add("A");listStr.add("F");
        displayListIterator(listStr);
        listStr.add(1,"addAtIndex1");
        displayListIterator(listStr);
        listStr.remove("addAtIndex1");
        displayListIterator(listStr);

        //List.addAll(index, collection)
        // create the Arraylist<String> filled from an array of string
        String[] arrStringBLOCK = {"B","L","O","C","K"};
        List<String> listStrBlock = new ArrayList<>( arrStringBLOCK.length);
        for (int i = 0; i < arrStringBLOCK.length; i++){
            listStrBlock.add(arrStringBLOCK[i]);
        }
        displayListIterator(listStrBlock);

        listStr.addAll(listStrBlock);
        displayListIterator(listStr);

        listStr.addAll(2,listStrBlock);
        displayListIterator(listStr);

        // List.get(index) , List.set(index, object)
        System.out.println( "listStr.get(0): " + listStr.get(0) );
        System.out.println( "listStr.get(19): " + listStr.get(19) );
        System.out.println("listStr.set(19,\"ZZ\") :" + listStr.set(19,"ZZ") );
        displayListIterator(listStr);

        System.out.println("listStr.lastIndexOf(\"A\"): " + listStr.lastIndexOf("A"));
        List<String> miSubListStr = listStr.subList(0, 4);
        System.out.println("listStr.subList(0, 4) : "); displayListIterator( miSubListStr);
        listStr.remove("A");
        displayListIterator(listStr);
/*
        listStr.add("A");
        displayListIterator(listStr);
        while (listStr.remove("A")){     //remove all the "A" and display the list each iteration
            displayListIterator(listStr);
        }
*/
    }

    private void displayListIterator(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print( iterator.next() + ", ");
        }
        System.out.print("size: " + list.size());
        System.out.println();
    }

    private void displayListIntFor(List<Integer> list) {
        for ( int e : list)  {
            System.out.print( e + ", ");
        }
        System.out.print("size: " + list.size());
        System.out.println();
    }


    private void displayListIntForOld(List<Integer> list) {
        for ( int i = 0; i < list.size(); i++) {
            System.out.print( list.get(i) + ", ");
        }
        System.out.print("size: " + list.size());
        System.out.println();
    }

    private void displayListStream(List list) {
        list.stream().forEach(e -> System.out.print(e + ", "));
        System.out.print("size: " + list.size());
        System.out.println();
    }
}
