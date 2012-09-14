package net.javainthebox.rpn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CalculatorController implements Initializable {
    private StackMachine machine;
    private int number = 0;
    private boolean legalflag = false;
    
    private double rootX;
    private double rootY;

    @FXML
    AnchorPane root;

    @FXML
    Label numberLabel;

    @FXML
    private void handleZero(ActionEvent event) {
        handleNumber(0);
    }

    @FXML
    private void handleOne(ActionEvent event) {
        handleNumber(1);
    }
    
    @FXML
    private void handleTwo(ActionEvent event) {
        handleNumber(2);
    }

    @FXML
    private void handleThree(ActionEvent event) {
        handleNumber(3);
    }

    @FXML
    private void handleFour(ActionEvent event) {
        handleNumber(4);
    }
    
    @FXML
    private void handleFive(ActionEvent event) {
        handleNumber(5);
    }

    @FXML
    private void handleSix(ActionEvent event) {
        handleNumber(6);
    }

    @FXML
    private void handleSeven(ActionEvent event) {
        handleNumber(7);
    }
    
    @FXML
    private void handleEight(ActionEvent event) {
        handleNumber(8);
    }

    @FXML
    private void handleNine(ActionEvent event) {
        handleNumber(9);
    }

    private void handleNumber(int value) {
        legalflag = true;
        if (number < 100_000_000) {
            number = number * 10 + value;
            numberLabel.setText(String.valueOf(number));
        }
    }
    
    @FXML
    private void handleEnter(ActionEvent event) {
        legalflag = false;
        machine.push(number);
        number = 0;
    }

    @FXML
    private void handleClear(ActionEvent event) {
        legalflag = false;
        machine.clear();
        number = 0;
        numberLabel.setText(String.valueOf(number));
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        if (legalflag) {
            machine.push(number);
        }
        legalflag = false;
        number = 0;

        try {
            numberLabel.setText(String.valueOf(machine.add()));
        } catch (ArithmeticException ex) {
            numberLabel.setText("Error");
        }
    }

    @FXML
    private void handleSub(ActionEvent event) {
        if (legalflag) {
            machine.push(number);
        }
        legalflag = false;
        number = 0;

        try {
            numberLabel.setText(String.valueOf(machine.sub()));
        } catch (ArithmeticException ex) {
            numberLabel.setText("Error");
        }
    }

    @FXML
    private void handleMal(ActionEvent event) {
        if (legalflag) {
            machine.push(number);
        }
        legalflag = false;
        number = 0;
        
        try {
            numberLabel.setText(String.valueOf(machine.mal()));
        } catch (ArithmeticException ex) {
            numberLabel.setText("Error");
        }
    }

    @FXML
    private void handleDiv(ActionEvent event) {
        if (legalflag) {
            machine.push(number);
        }
        legalflag = false;
        number = 0;

        try {
            numberLabel.setText(String.valueOf(machine.div()));
        } catch (ArithmeticException ex) {
            numberLabel.setText("Error");
        }
    }

    void setStackMachine(StackMachine machine) {
        this.machine = machine;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberLabel.setText(String.valueOf(number));
    }    

}
