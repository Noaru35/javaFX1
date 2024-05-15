package helloworld.hellor.world.jfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.DoubleStringConverter;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    	
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var button = new Button("OK");
        
        var label = new Label("CALCULADORA DE IMC");
        
        TextField textFieldIdade = new TextField();
        TextField textFieldPeso = new TextField();
        
        textFieldIdade.setTextFormatter(new TextFormatter<>(new DoubleStringConverter()));
        textFieldPeso.setTextFormatter(new TextFormatter<>(new DoubleStringConverter()));
        
        BorderPane layout = new BorderPane();
        layout.setTop(label); 
        
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
        		new VBox(new Label("Altura"), textFieldIdade),
        		new VBox(new Label("Peso"), textFieldPeso),
        		button
        		);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        
        layout.setCenter(vbox);
        
        BorderPane.setAlignment(label, Pos.CENTER);
        BorderPane.setAlignment(vbox, Pos.CENTER);
        
        BorderPane.setMargin(vbox, new Insets(10 ,10 ,10 ,10));
        
        button.setOnAction(event ->{
        	double altura = Double.parseDouble(textFieldIdade.getText());
        	double peso = Double.parseDouble(textFieldPeso.getText());
        	double imc = peso / (altura * 2);
        	
        	Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText(null);
            alert.setContentText("Seu imc é: " + imc );
            alert.showAndWait();
        	
        });
        
        var scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}