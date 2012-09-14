package net.javainthebox.rpn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RPNCalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackMachine machine = new StackMachine();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Calculator.fxml"));
        AnchorPane root = (AnchorPane)loader.load();
        CalculatorController controller = loader.getController();
        controller.setStackMachine(machine);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
    }
    
    public static void main(String... args) {
        launch(args);
    }    
}
