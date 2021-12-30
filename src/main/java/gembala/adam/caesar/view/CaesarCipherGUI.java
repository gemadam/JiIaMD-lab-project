/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gembala.adam.caesar.view;

import gembala.adam.caesar.controller.CaesarCipherController;
import gembala.adam.caesar.model.HistoryRecord;
import gembala.adam.caesar.validation.ValidatorException;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * GUI class of caesar cipher application
 * @author Adam
 * @version 1.0.0
 */
public class CaesarCipherGUI {
    
    /**
     * Controller used by GUI
     */
    CaesarCipherController c;
    
    /**
     * Alert used to display runtime errors and warnings
     */
    Alert a;
    
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
     * Table view with operation's history
     */
    TableView tabHistory;
    
    /**
     * Default constructor, initializes the instance of the class
     */
    public CaesarCipherGUI()
    {
        c = new CaesarCipherController();
        a = new Alert(AlertType.NONE);
        
        txtPublicText = new TextField();
        txtShift = new TextField();
        txtResult = new TextField();
        tabHistory = createHistoryTable();
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
        
        m1.setOnAction(event -> {
            if(txtShift.getText().contains("-"))
            {
                txtShift.setText(txtShift.getText().replace("-", ""));
            }
            
        });
        m2.setOnAction(event -> {
            if(!txtShift.getText().contains("-"))
            {
                txtShift.setText("-" + txtShift.getText());
            }
        });
        
        m.getItems().add(m1);
        m.getItems().add(m2);
  
        MenuBar mb = new MenuBar();
  
        mb.getMenus().add(m);
        
        return mb;
    }
    
    /**
     * Method creates history table view
     * @return Created table view
     */
    public TableView createHistoryTable()
    {
        var view = new TableView();
        
        var col1 = new TableColumn<HistoryRecord, String>("Public text");
        col1.setCellValueFactory(new PropertyValueFactory<>("publicText"));
        
        var col2 = new TableColumn<HistoryRecord, String>("Encrypted text");
        col2.setCellValueFactory(new PropertyValueFactory<>("privateText"));
        
        var col3 = new TableColumn<HistoryRecord, String>("Encryption key");
        col3.setCellValueFactory(new PropertyValueFactory<>("encryptionKey"));
        
        var col4 = new TableColumn<HistoryRecord, String>("Decryption key");
        col4.setCellValueFactory(new PropertyValueFactory<>("decryptionKey"));
        
        
        view.getColumns().add(col1);
        view.getColumns().add(col2);
        view.getColumns().add(col3);
        view.getColumns().add(col4);
        
        return view;
    }
    
    /**
     * Method creates initialized scene
     * @return Caesar cipher GUI scene
     */
    public Scene makeScene()
    {
        Button btnRun = new Button();
        btnRun.setText("Shift text");
        btnRun.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override public void handle(ActionEvent e) {
                
                try {
                    var iShift = Integer.parseInt(txtShift.getText());
                    
                    var sPublicText = txtPublicText.getText();
                    
                    var sEncryptedText = c.encrypt(sPublicText, iShift);
                    
                    txtResult.setText(sEncryptedText);
                    
                    tabHistory.getItems().add(new HistoryRecord(sPublicText, sEncryptedText, iShift, -iShift));
                }
                catch(ValidatorException ex)
                {
                    a.setAlertType(AlertType.ERROR);
                    a.setTitle("Validation error.");
                    a.setContentText(ex.getMessage());
                    
                    a.show();
                }
                catch(NumberFormatException ex)
                {
                    a.setAlertType(AlertType.ERROR);
                    a.setTitle("Number format error.");
                    a.setContentText("Shift has to be a integer number!");
                    
                    a.show();
                }
            }
            
        });
        
        Label label1 = new Label("Text to shift:");
        Label label2 = new Label("Key:");
        Label lbResult = new Label("Result: ");
  
        // create a VBox
        VBox menuLayout = new VBox(createMenuBar());
        
        VBox mainLayout = new VBox();
        mainLayout.setSpacing(10);

        mainLayout.getChildren().addAll(label1, txtPublicText, label2, txtShift, lbResult, txtResult, btnRun);
        
        menuLayout.getChildren().add(mainLayout);
        
        StackPane root = new StackPane();
        root.getChildren().add(menuLayout);
        
        SplitPane split_pane = new SplitPane();
        
        split_pane.getItems().add(root);
        split_pane.getItems().add(tabHistory);
        
        Scene scene = new Scene(split_pane, 700, 500);
        return scene;
    }
    
}
