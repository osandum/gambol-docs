package gambol.xml;

import java.net.URL;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import net.sandum.xml.GambolHelper;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author osa
 */
public class ClubParserTest {

    Schema schema;
    JAXBContext jaxbContext;

    @Before
    public void setUp() throws JAXBException, SAXException {
        jaxbContext = JAXBContext.newInstance(Club.class);

        assertNotNull(jaxbContext);

        schema = GambolHelper.getSchema();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void parseClub() throws JAXBException {
        URL src = getClass().getResource("/sample/club-ksf.xml");
        Unmarshaller um = jaxbContext.createUnmarshaller();
        um.setSchema(schema);
        Club ksf = (Club) um.unmarshal(src);
        assertNotNull(ksf);
    }
}
