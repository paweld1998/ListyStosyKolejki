package package1;

import java.util.Iterator;
import java.util.ListIterator;

public class OneWayLinkedListWithHead<T> extends AbstractList<T> {


    private class Element{
        private T value;
        private Element next;


        public T getValue() {
            return value;}
        public void setValue(T value) {
            this.value = value;}
        public Element getNext() {
            return next;}
        public void setNext(Element next) {
            this.next = next;}
        Element(T data){
            this.value=data;}
    }



    Element head=null;

    public OneWayLinkedListWithHead(){}

    public boolean isEmpty(){
        return head==null;}

    @Override
    public void clear() {
        head=null;}

    @Override
    public int size() {
        int pos=0;
        Element actElem=head;
        while(actElem!=null)
        {
            pos++;
            actElem=actElem.getNext();
        }
        return pos;}

    /** zwraca referencję na Element, wewnętrzną klasę */
    private Element getElement(int index){
        if(index<0) throw new IndexOutOfBoundsException();
        Element actElem=head;
        while(index>0 && actElem!=null){
            index--;
            actElem=actElem.getNext();
        }
        if (actElem==null)
            throw new IndexOutOfBoundsException();
        return actElem;
    }
    @Override
    public boolean add(T e) {
        Element newElem=new Element(e);
        if(head==null){
            head=newElem;
            return true;
        }
        Element tail=head;
        while(tail.getNext()!=null)
            tail=tail.getNext();
        tail.setNext(newElem);
        return true;
    }

    @Override
    public boolean add(int index, T data) {
        if(index<0) throw new IndexOutOfBoundsException();
        Element newElem=new Element(data);
        if(index==0)
        {
            newElem.setNext(head);
            head=newElem;
            return true;
        }
        Element actElem=getElement(index-1);
        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
        return true;
    }

    @Override
    public int indexOf(T data) {
        int pos=0;
        Element actElem=head;
        while(actElem!=null)
        {
            if(actElem.getValue().equals(data))
                return pos;
            pos++;
            actElem=actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data)>=0;
    }

    @Override
    public T get(int index) {
        Element actElem = getElement(index);
        return actElem.getValue();
    }

    @Override
    public T set(int index, T data) {
        Element actElem=getElement(index);
        T elemData=actElem.getValue();
        actElem.setValue(data);
            return elemData;
    }

    @Override
    public T remove(int index) {
        if(index<0 || head==null) throw new IndexOutOfBoundsException();
        if(index==0){
            T retValue=head.getValue();
            head=head.getNext();
            return retValue;}
        Element actElem=getElement(index-1);
        if(actElem.getNext()==null)
            throw new IndexOutOfBoundsException();
        T retValue=actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;}


    @Override
    public boolean remove(T value) {
        if(head==null)
            return false;
        if(head.getValue().equals(value)){
            head=head.getNext();
            return true;}
        Element actElem=head;
        while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value))
            actElem=actElem.getNext();
        if(actElem.getNext()==null)
            return false;
        actElem.setNext(actElem.getNext().getNext());
        return true;}


    private class InnerIterator implements Iterator<T>{
        Element actElem;
        public InnerIterator() {
            actElem=head;
        }
        @Override
        public boolean hasNext() {
            return actElem!=null;
        }
        @Override
        public T next() {
            T value=actElem.getValue();
            actElem=actElem.getNext();
            return value;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }




}
