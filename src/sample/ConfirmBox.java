package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

/**
 * Created by amine on 10/1/2016.
 */
public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);
        Label label1 = new Label();
        label1.setText(message);

        Button yesbutton =new Button("Yes");
        Button nobutton =new Button("No");

        yesbutton.setOnAction(e-> {
            answer = true ;
            window.close();
        });
        nobutton.setOnAction(e-> {
            answer = false ;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,yesbutton,nobutton);
        layout.setAlignment(CENTER);
        Scene scene = new Scene(layout,200,200);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}












