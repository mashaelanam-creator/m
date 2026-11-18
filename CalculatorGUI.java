import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField textField;
    JButton[] numButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton eqButton, clrButton;

    double num1, num2, result;
    char operator;

    CalculatorGUI() {

        setTitle("Calculator");
        setSize(380, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 20, 320, 70);
        textField.setFont(new Font("Segoe UI", Font.BOLD, 30));
        textField.setBackground(new Color(44, 44, 44));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField);

        JPanel panel = new JPanel();
        panel.setBounds(20, 110, 320, 350);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(30, 30, 30));

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(new Font("Segoe UI", Font.BOLD, 22));
            numButtons[i].setBackground(new Color(60, 60, 60));
            numButtons[i].setForeground(Color.WHITE);
            numButtons[i].setFocusPainted(false);
            numButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        Color operatorColor = new Color(255, 149, 0);

        JButton[] operators = {
                addButton, subButton, mulButton,
                divButton, eqButton
        };

        for (JButton btn : operators) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 22));
            btn.setBackground(operatorColor);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.addActionListener(this);
        }

        clrButton.setFont(new Font("Segoe UI", Font.BOLD, 22));
        clrButton.setBackground(new Color(220, 53, 69));
        clrButton.setForeground(Color.WHITE);
        clrButton.setFocusPainted(false);
        clrButton.addActionListener(this);

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(divButton);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(mulButton);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(subButton);

        panel.add(clrButton);
        panel.add(numButtons[0]);
        panel.add(eqButton);
        panel.add(addButton);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }

            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
