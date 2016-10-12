package sample;

/**
 * Created by amine on 10/5/2016 3:25 PM.
 */
public class test {
    public static void main(String[] args)
    {
        String ss = "sfsfiergferger.zef.zefzef/ergezrgze/ezrgerg efozpejf .. zefzepjf // zefpzejf";
        String[] splited = ss.split("\\.");
        for (int i = 0; i<splited.length;i++)
        {
            System.out.println(splited[i]);
        }
    }
}
