import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    public CSVReader(String path) {
        FileReader file = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(file);
        String headings = bufferedReader.readLine();

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
