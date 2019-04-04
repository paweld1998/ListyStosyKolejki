package package1;

public class KolejkaBufferFilter<T> implements IQueue<T> {

    private static final int DEFAULT_CAPACITY = 4;
    T array[];
    int head;
    int tail;
    int size;


    @SuppressWarnings("unchecked")
    public KolejkaBufferFilter(int size) {
        array=(T[])new Object[size];
        head=0;
        tail=0;
        size=0;
    }

    public KolejkaBufferFilter(){

        this(DEFAULT_CAPACITY);
        head=0;
        tail=0;
        size=0;
    }

    @Override
        public boolean isEmpty() {
            return getSize()==0;
    }

    @Override
    public boolean isFull() {
        return size()==DEFAULT_CAPACITY;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        }

        T elem = array[head];
        array[head]=null;
        head++;
        size--;
        if(head-1>array.length){
            head=0;
        }
        if(tail>=array.length&&size()<DEFAULT_CAPACITY){
            setTail(0);
        }

        return elem;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {

        if(isFull()){
            throw new FullQueueException();
        }

        array[tail]=elem;
        tail++;
        size++;
        if(tail>=array.length&&size()<DEFAULT_CAPACITY){
            setTail(0);
        }
        if(head>=array.length&&!isFull()){
            setHead(0);
        }

    }

    public int getSize() {
        return size;
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public T first() throws EmptyQueueException {
        return array[head];
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void printKolejka(){
        for(int i =0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }


}
