import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVReader {

    private HashMap<String, ArrayList<String>> data;

    public HashMap<String, ArrayList<String>> getData(){
        return data;
    }

    public CSVReader(String path) throws IOException {
        ArrayList<String> headersplit;
        BufferedReader bufferedReader;
        data = new HashMap<>();
        try {
            FileReader file = new FileReader(path);
            bufferedReader = new BufferedReader(file);
            String headings = bufferedReader.readLine();
            headersplit = parseLine(headings);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        //HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
        for (String heading : headersplit) {
            data.put(heading, new ArrayList<String>());
        }
        while(true){
            String currentLine = bufferedReader.readLine();
            if(currentLine == null){
                break;
            }
            ArrayList<String> lineSplit = parseLine(currentLine);
            for (int i=0; i<data.size(); i++) {
                String heading=headersplit.get(i);
                data.get(heading).add(lineSplit.get(i));
            }
        }
    }
    private ArrayList<String> parseLine(String line) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        boolean inquote = false;
        String temp_phrase = new String();
        for(int i=0 ; i<line.length(); i++) {
            if(line.charAt(i)=='"') {
                inquote = !inquote;
                continue;
            }
            if (inquote) {
                temp_phrase += line.charAt(i);
                continue;
            }
            if(line.charAt(i)==',') {
                if (temp_phrase.length() > 0) {
                    list.add(temp_phrase);
                    temp_phrase = new String();
                }
            }
            else{
                temp_phrase += line.charAt(i);
            }
        }
        if (temp_phrase.length() > 0) {
            list.add(temp_phrase);
        }
        return list;


    }
}
