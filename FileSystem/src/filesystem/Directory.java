/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Amir
 */
public class Directory {
    private String directoryPath;
    private ArrayList<File> files=new ArrayList<>();
    private ArrayList<Directory> subDirectories=new ArrayList<>();
    private boolean deleted = false;

    public Directory(String directoryPath, ArrayList<File> files, ArrayList<Directory> subDirectories) {
        this.directoryPath = directoryPath;
        this.files = files;
        this.subDirectories = subDirectories;
    }
    public Directory() {

    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public void setSubDirectories(ArrayList<Directory> subDirectories) {
        this.subDirectories = subDirectories;
    }





    public ArrayList<Directory> getSubDirectories() {
        return subDirectories;
    }


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


}
