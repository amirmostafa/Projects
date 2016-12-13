/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Amir
 */
public class Allocation {
    protected static int block_size;
    protected static int allocatedBlocks;
    protected static int emptyBlocks;
    protected static ArrayList<Integer> blocks=new ArrayList<>();
    protected static ArrayList<File> files=new ArrayList<>();
    
    public Allocation(int block_size, int allocatedBlocks , int emptyBlocks , ArrayList<Integer> blocks , ArrayList<File> files) {
        this.block_size = block_size;
        this.allocatedBlocks = allocatedBlocks;
        this.emptyBlocks = emptyBlocks;
        this.blocks = blocks;
        this.files = files;
    }

    public Allocation() {
        
    }

    public static ArrayList<File> getFiles() {
        return files;
    }

    public static void setFiles(ArrayList<File> files) {
        Allocation.files = files;
    }

    public static ArrayList<Integer> getBlocks() {
        return blocks;
    }

    public static void setBlocks(ArrayList<Integer> blocks) {
        Allocation.blocks = blocks;
    }
    
    public int getBlock_size() {
        return block_size;
    }

    public void setBlock_size(int block_size) {
        this.block_size = block_size;
    }

    public int getAllocatedBlocks() {
        return allocatedBlocks;
    }

    public void setAllocatedBlocks(int allocatedBlocks) {
        this.allocatedBlocks = allocatedBlocks;
    }

    public int getEmptyBlocks() {
        return emptyBlocks;
    }

    public void setEmptyBlocks(int emptyBlocks) {
        this.emptyBlocks = emptyBlocks;
    }


    
    public void createFile(String path , int size) throws FileNotFoundException, IOException{
        
    }
    
    public void deleteFile(String path) throws FileNotFoundException, IOException{
        
    }
    
    public void showStatus() throws IOException{
        Folder f=new Folder() ;
        int counter1=0,counter2=0;
        ArrayList<String>data=Folder.getFile();
        System.out.println("Empty Space : "+data.get(data.size()-2));
        System.out.println("Allocated Space : "+data.get(data.size()-1));
        for (int i=0;i<blocks.size();i++){
            if(blocks.get(i)==0)
                counter1++;
            else
                counter2++;
        }
        System.out.println("Empty Blocks in the Disk : "+counter1);
        System.out.println("Allocated Blocks in the Disk : "+counter2);
        System.out.println(blocks);
    }
    
        public void displayStructure() throws IOException{
        Folder f=new Folder() ;
        ArrayList<String>data=Folder.getFile();
        for (int i=0;i<(data.size()-3);i++){
            System.out.println(data.get(i));
        }
    }
    
    public void getAllocated(){
        Contigous c=new Contigous();
        
        int s=0;
        for (int i=0;i<files.size();i++){
            ArrayList<Integer>allocated=new ArrayList<>();
            allocated=files.get(i).getAllocatedBlocks();
            for (int j=0;j<allocated.size();j++){
                blocks.set(allocated.get(j), 1);
                if(s<allocated.get(j))
                    s=allocated.get(j);
                
            }
           // c.setLastBlock((s+1));
        }
    }
}
