package package1;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class DynamicStack<T> implements IStack<T> {


    private static final int DEFAULT_CAPACITY = 8;
    private int DYNAMIC_CAPACITY;
    T array[];

    private int tail;

    @SuppressWarnings("unchecked")
    public DynamicStack(int size) {
        array=(T[])new Object[size+1];
        DYNAMIC_CAPACITY=size;
        tail=0;
    }

    public DynamicStack(){
        this(DEFAULT_CAPACITY);
        DYNAMIC_CAPACITY=DEFAULT_CAPACITY;
        tail=0;
    }


    @Override
    public boolean isEmpty() {
        return tail==0;
}

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T returnElem = array[tail-1];
        array[tail-1]=null;
        tail--;
        if(tail<=DYNAMIC_CAPACITY*0.2){
            DYNAMIC_CAPACITY= (int) (DYNAMIC_CAPACITY*0.5);
            CopyArray(DYNAMIC_CAPACITY);
        }
        return returnElem;
    }

    @Override
    public void push(T elem) {
        array[tail]=elem;
        tail++;
        if(tail>=DYNAMIC_CAPACITY*0.8){
            DYNAMIC_CAPACITY=DYNAMIC_CAPACITY*2;
            CopyArray(DYNAMIC_CAPACITY);
        }

    }

    @Override
    public int size() {
        return tail;
    }

    @Override
    public T top() throws EmptyStackException {
        return null;
    }

   // @SuppressWarnings("unchecked")
    public void CopyArray(int newSize){
        T[] array2;
        array2=(T[])new Object[newSize];
        for(int i=0;i<size();i++){
           array2[i]=array[i];
        }
        array=array2;
    }

    public int getTail() {
        return tail;
    }

    public int getDYNAMIC_CAPACITY() {
        return DYNAMIC_CAPACITY;
    }

    public void printStack(){
        for(int i=0;i<size();i++){
            System.out.print(array[i]);
        }
    }

    public T get(int index){
        return array[index];
    }

    public T[] getArray() {
        return array;
    }


}
