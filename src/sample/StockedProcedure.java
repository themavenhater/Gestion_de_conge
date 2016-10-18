package sample;

import javafx.scene.control.ComboBox;

import java.sql.*;

/**
 * Created by amine on 10/3/2016.
 */
public class StockedProcedure {

    public static Connection c;
    public static Statement stmt;

    public static void nomprenom(ComboBox<String> kk){

         c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C:/Users/amine/Documents/mobilis.sqlite "; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT id,nom,prenom FROM employes ;" );

            while ( rs.next() ) {

                String  name = rs.getInt("id")+"  "+rs.getString("nom")+" "+rs.getString("prenom");
                kk.getItems().add(name);
            }
            rs.close();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        new ComboBoxAutoComplete<>(kk);
    }

    public static void addcongé(String debut ,String fini , String lieu ,int id_intérime  ,int id_employé){
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C:/Users/amine/Documents/mobilis.sqlite "; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();

            PreparedStatement prep = c.prepareStatement(
                    "INSERT INTO info_congé (id_employé,debut,fin, lieu_de_juissance, id_intérimaire)\n" +
                    "VALUES (?,?,?,?,?);");

            prep.setInt(1,id_employé);
            prep.setString(2,debut);
            prep.setString(3,fini);
            prep.setString(4,lieu);
            prep.setInt(5,id_intérime);
            prep.execute();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


    public static void add_abs_sort(int id_employé, int typee, String desire, String motif, String datee) {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C:/Users/amine/Documents/mobilis.sqlite "; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();


            PreparedStatement prep = c.prepareStatement(
                    "INSERT INTO info_sortie (id_employe,type,Desire,motif,date_sortie)\n" +
                            "VALUES (?,?,?,?,?);");

            prep.setInt(1,id_employé);
            prep.setInt(2,typee);
            prep.setString(3, desire);
            prep.setString(4, motif);
            prep.setString(5, datee);
            prep.execute();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void info_employé() {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C:/Users/amine/Documents/mobilis.sqlite ";
            // create a connection to the database
            c = DriverManager.getConnection(url);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employes ;");

            while (rs.next()) {

                int id = rs.getInt(1); //+"  "+rs.getString("nom")+" "+rs.getString("prenom");
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String fonction = rs.getString(4);
                String date_recru = rs.getString(5);
                int nb_conge = rs.getInt(6);
                String struct = rs.getString(8);
                //listedesemploye.addrows(id,nom,prenom,fonction,date_recru,nb_conge,struct);
                //listedesemploye.data.add(new listedesemploye.Person(id,nom,prenom,fonction,date_recru,struct,nb_conge)) ;
                sample.data.add(new sample.Person(id, nom, prenom, fonction, date_recru, struct, nb_conge));

            }
            rs.close();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }



}
