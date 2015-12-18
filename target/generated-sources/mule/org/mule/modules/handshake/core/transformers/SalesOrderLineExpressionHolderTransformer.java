
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
import org.mule.modules.handshake.core.SalesOrderLine;
import org.mule.modules.handshake.core.holders.HandshakeObjectExpressionHolder;
import org.mule.modules.handshake.core.holders.SalesOrderLineExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class SalesOrderLineExpressionHolderTransformer
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
        return (aClass == SalesOrderLineExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == SalesOrderLineExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {SalesOrderLineExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(SalesOrderLineExpressionHolder.class)});
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
        return SalesOrderLine.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(SalesOrderLine.class);
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
        SalesOrderLineExpressionHolder holder = ((SalesOrderLineExpressionHolder) src);
        SalesOrderLine result = new SalesOrderLine();
        try {
            final String _transformedIsku = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_iskuType").getGenericType(), null, holder.getIsku()));
            result.setIsku(_transformedIsku);
            final String _transformedVsku = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_vskuType").getGenericType(), null, holder.getVsku()));
            result.setVsku(_transformedVsku);
            final String _transformedSku = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_skuType").getGenericType(), null, holder.getSku()));
            result.setSku(_transformedSku);
            final String _transformedBarcode = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_barcodeType").getGenericType(), null, holder.getBarcode()));
            result.setBarcode(_transformedBarcode);
            final String _transformedItem = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_itemType").getGenericType(), null, holder.getItem()));
            result.setItem(_transformedItem);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Integer _transformedQty = ((Integer) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_qtyType").getGenericType(), null, holder.getQty()));
            result.setQty(_transformedQty);
            final BigDecimal _transformedUnitPrice = ((BigDecimal) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_unitPriceType").getGenericType(), null, holder.getUnitPrice()));
            result.setUnitPrice(_transformedUnitPrice);
            final String _transformedNotes = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_notesType").getGenericType(), null, holder.getNotes()));
            result.setNotes(_transformedNotes);
            final String _transformedListPrice = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_listPriceType").getGenericType(), null, holder.getListPrice()));
            result.setListPrice(_transformedListPrice);
            final String _transformedDiscount = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_discountType").getGenericType(), null, holder.getDiscount()));
            result.setDiscount(_transformedDiscount);
            final String _transformedPercentageDiscount = ((String) evaluateAndTransform(this.muleContext, event, SalesOrderLineExpressionHolder.class.getDeclaredField("_percentageDiscountType").getGenericType(), null, holder.getPercentageDiscount()));
            result.setPercentageDiscount(_transformedPercentageDiscount);
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
