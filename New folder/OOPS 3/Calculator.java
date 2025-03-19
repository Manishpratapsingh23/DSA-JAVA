import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString = {"7", "8", "9", "+",
                             "4", "5", "6", "-",
                             "1", "2", "3", "*",
                             ".", "/", "C", "√",
                             "+/-", "=", "0"};

    double temporary = 0;
    int operation = -1; // Stores the last operator used
    boolean startNewNumber = false; // Prevents appending numbers after an operation

    JTextArea display = new JTextArea(2, 25);
    Font font = new Font("Times New Roman", Font.BOLD, 20);

    Calculator() {
        super("Calculator");
        setDesign();
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 5));

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);

        for (int i = 0; i < 5; i++) row[i] = new JPanel();
        row[0].setLayout(f1);
        for (int i = 1; i < 5; i++) row[i].setLayout(f2);

        for (int i = 0; i < 19; i++) {
            button[i] = new JButton(buttonString[i]);
            button[i].setBackground(Color.white);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }

        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(new Dimension(430, 50));

        row[0].add(display);
        add(row[0]);

        for (int i = 0; i < 4; i++) row[1].add(button[i]);
        row[1].add(button[14]);
        add(row[1]);

        for (int i = 4; i < 8; i++) row[2].add(button[i]);
        row[2].add(button[15]);
        add(row[2]);

        for (int i = 8; i < 12; i++) row[3].add(button[i]);
        row[3].add(button[16]);
        add(row[3]);

        row[4].add(button[18]);
        for (int i = 12; i < 14; i++) row[4].add(button[i]);
        row[4].add(button[17]);
        add(row[4]);

        setVisible(true);
    }

    public void clear() {
        display.setText("");
        temporary = 0;
        operation = -1;
        startNewNumber = false;
    }

    public void getSqrt() {
        try {
            double value = Double.parseDouble(display.getText());
            if (value < 0) {
                display.setText("Error");
            } else {
                display.setText(Double.toString(Math.sqrt(value)));
            }
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    public void getPosNeg() {
        try {
            double value = Double.parseDouble(display.getText());
            display.setText(Double.toString(value * -1));
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    public void getResult() {
        try {
            double secondOperand = Double.parseDouble(display.getText());
            double result = 0;

            switch (operation) {
                case 0: result = temporary + secondOperand; break;
                case 1: result = temporary - secondOperand; break;
                case 2: result = temporary * secondOperand; break;
                case 3:
                    if (secondOperand == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = temporary / secondOperand;
                    break;
                default:
                    display.setText("Error");
                    return;
            }

            display.setText(Double.toString(result));
            operation = -1; // Reset operation
            startNewNumber = true; // After getting result, start a new number
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {   
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        // Handle number buttons
        for (int i = 0; i < 10; i++) {
            if (source == button[i] || source == button[18]) {
                if (startNewNumber) {
                    display.setText("");
                    startNewNumber = false;
                }
                display.append(buttonString[i]);
                return;
            }
        }

        // Handle operator buttons
        if (source == button[3]) processOperator(0); // "+"
        if (source == button[7]) processOperator(1); // "-"
        if (source == button[11]) processOperator(2); // "*"
        if (source == button[13]) processOperator(3); // "/"

        if (source == button[12]) display.append(".");
        if (source == button[14]) clear();
        if (source == button[15]) getSqrt();
        if (source == button[16]) getPosNeg();
        if (source == button[17]) getResult();
    }

    private void processOperator(int op) {
        try {
            if (!display.getText().isEmpty()) {
                temporary = Double.parseDouble(display.getText());
            } else {
                temporary = 0; // Default to 0 if no input
            }
            operation = op;
            startNewNumber = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    public static void main(String[] arguments) {
        new Calculator();
    }
}
