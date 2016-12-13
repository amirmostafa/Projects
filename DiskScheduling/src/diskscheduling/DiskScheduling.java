/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskscheduling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import com.objectplanet.chart.*; 
import java.awt.*; 
import java.util.Scanner;
/**
 *
 * @author Amir
 */
public class DiskScheduling {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Integer> FCFS(ArrayList<Integer>queue , int start){
        ArrayList<Integer>points=new ArrayList<>();
        int totalMovements=0;
        int sub=0;
        String sequence="";
        points.add(start);
        for (int i=0;i<queue.size();i++){
            
            sub=start-queue.get(i);
            if (sub<0){
                sub=sub*(-1);
            }
            totalMovements+=sub;
            sequence+=start+" -> "+ queue.get(i)+"  ";
            start=queue.get(i);
            points.add(start);
        }
        System.out.println(sequence);
        System.out.println(totalMovements+" Cylinders");
        return points;
    }
    
    public static ArrayList<Integer> SSTF(ArrayList<Integer>queue , int start){
        ArrayList<Integer>points=new ArrayList<>();
        int totalMovements=0;
        ArrayList<Integer>served=new ArrayList<>();
        int sub=0,min=1000,current=0;
        String sequence="";
        points.add(start);
        for (int j=0;j<queue.size();j++){
            min=1000;
            for (int i=0;i<queue.size();i++){
                if (start!=queue.get(i) && served.contains(queue.get(i))==false){
                    sub=start-queue.get(i);
                    if (sub<0){
                        sub=sub*(-1);
                    }
                    if (sub <= min){
                        min=sub;
                        current=queue.get(i);
                        
                    }
                }

            }
            
            served.add(current);
            totalMovements+=min;
            sequence+=start+" -> "+ current+"  ";
            start=current;
            points.add(start);
        }
        System.out.println(sequence);
        System.out.println(totalMovements+" Cylinders");
        return points;
    }
    
    public static ArrayList<Integer> SCAN(ArrayList<Integer>queue , int start){
        ArrayList<Integer>points=new ArrayList<>();
        int totalMovements=0;
        int sub=0,idx=0;
        String sequence="";
        boolean check=false;
        int end=Collections.max(queue);
        end+=20;
        queue.add(end);
        queue.add(start);
        queue.add(0);
        Collections.sort(queue);
        System.out.println(queue);
        points.add(start);
        for (int i=0;i<queue.size();i++){
            if (queue.get(i)==start){
                check=true;
                idx=i;
            }
            if (check==true && queue.get(i)!=start ){
                sub=start-queue.get(i);
                if (sub<0){
                    sub=sub*(-1);
                }  
                
                totalMovements+=sub;
                sequence+=start+" -> "+ queue.get(i)+"  ";
                start=queue.get(i); 
                points.add(start);
            }
               
        }
        
        start=queue.get(idx-1);
        points.add(start);
        for (int i=idx-2;i>0;i--){
            sub=start-queue.get(i);
            if (sub<0){
                sub=sub*(-1);
            }
            totalMovements+=sub;
            sequence+=start+" -> "+ queue.get(i)+"  ";
            start=queue.get(i);     
            points.add(start);
        }
        System.out.println(sequence);
        System.out.println(totalMovements+" Cylinders"); 
        return points;
    }
    
    public static ArrayList<Integer> CSCAN(ArrayList<Integer>queue , int start){
        ArrayList<Integer>points=new ArrayList<>();
        int totalMovements=0;
        int sub=0,idx=0;
        String sequence="";
        boolean check=false;
        int end=Collections.max(queue);
        end+=20;
        queue.add(end);
        queue.add(start);
        queue.add(0);
        Collections.sort(queue);
        System.out.println(queue);
        points.add(start);
        for (int i=0;i<queue.size();i++){
            if (queue.get(i)==start){
                check=true;
                idx=i;
            }
            if (check==true && queue.get(i)!=start ){
                sub=start-queue.get(i);
                if (sub<0){
                    sub=sub*(-1);
                }  
                
                totalMovements+=sub;
                sequence+=start+" -> "+ queue.get(i)+"  ";
                start=queue.get(i); 
                points.add(start);
            }
               
        }
        
        start=0;
        points.add(start);
        for (int i=1;i<idx;i++){
            sub=start-queue.get(i);
            if (sub<0){
                sub=sub*(-1);
            }
            totalMovements+=sub;
            sequence+=start+" -> "+ queue.get(i)+"  ";
            start=queue.get(i);    
            points.add(start);
        }
        System.out.println(sequence);
        System.out.println(totalMovements+" Cylinders");
        return points;
    }
    
    public static ArrayList<Integer> CLOOK(ArrayList<Integer>queue , int start){
        ArrayList<Integer>points=new ArrayList<>();
        int totalMovements=0;
        int sub=0,idx=0;
        String sequence="";
        boolean check=false;
        int end=Collections.max(queue);
        end+=20;
        queue.add(end);
        queue.add(start);
        queue.add(0);
        Collections.sort(queue);
        System.out.println(queue);
        points.add(start);
        for (int i=0;i<queue.size()-1;i++){
            if (queue.get(i)==start){
                check=true;
                idx=i;
            }
            if (check==true && queue.get(i)!=start ){
                sub=start-queue.get(i);
                if (sub<0){
                    sub=sub*(-1);
                }  
                
                totalMovements+=sub;
                sequence+=start+" -> "+ queue.get(i)+"  ";
                start=queue.get(i); 
                points.add(start);
            }
               
        }
        
        start=queue.get(1);
        points.add(start);
        for (int i=2;i<idx;i++){
            sub=start-queue.get(i);
            if (sub<0){
                sub=sub*(-1);
            }
            totalMovements+=sub;
            sequence+=start+" -> "+ queue.get(i)+"  ";
            start=queue.get(i); 
            points.add(start);
        }
        System.out.println(sequence);
        System.out.println(totalMovements+" Cylinders");    
        return points;
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer>queue=new ArrayList<>();
        ArrayList<Integer>points=new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        System.out.print("enter start :");
        int start=reader.nextInt();
        System.out.print("enter #number of requests :");
        int numOfReq=reader.nextInt();
        System.out.print("enter queue elements :");
        for (int i=0;i<numOfReq;i++){
            int element=reader.nextInt();        
            queue.add(element);
        }

        System.out.println("choose algorithm :");
        System.out.print("1-FCFS , 2- SSTF , 3- SCAN , 4- CSCAN , 5- CLOOK , 6-Exit ");
        int type=0;
        type=reader.nextInt();        
        while (true){
            if (type==1){
                points=FCFS(queue, start);
                new Test(points);
            }
            else if (type==2){
                points=SSTF(queue, start);
                new Test(points);
            }
            else if (type==3){
                points=SCAN(queue, start);
                new Test(points);
            }
            else if (type==4){
                points=CSCAN(queue, start);
                new Test(points);
            }
            else if (type==5){
                points=CLOOK(queue, start);
                new Test(points);
            }
            else if (type==6){
                break;
            }
            else {
                System.out.println("invalid input");
            }
            points=new ArrayList<>();
            System.out.print("1-FCFS , 2- SSTF , 3- SCAN , 4- CSCAN , 5- CLOOK , 6-Exit ");
            type=reader.nextInt();            
        }
    }
    
}
