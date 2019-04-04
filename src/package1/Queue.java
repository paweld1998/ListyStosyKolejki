package package1;

public class Queue<T> implements IQueue<T> { //kolejka ograniczona !

    private static final int DEFAULT_CAPACITY = 8;
    T array[];
    int size;



    @SuppressWarnings("unchecked")
    public Queue(int CAPACITY) {
        array=(T[])new Object[CAPACITY];
        size=0;
    }

    public Queue(){
        this(DEFAULT_CAPACITY);
        size=0;
    }



    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();

        T deqElem = array[0];
        for(int i =0;i<array.length-1;i++){
            array[i]=array[i+1];
        }
        size--;

        return deqElem;
    }


    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean isFull() {
        return size()==array.length;
    }



    @Override
    public void enqueue(T elem) throws FullQueueException {
        if(isFull()){
            throw new FullQueueException();
        }
        array[size()]=elem;

        size++;
    }

    @Override
    public int size() {
       return getSize();
    }

    public int getSize() {
        return size;
    }

    @Override
    public T first() throws EmptyQueueException {
        return null;
    }

    public void printQueue(){
        for(int i=0;i<size();i++){
            System.out.println(array[i]);
        }
    }
}
