package com.bext;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class SetLab {
    public SetLab() {

        //int[] arrint = {1,4,2,5,7,11,12,75,23,76};
        Integer[] arrInt = {12,12,75,23,23,76,1,4,2,5,7,11,12,23};
        //HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1,4,2,5,7,11,12,75,23,76));
        HashSet<Integer> hashSet = new HashSet<>( Arrays.asList( arrInt));
        TreeSet<Integer> treeSet = new TreeSet<>( Arrays.asList( arrInt));

        System.out.print("ORIGINAL          : ");
        displayArr( arrInt);
        //displayIterator( hashSet);
        System.out.print("HashSet Sin Orden : ");
        displayFor( hashSet);
        System.out.print("TreeSet Con Orden : ");
        displayFor( treeSet);
        //displayForEach( hashSet);

        HashSet<Integer> hashSet2 = new HashSet<>();

        hashSet2.addAll( hashSet);

        System.out.println("hashSet2");
        displayFor( hashSet2);

        System.out.println("hashSet.equals(hashSet): " + hashSet.equals( hashSet));
        System.out.println("hashSet.equals(hashSet2): " + hashSet.equals( hashSet2));

        System.out.println("hashSet2.add( 11): " + hashSet2.add( 11));
        System.out.println("hashSet.equals(hashSet2): " + hashSet.equals( hashSet2));

        System.out.println("hashSet2.add( 99): " + hashSet2.add( 99));
        System.out.println("hashSet.equals(hashSet2): " + hashSet.equals( hashSet2));

        HashSet<Integer> hashSetResp = new HashSet<>( hashSet);
        HashSet<Integer> hashSet2Resp = new HashSet<>( hashSet2);
        displayFor( hashSetResp);
        displayFor( hashSet2Resp);

        System.out.println("hashSet.retainAll( hashSet2): " + hashSet.retainAll( hashSet2));
        System.out.println("hashSet2.retainAll( hashSet): " + hashSet2.retainAll( hashSet));

        hashSet.clear(); hashSet.addAll( hashSetResp);
        hashSet2.clear(); hashSet2.addAll( hashSet2Resp);

        System.out.println(hashSet2.removeAll( hashSet));
        displayFor(hashSet2);

        System.out.println("hashSet2.contains( 99): " + hashSet2.contains( 99));
        System.out.println("hashSet.contains( 99): " + hashSet.contains( 99));

        System.out.println( String.format("%3s", "2").replace(" ","0"));
        Set<String> set = new TreeSet<String>((o1, o2) ->  String.format("%3s", o1.substring( o1.indexOf(" ") + 1)).replace(" ","0")
                                         .compareTo(  String.format("%3s", o2.substring( o2.indexOf(" ") + 1)).replace(" ","0")
                                         ));
        //Set<String> set = new TreeSet<String>((o1, o2) ->  o1.substring( o1.indexOf(" ") + 1)
        //        .compareTo(  o2.substring( o2.indexOf(" ") + 1)));

        set.add("test 15");
        set.add("dfd 2");
        set.add("ersfd 20");
        set.add("asdt 10");
        set.stream().forEach(s -> System.out.println(s));


    }

    private void displayArr(Integer[] arrInt) {
        for (int i = 0; i < arrInt.length; i++){
           System.out.print( arrInt[i] + ", ");
        }
        System.out.print( "size: " + arrInt.length);
        System.out.println();
    }

    private void displayForEach(HashSet<Integer> hashSet) {
        hashSet.forEach(e -> System.out.print(e + ", ") );
        System.out.print( "size: " + hashSet.size());
        System.out.println();
    }

    private void displayFor(Set<Integer> set) {
        for( Integer e: set){
            System.out.print( e + ", ");
        }
        System.out.print( "size: " + set.size());
        System.out.println();
    }

    private void displayIterator(Set set) {
        Iterator iter = set.iterator();
        while ( iter.hasNext()){
            System.out.print( iter.next() + ", ");
        }
        System.out.print( "size: " + set.size());
        System.out.println();
    }
}
