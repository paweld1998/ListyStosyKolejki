package package1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ONP {

    private DynamicStack<Double> dynamicStack;
    private ArrayList<String> array;

    public ONP(){
        dynamicStack= new DynamicStack<Double>();
        array = new ArrayList<>();
    }

    public void readFileTxt(String filepath){
        String line;
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while((line = bufferedReader.readLine())!=null){
                ArrayList<String> helper = new ArrayList<>();
                array.addAll(Arrays.asList(line.split(" ")));

            }

            bufferedReader.close();
            fileReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public double algorytm(){
        for(int i =0;i<array.size();i++){
            //System.out.println(array.get(i));
            if(array.get(i).equals("+")){
                double liczba = dynamicStack.pop()+dynamicStack.pop();
                dynamicStack.push(liczba);
            }
            if(array.get(i).equals("-")){
                double a = dynamicStack.pop();
                double b = dynamicStack.pop();
                double liczba = b-a;
                dynamicStack.push(liczba);
            }
            if(array.get(i).equals("*")){
                double liczba = dynamicStack.pop()*dynamicStack.pop();
                dynamicStack.push(liczba);
            }
            if(array.get(i).equals("/")){
                double a = dynamicStack.pop();
                double b = dynamicStack.pop();
                double liczba = b/a;
                dynamicStack.push(liczba);
            }

            if(liczba(i)){
                System.out.println(array.get(i));
                dynamicStack.push(Double.parseDouble(array.get(i)));}
        }

        return dynamicStack.pop();
    }


    public boolean liczba(int index){
        if(array.get(index).equals("+"))return false;
        if(array.get(index).equals("/"))return false;
        if(array.get(index).equals("*"))return false;
        if(array.get(index).equals("-"))return false;

        return true;
    }
}
