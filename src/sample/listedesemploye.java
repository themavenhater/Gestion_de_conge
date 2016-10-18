package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class listedesemploye extends Application {

    public static ObservableList<Person> data = FXCollections.observableArrayList();
    public TableView table = new TableView();
    TableColumn id, nom, prenom, fonction, date_recrutement, nb_congé, structureacc;

    public static void main(String[] args) {
        launch(args);
    }

    public static void addrows(int id, String nom, String prenom, String fonction, String date_recru, int nb_conge, String struct) {
        data = FXCollections.observableArrayList(new Person(id, nom, prenom, fonction, date_recru, struct, nb_conge));

    }

    @Override
    public void start(Stage stage) {


        Scene scene = new Scene(new Group());
        stage.setWidth(800);
        stage.setHeight(600);
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


        ((Group) scene.getRoot()).getChildren().addAll(table);

        stage.setScene(scene);
        stage.show();
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

        public Person(int id_id, String fName, String lName, String fonc, String date, String struct, int nb) {
            this.id = new SimpleStringProperty(String.valueOf(id_id));
            this.nom = new SimpleStringProperty(fName);
            this.prenom = new SimpleStringProperty(lName);
            this.fonction = new SimpleStringProperty(fonc);
            this.date = new SimpleStringProperty(date);
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
