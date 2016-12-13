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
public class Folder {
    public static ArrayList<Directory> directorys = new ArrayList<>();

    public ArrayList<Directory> getDirectorys() {
        return directorys;
    }

    public void setDirectorys(ArrayList<Directory> directorys) {
        this.directorys = directorys;
    }
    
    
    public static ArrayList<String> getFile() throws FileNotFoundException, IOException{
        ArrayList<String>data=new ArrayList<>();
        String line="";
        FileReader fileReader =  new FileReader("DiskStructure.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while((line = bufferedReader.readLine()) != null) {
            data.add(line);
        }
        return data;
    }
        
    public void c(){
        System.out.println(directorys.size());
        for (int i=0;i<directorys.size();i++){
            Directory d=directorys.get(i);
                if (d.isDeleted()==false){
                System.out.println("path : "+d.getDirectoryPath());
                for (int ii=0;ii<d.getSubDirectories().size();ii++){
                    if (d.getSubDirectories().get(ii).isDeleted()==false)
                        System.out.println("sub : "+d.getSubDirectories().get(ii).getDirectoryPath());
                }
                 for (int ii=0;ii<d.getFiles().size();ii++){
                     if (d.getFiles().get(ii).isDeleted()==false)
                        System.out.println("subfile : "+d.getFiles().get(ii).getFilePath());
                }
            }
        }
         System.out.println();
         System.out.println();
        for (int i=0;i<Allocation.getFiles().size();i++)
            System.out.println(Allocation.getFiles().get(i).getFilePath());
    }
    public void createFolder(String path) throws FileNotFoundException, IOException {
        User u=new User();
        ArrayList<String>cab=u.getFile("capabilities.txt");
        String line="",folder="",parent="";
        boolean check=false,check2=false,check4=false;
        Directory dir = new Directory(path, null, null);
        int idx=path.lastIndexOf('/');
        int counter=0;

        for (int i=0;i<path.length();i++){
            if (path.charAt(i)=='/')
                counter++;
        }

        folder=path.substring(idx+1);
        
        for (int i=0;i<directorys.size();i++){
            if (directorys.get(i).getDirectoryPath().equals(path) && directorys.get(i).isDeleted()==false){
                check=true;
                System.out.println("name is already created under this path.");
                break;
            }
        }
        if (check==false){
            folder="<"+folder+">";
            for (int i=0;i<counter;i++){
                folder="  "+folder;
            }

            parent=path.substring(0, idx);
            for (int i=0;i<cab.size();i++){
                String[] d=cab.get(i).split(",");
                        if (d[0].equals(parent)){
                            for (int j=1;j<d.length;j++){
                                if (d[j].equals(User.name)){
                                    if (d[j+1].startsWith("1")){
                                        check4=true;
                                        break;
                                    }
                                }
                            }
                        }
            }
            if (User.name.equals("admin"))
                check4=true;
            
            if(check4==true){
                for (int i=0;i<directorys.size();i++){
                    if (parent.equals(directorys.get(i).getDirectoryPath())  && directorys.get(i).isDeleted()==false ){
                        check2=true;
                        break;
                    }
                }
                if (check2==true){
                    if (counter>1){
                        idx=parent.lastIndexOf('/');
                        parent=parent.substring(idx+1);
                    }

                    FileReader fileReader =  new FileReader("DiskStructure.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    PrintWriter writer = new PrintWriter("DiskStructure2.txt");

                    while((line = bufferedReader.readLine()) != null) {   
                        writer.write(line+System.getProperty( "line.separator" ));
                        if (line.contains(parent) && line.charAt(counter-1)==' ' && line.charAt(counter+1)!=' '){
                            writer.write(folder+System.getProperty( "line.separator" ));
                        }
                        else if (parent.equals("root")&&line.contains(parent)){
                            writer.write(folder+System.getProperty( "line.separator" ));
                        }
                    }
                    writer.close();

                    FileReader fileReader2 =  new FileReader("DiskStructure2.txt");
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                    PrintWriter writer2 = new PrintWriter("DiskStructure.txt");
                    while((line = bufferedReader2.readLine()) != null) {   

                        writer2.write(line+System.getProperty( "line.separator" ));
                    }
                    writer2.close(); 

                    for (int i=0;i<directorys.size();i++){
                        if (directorys.get(i).getDirectoryPath().equals(parent)){
                            ArrayList<Directory>tmp=directorys.get(i).getSubDirectories();
                            tmp.add(dir);
                            directorys.get(i).setSubDirectories(tmp);
                        }
                    }
                    ArrayList<Directory>tmp1=new ArrayList<>();
                    dir.setSubDirectories(tmp1);
                    ArrayList<File>tmp2=new ArrayList<>();
                    dir.setFiles(tmp2);
                    directorys.add(dir);
                    System.out.println("Folder has been created successfully :)");
                }
                else {
                    System.out.println("path is not existing !!");
                }
            }
            else{
                System.out.println("access denied !!");
            }
        }
        
    }
    
    public void deleteFolder(String path) throws FileNotFoundException, IOException{
        boolean check=false,check2=false,check4=false;
        User u = new User();
        ArrayList<String>cab=u.getFile("capabilities.txt");
        ArrayList<String>deleted=new ArrayList<>();
        ArrayList<String>data=getFile();
        ArrayList<String>data2=new ArrayList<>();
        String line="",line2="";
        int idx=0,counter=0,s=0;
        Directory d ;
        File f;
        idx=path.lastIndexOf('/');
        String parent=path.substring(0, idx);
        for (int i=0;i<cab.size();i++){
                String[] da=cab.get(i).split(",");
                        if (da[0].equals(parent)){
                            for (int j=1;j<da.length;j++){
                                if (da[j].equals(User.name)){
                                    if (da[j+1].charAt(1)=='1'){
                                        check4=true;
                                        break;
                                    }
                                }
                            }
                        }
            }
        if (User.name.equals("admin"))
            check4=true;
            
        if(check4==true){
            for (int i=0;i<directorys.size();i++){
                if (directorys.get(i).getDirectoryPath().equals(path) && directorys.get(i).isDeleted()==false){
                    check=true;
                    idx=path.lastIndexOf('/');
                    path=path.substring(idx+1);
                    deleted.add(path);

                    directorys.get(i).setDeleted(true);

                    for (int ii=0;ii<directorys.get(i).getFiles().size();ii++){
                       f=directorys.get(i).getFiles().get(ii);
                       String sub=f.getFilePath();
                       idx=sub.lastIndexOf('/');
                       sub=sub.substring(idx+1);
                       deleted.add(sub);
                       f.setDeleted(true);
                    }
                    for (int ii=0;ii<directorys.get(i).getSubDirectories().size();ii++){
                       d=directorys.get(i).getSubDirectories().get(ii);
                       String sub=d.getDirectoryPath();
                       idx=sub.lastIndexOf('/');
                       sub=sub.substring(idx+1);
                       deleted.add(sub);
                       d.setDeleted(true);
                    }
                    for (int ii=0;ii<data.size();ii++){
                        if (data.get(ii).contains(deleted.get(0))){
                            counter=1;
                            s=ii;

                            for (int j=1;j<deleted.size();j++){
                                String da=data.get(++s).trim();
                                if (da.contains("<") && da.contains(">")){
                                    da=da.substring(1,(da.length()-1) );
                                }

                                if (deleted.contains(da)){
                                   counter++;

                                }else{
                                    break;
                                }
                            }
                        }
                        if (counter==deleted.size()){
                            ii=s+1;
                            counter=0;
                        }
                        data2.add(data.get(ii));
                    } 

                    PrintWriter writer2 = new PrintWriter("DiskStructure.txt");
                    for (int l=0;l<data2.size();l++){   
                        writer2.write(data2.get(l)+System.getProperty( "line.separator" ));
                    }
                    writer2.close();           
                    break;
                } 
            } 
            if (check==false){
                System.out.println("path is not existing !!");
            }
        }else{
            System.out.println("access denied");
        }
    
    }
}
