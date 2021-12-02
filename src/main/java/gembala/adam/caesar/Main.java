/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.caesar;

import gembala.adam.cesar.controller.CaesarCipherController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main class of a program
 * @author Adam Gembala
 * @version 1.0.0
 */
public class Main extends Application {
    
    /**
     * Arguments passed by command line
     */
    static String[] _args;
    
    /**
     * 
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        
        Button btn = new Button();
        btn.setText("Say 'Hello World!' on default Java console");
        btn.setOnAction((ActionEvent event) -> {
            // Initialize and execute controller
            var c = new CaesarCipherController();
            
            c.execute(_args);
            
            System.out.println("Dupa dupa");
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Dupa dupa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Main method of a program
     * @param args Parameters passed from command line
     */
    public static void main(String args[]) {
        
        _args = args;
        
        launch(args);
    }
}
