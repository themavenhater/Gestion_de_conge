package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by amine on 10/5/2016 10:49 AM.
 */
public class listedesemploye extends Application{
    Stage windows;
    Scene intro_scene;
    BorderPane pane;
    ObservableList<String> names;

    public static void main(String[] args) {launch(args);}

    public void start(Stage primaryStage) {

        names = FXCollections.observableArrayList(
                Font.getFamilies());
        ListView<String> liste = new ListView<String>(names);

        pane = new BorderPane();
        pane.setCenter(liste);

        intro_scene =new Scene(pane,800,600);

        windows.setScene(intro_scene);
        windows.show();
        windows.setResizable(false);
    }

}
