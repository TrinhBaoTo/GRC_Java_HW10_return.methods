// Trinh To, CS141, Fall 2019, Section A
// Programming Assignment #10, 10/28/19

// This program's behavior iscompares two applicants to
 //determine which one seems like the stronger
 //applicant. For each candidate I will need
 //either SAT or ACT scores plus a weighted GPA.

import java.util.Scanner;

public class Admit
{//open class
   public static void main(String[] args)
   {//open main
     
     Scanner  option= new Scanner(System.in); //open scanner class
     
     System.out.println("This program compares two applicants to \ndetermine which one seems like the stronger \napplicant. For each candidate I will need \neither SAT or ACT scores plus a weighted GPA.");
    
     System.out.println();
      
     double app1=0;
     double app2=0;
     
     for (int i=1; i<=2; i++)//loop for input 2 applicant information
     {
        System.out.println("Information for applicant #"+i+":");
        
        System.out.println("Do you have 1) SAT scores or 2) ACT scores?");   
        int a = option.nextInt();
        
        System.out.println();  
      
        if (a==1 && i==1){
         app1=Sat();// first applicant have SAT
         System.out.println(); 
        }
        else if (a==2 && i==1){
         app1=Act();// first applicant have ACT
         System.out.println();
        }
        else if (a==1 && i==2){
         app2=Sat();// second applicant have SAT
         System.out.println();
        }
        else if (a==2 && i==2){
         app2=Act();// second applicant have ACT
         System.out.println();
        }// if to found assign value for app1 and app2 (overall score)

     }
     
    compare(app1,app2);// call method to compare
     
   }//end main
   
   public static void compare(double app1, double app2)
   { //open method
   
     System.out.printf("First applicant overall score  = %.1f",app1);
     //print first applicant overall score
     System.out.println();
     
     System.out.printf("Second applicant overall score  = %.1f",app2);
     //print second applicant overall score
     System.out.println();
     System.out.println();

     if (app1>app2){
      System.out.println("The first applicant seems to be better."); 
     }  
     else if (app1==app2){
      System.out.println("The two applicants seem to be equal."); 
     }
     else{
     System.out.println("The second applicant seems to be better."); 
     }// compare the two overall score and decide who is better. 
     
   }//end method
   
   public static double Sat()
   { //open method
      Scanner  sat= new Scanner(System.in);
      
      System.out.print("   SAT math? ");
      int m = sat.nextInt();//input math score for the SAT
      System.out.print("   SAT critical reading? ");
      int r = sat.nextInt();//input reading score for the SAT
      System.out.print("   SAT writing? ");
      int w = sat.nextInt();//input writting score for the SAT   
      
      System.out.println();  
      
      double examscore=(2*m+r+w)/32;//equation for examscore
      
      double overall=Overall(examscore);//call method to calculate overall
      
      return overall;
   }//end method
   
   public static double Act()
   { //open method
      Scanner  act= new Scanner(System.in);
      
      System.out.print("   ACT English? ");
      int e = act.nextInt();//input English score for the ACT
      System.out.print("   ACT math? ");
      int m = act.nextInt();//input math score for the ACT
      System.out.print("   ACT reading? ");
      int r = act.nextInt();//input reading score for the ACT  
      System.out.print("   ACT science? ");
      int s = act.nextInt();//input science score for the ACT  
      
      System.out.println();  
      
      double examscore=(e+2*m+r+s)/1.8;//equation for examscore
      
      double overall=Overall(examscore);//call method to calculate overall 
      
      return overall;
   }//end method

   public static double Overall(double examscore)
   { //open method to calculate overall from:
      System.out.printf("  exam score = %.1f",examscore); 
               //examscore
      System.out.println();  
      System.out.println();  
      
      double score=gpascore();//call method to calculate gpa score
      System.out.printf("  GPA score = %.1f",score);
               //and gpa score
      System.out.println();
      
      double overall=score+examscore;//equations for overall score
      
      return overall;
   }//end method
   
   public static double gpascore()
   { //open method to calculate gpa score
      Scanner  Gpa= new Scanner(System.in);
      
      System.out.print("   overall GPA? ");
      double gpa = Gpa.nextDouble();//input for gpa 
      System.out.print("   Transcript Multiplier? ");
      double tm = Gpa.nextDouble();//input for Transcript Multiplier 
      
      double Gpascore=(gpa/4.0)*tm*100;//equation forTranscript Multiplier
      
      return Gpascore;         
   }//end method
   
}//end class