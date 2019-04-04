package package1;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws FullQueueException, EmptyQueueException {


        KolejkaBufferFilter<Integer> kolejkaBufferFilter = new KolejkaBufferFilter<>(4);



        kolejkaBufferFilter.enqueue(1);
        kolejkaBufferFilter.enqueue(2);
        kolejkaBufferFilter.enqueue(3);
        kolejkaBufferFilter.enqueue(4);





        //System.out.println(kolejkaBufferFilter.size());
        kolejkaBufferFilter.printKolejka();
        System.out.println();
        System.out.println("pobieram");
        System.out.println(kolejkaBufferFilter.dequeue());
        System.out.println(kolejkaBufferFilter.dequeue());
        System.out.println();
        kolejkaBufferFilter.printKolejka();


        kolejkaBufferFilter.enqueue(5);
        kolejkaBufferFilter.enqueue(6);
        System.out.println();
        kolejkaBufferFilter.printKolejka();
        kolejkaBufferFilter.dequeue();
        kolejkaBufferFilter.dequeue();

        kolejkaBufferFilter.enqueue(7);
        kolejkaBufferFilter.enqueue(8);
        System.out.println();


//
       kolejkaBufferFilter.printKolejka();

        //System.out.println(kolejkaBufferFilter.getHead());

       kolejkaBufferFilter.dequeue();
       kolejkaBufferFilter.enqueue(10);
        System.out.println();
        kolejkaBufferFilter.printKolejka();












    }
}
