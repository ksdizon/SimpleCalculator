import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame{
    //Elements of Frame
    
    //Labels
    JLabel operand1Label = new JLabel();
    JLabel operatorLabel = new JLabel();
    JLabel operand2Label = new JLabel();
    JLabel resultLabel = new JLabel();
    
    //Text Fields
    JTextField operand1Field = new JTextField();
    JTextField operatorField = new JTextField();
    JTextField operand2Field = new JTextField();
    JTextField resultField = new JTextField();
    
    //Buttons
    JButton calculateButton = new JButton();
    JButton exitButton = new JButton();
    
    public CalculatorApp(){
        setTitle("Simple Calculator");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //Location of elements (LEFT TO RIGHT!)
        operand1Label.setText("  Operand 1:");
        gc.gridx = 0;
        gc.gridy = 0;
        getContentPane().add(operand1Label, gc);
        
        operand1Field.setText("");
        operand1Field.setColumns(6);
        gc.gridx = 1;
        gc.gridy = 0;
        getContentPane().add(operand1Field,gc);
        
        operatorLabel.setText("Operator: ");
        gc.gridx = 0;
        gc.gridy = 1;
        getContentPane().add(operatorLabel,gc);
        
        operatorField.setText("");
        operatorField.setColumns(2);
        gc.gridx = 1;
        gc.gridy = 1;
        getContentPane().add(operatorField,gc);
        
        operand2Label.setText("  Operand 2:");
        gc.gridx = 0;
        gc.gridy = 2;
        getContentPane().add(operand2Label, gc);
        
        operand2Field.setText("");
        operand2Field.setColumns(6);
        gc.gridx = 1;
        gc.gridy = 2;
        getContentPane().add(operand2Field,gc);
        
        resultLabel.setText("Results: ");
        gc.gridx = 0;
        gc.gridy = 3;
        getContentPane().add(resultLabel,gc);
        
        resultField.setText("");
        resultField.setColumns(6);
        gc.gridx = 1;
        gc.gridy = 3;
        getContentPane().add(resultField,gc);
        
        calculateButton.setText("Calculate");
        gc.gridx = 0;
        gc.gridy = 4;
        getContentPane().add(calculateButton,gc);
        
        calculateButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String operand1 = operand1Field.getText();
               String operand2 = operand2Field.getText();
               String operator = operatorField.getText();
               
               if(operand1.equals("") || operand2.equals("")){
                   JOptionPane.showMessageDialog(null, "Missing Operand/s!", "ERROR", JOptionPane.ERROR_MESSAGE);
               }else{
               
                   double con_operand1 = Double.parseDouble(operand1); 
                   double con_operand2 = Double.parseDouble(operand2);
                   double result;
                   if(operator.equals("+")){
                       result = con_operand1 + con_operand2; 
                       String message = ""+result;                  
                       resultField.setText(message);
                   }else if(operator.equals("-")){
                       result = con_operand1 - con_operand2; 
                       String message = ""+result;
                       resultField.setText(message);                  
                   }else if(operator.equals("*")){
                       result = con_operand1 * con_operand2; 
                       String message = ""+result;
                       resultField.setText(message);
                   }else if(operator.equals("/")){
                       result = con_operand1 / con_operand2; 
                       String message = ""+result;
                       resultField.setText(message);
                   }else{
                       JOptionPane.showMessageDialog(null, "Invalid Operator", "ERROR", JOptionPane.ERROR_MESSAGE);
                   }
                }
           }    
        });
        
        exitButton.setText("     Exit     ");
        gc.gridx = 1;
        gc.gridy = 4;
        getContentPane().add(exitButton,gc);    
        
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                setVisible(false); 
            }
        });
    }
    
    public static void main(String[] args){
        CalculatorApp frame = new CalculatorApp();
        frame.setVisible(true);
    }
}