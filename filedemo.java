/*Assignment 5_A_1:*/
import java.io.*;
public class filedemo 
{
	public static void main(String args[])
               {
   	 int count=0;
   	 String str=new String();
   	 	 	  str=args[0];
   	 	  File f1=new File(str);
   	 	  if(f1.isDirectory())
   	 	  {
   	 	  	String s[]=f1.list();
   	 	  	for(int i=0;i<s.length;i++)
   	 	  	{
   	 	  		
   	 	  	
	  		File f=new File(str+"/"+s[i]);
                          String s2=s[i];
   	 	  if(f.isFile()&& s2.endsWith("txt"))
   	 	  {
                                                count++;
   	 		if(f.delete())
   	 		{
   	 	  	System.out.println("File Deleted Successfully");
   	 	  					}
   			}
    		}
   	    
   	 	  		
   	 	  	
   	 	  	System.out.println("Number of files deleted in directory :"+count);
   	 	  }
   	 	  else if(f1.isFile())
   	 	  { System.out.println("File Name : " + f1.getName());
            System.out.println("Parent Path : " + f1.getParent());
            System.out.println("Path : " + f1.getAbsolutePath());
            System.out.println("File Length : " + f1.length());
   	 	  	
   	 	  }
   	 	
   }
    
    
}
