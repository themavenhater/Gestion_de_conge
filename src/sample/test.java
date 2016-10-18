package sample;

/**
 * Created by amine on 10/5/2016 3:25 PM.
 */
public class test {
    public static void main(String[] args)
    {
        String ss = "1..moh..krakra..20";
        String[] splited = ss.split("\\..");
        int id = Integer.parseInt(splited[0]);
        System.out.println(id);
        System.out.println(splited[1]);
    }
}
