package package1;

public class ListQueue<T> implements IQueue<T> {

    private Node first=null;


    public ListQueue(){}

    public Node getFirst() {
        return first;
    }

    @Override
    public boolean isEmpty(){
        return first==null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        T deqElem = (T) first.getValue();
        first =first.getNext();

        return deqElem;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        Node newnode = new Node(elem);
        newnode.setNext(first);
        first=newnode;

    }

    @Override
    public int size() {
        if(isEmpty())return 0;
        Node actElem = first;
        int size=1;
        while (first.getNext()!=null){
            first=first.getNext();
            size++;

        }
        return size;
    }

    @Override
    public T first() throws EmptyQueueException {
        return (T) first.getValue();
    }

    public class Node<T>{

        private T value;
        private Node next;

        public Node(T value){
            this.value=value;
            next=null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }


}
