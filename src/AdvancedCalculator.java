import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedCalculator {
    private JFrame frame;
    private JTextField display;
    private double firstNumber = 0;
    private String operation = "";
    private boolean startNewNumber = true;

    public AdvancedCalculator() {
        frame = new JFrame("Java Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        // Button texts
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "CE", "√", "x²"
        };

        // Create buttons
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
                if (startNewNumber) {
                    display.setText("");
                    startNewNumber = false;
                }
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                display.setText("0");
                startNewNumber = true;
                firstNumber = 0;
                operation = "";
            } else if (command.equals("CE")) {
                display.setText("0");
                startNewNumber = true;
            } else if (command.equals("√")) {
                try {
                    double num = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(Math.sqrt(num)));
                    startNewNumber = true;
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
            } else if (command.equals("x²")) {
                try {
                    double num = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(num * num));
                    startNewNumber = true;
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
            } else if (command.equals("=")) {
                performCalculation();
            } else {
                // It's an operator (+, -, *, /)
                if (!operation.isEmpty()) {
                    performCalculation();
                }
                try {
                    firstNumber = Double.parseDouble(display.getText());
                    operation = command;
                    startNewNumber = true;
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
            }
        }
    }

    private void performCalculation() {
        try {
            double secondNumber = Double.parseDouble(display.getText());
            switch (operation) {
                case "+":
                    display.setText(String.valueOf(firstNumber + secondNumber));
                    break;
                case "-":
                    display.setText(String.valueOf(firstNumber - secondNumber));
                    break;
                case "*":
                    display.setText(String.valueOf(firstNumber * secondNumber));
                    break;
                case "/":
                    if (secondNumber != 0) {
                        display.setText(String.valueOf(firstNumber / secondNumber));
                    } else {
                        display.setText("Error");
                    }
                    break;
            }
            operation = "";
            startNewNumber = true;
        } catch (NumberFormatException ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdvancedCalculator());
    }
}

