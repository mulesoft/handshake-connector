
package org.mule.modules.handshake.core.transformers;

import java.math.BigDecimal;
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
import org.mule.modules.handshake.core.Variant;
import org.mule.modules.handshake.core.holders.HandshakeObjectExpressionHolder;
import org.mule.modules.handshake.core.holders.VariantExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class VariantExpressionHolderTransformer
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
        return (aClass == VariantExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == VariantExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {VariantExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(VariantExpressionHolder.class)});
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
        return Variant.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Variant.class);
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
        VariantExpressionHolder holder = ((VariantExpressionHolder) src);
        Variant result = new Variant();
        try {
            final String _transformedSku = ((String) evaluateAndTransform(this.muleContext, event, VariantExpressionHolder.class.getDeclaredField("_skuType").getGenericType(), null, holder.getSku()));
            result.setSku(_transformedSku);
            final BigDecimal _transformedUnitPrice = ((BigDecimal) evaluateAndTransform(this.muleContext, event, VariantExpressionHolder.class.getDeclaredField("_unitPriceType").getGenericType(), null, holder.getUnitPrice()));
            result.setUnitPrice(_transformedUnitPrice);
            final String _transformedBarcode = ((String) evaluateAndTransform(this.muleContext, event, VariantExpressionHolder.class.getDeclaredField("_barcodeType").getGenericType(), null, holder.getBarcode()));
            result.setBarcode(_transformedBarcode);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, VariantExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
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
