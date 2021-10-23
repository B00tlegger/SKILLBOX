import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    int i = 0;

    public XMLHandler() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("voter")) {
            String birthDay = attributes.getValue("birthDay");
            String name = attributes.getValue("name");
            try {
                DBConnection.countVoter(name, birthDay);
                i++;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
