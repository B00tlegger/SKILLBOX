
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Loader {

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";

        parseFile(fileName);

        //Printing results
        DBConnection.uniqueDB();
        DBConnection.printVoterCounts();

    }

    public static void parseFile(String fileName) throws ParserConfigurationException, SAXException, IOException {
        long timer = System.currentTimeMillis();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        DBConnection.insertMultiQuery();
        timer = System.currentTimeMillis() - timer;
        System.out.println(timer + " ms");
        DBConnection.uniqueDB();
    }
}