/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;

/**
 *
 * @author Amir
 */
public class File {
    private String filePath;
    private ArrayList<Integer> allocatedBlocks=new ArrayList<>();
    private boolean deleted=false;

    public File() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Integer> getAllocatedBlocks() {
        return allocatedBlocks;
    }

    public void setAllocatedBlocks(ArrayList<Integer> allocatedBlocks) {
        this.allocatedBlocks = allocatedBlocks;
    }


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    public void createFile(String path , int size) {
        
    }
    
    public void deleteFile(String path) {
        
    }
    
    public void DisplayDiskStatus() {
        
    }
}
