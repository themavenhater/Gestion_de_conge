package sample;

import javafx.scene.control.ComboBox;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Created by amine on 10/3/2016.
 */
public class StockedProcedure {

    public static Connection c;
    public static Statement stmt;
    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy ");
    static java.util.Date dateobj = new java.util.Date();

    public static void nomprenom(ComboBox<String> kk) {

        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite ";
            // create a connection to the database
            c = DriverManager.getConnection(url);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,nom,prenom FROM employes ;");

            while (rs.next()) {

                String name = rs.getInt("id") + "  " + rs.getString("nom") + " " + rs.getString("prenom");
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

    public static void addcongé(String nom, String prenom, String debut, String fini, String lieu, int id_employé, int id_interim) {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite ";
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM employes WHERE id=" + id_employé + ";");

            String fonction = rs.getString(4);
            String date_recru = rs.getString(5);
            String struct = rs.getString(8);
            replace.replace_info(1, nom, prenom, date_recru, fonction, struct, debut, fini, lieu);

            PreparedStatement prep = c.prepareStatement(
                    "INSERT INTO info_congé (id_employé,debut,fin, lieu_de_juissance, id_intérimaire)\n" +
                            "VALUES (?,?,?,?,?);");

            prep.setInt(1, id_employé);
            prep.setString(2, debut);
            prep.setString(3, fini);
            prep.setString(4, lieu);
            prep.setInt(5, id_interim);
            prep.execute();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void add_abs_sort(int id_employé, String nom, String prenom, int typee, String desire, String motif, String datee) {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite "; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT * FROM employes WHERE id=" + id_employé + ";");

            String fonction = rs.getString(4);
            String date_recru = rs.getString(5);
            String struct = rs.getString(8);
            replace.replace_info(2, nom, prenom, date_recru, fonction, struct, datee, desire, motif);

            PreparedStatement prep = c.prepareStatement(
                    "INSERT INTO info_sortie (id_employe,type,Desire,motif,date_sortie)\n" +
                            "VALUES (?,?,?,?,?);");

            prep.setInt(1, id_employé);
            prep.setInt(2, typee);
            prep.setString(3, desire);
            prep.setString(4, motif);
            prep.setString(5, df.format(dateobj));
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
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite ";
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

    public static void info_rc() {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite ";
            // create a connection to the database
            c = DriverManager.getConnection(url);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM info_rc ;");

            while (rs.next()) {

                int id = rs.getInt(1);
                String du = rs.getString(2);
                String au = rs.getString(3);
                String motif = rs.getString(4);
                int id_emoloi = rs.getInt(5);

                sample.rc_data.add(new sample.rc_Person(id, du, au, motif, id_emoloi));
            }
            rs.close();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void info_abs() {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite ";
            // create a connection to the database
            c = DriverManager.getConnection(url);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM info_sortie ;");

            while (rs.next()) {

                int id = rs.getInt(1);
                int type = rs.getInt(2);
                String desire = rs.getString(3);
                String motif = rs.getString(4);
                String date = rs.getString(5);
                int id_emoloi = rs.getInt(6);
                sample.abs_data.add(new sample.abs_Person(id, type, desire, motif, date, id_emoloi));
            }
            rs.close();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void info_cong() {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite";
            // create a connection to the database
            c = DriverManager.getConnection(url);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM info_congé ;");

            while (rs.next()) {

                int id = rs.getInt(1);
                int id_emp = rs.getInt(2);
                String debut = rs.getString(3);
                String fin = rs.getString(4);
                String lieu = rs.getString(5);
                int id_inter = rs.getInt(6);
                sample.cong_data.add(new sample.cong_Person(id, id_emp, debut, fin, lieu, id_inter));
            }
            rs.close();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void modify_emploi(int id, String sd) {

        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite "; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();
            PreparedStatement prep = null;

            prep = c.prepareStatement(
                    "UPDATE employes SET structure_actuelle=? WHERE id=?;");
            prep.setString(1, sd);
            prep.setInt(2, id);
            prep.execute();
            stmt.close();
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void add_employé(String nom, String prenom, String fonction, String date_recru, String struct) {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite"; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();

            PreparedStatement prep = null;

            prep = c.prepareStatement(
                    "INSERT INTO employes (nom,prenom, fonction,date_recrutement,structure_actuelle)\n" +
                            "VALUES (?,?,?,?,?);");
            prep.setString(1, nom);
            prep.setString(2, prenom);
            prep.setString(3, fonction);
            prep.setString(4, date_recru);
            prep.setString(5, struct);
            prep.execute();
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete_emploi(int id) {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite"; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();

            PreparedStatement prep = null;
            prep = c.prepareStatement(
                    "DELETE FROM employes WHERE id=" + id + ";");

            prep.execute();
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add_rc(String nom, String prenom, String debut, String fini, int id_employé, String motif) {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite"; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database

            c = DriverManager.getConnection(url);

            stmt = c.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT * FROM employes WHERE id=" + id_employé + ";");

            String fonction = rs.getString(4);
            String date_recru = rs.getString(5);
            String struct = rs.getString(8);
            replace.replace_info(3, nom, prenom, date_recru, fonction, struct, debut, fini, motif);

            PreparedStatement prep = c.prepareStatement(
                    "INSERT INTO info_rc (du,au,motif_rc, id_employé)\n" +
                            "VALUES (?,?,?,?);");

            prep.setString(1, debut);
            prep.setString(2, fini);
            prep.setString(3, motif);
            prep.setInt(4, id_employé);
            prep.execute();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void change_struct(int id, String sd) {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite"; //C:\Users\amine\Documents\mobilis.sqlite
            // create a connection to the database
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();

            PreparedStatement prep = null;
            prep = c.prepareStatement(
                    "INSERT INTO id_struct (date_changement,id_employe,type_structure) VALUES (?,?,?)");
            prep.setString(1, df.format(dateobj));
            prep.setInt(2, id);
            prep.setString(3, sd);
            prep.execute();
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void info_struct() {
        c = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:stagiaire/mobilis.sqlite ";
            // create a connection to the database
            c = DriverManager.getConnection(url);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM id_struct ;");

            while (rs.next()) {

                int id = rs.getInt(1); //+"  "+rs.getString("nom")+" "+rs.getString("prenom");
                String date_chang = rs.getString(2);
                int id_empl = rs.getInt(3);
                String type_struct = rs.getString(4);
                sample.struct_data.add(new sample.struc_Person(id, date_chang, id_empl, type_struct));
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


