/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
/**
 *
 * @author Amir
 */
public class Regression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        ArrayList<Integer> dependent=new ArrayList<>();
        ArrayList<Integer> independent=new ArrayList<>();
        ArrayList<Integer> dMean=new ArrayList<>();
        ArrayList<Integer> inMean=new ArrayList<>();
        ArrayList<Integer> SquareDMean=new ArrayList<>();
        ArrayList<Integer> SquareINMean=new ArrayList<>();
        ArrayList<Integer> Mul=new ArrayList<>();
        
        double Mean_Dep=0;
        double Mean_InDep=0;

       String Filename="1.txt";
       
       String delimiter=",";
       
       BufferedReader reader=new BufferedReader(new FileReader(Filename));
       String Trans="";
        while(reader.ready()!=false){
           Trans=reader.readLine();
           StringTokenizer Split=new StringTokenizer(Trans, delimiter);
           int sub=Integer.parseInt(Split.nextToken());
           dependent.add(sub);
           sub=Integer.parseInt(Split.nextToken());
           independent.add(sub);
       }
    int sum1=0;
    int sum2=0;
    for(int i=0;i<dependent.size();i++){
        sum1+=dependent.get(i);
        sum2+=independent.get(i);
    }
        System.out.println("Sum1:"+sum1);
        System.out.println("Sum2:"+sum2);
    Mean_Dep=sum1/dependent.size();
    Mean_InDep=sum2/independent.size();
    System.out.println("Mean1:"+Mean_Dep);
    System.out.println("Mean2:"+Mean_InDep);
    for(int i=0;i<dependent.size();i++){
        dMean.add(dependent.get(i)-(int)Mean_Dep);
        inMean.add(independent.get(i)-(int)Mean_InDep);
        System.out.println("dMean:"+dMean.get(i));
        System.out.println("inMean:"+inMean.get(i));
    }
    int SumSDMMean=0;
    int SumSINMean=0;
    int SumOfMul=0;
    for(int i=0;i<dependent.size();i++){
        Mul.add(dMean.get(i)*inMean.get(i));
        SumOfMul+=Mul.get(i);
        SquareDMean.add(dMean.get(i)*dMean.get(i));
        SquareINMean.add(inMean.get(i)*inMean.get(i));
        SumSDMMean+=SquareDMean.get(i);
        SumSINMean+=SquareINMean.get(i);
        System.out.println("SquareDMean:"+SquareDMean.get(i));
        System.out.println("SquareINMean:"+SquareINMean.get(i));
        System.out.println("Mul:"+Mul.get(i));
    }
    System.out.println("SumSDMMean:"+SumSDMMean);
    System.out.println("SumSINMean:"+SumSINMean);
    System.out.println("SumOfMul:"+SumOfMul);
    double W1=(double)SumOfMul/(double)SumSDMMean;
    System.out.println("W1:"+W1);
    double W0=(double)Mean_InDep-(W1*(double)Mean_Dep);
    System.out.println("W0:"+W0);
    

       Filename="2.txt";
       int correct=0;
       int cover=0;
       reader=new BufferedReader(new FileReader(Filename));
       Trans="";
       ArrayList<Integer> Newvalues=new ArrayList<>();
       ArrayList<Integer> CorrectIndependent=new ArrayList<>();
        while(reader.ready()!=false){
            Trans=reader.readLine();
            Newvalues.add(Integer.parseInt(Trans));
        }
        
        for(int i=0;i<Newvalues.size();i++){
            System.out.println("New:"+Newvalues.get(i));
            for(int j=0;j<dependent.size();j++){
                if(Newvalues.get(i)==dependent.get(j)){
                    cover++;
                    double y=W0+W1*Newvalues.get(i);
                    System.out.println("y:"+y);
                    if((int)y==independent.get(j)){
                        correct++;
                        
                    }
                    
                }
            }
        }
        System.out.println("Cover:"+cover);
        System.out.println("correct:"+correct);
        double accuracy =correct/cover;
        System.out.println("Accuracy:"+accuracy );
    
    
    
    
       
       
    }
    
    
}
