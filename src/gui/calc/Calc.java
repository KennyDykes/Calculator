package gui.calc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptException;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * By: Kenith Dykes 
 *  Copyright 7/24/15
 * Calculator Program using JApplet
 */
public class Calc extends JApplet {
	public String expression="";
	JLabel show;
	public void init()
	{
		new Calc();
	}
	
  public Calc()
   {
	   	Container ct=getContentPane();
	   	ct.setLayout(new BorderLayout());
	   	JPanel up=new JPanel();
        up.setLayout(new GridLayout(3,1));
        
        up.add(new JLabel());
        up.add(show = new JLabel(""));
	   	
	    JPanel low = new JPanel();
        low.setLayout(new GridLayout(5,4));

        String [] calculator = {"7","8","9","-","4","5","6","+",
                        "1","2","3","×",".","0","(","÷",")"};
        
        JButton clear=new JButton("CLR");
        clear.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) {
				expression=new String();
				show.setText("");
			}    });
        
        JButton equal=new JButton("=");
        equal.addActionListener(new ActionListener()
        {
           	@Override
			public void actionPerformed(ActionEvent e) {
           		Calculations cal=new Calculations(expression);
           		show.setText(""+cal.Stackmeth());
				
			} });
        
        for (int i=0;i<calculator.length;i++) {
                JButton current;
                low.add(current = new JButton(calculator[i]));
                current.addActionListener(
                        new ActionListener()
        {
        public void actionPerformed(ActionEvent e) {
            	expression = expression + e.getActionCommand();
            	show.setText(expression);   }
        }

        );
        }
        low.add(clear);
        low.add(equal);
        ct.add(up,BorderLayout.NORTH);
        ct.add(low,BorderLayout.SOUTH);
   }
}
