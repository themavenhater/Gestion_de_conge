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



    public static void add_abs_sort(int id_employé, int typee,String affectation,String desire,String motif){
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C:/Users/amine/Documents/mobilis.sqlite "; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();

            PreparedStatement prep = c.prepareStatement(
                    "INSERT INTO info_sortie (id_employe,type,affectation,Desire,motif,)\n"  +
                            "VALUES (?,?,?,?,?);");

            prep.setInt(1,id_employé);
            prep.setInt(2,typee);
            prep.setString(3,affectation);
            prep.setString(4,desire);
            prep.setString(5,motif);
            prep.execute();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }



}
