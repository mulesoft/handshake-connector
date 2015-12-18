
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
import org.mule.modules.handshake.core.Address;
import org.mule.modules.handshake.core.CreditCard;
import org.mule.modules.handshake.core.Customer;
import org.mule.modules.handshake.core.Order;
import org.mule.modules.handshake.core.SalesOrderLine;
import org.mule.modules.handshake.core.holders.HandshakeObjectExpressionHolder;
import org.mule.modules.handshake.core.holders.OrderExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class OrderExpressionHolderTransformer
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
        return (aClass == OrderExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == OrderExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {OrderExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(OrderExpressionHolder.class)});
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
        return Order.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Order.class);
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
        OrderExpressionHolder holder = ((OrderExpressionHolder) src);
        Order result = new Order();
        try {
            final String _transformedId = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final Customer _transformedCustomer = ((Customer) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_customerType").getGenericType(), null, holder.getCustomer()));
            result.setCustomer(_transformedCustomer);
            final Address _transformedBillTo = ((Address) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_billToType").getGenericType(), null, holder.getBillTo()));
            result.setBillTo(_transformedBillTo);
            final Address _transformedShipTo = ((Address) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_shipToType").getGenericType(), null, holder.getShipTo()));
            result.setShipTo(_transformedShipTo);
            final CreditCard _transformedCreditCard = ((CreditCard) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_creditCardType").getGenericType(), null, holder.getCreditCard()));
            result.setCreditCard(_transformedCreditCard);
            final String _transformedUserGroup = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_userGroupType").getGenericType(), null, holder.getUserGroup()));
            result.setUserGroup(_transformedUserGroup);
            final String _transformedCategory = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_categoryType").getGenericType(), null, holder.getCategory()));
            result.setCategory(_transformedCategory);
            final List<SalesOrderLine> _transformedLines = ((List<SalesOrderLine> ) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_linesType").getGenericType(), null, holder.getLines()));
            result.setLines(_transformedLines);
            final Date _transformedLastEdited = ((Date) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_lastEditedType").getGenericType(), null, holder.getLastEdited()));
            result.setLastEdited(_transformedLastEdited);
            final String _transformedManufacturerIds = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_manufacturerIdsType").getGenericType(), null, holder.getManufacturerIds()));
            result.setManufacturerIds(_transformedManufacturerIds);
            final String _transformedManufacturerNames = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_manufacturerNamesType").getGenericType(), null, holder.getManufacturerNames()));
            result.setManufacturerNames(_transformedManufacturerNames);
            final String _transformedStatus = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
            final String _transformedShippingMethod = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_shippingMethodType").getGenericType(), null, holder.getShippingMethod()));
            result.setShippingMethod(_transformedShippingMethod);
            final String _transformedPaymentTerms = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_paymentTermsType").getGenericType(), null, holder.getPaymentTerms()));
            result.setPaymentTerms(_transformedPaymentTerms);
            final String _transformedNotes = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_notesType").getGenericType(), null, holder.getNotes()));
            result.setNotes(_transformedNotes);
            final String _transformedCustomerPO = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_customerPOType").getGenericType(), null, holder.getCustomerPO()));
            result.setCustomerPO(_transformedCustomerPO);
            final Boolean _transformedEmailSent = ((Boolean) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_emailSentType").getGenericType(), null, holder.getEmailSent()));
            result.setEmailSent(_transformedEmailSent);
            final String _transformedStartShipDate = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_startShipDateType").getGenericType(), null, holder.getStartShipDate()));
            result.setStartShipDate(_transformedStartShipDate);
            final String _transformedCancelDate = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_cancelDateType").getGenericType(), null, holder.getCancelDate()));
            result.setCancelDate(_transformedCancelDate);
            final Boolean _transformedFreeShipping = ((Boolean) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_freeShippingType").getGenericType(), null, holder.getFreeShipping()));
            result.setFreeShipping(_transformedFreeShipping);
            final Boolean _transformedShipPartial = ((Boolean) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_shipPartialType").getGenericType(), null, holder.getShipPartial()));
            result.setShipPartial(_transformedShipPartial);
            final String _transformedSignatureURL = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_signatureURLType").getGenericType(), null, holder.getSignatureURL()));
            result.setSignatureURL(_transformedSignatureURL);
            final List<String> _transformedPhotoURLs = ((List<String> ) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_photoURLsType").getGenericType(), null, holder.getPhotoURLs()));
            result.setPhotoURLs(_transformedPhotoURLs);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final String _transformedTotalOffDiscount = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_totalOffDiscountType").getGenericType(), null, holder.getTotalOffDiscount()));
            result.setTotalOffDiscount(_transformedTotalOffDiscount);
            final String _transformedPercentDiscount = ((String) evaluateAndTransform(this.muleContext, event, OrderExpressionHolder.class.getDeclaredField("_percentDiscountType").getGenericType(), null, holder.getPercentDiscount()));
            result.setPercentDiscount(_transformedPercentDiscount);
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
