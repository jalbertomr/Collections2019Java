package com.bext;

import java.lang.reflect.Array;
import java.text.Normalizer;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class LinkedListLab {
    LinkedListLab() throws InterruptedException {
        System.out.println("LinkedListLab");
        /*
        LinkedList.addFirst(Object E);
        LinkedList.addLast( Object E);
         */

        LinkedList<String> miLList = new LinkedList<>();
        LinkedList<String> miLListRESP = new LinkedList<>();
        //Collections.shuffle(list, new Random());
        displayListIterator(miLList);
        miLList.addFirst("addFirst1");
        miLList.addFirst("addFirst2");
        miLList.addFirst("addFirst3");
        miLList.addLast("addLast1");
        miLList.addLast("addLast2");
        miLList.addLast("addLast3");
        miLListRESP.addAll(miLList);
        displayListIterator(miLListRESP);
        displayListIterator(miLList);

        System.out.println("miLList.getFirst(): " + miLList.getFirst());
        System.out.println("miLList.getLast(): " + miLList.getLast());

        System.out.println("miLList.remove(): " + miLList.remove());
        System.out.println("miLList.remove(): " + miLList.remove());
        System.out.println("miLList.remove(): " + miLList.remove());
        System.out.println("miLList.remove(): " + miLList.remove());

        miLList.clear();
        miLList.addAll(miLListRESP);
        displayListIterator(miLList);
        System.out.println("miLList.set( 2,\"set(2,obj)\"): " + miLList.set(2, "set(2,obj)"));
        displayListIterator(miLList);
        System.out.println("miLList.get(3): " + miLList.get(3));

        System.out.println("miLList.add(\"add1\"): " + miLList.add("add1"));  //add at last
        System.out.println("miLList.add(\"add2\"): " + miLList.add("add2"));  //add at last
        displayListIterator(miLList);
        System.out.println("miLList.remove(2): " + miLList.remove(2));
        displayListIterator(miLList);

        miLList.clear();
        miLList.addAll(miLListRESP);
        displayListIterator(miLList);
        displayListIterator(miLListRESP);
        System.out.println("miLListRESP.containsAll( miLList): " + miLListRESP.containsAll(miLList));
        miLList.add("EXTRA");
        displayListIterator(miLList);
        displayListIterator(miLListRESP);
        System.out.println("miLListRESP.containsAll( miLList): " + miLListRESP.containsAll(miLList));

        Spliterator spliterator = miLList.spliterator();

        Datos datos = new Datos();
        miLList.clear();
        miLList.addAll(datos.listNombres.subList(0, 10));
        miLList.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();

        miLList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return removeAccents(o1).compareTo(removeAccents(o2));
            }
        });
        miLList.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();

        // LikedList  add , Remove  better performance than ArrayList
        //            get, set      lower perforance than ArrayList

        miLList.clear();
        miLList.addAll(datos.listNombres.subList(0, 5));
        displayLinkedList(miLList);
        ListIterator<String> listIterator = miLList.listIterator();
        System.out.println("ListIterator.hasNext()  ListIterator.next()");
        int i = 1;
        int showtime = 100;
        while (listIterator.hasNext()) {
            System.out.println(String.format("%" + 12 * i + "s", listIterator.next()));
            Tsleep(showtime);
            i++;
        }

        System.out.println("ListIterator.hasPrevious()  ListIterator.previous()");
        i--;
        while (listIterator.hasPrevious()) {
            System.out.println(String.format("%" + 12 * i + "s", listIterator.previous()));
            Tsleep(showtime);
            i--;
        }

        displayLinkedList(miLList);

        i = 1;
        while (listIterator.hasNext()) {
            if (listIterator.nextIndex() == 2) break;
            System.out.println(String.format("%" + 12 * i + "s", listIterator.next()));
            Tsleep(showtime);
            i++;
        }

/*
|      Álan||   Jacinto||  Martinez||    Alicia||     Jesús|
        Álan
                 Jacinto
 */
        System.out.println("listIterator.add(\"ADDIT\");");
        listIterator.add("ADDIT");
        displayLinkedList(miLList);
/*
|      Álan||   Jacinto||     ADDIT||  Martinez||    Alicia||     Jesús|
 */
        System.out.println("if (listIterator.hasPrevious()) { listIterator.previous(); listIterator.remove(); }");
        if (listIterator.hasPrevious()) {
            listIterator.previous();
            listIterator.remove();
        }
        displayLinkedList(miLList);

        System.out.println("listIterator.nextIndex(): " + listIterator.nextIndex());
        System.out.println("listIterator.add(\"ADDagain\");");
        listIterator.add("ADDagain");
        displayLinkedList(miLList);
/*
|      Álan||   Jacinto||  ADDagain||  Martinez||    Alicia||     Jesús|
 */

        System.out.println("listIterator move to the end");
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        System.out.println("listIterator.add(\"AlFinal\");");
        listIterator.add("AlFinal");
        displayLinkedList(miLList);
/*
|      Álan||   Jacinto||  ADDagain||  Martinez||    Alicia||     Jesús||   AlFinal|
 */

        System.out.println("if ( listIterator.hasPrevious() ) { listIterator.previous();  }");
        System.out.println("listIterator.remove();");
        if (listIterator.hasPrevious()) {
            listIterator.previous();
        }
        listIterator.remove();
        displayLinkedList(miLList);
/*
|      Álan||   Jacinto||  ADDagain||  Martinez||    Alicia||     Jesús|
 */

        System.out.println("move to the begining and add");
        while (listIterator.hasPrevious()) listIterator.previous();
        listIterator.add("addBegin");
        displayLinkedList(miLList);
/*
|  addBegin||      Álan||   Jacinto||  ADDagain||  Martinez||    Alicia||     Jesús|
 */

        System.out.println("if (listIterator.hasPrevious()) listIterator.previous();");
        System.out.println("listIterator.remove();");
        if (listIterator.hasPrevious()) listIterator.previous();
        listIterator.remove();
        displayLinkedList(miLList);
/*
|      Álan||   Jacinto||  ADDagain||  Martinez||    Alicia||     Jesús|
 */
        System.out.println("miLList.remove(\"ADDagain\")" + miLList.remove("ADDagain"));
        miLList.remove("ADDagain");
        displayLinkedList(miLList);
    }

    public  static String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}+","");
    }

    private void displayLinkedList( LinkedList linkedList) {
        int cellLength = 10;
        linkedList.stream()
                .map(s -> String.format("|%" + cellLength + "s|", s))
                .forEach( s -> System.out.print( s));
        System.out.println();
    };

    private void Tsleep(int miliseconds)  {
        try {
            Thread.sleep( miliseconds);
        } catch( InterruptedException ie) {
            System.err.format( "InterruptedException: %s%n" + ie);
        };
    }

    private void displayListIterator(List list) {
        System.out.print("size: " + list.size() + " ");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print( iterator.next() + ", ");
        }
        System.out.println();
    }

    private void displayListIntFor(List<Integer> list) {
        System.out.print("size: " + list.size() + " ");
        for ( int i = 0; i < list.size(); i++) {
            System.out.print( list.get(i) + ", ");
        }
        System.out.println();
    }

    private void displayListStream(List list) {
        System.out.print("size: " + list.size() + " ");
        list.stream().forEach(e -> System.out.print(e + ", "));
        System.out.println();
    }
}
