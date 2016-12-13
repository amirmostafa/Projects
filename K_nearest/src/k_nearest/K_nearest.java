/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k_nearest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amir
 */
public class K_nearest {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<String> read(String fileName ) throws FileNotFoundException, IOException{
        ArrayList<String>allFile =new ArrayList<>();
        String line="";
        int count=0;

        FileReader fileReader =  new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while((line = bufferedReader.readLine()) != null) {   
            allFile.add(line);
        }

        return allFile;
    }
        
    public static void check(String testFileName ,  ArrayList<String>allFile) throws FileNotFoundException, IOException{
        ArrayList<String> testFile =read(testFileName);
        String[] testValues=null;
        String[] actualValues=null;
        ArrayList<Double> distance =new ArrayList<>();
        int d=0,testV=0,actualV=0;
        
        for (int i=0;i<testFile.size();i++){                    //loop 3la el test file
            testValues=testFile.get(i).split(",");
            distance.clear();
            for (int j=1;j<allFile.size();j++){                 //loop 3la el training file
                actualValues=allFile.get(j).split(",");
                
                d=0;
                for (int k=0;k<testValues.length;k++){
                    testV=Integer.parseInt(testValues[k]);
                    actualV=Integer.parseInt(actualValues[k]);
                    d+= Math.pow(testV-actualV, 2);
                }
                distance.add(Math.sqrt(d));
            }
            System.out.println(distance);
            
            getPrediction(distance);
        }
        
    }
    
    public static void getPrediction(ArrayList<Double> distance) throws IOException{
        ArrayList<String>allFile=read("set.txt");
        ArrayList<Integer>min=new ArrayList<>();
        ArrayList<Double>copy=new ArrayList<>();
        copy.addAll(distance);
        int yescount=0;
        int nocount=0;
        String[] response=null;
        for (int i=0;i<4;i++){
            Object obj = Collections.min(copy);
            for (int j=0;j<distance.size();j++){
                if((double)obj==distance.get(j)){
                    min.add(j);
                }
            }
            copy.remove(obj);
        }
        Collections.sort(min);
        System.out.println(min);
        
        for (int i=0;i<min.size();i++){
            for (int l=1;l<allFile.size();l++){
                if (l-1==min.get(i)){
                    response=allFile.get(l).split(",");
                    
                    if (response[response.length-1].equals("yes"))
                        yescount++;
                    else
                        nocount++;
                }
            }
        }
        System.out.println("yes count : "+yescount +"  no count : "+nocount);
      // double coverage=4.0/(allFile.size()-1);
        double accurcy=0;
        if (yescount>=nocount){
            System.out.println("yes");
             accurcy=(4-nocount)/4.0;
        }
        else{
            System.out.println("no");
            accurcy=(4-yescount)/4.0;
        }
        
    //    System.out.println("coverage = "+coverage*100+" %");
        System.out.println("acuracy = "+accurcy*100+" %");
        
        
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         ArrayList<String>allFile=read("set.txt");
        check("test.txt" ,allFile ) ;
    }
    
}
