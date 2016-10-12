package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

import static java.time.LocalDate.*;


/**
 * Created by amine on 10/1/2016 9:53 AM.
 */

public class sample extends Application {

    Stage window;
    Scene intro_scene;
    BorderPane pane;
    GridPane login_pane,conge_pane,absrc_pane;
    FlowPane flow;
    VBox intro,info_pane,modif_pane,demand_pane;
    Button login,info,modifier,demande,rc,absence,congé,sortie,retour,retour_demande,retour_modif,retour_info,retout_abssort,confirm_congé,confirm_absrc;
    Label title ;
    ComboBox<String> names,interim;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        //add Title ====================================================================================================
        title= new Label("Gestion De Congé");
        title.setFont(Font.font("Amble CN" ,FontWeight.EXTRA_LIGHT,25));

        //create Buttons================================================================================================
        //Login
        login = new Button("Login");
        login.setStyle("-fx-font: 18 arial; -fx-base: #42ff1d;");
        info = new Button("information");
        info.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        modifier = new Button("modifier");
        modifier.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        demande = new Button("demande");
        demande.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        rc = new Button("recuperation");
        rc.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        absence = new Button("abs");
        absence.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        congé = new Button("congé");
        congé.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        sortie= new Button("sortie");
        sortie.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        retour = new Button("<<----");
        retour.setStyle("-fx-font: 18 arial; -fx-base: #ecee0f;");retour.setMaxSize(200,100);

        //Login pane ===================================================================================================
        login_pane = new GridPane();
        login_pane.setPadding(new Insets(10, 10, 10, 10));
        login_pane.setMinSize(300, 300);
        login_pane.setVgap(5);
        login_pane.setHgap(5);
        Text username = new Text("Username:");
        login_pane.add(username, 0, 0);
        TextField text = new TextField();
        text.setPrefColumnCount(10);
        login_pane.add(text, 1, 0);
        Text password = new Text("Password:");
        login_pane.add(password, 0, 1);
        TextField text2 = new TextField();
        text2.setPrefColumnCount(10);
        login_pane.add(text2, 1, 1);
        login.setMaxSize(100,100);
        login_pane.add(login,1,2);
        login_pane.setStyle("-fx-background-color: #5ed88f;");

        //congé pane ==================================================================================================
        conge_pane = new GridPane();
        setPane(conge_pane);
        Text du = new Text("Du :");
        conge_pane.add(du,0,7);
        DatePicker datePicker = new DatePicker();
        conge_pane.add(datePicker,1,7);
        Text Au = new Text("Au :");
        conge_pane.add(Au,0,10);
        DatePicker datePicker2 = new DatePicker();
        conge_pane.add(datePicker2,1,10);
        Text lieu = new Text("Lieu de juissance");
        conge_pane.add(lieu,0,12);
        TextField lieujuis = new TextField();
        conge_pane.add(lieujuis,1,12);
        ToggleGroup group = new ToggleGroup();
        ToggleButton inter1 = new ToggleButton("normal");
        inter1.setSelected(true);
        ToggleButton inter2 = new ToggleButton("superieure");
        inter2.setToggleGroup(group);
        final ToggleGroup tg = new ToggleGroup();
        HBox rbContainer = new HBox(20,inter1,inter2);
        inter1.setToggleGroup(tg);
        inter2.setToggleGroup(tg);
        conge_pane.add(rbContainer,1,14);
        Text nominter = new Text("nom prénom de l'intérimaire");
        nominter.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        conge_pane.add(nominter,0,20);
        nominter.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        interim = new ComboBox<>();
        interim.setStyle("-fx-font: 18 arial; -fx-base: #62ee3b;");
        conge_pane.add(interim,1,20);
        StockedProcedure.nomprenom(interim);
        confirm_congé = new Button("Confirm");
        conge_pane.add(confirm_congé,1,23);
        Text erreur = new Text("champ obligatoire");
        erreur.setStyle("-fx-font: 18 arial; -fx-background-color: #5245ee;");
        retour_demande = new Button("Retour");
        retour_demande.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        conge_pane.add(retour_demande,1,35);

        //sortie_absence================================================================================================
        absrc_pane=new GridPane();
        setPane(absrc_pane);
        Text date = new Text("Date :");
        date.setStyle("-fx-font: 18 arial;");
        absrc_pane.add(date,0,3);
        DatePicker date_abs_sort = new DatePicker();
        date_abs_sort.setStyle("-fx-font: 18 arial;");
        absrc_pane.add(date_abs_sort,1,3);
        Text desire = new Text("Desire :");
        desire.setStyle("-fx-font: 18 arial;");
        absrc_pane.add(desire,0,4);
        Text motif = new Text("Motif :");
        motif.setStyle("-fx-font: 18 arial;");
        absrc_pane.add(motif,0,5);
        TextField motiftxt = new TextField();
        absrc_pane.add(motiftxt,1,5);
        TextField desiretxt = new TextField();
        absrc_pane.add(desiretxt,1,4);
        confirm_absrc = new Button("Confirm");
        absrc_pane.add(confirm_absrc,1,23);
        retout_abssort = new Button("Retour");
        retout_abssort.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        absrc_pane.add(retout_abssort,1,35);
        // date_abs_sort motiftxt desiretxt




        // VBOXes ======================================================================================================
        // intro Vbox ======================================
        intro = new VBox(20,info,demande,modifier);
        intro.setPadding(new Insets(100, 100, 100, 100));
        info.setMaxSize(200,100);
        demande.setMaxSize(200,100);
        modifier.setMaxSize(200,100);
        //information Vbox==================================
        info_pane = new VBox(20);
        info_pane.setPadding(new Insets(100, 100, 100, 100));
        //modifier Vbox ====================================
        modif_pane = new VBox(20);
        modif_pane.setPadding(new Insets(100, 100, 100, 100));
        //demande Vbox======================================
        demand_pane = new VBox(20,rc,absence,congé,sortie);
        demand_pane.setPadding(new Insets(100, 100, 100, 100));
        rc.setMaxSize(200,100);
        absence.setMaxSize(200,100);
        congé.setMaxSize(200,100);
        sortie.setMaxSize(200,100);

        //Title Pan ====================================================================================================
        flow = new FlowPane();
        flow.setPadding(new Insets(10, 10, 10, 10));
        flow.setStyle("-fx-background-color: DAE6F3;");
        flow.getChildren().addAll(title);

        //add pane's to the Main pane ==================================================================================
        pane = new BorderPane();
        pane.setLeft(login_pane);
        pane.setTop(flow);
        //pane.setCenter(intro);

        intro_scene = new Scene(pane,1200,650);
        window.setTitle("Title Here");
        window.setOnCloseRequest(e -> {e.consume(); closeProgram();});
        window.setScene(intro_scene);
        window.show();
        window.setResizable(false);

        //Button action=================================================================================================
        login.setOnAction(e-> pane.setCenter(intro));
        demande.setOnAction(e-> {delete(demand_pane);demand_pane.getChildren().addAll(retour);});
        retour.setOnAction(e-> delete(intro));
        info.setOnAction(e-> { delete(info_pane);info_pane.getChildren().addAll(retour);});
        modifier.setOnAction(e-> {delete(modif_pane);modif_pane.getChildren().addAll(retour);});
        confirm_congé.setOnAction(e->
        {
           conge_pane.getChildren().removeAll(erreur);
            if (names.getValue()==null ||datePicker.getValue()==null ||
                datePicker2.getValue()==null||lieujuis.getText()==null || interim.getValue()==null){
                conge_pane.add(erreur,1,24);}
            else {  String information_congé = names.getValue()+" "+datePicker.getValue()+" " +
                datePicker2.getValue()+" "+lieujuis.getText()+" "+interim.getValue();
            System.out.println(information_congé);
            setinformation_congé(information_congé);}
        });
        congé.setOnAction(e-> {pane.setRight(conge_pane) ; demand_pane.setMouseTransparent(true);     });
        retour_demande.setOnAction(e-> { pane.setRight(null);demand_pane.setMouseTransparent(false);  });
        absence.setOnAction(e->{pane.setRight(absrc_pane) ; demand_pane.setMouseTransparent(true);    });

        confirm_absrc.setOnAction(e->
        {

            absrc_pane.getChildren().removeAll(erreur);
            if (names.getValue()!=null&&date_abs_sort.getValue()!=null && motiftxt.getText()!=null && desiretxt.getText()!=null)
            {
                String information_abs_sortie =names.getValue()+"."+date_abs_sort.getValue()+"."+motiftxt.getText()+"."+desiretxt.getText();
                //setinformation_abs_sort(information_abs_sortie,1);
            }
            else if (names.getValue()==""||date_abs_sort.getValue()==(LocalDate.parse("")) || motiftxt.getText()=="" || desiretxt.getText()==""){
                names.getEditor().clear();
                date_abs_sort.getEditor().clear();
                motiftxt.clear();
                desiretxt.clear();
                absrc_pane.add(erreur,1,24);

            }
        });

    }

    private void setinformation_congé(String inform){
        String[] splited = inform.split("\\s+");
        int id_employé=Integer.parseInt(splited[0]);
        String nom = splited[1];
        String prenom =splited[2];
        String début= splited[3];
        String fin = splited[4];
        String liue =splited[5];
        int id_intérimaire = Integer.parseInt(splited[6]);

        StockedProcedure.addcongé(début,fin,liue,id_intérimaire,id_employé);
    }

    private void setinformation_abs_sort(String inform,int type)
    {
        String[] splited = inform.split("\\.");
        String[] nomprenom= splited[0].split("\\s+");
        int id_employé=Integer.parseInt(nomprenom[0]);
        String nom = nomprenom[1];
        String prenom =nomprenom[2];
        String date = splited[1];
        String motif = splited[2];
        String desire = splited[3];
        //StockedProcedure.add_abs_sort(id_employé,1,);

    }


    private void delete(Node kk){
        pane.setCenter(null);
        pane.setCenter(kk);
        demand_pane.getChildren().removeAll(retour);
        info_pane.getChildren().remove(retour);
        modif_pane.getChildren().remove(retour);
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("stupid title", " exit ?");
        System.out.println(answer);
        if(answer){
            window.close();
        }
    }

    private void deleteinfo(){}

    private void setPane(GridPane pane){

        pane.setStyle("-fx-background-color: #d86f44;");
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(5);
        pane.setHgap(5);
        Text nom = new Text("Nom prénom de l'employé");
        nom.setStyle("-fx-font: 18 arial; -fx-base: #3133ee;");
        pane.add(nom,0,2);
        names = new ComboBox<>();
        names.setStyle("-fx-font: 18 arial; -fx-base: #62ee3b;");
        pane.add(names,1,2);
        StockedProcedure.nomprenom(names);
    }

}