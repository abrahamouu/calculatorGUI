package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the Calculator.Form Class that incorporates GUI and functions of all buttons. 
 * @author Abraham Ou
 * @version 0.1
 *
 */
public class Calculator {
    private JPanel mainPanel;
    private JTextField textField;
    private JButton zeroBtn;
    private JButton oneBtn;
    private JButton fourBtn;
    private JButton sevenBtn;
    private JButton clearBtn;
    private JButton reciprocalBtn;
    private JButton mClearBtn;
    private JButton mRecallBtn;
    private JButton powerBtn;
    private JButton signBtn;
    private JButton eightBtn;
    private JButton fiveBtn;
    private JButton twoBtn;
    private JButton mAddBtn;
    private JButton logBtn;
    private JButton factorialBtn;
    private JButton nineBtn;
    private JButton sixBtn;
    private JButton threeBtn;
    private JButton digitBtn;
    private JButton mSubBtn;
    private JButton sqrBtn;
    private JButton divideBtn;
    private JButton mulBtn;
    private JButton minusBtn;
    private JButton addBtn;
    private JButton equalBtn;
    private double buffer1;
    private double buffer2;
    private double memoryBuffer;
    private String currentString;

    /**
     * Calculator.Form Constructor
     * Initializes Event Handlers for Each Button
     * For numerical buttons(0-9), event handler base class is numberBtnClicked and extends to each button.
     * Arithmetic and Memory Buttons also implemented within constructor.
     */
    public Calculator() {
        if(textField.getText().equals("")){
            textField.setText("0");
        }

        zeroBtn.addActionListener(new zeroBtnClicked(0,textField));
        oneBtn.addActionListener(new oneBtnClicked(1,textField));
        twoBtn.addActionListener(new twoBtnClicked(2,textField));
        threeBtn.addActionListener(new threeBtnClicked(3,textField));
        fourBtn.addActionListener(new fourBtnClicked(4,textField));
        fiveBtn.addActionListener(new fiveBtnClicked(5,textField));
        sixBtn.addActionListener(new sixBtnClicked(6,textField));
        sevenBtn.addActionListener(new sevenBtnClicked(7,textField));
        eightBtn.addActionListener(new eightBtnClicked(8,textField));
        nineBtn.addActionListener(new nineBtnClicked(9,textField));



        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
//                System.out.println("The current operator: " + currentString);
            }
        });

        digitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("0")){
                    textField.setText("0.");
                }
                else if(textField.getText().equals("0.")){
                    textField.setText("0.");
                }
                else if(textField.getText().contains(".")){
                    textField.setText(textField.getText());
                }
                else{
                    textField.setText(textField.getText() + ".");
                }

            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buffer1 = buffer1 + Double.parseDouble(textField.getText());
                textField.setText("");
                currentString = "+";
            }
        });
        equalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator();

            }
        });
        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buffer1 = buffer1 + Double.parseDouble(textField.getText());
                textField.setText("");
                currentString = "-";
            }
        });
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buffer1 = buffer1 + Double.parseDouble(textField.getText());
                textField.setText("");
                currentString = "*";
            }
        });
        divideBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buffer1 = buffer1 + Double.parseDouble(textField.getText());
                textField.setText("");
                currentString = "/";
            }
        });
        sqrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buffer1 = Double.parseDouble(textField.getText());
                if(buffer1 < 0){
                    textField.setText("ERROR");
                }
                else {
                    double result = Math.sqrt(buffer1);
                    if(result % 1 == 0){
                        int tempInt = (int) result;
                        textField.setText(String.valueOf(tempInt));
                    }
                    else {
                        textField.setText(String.valueOf(result));
                    }

                }
                buffer1 = 0;
            }
        });
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buffer1 = Double.parseDouble(textField.getText());
                if(buffer1 <= 0){
                    textField.setText("ERROR");
                }
                else {
                    double tempVal = Math.log(buffer1);
                    if(tempVal % 1 == 0){
                        int tempInt = (int) tempVal;
                        textField.setText(String.valueOf(tempInt));
                    }
                    else {
                        textField.setText(String.valueOf(tempVal));
                    }
                }
                buffer1 = 0;
            }
        });
        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double tempVal = Double.parseDouble(textField.getText()) * -1;
                if(tempVal % 1 == 0){
                    int tempInt = (int) tempVal;
                    textField.setText(String.valueOf(tempInt));
                }
                else {
                    textField.setText(String.valueOf(tempVal));
                }

            }
        });
        reciprocalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buffer1 = Double.parseDouble(textField.getText());
                if(buffer1 == 0){
                    textField.setText("ERROR");
                }
                else{
                    double tempVal = 1.0/buffer1;
                    if(tempVal % 1 == 0){
                        int tempInt = (int) tempVal;
                        textField.setText(String.valueOf(tempInt));
                    }
                    else {
                        textField.setText(String.valueOf(tempVal));
                    }
                }
                buffer1 = 0;

            }
        });
        powerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buffer1 = buffer1 + Double.parseDouble(textField.getText());
                textField.setText("");
                currentString = "^";
            }
        });
        factorialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Double.parseDouble(textField.getText()) > 9){
                    textField.setText("ERROR");
                }
                else {
                    buffer1 = Double.parseDouble(textField.getText());
                    double tempVal = factorial(buffer1);
                    if(tempVal % 1 == 0){
                        int tempInt = (int) tempVal;
                        textField.setText(String.valueOf(tempInt));
                    }
                    else {
                        textField.setText(String.valueOf(tempVal));
                    }
                }
                buffer1 = 0;
            }

        });
        mClearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoryBuffer = 0;
                textField.setText("0");
            }
        });
        mRecallBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(memoryBuffer % 1 == 0){
                    int tempInt = (int) memoryBuffer;
                    textField.setText(String.valueOf(tempInt));
                }
                else {
                    textField.setText(String.valueOf(memoryBuffer));
                }
                System.out.println("Stored in mem: " + memoryBuffer);

            }
        });
        mAddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //if buffer is empty add current displayed value to memory
                if(memoryBuffer == 0){
                    memoryBuffer = Double.parseDouble(textField.getText());
                }
                //otherwise add to itself
                else {
                    memoryBuffer += Double.parseDouble(textField.getText());
                }
                if(memoryBuffer % 1 == 0){
                    int tempInt = (int) memoryBuffer;
                    textField.setText(String.valueOf(tempInt));
                }
                else {
                    textField.setText(String.valueOf(memoryBuffer));
                }




            }
        });
        mSubBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(memoryBuffer == 0){
                    memoryBuffer = Double.parseDouble(textField.getText()) * -1;
                }
                else{
                    memoryBuffer -= Double.parseDouble(textField.getText());
                }
                if(memoryBuffer % 1 == 0){
                    int tempInt = (int) memoryBuffer;
                    textField.setText(String.valueOf(tempInt));
                }
                else {
                    textField.setText(String.valueOf(memoryBuffer));
                }
            }
        });
    }

    /**
     * Operator() is a helper method to help equal to identify which arithmetic operation and execute.
     * Executes arithmetic operations for +, -, *, /, and ^
     */
    public void operator(){
        String result = "";
        String operator = currentString;
//        System.out.println("Current operator: " + operator);
        switch (operator){
            case "+":
                    buffer2 = buffer1 + Double.parseDouble(textField.getText());
                if((buffer1 % 1 == 0) && (Double.parseDouble(textField.getText()) % 1 == 0)){

                    int tempInt = (int) buffer2;
                    textField.setText(Integer.toString(tempInt));
                    buffer1 = 0;
                }
                else {

                    buffer2 = buffer1 + Double.parseDouble(textField.getText());
                    if(buffer2 % 1 == 0){
                        int tempVal = (int)buffer2;
                        textField.setText(Integer.toString(tempVal));
                    }
                    else{
                        textField.setText(Double.toString(buffer2));
                    }

                    buffer1 = 0;
                }
                currentString = "";

                break;
            case "-":
                buffer2 = buffer1 - Double.parseDouble(textField.getText());
                if((buffer1 % 1 == 0) && (Double.parseDouble(textField.getText()) % 1 == 0)){

                    int tempInt = (int) buffer2;
                    textField.setText(Integer.toString(tempInt));
                    buffer1 = 0;
                }
                else {

                    buffer2 = buffer1 - Double.parseDouble(textField.getText());
                    if(buffer2 % 1 == 0){
                        int tempVal = (int)buffer2;
                        textField.setText(Integer.toString(tempVal));
                    }
                    else{
                        textField.setText(Double.toString(buffer2));
                    }

                    buffer1 = 0;
                }
                currentString = "";
                break;
            case "*":
                buffer2 = buffer1 * Double.parseDouble(textField.getText());
                if((buffer1 % 1 == 0) && (Double.parseDouble(textField.getText()) % 1 == 0)){

                    int tempInt = (int) buffer2;
                    textField.setText(Integer.toString(tempInt));
                    buffer1 = 0;
                }
                else {
                    buffer2 = buffer1 * Double.parseDouble(textField.getText());
                    if(buffer2 % 1 == 0){
                        int tempVal = (int)buffer2;
                        textField.setText(Integer.toString(tempVal));
                    }
                    else{
                        textField.setText(Double.toString(buffer2));
                    }

                    buffer1 = 0;
                }
                currentString = "";
                break;
            case "/":
                buffer2 = buffer1 / Double.parseDouble(textField.getText());
                if(Double.parseDouble(textField.getText()) == 0){
                    textField.setText("ERROR");
                }
                else {
                    if((buffer1 % 1 == 0) && (Double.parseDouble(textField.getText()) % 1 == 0)){

                        int tempInt = (int) buffer2;
                        textField.setText(Integer.toString(tempInt));
                        buffer1 = 0;
                    }
                    else {
                        buffer2 = buffer1 / Double.parseDouble(textField.getText());
                        if(buffer2 % 1 == 0){
                            int tempVal = (int)buffer2;
                            textField.setText(Integer.toString(tempVal));
                        }
                        else{
                            textField.setText(Double.toString(buffer2));
                        }

                        buffer1 = 0;
                    }
                }

                currentString = "";
                break;
            case "^":
                //add edge case for error
                if(buffer1 < 0 && textField.getText().contains(".")){
                    textField.setText("ERROR");
                }
                else {
                    double tempVal = Math.pow(buffer1, Double.parseDouble(textField.getText()));
                    if(tempVal % 1 == 0){
                        int tempInt = (int) tempVal;
                        textField.setText(Integer.toString(tempInt));
                    }
                    else{
                        textField.setText(Double.toString(tempVal));
                    }
                }

                buffer1 = 0;
                break;
            default:
                break;
        }

    }

    /**
     * test() function for sample tests in main
     * @param button is String input that is used to identify which button is being tested for sample tests.
     */
    public void test( String button){
        switch (button){
            case "0": zeroBtn.doClick();break;
            case "1": oneBtn.doClick();break;
            case "2": twoBtn.doClick();break;
            case "3": threeBtn.doClick();break;
            case "4": fourBtn.doClick();break;
            case "5": fiveBtn.doClick();break;
            case "6": sixBtn.doClick();break;
            case "7": sevenBtn.doClick();break;
            case "8": eightBtn.doClick();break;
            case "9": nineBtn.doClick();break;
            case "x!": factorialBtn.doClick();break;
            case "-/+": signBtn.doClick();break;
            case "AC": clearBtn.doClick();break;
            case "1/x": reciprocalBtn.doClick();break;
            case "sqr": sqrBtn.doClick();break;
            case "log": logBtn.doClick();break;
            case ".": digitBtn.doClick();break;
            case "+": addBtn.doClick();break;
            case "-": minusBtn.doClick();break;
            case "*": mulBtn.doClick();break;
            case "/": divideBtn.doClick();break;
            case "**": powerBtn.doClick();break;
            case "=": equalBtn.doClick();break;
            case "MR": mRecallBtn.doClick();break;
            case "MC": mClearBtn.doClick();break;
            case "M-": mSubBtn.doClick();break;
            case "M+": mAddBtn.doClick();break;
            case "txt": System.out.println("The result is: " + textField.getText());break;
            default:System.out.println("invalid input");break;
        }
    }

    /**
     * Helper method for factorial button to recursively find factorial of a value.
     * @param x is the input value that is used to find the factorial of.
     * @return returns the factorial result of input,x, with a type of double.
     */
    public double factorial(double x){
        if(x == 0){
            return 1;
        }
        else if(x == 1){
            return 1;
        }

        return x*factorial(x-1);
    }

    /**
     * Main class creates the calculator object and allows user interaction with calculator
     * @param args is default arg input for main
     * Modifies UI appearance to Nimbus Look and Feel
     * Runs Local Test Cases
     */
    public static void main(String[] args) {
        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Calculator().mainPanel);
        frame.pack();
        frame.setVisible(true);
        Calculator myCal = new Calculator();

        //test addition
        System.out.println("Testing addition");
        myCal.test("1");
        myCal.test("+");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 3");

        //test subtraction
        System.out.println("Testing subtraction");
        myCal.test("1");
        myCal.test(".");
        myCal.test("2");
        myCal.test("-");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: -0.8");

        //test multiplication
        System.out.println("Testing multiplication");
        myCal.test("1");
        myCal.test("*");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 2");

        //test division
        System.out.println("Testing division");
        myCal.test("1");
        myCal.test(".");
        myCal.test("2");
        myCal.test("/");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 0.6");

        //test power
        System.out.println("Testing power");
        myCal.test("2");
        myCal.test("**");
        myCal.test("3");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 8");

        //test square
        System.out.println("Testing reciprocal");
        myCal.test("2");
        myCal.test("1/x");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 0.5");

        //test percentage
        System.out.println("Testing factorial");
        myCal.test("5");
        myCal.test("x!");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 120");

        //test square root
        System.out.println("Testing square root");
        myCal.test("4");
        myCal.test("sqr");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 2");
    }

}


