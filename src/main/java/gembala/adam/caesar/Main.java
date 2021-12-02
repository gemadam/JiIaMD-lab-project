/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.caesar;

import gembala.adam.cesar.controller.CaesarCipherController;
import gembala.adam.cesar.view.CaesarCipherGUI;
import javafx.application.Application;
import static javafx.application.Application.launch;
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

    CaesarCipherGUI gui;
    
    @Override
    public void start(Stage primaryStage) {
        gui = new CaesarCipherGUI();

        primaryStage.setTitle("Caesar Cipher GUI");
        primaryStage.setScene(gui.makeScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}