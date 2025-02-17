package com.example.homework3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.util.Scanner;

public class LoanCalculatorController {
    @FXML
    private TextField loanAmountTextField;

    @FXML
    private TextField annualInterestRateTextField;

    @FXML
    private TextField numberOfYearsTextField;

    @FXML
    private Label monthlyPaymentLabel;

    @FXML
    private Label totalPaymentLabel;

    @FXML
    public void computePayment(ActionEvent event) {
        try {
            double loanAmount = extractDouble(loanAmountTextField.getText());
            double annualInterestRate = extractDouble(annualInterestRateTextField.getText());
            double numberOfYears = extractDouble(numberOfYearsTextField.getText());

            int totalMonths = (int) (numberOfYears * 12);

            double monthlyInterestRate = (annualInterestRate / 12) / 100;

            double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));
            double totalPayment = monthlyPayment * totalMonths;

            monthlyPaymentLabel.setText("Monthly Payment: $%.2f" + monthlyPayment);
            totalPaymentLabel.setText("Total Payment: $%.2f" + totalPayment);

        } catch (Exception e) {
            monthlyPaymentLabel.setText("Invalid input!");
            totalPaymentLabel.setText("");
        }
    }

    private double extractDouble(String input) throws Exception{
        Scanner scanner = new Scanner(input);
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        throw new Exception("Invalid number");
    }

}