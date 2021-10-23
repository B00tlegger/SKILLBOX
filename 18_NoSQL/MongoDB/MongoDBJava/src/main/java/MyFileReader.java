import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
    private ArrayList<String> allLines;
    private String path;

    public MyFileReader(String path){
        this.path = path;
        reedFile();
    }

    public void reedFile (){
        allLines = new ArrayList<>();
        try {
            allLines = (ArrayList<String>) Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllLines(){
        return allLines;
    }

    public String getLine(int lineNumber){
        return allLines.get(lineNumber);
    }
}
