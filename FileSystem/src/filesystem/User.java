/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Amir
 */
public class User {
    public static String name="admin";
    private static String password="admin";
    private static boolean check=false;


    public static ArrayList<String> getFile(String fileName) throws FileNotFoundException, IOException{
        ArrayList<String>data=new ArrayList<>();
        String line="";
        FileReader fileReader =  new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while((line = bufferedReader.readLine()) != null) {
            data.add(line);
        }
        return data;
    }
    
    public void tellUser() {
         System.out.println("current logged user is "+name);
    }
    
    public void cUser(String uname , String upassword) throws IOException {
        boolean check=false;
        ArrayList<String>data=getFile("user.txt");
        String n=uname+","+upassword;
        if(name.equals("admin")){
            for (int i=0;i<data.size();i++){
                String[] u=data.get(i).split(",");
                String na=u[0];
                if(na.equals(uname)){
                    check=true;
                    break;
                }
            }
            if (check==false){
                data.add(n);
                PrintWriter writer2 = new PrintWriter("user.txt");
                for (int i=0;i<data.size();i++)
                    writer2.write(data.get(i)+System.getProperty( "line.separator" ));

                writer2.close();   
                System.out.println("user created successfully ");  
            }else{
                System.out.println("username is already existing");
            }
        }else{
            System.out.println("access denied");
        }
    }
    
    public void grant(String uname , String path , String capability) throws IOException {
        boolean check=false,check2=false,check3=false,check4=false;
        ArrayList<Directory>dir=Folder.directorys;
        ArrayList<String>data=getFile("user.txt");
        ArrayList<String>data2=getFile("capabilities.txt");
        if (name.equals("admin")){
            for (int i=0;i<data.size();i++){
                String[] u=data.get(i).split(",");
                String n=u[0];
                if (uname.equals(n)){
                    check=true;
                    break;
                }
            }
            
            if (check==true){
                for (int i=0;i<dir.size();i++){
                    String p=dir.get(i).getDirectoryPath();
                    if (p.equals(path)){
                        check2=true;
                        break;
                    }
                }
                
                if (check2==true){
                    for (int i=0;i<data2.size();i++){
                        String[] d=data2.get(i).split(",");
                        if (d[0].equals(path)){
                            for (int j=1;j<d.length;j++){
                                if (d[j].equals(uname)){
                                    d[j+1]=capability;
                                    check3=true;
                                    break;
                                }
                            }
                            if(check3==false){
                                data2.set(i, data2.get(i)+","+uname+","+capability);
                            }
                            check4=true;
                            break;
                        }
                    }
                    if (check4==false){
                        data2.add(path+","+uname+","+capability);
                    }
                    PrintWriter writer2 = new PrintWriter("capabilities.txt");
                    for (int i=0;i<data2.size();i++)
                        writer2.write(data2.get(i)+System.getProperty( "line.separator" ));

                writer2.close(); 
                }else{
                    System.out.println("folder path is not existing !");
                }
            }else{
                System.out.println("username is not existing");
            }
            
        }else{
            System.out.println("access denied");
        }
    }
    public void login(String uname , String upassword) throws IOException {
        boolean check=false;
        ArrayList<String>data=getFile("user.txt");
        for (int i=0;i<data.size();i++){
            String[] u=data.get(i).split(",");
            String n=u[0];
            String p=u[1];
            if (uname.equals(n) && upassword.equals(p)){
                 name=uname;
                 password=upassword;
                 System.out.println("logged in as "+uname+" successfully" );
                 check=true;
                 break;
            }
        }
        if (check==false){
            System.out.println("invalid username or password !");
        }
    }
    
}
