/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Scanner;

public class Commands {

    /**
     * @param args the command line arguments
     */
    public static void clear(String command){
        
    }
    public static void cd(String command){
        
    }
    public static void ls(String command){
        
    }
    public static void cp(String command){
        
    }
    public static void mv(String command){
        
    }
    public static void rm(String command){
        
    }
    public static void mkdir(String command){
        
    }
    public static void rmdir(String command){
        
    }
    public static void cat(String command){
        
    }
    public static void more(String command){
        
    }
    public static void args(String command){
        
    }
    public static void date(String command){
        
    }
    public static void help(String command){
        
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       
        System.out.println("Welcome to Command Line Interpreter");
        System.out.println("commands : clear, cd, ls, cp, mv, rm, mkdir, rmdir, cat, more, pwd, args, date, help, exit.");
        System.out.print("Your Command : ");
        String command=input.nextLine();
        while(command.equals("exit")==false){
            if(command.contains("clear")){
                clear(command);
            }
            else if(command.contains("cd")){
                cd(command);
            }
            else if(command.contains("ls")){
                ls(command);
            }
            else if(command.contains("cp")){
                cp(command);
            }
            else if(command.contains("mv")){
                mv(command);
            }
            else if(command.contains("rm")){
                rm(command);
            }
            else if(command.contains("mkdir")){
                mkdir(command);
            }
            else if(command.contains("rmdir")){
                rmdir(command);
            }
            else if(command.contains("cat")){
                cat(command);
            }
            else if(command.contains("more")){
                more(command);
            }
            else if(command.contains("args")){
                args(command);
            }
            else if(command.contains("date")){
                date(command);
            }
            else if(command.contains("help")){
                help(command);
            }
            else if(command.contains("exit")){
                return;
            }
            System.out.println("commands : clear, cd, ls, cp, mv, rm, mkdir, rmdir, cat, more, pwd, args, date, help, exit.");
            System.out.print("Your Command : ");
            command=input.nextLine();
        }
    }
    
}
