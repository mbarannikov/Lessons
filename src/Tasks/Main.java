package Tasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("4 & 4 " + (4 & 4 ));
            System.out.println("8 & 4  " + (8 & 4 ));
            System.out.println("9 & 4  " + (9 & 4 ));
            System.out.println("13 & 4 " + (13 & 4));
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingDeque.poll());
            System.out.println("---");
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println("---");
            System.out.println(blockingDeque.poll(200, TimeUnit.NANOSECONDS));
            System.out.println("---");
            System.out.println(blockingDeque.poll(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
// Handle interruption
        }
        //5 91 3 47

    }
}

class A {}
class B extends A { }
class C extends B { }