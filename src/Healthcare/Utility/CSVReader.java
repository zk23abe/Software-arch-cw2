package Healthcare.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    private ArrayList< ArrayList<String>> data;
    private ArrayList<String> headers;
    public ArrayList<String> getHeaders(){
        return this.headers;
    }
    public ArrayList< ArrayList<String>> getData(){
        return data;
    }

    public CSVReader(String path) throws IOException {
        ArrayList<String> headersplit;
        BufferedReader bufferedReader;
        data = new ArrayList<>();
        try {
            FileReader file = new FileReader(path);
            bufferedReader = new BufferedReader(file);
            String headings = bufferedReader.readLine();
            headers = parseLine(headings);
        } catch (Exception e) {

            return;
        }

        while(true){
            String currentLine = bufferedReader.readLine();
            if(currentLine == null){
                break;
            }
            ArrayList<String> lineSplit = parseLine(currentLine);

            this.data.add(lineSplit);
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
