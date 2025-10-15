import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
public class Calculator {
    public static void main(String[] args) {
        JFrame f=new JFrame("Calculator");
        f.setSize(700,900);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel l=new JLabel("Calculator");
        JTextField l=new JTextField();
        l.setEditable(false);

        f.add(l,BorderLayout.NORTH);
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(4,4,5,5));
        String arr[]=
        {
           "7","8","9","/",
           "4","5","6","*",
           "1","2","3","+",
           ".","c","=","-"
        };
        for(String s:arr)
        {
            JButton nt=new JButton(s);
            nt.addActionListener(e->
            {
                String c=e.getActionCommand();
                if(c.equals("c"))
                {
                    l.setText("");
                }
                else if(c.equals("="))
                {
                   try{ 
                    String result=eval(l.getText());
                    l.setText(result);
                   }
                   catch(Exception ex)
                   {
                       l.setText("error");
                   }
                }
                else
                {
                    l.setText(l.getText()+c);
                }
            }
            );
           p.add(nt);
        }
        f.add(p,BorderLayout.CENTER);
        f.setVisible(true);


    }
        public static String  eval(String expr) throws Exception
        {
        java.util.Stack<Double> numbers = new java.util.Stack<>();
        java.util.Stack<Character> ops = new java.util.Stack<>();

        for (int i=0; i<expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c) || c=='.') {
                StringBuilder sb = new StringBuilder();
                while (i<expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i)=='.')) {
                    sb.append(expr.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (c=='+' || c=='-' || c=='*' || c=='/') {
                while (!ops.isEmpty() && precedence(c) <= precedence(ops.peek())) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = ops.pop();
                    numbers.push(apply(a,b,op));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = ops.pop();
            numbers.push(apply(a,b,op));
        }

        return numbers.pop().toString();
    }

    public static int precedence(char op) {
        if(op=='+'||op=='-') return 1;
        if(op=='*'||op=='/') return 2;
        return 0;
    }

    public static double apply(double a, double b, char op) {
        switch(op) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }
        // for(int i=0;i<=9;i++)
        // {
        //   f.add(new JButton(""+i));
        // } 
        // f.add(new JButton("."));
        // f.add(new JButton("/"));
        //  f.add(new JButton("+"));
        //   f.add(new JButton("="));
        //    f.add(new JButton("-"));
        //     f.add(new JButton("*"));
        // f.setVisible(true);
        

    
}
