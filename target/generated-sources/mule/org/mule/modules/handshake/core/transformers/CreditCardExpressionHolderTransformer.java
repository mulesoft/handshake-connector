
package org.mule.modules.handshake.core.transformers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.handshake.core.CreditCard;
import org.mule.modules.handshake.core.holders.CreditCardExpressionHolder;
import org.mule.modules.handshake.core.holders.HandshakeObjectExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class CreditCardExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == CreditCardExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CreditCardExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CreditCardExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CreditCardExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return CreditCard.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CreditCard.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        CreditCardExpressionHolder holder = ((CreditCardExpressionHolder) src);
        CreditCard result = new CreditCard();
        try {
            final String _transformedType = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final String _transformedLastFour = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_lastFourType").getGenericType(), null, holder.getLastFour()));
            result.setLastFour(_transformedLastFour);
            final String _transformedMonth = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_monthType").getGenericType(), null, holder.getMonth()));
            result.setMonth(_transformedMonth);
            final String _transformedYear = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_yearType").getGenericType(), null, holder.getYear()));
            result.setYear(_transformedYear);
            final String _transformedExpiry = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_expiryType").getGenericType(), null, holder.getExpiry()));
            result.setExpiry(_transformedExpiry);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final String _transformedNumber = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_numberType").getGenericType(), null, holder.getNumber()));
            result.setNumber(_transformedNumber);
            final String _transformedCvv = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_cvvType").getGenericType(), null, holder.getCvv()));
            result.setCvv(_transformedCvv);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, CreditCardExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final Date _transformedMtime = ((Date) evaluateAndTransform(this.muleContext, event, HandshakeObjectExpressionHolder.class.getDeclaredField("_mtimeType").getGenericType(), null, holder.getMtime()));
            result.setMtime(_transformedMtime);
            final Date _transformedCtime = ((Date) evaluateAndTransform(this.muleContext, event, HandshakeObjectExpressionHolder.class.getDeclaredField("_ctimeType").getGenericType(), null, holder.getCtime()));
            result.setCtime(_transformedCtime);
            final String _transformedObjID = ((String) evaluateAndTransform(this.muleContext, event, HandshakeObjectExpressionHolder.class.getDeclaredField("_objIDType").getGenericType(), null, holder.getObjID()));
            result.setObjID(_transformedObjID);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
