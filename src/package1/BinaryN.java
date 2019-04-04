package package1;

import java.beans.BeanInfo;
import java.util.Scanner;

public class BinaryN {

    private DynamicStack<Integer> dynamicStack;

    public BinaryN(){
        dynamicStack = new DynamicStack<>();
    }

    public void algorytm(){
        Scanner scanner = new Scanner(System.in);
       Integer n = scanner.nextInt();
       Integer i=0;

        while (n>0){
            dynamicStack.push((n%2));
            n=n/2;
        }
    }


    public DynamicStack<Integer> getDynamicStack() {
        return dynamicStack;
    }

    public void printBinaryN(){
        while(!dynamicStack.isEmpty()){
            System.out.print(dynamicStack.pop().toString());
        }

    }
}
