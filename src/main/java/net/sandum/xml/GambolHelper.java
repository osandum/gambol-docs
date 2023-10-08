package net.sandum.xml;

import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author osa
 */
public class GambolHelper {

  private static final URL GAMBOL_XSD = GambolHelper.class.getClassLoader().getResource("META-INF/xsd/gambol.xsd");

  private GambolHelper() {}

    public static Schema getSchema() {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            return sf.newSchema(GAMBOL_XSD);
        }
        catch (SAXException ex) {
            throw new RuntimeException(ex);
        }
    }
}
