
package org.mule.modules.handshake.core.transformers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import org.mule.modules.handshake.core.Category;
import org.mule.modules.handshake.core.Item;
import org.mule.modules.handshake.core.Variant;
import org.mule.modules.handshake.core.holders.HandshakeObjectExpressionHolder;
import org.mule.modules.handshake.core.holders.ItemExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class ItemExpressionHolderTransformer
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
        return (aClass == ItemExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ItemExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ItemExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ItemExpressionHolder.class)});
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
        return Item.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Item.class);
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
        ItemExpressionHolder holder = ((ItemExpressionHolder) src);
        Item result = new Item();
        try {
            final String _transformedSku = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_skuType").getGenericType(), null, holder.getSku()));
            result.setSku(_transformedSku);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final String _transformedLongDesc = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_longDescType").getGenericType(), null, holder.getLongDesc()));
            result.setLongDesc(_transformedLongDesc);
            final String _transformedBarcode = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_barcodeType").getGenericType(), null, holder.getBarcode()));
            result.setBarcode(_transformedBarcode);
            final String _transformedUnitPrice = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_unitPriceType").getGenericType(), null, holder.getUnitPrice()));
            result.setUnitPrice(_transformedUnitPrice);
            final Integer _transformedMinQty = ((Integer) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_minQtyType").getGenericType(), null, holder.getMinQty()));
            result.setMinQty(_transformedMinQty);
            final Integer _transformedMultQty = ((Integer) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_multQtyType").getGenericType(), null, holder.getMultQty()));
            result.setMultQty(_transformedMultQty);
            final Category _transformedCategory = ((Category) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_categoryType").getGenericType(), null, holder.getCategory()));
            result.setCategory(_transformedCategory);
            final Integer _transformedCategoryPosition = ((Integer) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_categoryPositionType").getGenericType(), null, holder.getCategoryPosition()));
            result.setCategoryPosition(_transformedCategoryPosition);
            final List<Variant> _transformedVariants = ((List<Variant> ) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_variantsType").getGenericType(), null, holder.getVariants()));
            result.setVariants(_transformedVariants);
            final Map<String, String> _transformedAdditionalPrices = ((Map<String, String> ) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_additionalPricesType").getGenericType(), null, holder.getAdditionalPrices()));
            result.setAdditionalPrices(_transformedAdditionalPrices);
            final String _transformedManufacturer = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_manufacturerType").getGenericType(), null, holder.getManufacturer()));
            result.setManufacturer(_transformedManufacturer);
            final List<String> _transformedImageURLs = ((List<String> ) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_imageURLsType").getGenericType(), null, holder.getImageURLs()));
            result.setImageURLs(_transformedImageURLs);
            final List<String> _transformedThumbnailURLs = ((List<String> ) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_thumbnailURLsType").getGenericType(), null, holder.getThumbnailURLs()));
            result.setThumbnailURLs(_transformedThumbnailURLs);
            final String _transformedThumbnailURL = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_thumbnailURLType").getGenericType(), null, holder.getThumbnailURL()));
            result.setThumbnailURL(_transformedThumbnailURL);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
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
