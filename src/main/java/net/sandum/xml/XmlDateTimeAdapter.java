package net.sandum.xml;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author osa
 */
public class XmlDateTimeAdapter extends XmlAdapter<String, Date> {

    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public Date unmarshal(String s) throws ParseException {
        return df.parse(s);
    }

    @Override
    public String marshal(Date d) {
        return df.format(d);
    }

}
