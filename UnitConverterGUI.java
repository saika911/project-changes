
package com.mycompany.saikaaa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverterGUI extends JFrame implements ActionListener {
    private JComboBox<String> conversionType;
    private JTextField inputField;
    private JLabel resultLabel;

    public UnitConverterGUI() {
        setTitle("Unit Converter");
        setSize(450, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("Unit Converter", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        String[] options = {
            "Celsius to Fahrenheit",
            "Fahrenheit to Celsius",
            "Meters to Kilometers",
            "Kilometers to Meters",
            "Miles to Kilometers",
            "Kilometers to Miles",
            "Kilograms to Pounds",
            "Pounds to Kilograms",
            "Seconds to Minutes",
            "Minutes to Hours"
        };

        conversionType = new JComboBox<>(options);
        add(conversionType);

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        add(inputField);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabel = new JLabel("Result will appear here", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double input = Double.parseDouble(inputField.getText());
            int choice = conversionType.getSelectedIndex();
            double result = 0;
            String output = "";

            switch (choice) {
                case 0:
                    result = Conversions.celsiusToFahrenheit(input);
                    output = input + " °C = " + result + " °F";
                    break;
                case 1:
                    result = Conversions.fahrenheitToCelsius(input);
                    output = input + " °F = " + result + " °C";
                    break;
                case 2:
                    result = Conversions.metersToKilometers(input);
                    output = input + " meters = " + result + " kilometers";
                    break;
                case 3:
                    result = Conversions.kilometersToMeters(input);
                    output = input + " kilometers = " + result + " meters";
                    break;
                case 4:
                    result = Conversions.milesToKilometers(input);
                    output = input + " miles = " + result + " kilometers";
                    break;
                case 5:
                    result = Conversions.kilometersToMiles(input);
                    output = input + " kilometers = " + result + " miles";
                    break;
                case 6:
                    result = Conversions.kilogramsToPounds(input);
                    output = input + " kg = " + result + " lb";
                    break;
                case 7:
                    result = Conversions.poundsToKilograms(input);
                    output = input + " lb = " + result + " kg";
                    break;
                case 8:
                    result = Conversions.secondsToMinutes(input);
                    output = input + " seconds = " + result + " minutes";
                    break;
                case 9:
                    result = Conversions.minutesToHours(input);
                    output = input + " minutes = " + result + " hours";
                    break;
            }

            resultLabel.setText(output);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UnitConverterGUI gui = new UnitConverterGUI();
            gui.setVisible(true);
        });
    }
}