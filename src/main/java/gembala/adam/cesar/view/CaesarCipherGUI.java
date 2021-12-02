/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gembala.adam.cesar.view;

import gembala.adam.cesar.controller.CaesarCipherController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * GUI class of caesar cipher application
 * @author Adam
 */
public class CaesarCipherGUI {
    
    /**
     * Controller used by GUI
     */
    CaesarCipherController c;
    
    /**
     * Input with text to be encrypted
     */
    TextField txtPublicText;
    
    /**
     * Input with encryption key
     */
    TextField txtShift;
    
    /**
     * Input with result of the encryption
     */
    TextField txtResult;
    
    /**
     * Default constructor, initializes the instance of the class
     */
    public CaesarCipherGUI()
    {
        c = new CaesarCipherController();
        
        txtPublicText = new TextField();
        txtShift = new TextField();
        txtResult = new TextField();
    }
    
    /**
     * Method creates menu bar
     * @return Created menu bar
     */
    public MenuBar createMenuBar()
    {
        Menu m = new Menu("Menu");
  
        // create menuitems
        MenuItem m1 = new MenuItem("Encryption");
        MenuItem m2 = new MenuItem("Decryption");
        
        m1.setOnAction((ActionEvent event) -> {
            System.out.println("Encryption");
        });
        m2.setOnAction((ActionEvent event) -> {
            System.out.println("Decryption");
        });
        
        m.getItems().add(m1);
        m.getItems().add(m2);
  
        MenuBar mb = new MenuBar();
  
        mb.getMenus().add(m);
        
        return mb;
    }
    
    
    /**
     * Method creates initialized scene
     * @return Caesar cipher GUI scene
     */
    public Scene makeScene()
    {
        Button btn = new Button();
        btn.setText("Shift text");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override public void handle(ActionEvent e) {
                
                txtResult.setText("This is placeholder for result");
                
            }
            
        });
        
        Label label1 = new Label("Text to shift:");
        Label label2 = new Label("Key:");
        Label lbResult = new Label("Result: ");
  
        // create a VBox
        VBox mainLayout = new VBox();
        mainLayout.setSpacing(10);

        mainLayout.getChildren().addAll(label1, txtPublicText, label2, txtShift, lbResult, txtResult, btn);
        
        StackPane root = new StackPane();
        root.getChildren().add(mainLayout);
        
        Scene scene = new Scene(root, 300, 250);
        return scene;
    }
    
}
