
package org.mule.modules.handshake.core.transformers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Generated;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class StringToDateTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
    private int priorityWeighting = 1;

    public StringToDateTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(Date.class);
        setName("StringToDateTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        try {
            return SIMPLE_DATE_FORMAT.parse(src.toString());
        } catch (ParseException e) {
            throw new TransformerException(MessageFactory.createStaticMessage(String.format("Could not parse %s using the format %s", src, SIMPLE_DATE_FORMAT.toPattern())), this, e);
        }
    }

    /**
     * Retrieves priorityWeighting
     * 
     */
    public int getPriorityWeighting() {
        return this.priorityWeighting;
    }

    /**
     * Sets priorityWeighting
     * 
     * @param value Value to set
     */
    public void setPriorityWeighting(int value) {
        this.priorityWeighting = value;
    }

}
