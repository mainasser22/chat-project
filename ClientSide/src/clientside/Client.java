/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.rmi.ConnectException;
import java.rmi.Naming;
import java.util.Scanner;
import operation.Operation;

/**
 *
 * @author Nasser
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try{
        Operation p=(Operation)Naming.lookup("rmi://127.0.0.1:2244/calc"); // لو جهازين مختلفين هحط ال ip بتاع الجهاز التاني 
       
      
    System.out.println("Enter first number");
    int x=input.nextInt();

    System.out.println("Enter second number");
    int y=input.nextInt();
       //System.out.println("Choose an operator: +, -, *, or /");
        System.out.println("\n menu options: ");
        System.out.println("\t to sum enter 1 ");
        System.out.println("\t to sub enter 2 ");
        System.out.println("\t to multi enter 3 ");
        System.out.println("\t to div enter 4 ");
        
        int operator = input.nextInt();
      switch(operator)
    {
     case 1:
        
        System.out.println("Result= "+x + " + " + y + " = " + p.sum(x, y));
        break;
    case 2:
        
        System.out.println("Result= "+ x + " - " + y + " = " + p.sub(x, y));
        break;
        
    case 3:
        
        System.out.println("Result= "+x + " * " +y + " = " + p.mul(x, y));
        break; 
    case 4:
        if(y==0.0)
        {
            System.out.println("\t\t we can not divide by zero, retry other 2 numbers ");
        }
        System.out.println("Result= "+ x + " / " + y + " = " + p.div(x, y));
        break;
        

     default:
        System.out.println("Invalid operator!");
        break;
    }
        
       
        }
        catch(ConnectException conEx)
        {
            System.out.println("Unable to connect to server");
            System.exit(1);
        }catch(Exception e){
        
         System.exit(1);     }
    }
    
}
