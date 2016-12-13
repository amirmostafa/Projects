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
public class Contigous extends Allocation{
    //private static int lastBlock=0;
    

   /* public static int getLastBlock() {
        return lastBlock;
    }

    public static void setLastBlock(int lastBlock) {
        Contigous.lastBlock = lastBlock;
    } */

    public Contigous(int block_size, int allocatedBlocks, int emptyBlocks, ArrayList<Integer> blocks, ArrayList<File> files) {
        super(block_size, allocatedBlocks, emptyBlocks, blocks, files);
    }
            
   

    public Contigous() {
    }
    

    
    
    @Override
    public void createFile(String path , int size) throws FileNotFoundException, IOException{
        boolean check=false,check2=false,check4=false;
        User u = new User();
        ArrayList<String>cab=u.getFile("capabilities.txt");
        Folder f= new Folder();
        File file=new File();
        ArrayList<String>data=f.getFile();
        ArrayList<Integer>allocatedBlocks=new ArrayList<>();
        ArrayList<Directory>directories=f.getDirectorys();
        ArrayList<File>subFiles=new ArrayList<>();

        for (int i=0;i<files.size();i++){
            if (files.get(i).getFilePath().equals(path) && files.get(i).isDeleted()==false){
                System.out.println("Path already exists !");
                return;
            }
        }
                
        
        

        int idx=path.lastIndexOf('/');
        int counter=0;
        String fileName="",parent="",line="";
        
        fileName=path.substring(idx+1);
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
            for (int i=0;i<directories.size();i++){
                if (directories.get(i).getDirectoryPath().equals(parent)){
                    file.setFilePath(path);
                    file.setAllocatedBlocks(allocatedBlocks);
                    subFiles=directories.get(i).getFiles();
                    subFiles.add(file);
                    files.add(file);
                    directories.get(i).setFiles(subFiles);
                    check2=true;
                }
            }
            if (check2==false){
                System.out.println("path is invalid");
                return;
            }

            for (int i=0;i<blocks.size();i++){
                check=false;
                if ((blocks.size()-i)<size){
                    check=true;
                    break;
                }
                for (int j=i;j<=(i+size);j++){
                    if (blocks.get(j)==1){
                        check=true;
                        break;
                    }
                }
                if (check==false){
                    for (int j=i;j<(i+size);j++){
                        blocks.set(j,1);
                        allocatedBlocks.add(j);

                    }

                    break;
                }
            }

            if (check==true){
                System.out.println("There is no enough space !");
                return;
            }

            for (int i=0;i<path.length();i++){
                if (path.charAt(i)=='/')
                    counter++;
            }
            if (counter>1){
                idx=parent.lastIndexOf('/');
                parent=parent.substring(idx+1);
            }

            for (int i=0;i<counter;i++){
                fileName="  "+fileName;
            }
            for (int i=0;i<data.size();i++){
                line = data.get(i);
                if (line.contains(parent) && line.charAt(counter-1)==' ' && line.charAt(counter+1)!=' '){
                    data.add(++i, fileName);
                    break;
                }
                else if (parent.equals("root")&&line.contains(parent)){
                    data.add(++i, fileName);
                    break;
                }
            }
            String s=String.valueOf(Integer.parseInt(data.get((data.size()-1)))+allocatedBlocks.size());
            String g=String.valueOf(Integer.parseInt(data.get((data.size()-2)))-allocatedBlocks.size());
            data.set((data.size()-1),s);
            data.set((data.size()-2), g);
            PrintWriter writer = new PrintWriter("DiskStructure.txt");  
            for (int i=0;i<data.size();i++){
                line = data.get(i);
                writer.write(line+System.getProperty( "line.separator" ));
            }
            writer.close();

            FileReader fileReader =  new FileReader("allocation.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String>l=new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) { 
                l.add(line);
            }

            PrintWriter writer2 = new PrintWriter("allocation.txt");  
            for (int i=0;i<l.size();i++){
                line = l.get(i);
                writer2.write(line+System.getProperty( "line.separator" ));
            }
            writer2.write(path+System.getProperty( "line.separator" ));
            writer2.write(allocatedBlocks.get(0)+System.getProperty( "line.separator" ));
            writer2.write(allocatedBlocks.get(allocatedBlocks.size()-1)+System.getProperty( "line.separator" ));
            writer2.close();
        }else{
            System.out.println("access denied");
        }

    }
    
    @Override
    public void deleteFile(String path) throws FileNotFoundException, IOException{
        boolean check=false,check2=false,check4=false;
        User u = new User();
        ArrayList<String>cab=u.getFile("capabilities.txt");
        String line="";
        int st=0,end=0;
        Folder f= new Folder();
        ArrayList<String>data=f.getFile();
        int idx=path.lastIndexOf('/');
        int counter=0;
        String fileName="",parent="";
        
        fileName=path.substring(idx+1);
        parent=path.substring(0, idx);
        
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
            for (int i=0;i<files.size();i++){
                if (files.get(i).getFilePath().equals(path) && files.get(i).isDeleted()==false){
                    files.get(i).setDeleted(true);
                    check=true;
                    break;
                }
            }
            if (check==false){
                System.out.println("file is not existing !");
            }
            else{
                FileReader fileReader =  new FileReader("allocation.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ArrayList<String>l=new ArrayList<>();
                while((line = bufferedReader.readLine()) != null) { 
                    check2=false;
                    if (line.equals(path)){
                        st=Integer.parseInt(bufferedReader.readLine());
                        end=Integer.parseInt(bufferedReader.readLine());
                        check2=true;
                    }
                    if (check2==false){
                        l.add(line);
                    }
                }
                int r=0;
                for (int i=st;i<=end;i++){
                    blocks.set(i, 0);
                    r++;
                }
                data.set((data.size()-2), String.valueOf((Integer.parseInt(data.get((data.size()-2)))+r)));
                data.set((data.size()-1), String.valueOf((Integer.parseInt(data.get((data.size()-1)))-r)));
                PrintWriter writer = new PrintWriter("allocation.txt");  
                for (int i=0;i<l.size();i++){
                    line = l.get(i);
                    writer.write(line+System.getProperty( "line.separator" ));
                }
                writer.close();


                PrintWriter writer2 = new PrintWriter("DiskStructure.txt");  
                for (int i=0;i<l.size();i++){
                    line = l.get(i);

                }

                String[] parents=parent.split("/");
                for (int i=0;i<data.size();i++){
                    for (int j=0;j<parents.length;j++){
                        if (data.get(i).contains(parents[j])){
                            counter++;
                            break;
                        }
                    }               
                    if (counter==parents.length && data.get(i).contains(fileName)){
                        i++;
                        counter=0;
                    }    
                    writer2.write(data.get(i)+System.getProperty( "line.separator" ));
                }
                writer2.close();
            }
        }else{
            System.out.println("access denied");
        }
    }
    
}
