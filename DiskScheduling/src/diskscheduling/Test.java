/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskscheduling;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
 
import javax.swing.*;
/**
 *
 * @author Amir
 */
public class Test extends JFrame {
        ArrayList<Integer>pointss=new ArrayList<>();
        
	public Test(ArrayList<Integer>pointss) {
		this.setTitle("Disk Scheduling");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
                this.pointss=pointss;
 
	}
 
	public void paint(Graphics g) {
		g.setColor(Color.white);
		//g.drawLine(100, 300, 350, 400);
               // g.drawString("100", 0, 500);
               // g.drawLine(350, 400, 100,500);
             //  g.drawLine(50, 50, 100, 70);
             //  g.drawString("amir", 100, 100);
               int[] a={0,50,50,500};
               int[] b={50,90,90,110};
               g.drawPolyline(a, b, 4);
               String s="";
               g.setColor(Color.red);
               int d=50;
               ArrayList<Integer> point = new ArrayList<Integer>(pointss);
               Collections.sort(point);
               if (point.get(0)!=0){
                    point.add(0, 0);
                    point.add(point.get(point.size()-1)+20);
               }
             
               System.out.println(point);
               for (int i=0;i<point.size();i++){
                   s=point.get(i).toString();
                    char[] charArray = s.toCharArray();  

                    int x=point.get(i);
                    if (point.get(i)==0)
                        x=5;
                    //double xx=x*1.5;
                    x=x;
                    g.drawChars(charArray, 0, s.length(),x , 100); 
                    //d=d+20;
               }
               

               
               int[] a2=new int[pointss.size()];
               int[] b2=new int[pointss.size()];
               int d2=50;
               b2[0]=130;
                  // System.out.println(pointss);
               for (int i=0;i<a2.length;i++){

                       a2[i]=pointss.get(i);  
                       if (pointss.get(i)==0)
                           a2[i]=5;
                           
                   
                   if (i<a2.length && i!=0)
                       b2[i]=b2[i-1]+20;
               }

               g.drawPolyline(a2, b2, a2.length);
            //  g.drawString("amir", 50, 50);
	}
 
	public static void main(String[] args) {
		//new Test();
	}
    
}
