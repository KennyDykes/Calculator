package gui.calc;

import java.util.EmptyStackException;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/*
 * By: Kenith Dykes 
 *  Copyright 7/24/15
 * Calculator Program using JApplet
 * Uses 2 stack method in calculating
 */
public class Calculations {
	
	private String [] equation;
	private Stack <String> oper=new Stack<String>(); //Stack is for math symbols
	private Stack <Double>num=new Stack<Double>();   //Stack is for numbers 
	
	public Calculations(String expression)
	{	  equation=expression.split("(?!^)((?<=[-+×÷)(])|(?=[-+×÷)(]))");} //parses equation string 
	/*
	 * Fills our two stacks and does computation
	 */
	public Double Stackmeth()
	{
		 for(int i=0;i<=equation.length-1;i++)
		  {
			if(equation[i].equals("("))
			 {	oper.push("("); }
			else if(equation[i].equals("÷"))
			{
				oper.push("÷");
			}
			else if(equation[i].equals("×"))
			{
				oper.push("×");
			}
			else if(equation[i].equals("+"))
			{
				oper.push("+");
			}
			else if(equation[i].equals("-"))
			{
				oper.push("-");
			}
			else if(equation[i].equals(")"))
			{
				getComp();
		    }
			else
			{
				num.push(Double.valueOf(equation[i]));
			}
     	  }
		while(oper.size()!=0)
		{	getFinal();}
		return num.pop();
	}
 /*
  * Does complete computation of the equation string
  */
	 private void getFinal()
	 {
		     String op=new String (oper.pop());
    		 if(op.equals("÷"))
    		 {	Double one,two;
 		        one=num.pop();
 		        two=num.pop();
 			 num.push(two/one); }
    		 else if(op.equals("×"))
    		 { num.push(num.pop()*num.pop()); }
    		 if(op.equals("+"))
    		 {	num.push(num.pop()+num.pop()); }
    		 else if(op.equals("-"))
    		 { num.push(num.pop()-num.pop()); }
    		
    	 
	 }
	 /*
	  * Does computation for string that includes "( )"
	  */
     private void getComp()
     {
    	 String op=new String (oper.pop());
    	 while(!op.equals("("))
    	 {
    		 if(op.equals("÷"))
    		 {	Double one,two;
    		    one=num.pop();
    		    two=num.pop();
    			 num.push(two/one); }
    		 else if(op.equals("×"))
    		 { num.push(num.pop()*num.pop()); }
    		 if(op.equals("+"))
    		 {	num.push(num.pop()+num.pop()); }
    		 else if(op.equals("-"))
    		 { num.push(num.pop()-num.pop()); }
    		 op=new String(oper.pop());
    	 }
     }
     /*
	 public int Parse()
	 {
		 int j=0,op=0,op1=0;
		 if(equation[0].equals("("))
		 {
			 j++;
			 while(!equation[j].equals(")"))
			 {
				 if(equation[j].equals("÷"))
				 {
					 j++;
					 op1=Integer.valueOf(equation[j]);
					 op /=op1;
				 }
				 else if(equation[j].equals("×"))
				 {
					 j++;
					 op1=Integer.valueOf(equation[j]);
					 op *=op1;
				 }	
				 else if(equation[j].equals("+"))
				 {
					 j++;
					 op1=Integer.valueOf(equation[j]);
					 op +=op1;
				 }	
				 else if(equation[j].equals("-"))
				 {
					 j++;
					 op1=Integer.valueOf(equation[j]);
					 op -=op1;
				 }	
				 else
				 {
					op=Integer.valueOf(equation[j]); ;
				 }
				 j++;
			 }
		 }
		 else
		 {
			 for(int i=0;i<=equation.length-1;i++)
			 {
				 if(equation[i].equals("÷"))
				 {
					 i=i+1;
					 op1=Integer.valueOf(equation[i]);
					 op /=op1;
				 }
				 else if(equation[i].equals("×"))
				 {
					 i=i+1;
					 op1=Integer.valueOf(equation[i]);
					 op *=op1;
				 }	
				 else if(equation[i].equals("+"))
				 {
					 i=i+1;
					 op1=Integer.valueOf(equation[i]);
					 op +=op1;
				 }	
				 else if(equation[i].equals("-"))
				 {
					 i=i+1;
					 op1=Integer.valueOf(equation[i]);
					 op -=op1;
				 }	
				 else if(equation[i].equals(""))
				 {
					 
				 }
				
				 else
				 {
					 try{
					op=Integer.valueOf(equation[i]);
					 }
                     catch(NumberFormatException ex){ 
                    	 System.err.println("Ilegal input");
                              } 
				 	 }	 
			 }
		 }
		 return op;
	 
		 
		 }*/
}
