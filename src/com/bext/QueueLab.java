package com.bext;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueLab {
    public QueueLab() {        System.out.println("QueueLab");
        /*

         */

        Queue<String> miQueue = new LinkedList<>();
        Queue<String> miQueueRESP = new LinkedList<>();
        //Collections.shuffle(list, new Random());
        displayQueueIterator(miQueue);
        miQueue.add("add1");
        displayQueueIterator(miQueue);
        miQueue.add("add2");
        displayQueueIterator(miQueue);
        miQueue.add("add3");
        displayQueueIterator(miQueue);
        miQueue.add("add4");
        displayQueueIterator(miQueue);
        miQueue.add("add5");
        displayQueueIterator(miQueue);
        miQueue.add("add6");
        displayQueueIterator(miQueue);
        miQueueRESP.addAll(miQueue);
        displayQueueIterator(miQueueRESP);
        displayQueueIterator( miQueue);

        System.out.println("miQueue.poll(): " + miQueue.poll());
        displayQueueIterator(miQueue);
        System.out.println("miQueue.poll(): " + miQueue.poll());
        displayQueueIterator(miQueue);
        System.out.println("miQueue.remove(): " + miQueue.remove());
        displayQueueIterator(miQueue);
        System.out.println("miQueue.remove(): " + miQueue.remove());
        displayQueueIterator(miQueue);
        System.out.println("miQueue.remove(): " + miQueue.remove());
        displayQueueIterator(miQueue);
        System.out.println("miQueue.remove(): " + miQueue.remove());
        displayQueueIterator(miQueue);
        displayQueueIterator(miQueue);

        miQueue.clear();
        miQueue.addAll(miQueueRESP);
        displayQueueIterator(miQueue);
        System.out.println("miQueue.peek(): " + miQueue.peek());
        displayQueueIterator(miQueue);
        System.out.println("miQueue.poll(): " + miQueue.poll() );
        displayQueueIterator(miQueue);

        System.out.println( "miQueue.add(\"add1\"): "  + miQueue.add("add1"));  //add at last
        System.out.println( "miQueue.add(\"add2\"): "  + miQueue.add("add2"));  //add at last
        displayQueueIterator(miQueue);
        System.out.println( "miQueue.remove(2): " + miQueue.remove(2));
        System.out.println( "miQueue.remove(\"add2\")" + miQueue.remove("add2"));

        displayQueueIterator(miQueue);

        miQueue.clear();
        miQueue.addAll( miQueueRESP);
        displayQueueIterator(miQueue);
        displayQueueIterator(miQueueRESP);
        System.out.println( "miQueueRESP.containsAll( miQueue): " + miQueueRESP.containsAll( miQueue) );
        miQueue.add("EXTRA");
        displayQueueIterator(miQueue);
        displayQueueIterator(miQueueRESP);
        System.out.println( "miQueueRESP.containsAll( miQueue): " + miQueueRESP.containsAll( miQueue) );

    }

    private void displayQueueIterator(Queue queue) {
        System.out.print("size: " + queue.size() + " ");
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print( iterator.next() + ", ");
        }
        System.out.println();
    }

    private void displayQueueIntFor(Queue<Integer> queue) {
        System.out.print("size: " + queue.size() + " ");
        for ( int i = 0; i < queue.size(); i++) {
            System.out.print( "queue.get(i) NOT ENABLED");
        }
        System.out.println();
    }

    private void displayQueueStream(Queue queue) {
        System.out.print("size: " + queue.size() + " ");
        queue.stream().forEach(e -> System.out.print(e + ", "));
        System.out.println();
    }


}
