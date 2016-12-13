/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Amir
 */
public class DeadLock {

    static int[] available;
    static int[][] maximum;
    static int[][] allocation;
    static int[][] need;
    static int[][] tempAlloc;
    static int[][] tempNeed;
    static int[] tempAvailable;
    static int m = 0;
    static int n = 0;

    public static void readMax(String filename) throws FileNotFoundException, IOException {
        int count = 0;
        String line = "";
        String[] temp = null;
        FileReader fileReader = new FileReader(filename);
        FileReader fileReader2 = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        while ((line = bufferedReader.readLine()) != null) {
            temp = line.split(",");
            count++;
        }

        n = count;
        m = temp.length;
        maximum = new int[n][m];
        allocation = new int[n][m];
        need = new int[n][m];
        tempAlloc=new int[n][m];
        tempNeed=new int[n][m];
        tempAvailable=new int[m];
        for (int i = 0; i < n; i++) /// Allocation
        {
            for (int j = 0; j < m; j++) {
                allocation[i][j] = 0;
            }
        }
        

        for (int i = 0; i < count; i++) {
            line = bufferedReader2.readLine();
            temp = line.split(",");

            for (int j = 0; j < temp.length; j++) //// Maximum
            {
                maximum[i][j] = Integer.parseInt(temp[j]);
            }

        }

        for (int i = 0; i < n; i++) ///// NEED
        {
            for (int j = 0; j < m; j++) {
                need[i][j] = maximum[i][j] - allocation[i][j];
            }
        }
    }

    public static void checkRequest(int[] resource, int ProcessNum, int[] request) throws IOException {
        boolean error = false;

        for (int i=0;i<n;i++)
            for (int j = 0; j < m; j++) {
                tempAlloc[i][j]=allocation[i][j];
                tempNeed[i][j]=need[i][j];
            }
        for (int i=0;i<m;i++)
            tempAvailable[i]=available[i];
        
        
        for (int i = 0; i < n; i++) {
            if (i == ProcessNum) {
                for (int j = 0; j < m; j++) {
                    if (request[j] > tempNeed[i][j]) {
                        error = true;
                        break;
                    }
                }
            }
        }

        if (error == false) {
            boolean error2 = false;
            for (int i = 0; i < m; i++) {
                if (request[i] > tempAvailable[i]) {
                    error2 = true;
                    break;
                }
            }
            if (error2 == false) {            ///// request Granted
                for (int j = 0; j < m; j++) {
                    tempAvailable[j] = tempAvailable[j] - request[j];
                }
                
                for (int j = 0; j < m; j++) {
                //    System.out.print("available : "+available[j]);
                }
                for (int i = 0; i < n; i++) {
                    if (i == ProcessNum) {
                        for (int j = 0; j < m; j++) {
                            tempAlloc[i][j] = tempAlloc[i][j] + request[j];
                            tempNeed[i][j] = tempNeed[i][j] - request[j];
                        }
                    }
                }
                
                
                 Request();

            } else {
                System.out.println("Error Request > Available ");
            }

        } else {
            System.out.println("Error Request > Need ");
        }
        
       
    }

    public static void Request() {
        int counter = n,seq=0,errorCounter=0;
        int[] work=new int[m];
        for (int i=0;i<m;i++)
            work[i]=tempAvailable[i];
        boolean check = false , check2=false;
        String[] sequence = new String[n + 2];
        sequence[0] = "<";
        sequence[sequence.length - 1] = ">";
        String[] finish = new String[n];
        for (int j = 0; j < n; j++) {
            finish[j] = "false";
        }

        while (counter > 0) {
            for (int i = 0; i < n; i++) {
                errorCounter++;
                if (finish[i]=="false"){
                    for (int j = 0; j < m; j++) {
                        check = false;

                            if (tempNeed[i][j] <= work[j]) {
                                finish[i] = "true";
                                work[j] = work[j] + tempAlloc[i][j];

                  //      System.out.println("available : "+work[j]+"  need : "+need[i][j]);

                             //    System.out.println();
                            //    System.out.println("I : "+i);
                                if (counter == 1) 
                                    sequence[seq + 1] = "p" + i;
                                 else 
                                    sequence[seq + 1] = "p" + i + ",";
                                
                                check = true;

                            } else {
                                finish[i] = "false";
                                break;
                            }

                        }
                        if (check == true) {
                            counter--;
                            seq++;
                            errorCounter--;
                        }
                    }
            }
            if(errorCounter>n)
            {
                System.out.println("UNSAFE");
                check2=true;
                break;
            }
                
        }
        
        if (check2==false){
            for (int i=0;i<n;i++)
                for (int j = 0; j < m; j++) {
                    allocation[i][j]=tempAlloc[i][j];
                    need[i][j]=tempNeed[i][j];
                }
                for (int i=0;i<m;i++)
                    available[i]=tempAvailable[i];

                System.out.print("sequence : ");
                for (int j = 0; j < n + 2; j++) {
                    System.out.print(sequence[j]);
                }
        }


    }

    public static void release(int processNum, int[] request) {
        boolean check=false;
        for (int i = 0; i < n; i++) {
            if (i == processNum) {
                for (int j = 0; j < m; j++) {
                    if (request[j]>allocation[i][j]){
                        check=true;
                        break;
                    }
                }
            }
        }
        
        if (check==false){
            for (int i = 0; i < n; i++) {
                if (i == processNum) {
                    for (int j = 0; j < m; j++) {
                        allocation[i][j] = allocation[i][j] - request[j];
                        available[j] = available[j] + request[j];
                    }
                }
            }
            for (int i=0;i<n;i++)
                for (int j = 0; j < m; j++) {
                    tempAlloc[i][j]=allocation[i][j];
                    tempNeed[i][j]=need[i][j];
                }
            for (int i=0;i<m;i++)
                tempAvailable[i]=available[i];
            Request();
        }
        else{
            System.out.println();
            System.out.println("Error Request > Allocation");
        }
    }

    public static void showState() {
        System.out.print("available : ");
        for (int j = 0; j < m; j++) {
            System.out.print(available[j] + " ");
        }

        System.out.println();
        System.out.print("Need : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(need[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("allocation : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(allocation[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.print("maximum : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maximum[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void start() throws IOException {  
        int[] request=new int[3];
        int[] resource=new int[3];
        Scanner reader = new Scanner(System.in);
        System.out.print("file name : ");
        String filename=reader.next();
        readMax(filename);
        System.out.print("resources : ");
        for (int i=0;i<3;i++)
            resource[i]=reader.nextInt();
        
        available = new int[resource.length];

        for (int i = 0; i < resource.length; i++) {
            available[i] = resource[i];
        } 
        
        System.out.print("type : RQ to request , RL to release , * to show state , Q to Quit : ");
        String c=reader.next();
        while (c.equals("Q")==false){
            if (c.equals("RQ")){
                System.out.print("Process Number : ");
                int processNum=reader.nextInt();
                if ((n-1)<processNum){
                    System.out.print("Process Number > #of Processes ");
                }
                else{
                System.out.print("request : ");
                for (int i=0;i<3;i++)
                    request[i]=reader.nextInt();
                
                checkRequest(resource, processNum, request);
                }
            }
            else if (c.equals("RL")){
                System.out.print("Process Number : ");
                int processNum=reader.nextInt();
                if ((n-1)<processNum){
                    System.out.print("Process Number > #of Processes ");
                }
                else{
                System.out.print("request : ");
                for (int i=0;i<3;i++)
                    request[i]=reader.nextInt();
                
                 release(processNum, request);
                }
            }
            
            else if (c.equals("*")){
                showState();
            }
                
            else if (c.equals("Q")==false){
                System.out.print("invalid input ");
            }
            
            System.out.println();
            System.out.println();
            System.out.print("type : RQ to request , RL to release , * to show state , Q to Quit : ");
            c=reader.next();
        }

    }

    public static void main(String[] args) throws IOException {
        start();
    }
}
