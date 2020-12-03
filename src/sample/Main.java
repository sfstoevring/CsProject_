package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("DEFENDaLOT");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();


    }


    public static void main(String[] args) throws ParseException, UnknownHostException {
        launch(args);

    }


}