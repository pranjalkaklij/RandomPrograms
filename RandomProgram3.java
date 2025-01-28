import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomProgram3 {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("PATH==> "+System.getenv("OUTPUT_PATH"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = bufferedReader.readLine();

            String result = Result3.timeConversion(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("print -- "+e);
        }
        
    }
}
class Result3 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    String formated_24hString = "";
    if (!s.equals(null) && !s.equals("null")) {
       int min = Integer.parseInt(s.substring(0, 2));
       String AmPm = s.substring(8,10);
       
       if(AmPm.equalsIgnoreCase("PM")){
        if (min != 12) {
            min = min + 12;
        }
        formated_24hString = min + s.substring(2, 8);
       }
       else if(AmPm.equalsIgnoreCase("AM"))
       {
        if (min == 12) {
            formated_24hString = "00" + s.substring(2, 8);
        }
        else if (min<10) {
            formated_24hString = "0" +min+ s.substring(2, 8);
        }
        else
        {
            formated_24hString = min+ s.substring(2, 8);
        }
        
       }

    }
    return formated_24hString;

    }

}
