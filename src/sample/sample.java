package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by amine on 10/1/2016 9:53 AM.
 */

public class sample extends Application {

    public static ObservableList<Person> data = FXCollections.observableArrayList();
    public TableView table = new TableView();
    Stage window;
    Scene intro_scene;
    BorderPane pane;
    GridPane login_pane,conge_pane,absrc_pane;
    FlowPane flow;
    VBox intro,info_pane,modif_pane,demand_pane;
    Button login, info, modifier, demande, rc, absence, congé, show_employe, show_conge, sortie,
            retour, retour_demande, retour_info_employé, retout_abssort, confirm_congé, confirm_absrc,
            info_rc, info_sortie, info_abs, info_conge;
    Label title ;
    ListView list_rc, list_conge, list_abs, list_sortie;
    ComboBox<String> names,interim;
    TableColumn id, nom, prenom, fonction, date_recrutement, nb_congé, structureacc;

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
        retour.setStyle("-fx-font: 18 arial; -fx-base: #ecee0f;");
        retour.setMaxSize(200, 100);
        show_conge = new Button("info congé");
        show_conge.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        show_employe = new Button("info employé");
        show_employe.setStyle("-fx-font: 18 arial; -fx-base: #2d46ee;");
        retour_info_employé = new Button("<--");
        retour_info_employé.setStyle("-fx-font: 18 arial; -fx-base: #ecee0f;");
        retour_info_employé.setMaxSize(200, 100);


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

        //absrc_pane================================================================================================
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
        Text erreur2 = new Text("date érroné");
        erreur2.setStyle("-fx-font: 18 arial; -fx-background-color: #5245ee;");


        //TableView=====================================================================================================
        //epoloyes==========================================
        table.setMinSize(750, 550);
        id = new TableColumn("ID");
        nom = new TableColumn("Nom");
        prenom = new TableColumn("Prénom");
        date_recrutement = new TableColumn("date");
        fonction = new TableColumn("fonction");
        nb_congé = new TableColumn("nombre de congé");
        structureacc = new TableColumn("structure Actuelle");

        create_column(id, "ID", 30, 40);
        id.setSortType(TableColumn.SortType.ASCENDING);
        create_column(nom, "nom", 100, 120);
        create_column(prenom, "Prénom", 100, 120);
        create_column(fonction, "Fonction", 150, 150);
        create_column(date_recrutement, "Date de recrutement", 100, 110);
        create_column(nb_congé, "congé", 80, 40);
        create_column(structureacc, "Structure actuelle", 100, 150);

        table.getColumns().addAll(id, nom, prenom, fonction, date_recrutement, nb_congé, structureacc);
        StockedProcedure.info_employé();
        table.setItems(data);


        // VBOXes ======================================================================================================
        // intro Vbox ======================================
        intro = new VBox(20,info,demande,modifier);
        intro.setPadding(new Insets(100, 100, 100, 100));
        info.setMaxSize(200,100);
        demande.setMaxSize(200,100);
        modifier.setMaxSize(200,100);
        //information Vbox==================================
        info_pane = new VBox(20, show_employe, show_conge, retour);
        info_pane.setPadding(new Insets(100, 100, 100, 100));
        show_employe.setMaxSize(200, 100);
        show_conge.setMaxSize(200, 100);
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
        info.setOnAction(e -> {
            delete(info_pane);
            info_pane.getChildren().addAll(retour);
        });
        modifier.setOnAction(e-> {delete(modif_pane);modif_pane.getChildren().addAll(retour);});

        confirm_congé.setOnAction(e->
        {
            System.out.println();
           conge_pane.getChildren().removeAll(erreur);
            if (names.getValue() == null || lieujuis.getText() == null) {
                if (datePicker.getValue() == null || datePicker2.getValue() == null) conge_pane.add(erreur2, 1, 25);
                System.out.println("ifififif");
                conge_pane.add(erreur, 1, 24);
            } else {
                String information_congé = names.getValue() + " " + datePicker.getValue() + " " +
                        datePicker2.getValue() + " " + lieujuis.getText() + " " + interim.getValue();
                System.out.println(information_congé);
                setinformation(information_congé, 1);
                names.setValue(null);
                datePicker.setValue(null);
                datePicker2.setValue(null);
                interim.setValue(null);
                lieujuis.setText(null);
            }
        });
        confirm_absrc.setOnAction(e->
        {
            System.out.println(names.getValue());
            absrc_pane.getChildren().removeAll(erreur);
            absrc_pane.getChildren().removeAll(erreur2);
            if (names.getValue() == null || desiretxt.getText() == null || motiftxt.getText() == null) {
                absrc_pane.add(erreur, 1, 20);
                if (date_abs_sort.getValue() == null) absrc_pane.add(erreur2, 1, 20);
                date_abs_sort.setValue(null);
            } else
            {
                String information_congé2 = names.getValue() + " " + desiretxt.getText() + " " + motiftxt.getText() + " " + date_abs_sort.getValue();
                System.out.println(information_congé2);
                setinformation(information_congé2, 2);
                absrc_pane.getChildren().remove(erreur2);
                names.setValue(null);
                desiretxt.setText(null);
                motiftxt.setText(null);
                date_abs_sort.setValue(null);
            }

        });

        congé.setOnAction(e -> {
            pane.setRight(conge_pane);
            demand_pane.setMouseTransparent(true);
        });
        retour_demande.setOnAction(e ->
        {
            conge_pane.getChildren().remove(erreur);
            names.setValue(null);
            datePicker.setValue(null);
            datePicker2.setValue(null);
            interim.setValue(null);
            lieujuis.setText(null);
            pane.setRight(null);
            demand_pane.setMouseTransparent(false);

        });

        absence.setOnAction(e -> {
            pane.setRight(absrc_pane);
            demand_pane.setMouseTransparent(true);
        });
        retout_abssort.setOnAction(e ->
        {
            names.setValue(null);
            desiretxt.setText(null);
            motiftxt.setText(null);
            date_abs_sort.setValue(null);
            pane.setRight(null);
            demand_pane.setMouseTransparent(false);
        });
        show_employe.setOnAction(e -> {
            info_pane.setMouseTransparent(true);
            pane.setCenter(table);
            flow.getChildren().add(retour_info_employé);
        });
        retour_info_employé.setOnAction(e -> {
            flow.getChildren().remove(retour_info_employé);
            pane.setCenter(null);
            pane.setLeft(null);
            pane.setCenter(info_pane);
            pane.setLeft(login_pane);
            info_pane.setMouseTransparent(false);
        });
    }


    private void setinformation(String inform, int type) {
        String[] splited = inform.split("\\s+");
        /*int id_employé=Integer.valueOf(splited[0]);
        System.out.println(id_employé);
        String nom = splited[1];
        String prenom =splited[2];
        String début= ;
        String fin =
        String liue =;
        int id_intérimaire = Integer.parseInt(splited[6]);
        */
        if (type == 1)
            StockedProcedure.addcongé(splited[3], splited[4], splited[5], Integer.parseInt(splited[6]), Integer.valueOf(splited[0]));
        if (type == 2)
            StockedProcedure.add_abs_sort(Integer.parseInt(splited[0]), type, splited[3], splited[4], splited[5]);

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

    private void create_column(TableColumn nom_column, String nom, int size, int size2) {
        nom_column.setMinWidth(size);
        nom_column.setMaxWidth(size2);
        nom_column.setCellValueFactory(new PropertyValueFactory<>(nom));
    }

    public static class Person {

        private final SimpleStringProperty id;
        private final SimpleStringProperty nom;
        private final SimpleStringProperty prenom;
        private final SimpleStringProperty fonction;
        private final SimpleStringProperty date;
        private final SimpleStringProperty structureacc;
        private final SimpleStringProperty nb_congé;

        public Person(int id_id, String fName, String lName, String fonc, String datee, String struct, int nb) {
            this.id = new SimpleStringProperty(String.valueOf(id_id));
            this.nom = new SimpleStringProperty(fName);
            this.prenom = new SimpleStringProperty(lName);
            this.fonction = new SimpleStringProperty(fonc);
            this.date = new SimpleStringProperty(datee);
            this.structureacc = new SimpleStringProperty(struct);
            this.nb_congé = new SimpleStringProperty(String.valueOf(nb));

        }


        public String getID() {
            return id.get();
        }

        public void setID(int id_id) {
            id.set(String.valueOf(id_id));
        }


        public String getNom() {
            return nom.get();
        }

        public void setNom(String fName) {
            nom.set(fName);
        }

        public String getPrénom() {
            return prenom.get();
        }

        public void setPrénom(String lName) {
            prenom.set(lName);
        }

        public String getFonction() {
            return fonction.get();
        }

        public void setFonction(String fonc) {
            fonction.set(fonc);
        }

        public String getdate() {
            return date.get();
        }

        public void setdate(String datee) {
            date.set(datee);
        }

        public String getStructureacc() {
            return structureacc.get();
        }

        public void setStructureacc(String struct) {
            structureacc.set(struct);
        }

        public String getNb_congé() {
            return nb_congé.get();
        }

        public void setNb_congé(int nb) {
            nb_congé.set(String.valueOf(nb));
        }
    }
}

