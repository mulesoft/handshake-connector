
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
import org.mule.modules.handshake.core.CustomerGroup;
import org.mule.modules.handshake.core.UserGroup;
import org.mule.modules.handshake.core.holders.CustomerExpressionHolder;
import org.mule.modules.handshake.core.holders.HandshakeObjectExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class CustomerExpressionHolderTransformer
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
        return (aClass == CustomerExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CustomerExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CustomerExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CustomerExpressionHolder.class)});
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
        return Customer.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Customer.class);
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
        CustomerExpressionHolder holder = ((CustomerExpressionHolder) src);
        Customer result = new Customer();
        try {
            final String _transformedContact = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_contactType").getGenericType(), null, holder.getContact()));
            result.setContact(_transformedContact);
            final String _transformedId = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final String _transformedTaxId = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_taxIdType").getGenericType(), null, holder.getTaxId()));
            result.setTaxId(_transformedTaxId);
            final Address _transformedBillTo = ((Address) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_billToType").getGenericType(), null, holder.getBillTo()));
            result.setBillTo(_transformedBillTo);
            final List<Address> _transformedShipTos = ((List<Address> ) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_shipTosType").getGenericType(), null, holder.getShipTos()));
            result.setShipTos(_transformedShipTos);
            final String _transformedDefaultShipTo = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_defaultShipToType").getGenericType(), null, holder.getDefaultShipTo()));
            result.setDefaultShipTo(_transformedDefaultShipTo);
            final List<CreditCard> _transformedCreditCards = ((List<CreditCard> ) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_creditCardsType").getGenericType(), null, holder.getCreditCards()));
            result.setCreditCards(_transformedCreditCards);
            final UserGroup _transformedUserGroup = ((UserGroup) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_userGroupType").getGenericType(), null, holder.getUserGroup()));
            result.setUserGroup(_transformedUserGroup);
            final CustomerGroup _transformedCustomerGroup = ((CustomerGroup) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_customerGroupType").getGenericType(), null, holder.getCustomerGroup()));
            result.setCustomerGroup(_transformedCustomerGroup);
            final String _transformedShippingMethod = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_shippingMethodType").getGenericType(), null, holder.getShippingMethod()));
            result.setShippingMethod(_transformedShippingMethod);
            final String _transformedPaymentTerms = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_paymentTermsType").getGenericType(), null, holder.getPaymentTerms()));
            result.setPaymentTerms(_transformedPaymentTerms);
            final String _transformedCurrency = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_currencyType").getGenericType(), null, holder.getCurrency()));
            result.setCurrency(_transformedCurrency);
            final String _transformedLocale = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_localeType").getGenericType(), null, holder.getLocale()));
            result.setLocale(_transformedLocale);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
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
