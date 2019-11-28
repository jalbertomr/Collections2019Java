package com.bext;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamLab {
    public StreamLab() {

        //reduceStreamMayor();
        reductions();
    }

    private void reductions() {

/*   https://www.logicbig.com/tutorials/core-java-tutorial/java-util-stream/reduction.html
    Returns
       Single Value:   min(), max(),  count(), sum(),  average(), summaryStatistics()
       Collections:    collect(), toArray()

       fold operations uses binary function ( accumulator ) whose first argument is the
       value returned from the last excecution of the same function, second argunent is the
       current stream element
       (a, b) ->
       a previos result, b current element of the stream

       BiFunction
          |
       BinaryOperator
 */
        // (1) Optional<T>  reduce( BinaryOperator<T> accumulator)

        int i = IntStream.range(1, 6)
                .reduce((a, b) -> a * b)
                .orElse(-1);
        System.out.println("product:" + i);

        i = IntStream.range(1, 6).sum();
        System.out.println("sum:" + i);

        // (2) T reduce ( T Identity, BunaryOperator<T> accumulator)
        // Identity is the initial value of reduction
        i = IntStream.range(1, 6)
                .reduce(100, (a, b) -> a * b);
        System.out.println("product with initial value of 100: " + i);

        i = IntStream.empty()
                .reduce(100, (a, b) -> a * b);
        System.out.println("product with initial value of 100 with empty stream: " + i);

        i = IntStream.range(1, 6)
                .parallel()
                .reduce(100, (a, b) -> a * b);
        System.out.println("product with initial value of 100 paralelized (identity taken many times (wrong answer)): " + i);

        //(3) <U> U reduce(U identity,
        //                 Bifunction<U, ? super T,U> accumulator,
        //                 BinaryOperator<U> combiner)
        //  this is a combination of map() and reduce()
        // the identity value must be an identity for the combiner function
        // combiner(identity, u) == u
        // also combiner must be compatible with accumulator
        // combiner.apply( u, accumulator.apply( identity, t)) == accumulator.apply( u, t)

        i = Stream.of("2","3","4","5")     // using anonymous classes
                .parallel()
                .reduce(0, new BiFunction<Integer, String, Integer>() {
                    @Override
                    public Integer apply(Integer integer, String s) {
                        return Integer.sum(integer, Integer.parseInt(s));
                    }
                }, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        return Integer.sum( integer, integer2);
                    }
                });
        System.out.println("string values converted and sumed: " +  i );

        i = Stream.of("2","3","4","5")     // using anonymous classes
                .parallel()
                .reduce( 0, ( integer, s) -> Integer.sum(integer, Integer.parseInt( s )),
                        ((integer, integer2) -> Integer.sum( integer, integer2)));
        System.out.println("string values converted and sumed: " +  i );

        // Stream min()
        // Optional<T> min( Comparator<? super T> comparator)

        String miStr = Stream.of("Perro","zanahoria","caballo")
                    .min(String::compareTo)
                    .get();
        System.out.println(miStr);

        miStr = Stream.of("Perro","zanahoria","caballo")
                .filter(e -> e.length() == 3)
                .min(String::compareTo)
                .orElse("Ninguno");
        System.out.println(miStr);

        Optional<String> miReduce = Stream.of("Perro","zanahoria","caballo")
                .reduce( (s, s2) -> s.compareTo(s2) <= 0 ? s : s2);
        System.out.println(miReduce);

         miStr = Stream.of("Perro","zanahoria","caballo")
                .max(String::compareTo)
                .get();
        System.out.println(miStr);

        miReduce = Stream.of("Perro","zanahoria","caballo")
                .reduce((s,s2)-> s.compareTo(s2) > 0 ? s :s2);
        System.out.println(miStr);

        double midouble = DoubleStream.of( 1.3, 2.5, 3, 5.4)
                .sum();
        System.out.println(midouble);

        midouble = DoubleStream.of(1.3, 2.5, 3, 5.4)
                .reduce( 0 , Double::sum);
        System.out.println(midouble);

        double average = LongStream.range(1, 10)
                .average()
                .orElse(-1);
        System.out.println( average);

        long micount = Stream.of("Perro","zanahoria","caballo")
                .count();
        System.out.println( micount);

        micount = Stream.of("Perro","zanahoria","caballo")
                .mapToLong( s -> 1L)
                .sum();

        System.out.println( micount);

        IntSummaryStatistics miStat = IntStream.rangeClosed(1,10)
                .summaryStatistics();
        System.out.println(miStat);


    }

    private void reduceStreamMayor() {
        //List<String> words = new ArrayList<>();   // If we want it Empty
        List<String> words = Arrays.asList("Esta","es","una","prueba","para","obtener","la","palabra","mayor","o","menor");

        System.out.println(words.toString());

        Optional<String> longestWord = words.stream()
                .reduce( (word1, word2 )-> word1.length() > word2.length() ? word1 : word2);
        System.out.println( "longestWord: " + longestWord);

        Optional<String> shortestWord = words.stream()
                .reduce( ( word1, word2) -> word1.length() < word2.length() ? word1 : word2);
        System.out.println( "shortestWord: " + shortestWord);
        if (shortestWord.isPresent()) System.out.println(shortestWord.get());

        // Array <- list
        String[] arrString = new String[ words.size() ];
        arrString = words.toArray( arrString );
        Arrays.stream( arrString).forEach(a-> System.out.print(a + " "));
        //String[] arrString = {"Esta","es","una","prueba","para","obtener","la","palabra","mayor","o","menor"};

        Optional<String> joinedWords = Arrays.stream( arrString)
                .reduce( (word1, word2) -> word1 + "-" + word2 );
        if ( joinedWords.isPresent()) {
            System.out.println( joinedWords.get());
        }

        // Stream reduce sum a list of integers
        Integer[] arrInt = {-2, 0, 200, 12, 23, -45};

        List<Integer> listInt = new ArrayList<>( Arrays.asList( arrInt));
        listInt.stream().forEach( e -> System.out.print(e + " "));
        System.out.println();

        Optional<Integer> sumArrInt = Arrays.stream( arrInt)   // arrInt to stream.reduce
                .reduce( (a, b) -> a + b);
        if ( sumArrInt.isPresent()) {
            System.out.println( "sumArrInt: " + sumArrInt );
        }

        LongStream.range( 2,10).forEach(a-> System.out.print(a + " "));  // LongStream.range  reduce   .orElse exclude the right most element
        long product = LongStream.range( 2, 10)
                .reduce( (a, b) -> a * b)
                .orElse(-1);
        System.out.println("product: " + product );

        LongStream.range( 2,10).forEach(a-> System.out.print(a + " "));  // LongStream.range  reduce   .orElse exclude the right most element
        long sumaA = LongStream.range( 2, 10)
                .reduce( (a, b) -> a + b).getAsLong();
                //.orElse(-1);
        System.out.println("sumaA: " + sumaA );

        long sumaB = LongStream.of(1L, 1L, 1L, 1L, 1L)
                .reduce( (a, b) -> a + b)
                .orElse( -1);
        //.orElse(-1);
        System.out.println("sumaB: " + sumaB );  // sumaB: 5


    }
}

/*
Stream.reduce() in Java with examples
      Many times, we need to perform operations where a stream reduces to single resultant value, for example, maximum, minimum, sum, product, etc. Reducing is the repeated process of combining all elements.
        reduce operation applies a binary operator to each element in the stream where the first argument to the operator is the return value of the previous application and second argument is the current stream element.
        Syntax :

        T reduce(T identity, BinaryOperator<T> accumulator);

        Where, identity is initial value
        of type T and accumulator is a
        function for combining two values.

        sum(), min(), max(), count() etc. are some examples of reduce operations. reduce() explicitly asks you to specify how to reduce the data that made it through the stream.

*/
// Implementation of reduce method
// to get the longest String
/*
class GFG {

    // Driver code
    public static void main(String[] args)
    {
        // creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");

        // The lambda expression passed to reduce() method takes two Strings and returns the longer String.
        // The result of the reduce() method is an Optional because the list on which reduce() is called may be empty.
        Optional<String> longestString = words.stream()
                .reduce((word1, word2)
                        -> word1.length() > word2.length()
                        ? word1 : word2);

        // Displaying the longest String
        longestString.ifPresent(System.out::println);
    }
}
*/
/*
import java.util.*;

class GFG {

    // Driver code
    public static void main(String[] args)
    {

        // String array
        String[] array = { "Geeks", "for", "Geeks" };

        // The result of the reduce() method is an Optional because the list on which reduce() is called may be empty.
        Optional<String> String_combine = Arrays.stream(array)
                .reduce((str1, str2)
                        -> str1 + "-" + str2);

        // Displaying the combined String
        if (String_combine.isPresent()) {
            System.out.println(String_combine.get());
        }
    }
}
*/

// Implementation of reduce method
// to get the sum of all elements
/*
import java.util.*;

class GFG {

    // Driver code
    public static void main(String[] args)
    {

        // Creating list of integers
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

        // Finding sum of all elements
        int sum = array.stream().reduce(0,
                (element1, element2) -> element1 + element2);

        // Displaying sum of all elements
        System.out.println("The sum of all elements is " + sum);
    }
}
*/
// Implementation of reduce method to get the product of all numbers in given range.
/*
import java.util.*;
import java.util.stream.IntStream;

class GFG {

    // Driver code
    public static void main(String[] args)
    {

        // To get the product of all elements
        // in given range excluding the
        // rightmost element
        int product = IntStream.range(2, 8)
                .reduce((num1, num2) -> num1 * num2)
                .orElse(-1);

        // Displaying the product
        System.out.println("The product is : " + product);
    }
}
*/
/*
Output :

        The product is : 5040
*/
