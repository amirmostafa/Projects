/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import static filesystem.Folder.directorys;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amir
 */
public class FileSystem {


    public static void getDirectories(int level,Directory d2,String method) throws FileNotFoundException, IOException{
        Directory d3=d2;
        String line="",lvl="",line3="",line4="";
        int counter=0,prevCounter=0;
        for (int i=0;i<level;i++){   //b7ot spaces abl esm el file 3ashan yzbt el level
            lvl+="  ";
        }
       Allocation a=new Allocation();
       Folder f = new Folder();
        ArrayList<String>data=f.getFile();          //da el file 5adto fel arraylist
       
        for (int i=0;i<data.size();i++) { 
            int g=i;
            int t=i;
            if (i!=0)
                line4=data.get(--t);
            line=data.get(i);                       
            line3=data.get(++g);
            Directory d=new Directory();
            if(line.equals("       .")){                //da 3ashan fe a5r el file 7atet el allocated w el empty space
                a.setBlock_size(1);
                int empty=Integer.parseInt(data.get((++i)));
                int allocated=Integer.parseInt(data.get((++i)));
                a.setEmptyBlocks(empty);
                a.setAllocatedBlocks(allocated);
                ArrayList<Integer>blocks=new ArrayList<>();
                for (int u=0;u<(empty+allocated);u++){
                    blocks.add(0);
                }
                a.setBlocks(blocks);
               
            }
                    // de lw l2a folder w mfee4 t7to subfiles w subfolders mfeha4 recursion
            else if (line.contains("<") && line.contains(">") && line.startsWith(lvl) && line.charAt(lvl.length())!=' ' && line3.charAt(lvl.length()+1)!=' ') {
                line=line.trim();
                line=line.substring(1, (line.length()-1) );
                boolean chd=false;
                if (d2.getDirectoryPath()!=null)
                    line=d2.getDirectoryPath()+"/"+line;
                for (int ii=0;ii<directorys.size();ii++){
                    if (line.equals(directorys.get(ii).getDirectoryPath())){
                        chd=true;
                         ArrayList<Directory>tmp=d2.getSubDirectories();
                        tmp.add(directorys.get(ii));
                        d2.setSubDirectories(tmp);
                        break;
                    }
                }
                if (chd==false){                   
                    d.setDirectoryPath(line);
                                        ArrayList<Directory>tmp=d2.getSubDirectories();
                        tmp.add(d);
                        d2.setSubDirectories(tmp);
                    directorys.add(d);
                }
              
            }//lw l2a folder w feeh t7to subfiles aw subfolders
            else if (line.contains("<") && line.contains(">") && line.startsWith(lvl) && line.charAt(lvl.length())!=' ' ) {
               
                line=line.trim();
                line=line.substring(1, (line.length()-1) );
            
                if (d2.getDirectoryPath()!=null)
                    line=d2.getDirectoryPath()+"/"+line;
                boolean chd=false;
                 for (int ii=0;ii<directorys.size();ii++){
                    if (line.equals(directorys.get(ii).getDirectoryPath())){
                        chd=true;
                        
                        ArrayList<Directory>tmp=d2.getSubDirectories();
                        tmp.add(directorys.get(ii));
                        d2.setSubDirectories(tmp);
                        break;
                    }
                }
                if (chd==false){                   
                    d.setDirectoryPath(line);               
                   
                    ArrayList<Directory>tmp=d2.getSubDirectories();
                        tmp.add(d);
                        d2.setSubDirectories(tmp);
                         directorys.add(d);
                }
                    getDirectories(++level,d,method);

          
         
            }   // lw file   .txt
            else if (line.contains("<")==false && line.contains(">")==false  && line.startsWith(lvl) && line.charAt(lvl.length())!=' '){

                int h=i;
                h--;
                int k=lvl.length()-1;
                String path="";
                boolean check=false;
                String tmp2=d2.getDirectoryPath();
                int idx=tmp2.lastIndexOf("/");
                tmp2=tmp2.substring(idx+1);
                for (;h>=0;h--){
                    if (data.get(h).charAt(k)!=' '){
                        
                        if (data.get(h).contains(tmp2)==false){
                            String tmp=data.get(h).trim();
                            tmp=tmp.substring(1,tmp.length()-1);
                            if (check==false)
                                path=tmp;
                            else
                                path=tmp+"/"+path;
                            check=true;
                            
                        }else if (check==false){
                            break;
                        }
                        
                       if (check==true){
                           k-=2;
                       }
                    }
                }
                if (check==true){
                    
                Directory dd=new Directory();
                dd.setDirectoryPath(path);
                d2=dd; 
                directorys.add(dd);
                }
                line=line.trim();
                File file=new File();
                    
                    if (d2.getDirectoryPath()!=null)
                        line=d2.getDirectoryPath()+"/"+line;
                    file.setFilePath(line);
                    ArrayList<Integer>l=new ArrayList<>();
                    if (method.equals("con")){
                        FileReader fileReader =  new FileReader("allocation.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        String line2="";
                        int st=0,end=0;
                        while((line2 = bufferedReader.readLine()) != null) { 
                            if (line2.equals(line)){
                                st = Integer.parseInt(bufferedReader.readLine());
                                end = Integer.parseInt(bufferedReader.readLine());
                                for (int j=st;j<=end;j++){
                                    l.add(j);
                                }
                            }
                        }
                    }else{
                        FileReader fileReader =  new FileReader("allocation2.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        String line2="";
                        int st=0,end=0,index=0;
                        while((line2 = bufferedReader.readLine()) != null) { 
                            if (line2.equals(line)){
                                index = Integer.parseInt(bufferedReader.readLine());
                                break;
                            }
                        }
                        String[] alloc=null;
                        FileReader fileReader2 =  new FileReader("indexed.txt");
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                        while((line2 = bufferedReader2.readLine()) != null) { 

                            if (line2.equals(String.valueOf(index))){
                                alloc= bufferedReader2.readLine().split(",");
                                break;
                            }
                        }
                        if (alloc!=null){
                        for (int j=0;j<alloc.length;j++){
                            l.add(Integer.parseInt(alloc[j]));
                        }    
                    }
                }
                
                file.setAllocatedBlocks(l);
                ArrayList<File>s=d.getFiles();
                s.add(file);
                d2.setFiles(s); 
                Allocation.files.add(file);
            
            }
            
            if (i==(data.size()-1)){
                return;
            }
            
        }   
    }
    public static void main(String[] args) throws IOException {
        Directory d2=new Directory();
        Folder f=new Folder();
        Contigous c = new Contigous();
        Indexed i = new Indexed();
        Allocation a =new Allocation();
        User u=new User();
        System.out.println("choose the technique : 1- indexed , 2- contigous");
        Scanner reader = new Scanner(System.in); 
        int m=reader.nextInt();
        if (m==1)
            getDirectories(0,d2,"indexed");
        else if (m==2)
            getDirectories(0,d2,"con");
        else{
            System.out.println("invalid input");
            return;
        }
        a.getAllocated();
        //f.c();
        System.out.println("1- tell User , 2- create user , 3- grant  , 4- login , 5- create folder , 6- delete folder  \n7- create file , 8- delete file , 9- DisplayDiskStatus , 10- DisplayDiskStructure  11-exit");
        int choice = reader.nextInt();
        while (choice !=11){
            if (choice==1){
                u.tellUser();
            }
            else if (choice==2){
                System.out.println("name : ");
                String name = reader.next();
                System.out.println("password : ");
                String password = reader.next();
                u.cUser(name, password);
            }
            else if (choice==3){
                System.out.println("name : ");
                String name = reader.next();
                System.out.println("path : ");
                String path = reader.next();
                System.out.println("capability : ");
                String capability = reader.next();
                u.grant(name, path, capability);
            }
            else if (choice==4){
                System.out.println("name : ");
                String name = reader.next();
                System.out.println("password : ");
                String password = reader.next();
                u.login(name, password);
            }
            if (choice==5){
                System.out.print("path : ");
                String path = reader.next();
                f.createFolder(path);
            }
            else if (choice==6){
                System.out.println("path : ");
                String path = reader.next();
                f.deleteFolder(path);
            }
            else if (choice==7){               
                System.out.print("path : ");
                String path = reader.next();
                System.out.print("size : ");
                int size = reader.nextInt();
                if (m==1)
                    i.createFile(path,size);
                else
                    c.createFile(path,size);
            }
            else if (choice==8){               
                System.out.print("path : ");
                String path = reader.next();
                if (m==1)
                    i.deleteFile(path);
                else
                    c.deleteFile(path);
            }
            else if (choice==9){               
                a.showStatus();
            }
            else if (choice==10){               
                a.displayStructure();
            }
            else if (choice==11){
                break;
            }
            else {
                System.out.println("invalid input");
            }
            System.out.println("1- tell User , 2- create user , 3- grant  , 4- login , 5- create folder , 6- delete folder , 7- create file , 8- delete file , 9- DisplayDiskStatus , 10- DisplayDiskStructure  11-exit");
            choice = reader.nextInt();
        }
       /* while (choice !=7){
            if (choice==1){
                System.out.print("path : ");
                String path = reader.next();
                f.createFolder(path);
            }
            else if (choice==2){
                System.out.println("path : ");
                String path = reader.next();
                f.deleteFolder(path);
            }
            else if (choice==3){               
                System.out.print("path : ");
                String path = reader.next();
                System.out.print("size : ");
                int size = reader.nextInt();
                if (m==1)
                    i.createFile(path,size);
                else
                    c.createFile(path,size);
            }
            else if (choice==4){               
                System.out.print("path : ");
                String path = reader.next();
                if (m==1)
                    i.deleteFile(path);
                else
                    c.deleteFile(path);
            }
            else if (choice==5){               
                a.showStatus();
            }
            else if (choice==6){               
                a.displayStructure();
            }
            else if (choice==7){
                break;
            }
            else {
                System.out.println("invalid input");
            }
            System.out.println("1- create folder , 2- delete folder , 3- create file , 4- delete file , 5- DisplayDiskStatus , 6- DisplayDiskStructure , 7 exit");
            choice = reader.nextInt();
        }*/
    }
    
}
