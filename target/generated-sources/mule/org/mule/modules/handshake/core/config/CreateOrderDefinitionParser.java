
package org.mule.modules.handshake.core.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.handshake.core.holders.AddressExpressionHolder;
import org.mule.modules.handshake.core.holders.CreditCardExpressionHolder;
import org.mule.modules.handshake.core.holders.CustomerExpressionHolder;
import org.mule.modules.handshake.core.holders.CustomerGroupExpressionHolder;
import org.mule.modules.handshake.core.holders.OrderExpressionHolder;
import org.mule.modules.handshake.core.holders.SalesOrderLineExpressionHolder;
import org.mule.modules.handshake.core.holders.UserGroupExpressionHolder;
import org.mule.modules.handshake.core.processors.CreateOrderMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class CreateOrderDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateOrderDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateOrderMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-order] within the connector [handshake] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-order] within the connector [handshake] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createOrder");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        if (!parseObjectRef(element, builder, "order", "order")) {
            BeanDefinitionBuilder orderBuilder = BeanDefinitionBuilder.rootBeanDefinition(OrderExpressionHolder.class.getName());
            Element orderChildElement = DomUtils.getChildElementByTagName(element, "order");
            if (orderChildElement!= null) {
                parseProperty(orderBuilder, orderChildElement, "mtime", "mtime");
                parseProperty(orderBuilder, orderChildElement, "ctime", "ctime");
                parseProperty(orderBuilder, orderChildElement, "owner", "owner");
                parseProperty(orderBuilder, orderChildElement, "ownerName", "ownerName");
                parseProperty(orderBuilder, orderChildElement, "objID", "objID");
                parseProperty(orderBuilder, orderChildElement, "id", "id");
                if (!parseObjectRef(orderChildElement, orderBuilder, "customer", "customer")) {
                    BeanDefinitionBuilder _customerBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomerExpressionHolder.class.getName());
                    Element _customerChildElement = DomUtils.getChildElementByTagName(orderChildElement, "customer");
                    if (_customerChildElement!= null) {
                        parseProperty(_customerBuilder, _customerChildElement, "mtime", "mtime");
                        parseProperty(_customerBuilder, _customerChildElement, "ctime", "ctime");
                        parseProperty(_customerBuilder, _customerChildElement, "owner", "owner");
                        parseProperty(_customerBuilder, _customerChildElement, "ownerName", "ownerName");
                        parseProperty(_customerBuilder, _customerChildElement, "objID", "objID");
                        parseProperty(_customerBuilder, _customerChildElement, "contact", "contact");
                        parseProperty(_customerBuilder, _customerChildElement, "id", "id");
                        parseProperty(_customerBuilder, _customerChildElement, "name", "name");
                        parseProperty(_customerBuilder, _customerChildElement, "email", "email");
                        parseProperty(_customerBuilder, _customerChildElement, "taxId", "taxId");
                        if (!parseObjectRef(_customerChildElement, _customerBuilder, "bill-to", "billTo")) {
                            BeanDefinitionBuilder __billToBuilder = BeanDefinitionBuilder.rootBeanDefinition(AddressExpressionHolder.class.getName());
                            Element __billToChildElement = DomUtils.getChildElementByTagName(_customerChildElement, "bill-to");
                            if (__billToChildElement!= null) {
                                parseProperty(__billToBuilder, __billToChildElement, "mtime", "mtime");
                                parseProperty(__billToBuilder, __billToChildElement, "ctime", "ctime");
                                parseProperty(__billToBuilder, __billToChildElement, "owner", "owner");
                                parseProperty(__billToBuilder, __billToChildElement, "ownerName", "ownerName");
                                parseProperty(__billToBuilder, __billToChildElement, "objID", "objID");
                                parseProperty(__billToBuilder, __billToChildElement, "id", "id");
                                parseProperty(__billToBuilder, __billToChildElement, "name", "name");
                                parseProperty(__billToBuilder, __billToChildElement, "street", "street");
                                parseProperty(__billToBuilder, __billToChildElement, "street2", "street2");
                                parseProperty(__billToBuilder, __billToChildElement, "city", "city");
                                parseProperty(__billToBuilder, __billToChildElement, "state", "state");
                                parseProperty(__billToBuilder, __billToChildElement, "postcode", "postcode");
                                parseProperty(__billToBuilder, __billToChildElement, "country", "country");
                                parseProperty(__billToBuilder, __billToChildElement, "phone", "phone");
                                parseProperty(__billToBuilder, __billToChildElement, "fax", "fax");
                                parseProperty(__billToBuilder, __billToChildElement, "isDefaultShipTo", "isDefaultShipTo");
                                parseProperty(__billToBuilder, __billToChildElement, "multiLineStr", "multiLineStr");
                                parseProperty(__billToBuilder, __billToChildElement, "stCustomer", "stCustomer");
                                parseProperty(__billToBuilder, __billToChildElement, "resourceUri", "resourceUri");
                                _customerBuilder.addPropertyValue("billTo", __billToBuilder.getBeanDefinition());
                            }
                        }
                        parseListAndSetProperty(_customerChildElement, _customerBuilder, "shipTos", "ship-tos", "ship-to", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AddressExpressionHolder.class);
                                parseProperty(builder, element, "mtime", "mtime");
                                parseProperty(builder, element, "ctime", "ctime");
                                parseProperty(builder, element, "owner", "owner");
                                parseProperty(builder, element, "ownerName", "ownerName");
                                parseProperty(builder, element, "objID", "objID");
                                parseProperty(builder, element, "id", "id");
                                parseProperty(builder, element, "name", "name");
                                parseProperty(builder, element, "street", "street");
                                parseProperty(builder, element, "street2", "street2");
                                parseProperty(builder, element, "city", "city");
                                parseProperty(builder, element, "state", "state");
                                parseProperty(builder, element, "postcode", "postcode");
                                parseProperty(builder, element, "country", "country");
                                parseProperty(builder, element, "phone", "phone");
                                parseProperty(builder, element, "fax", "fax");
                                parseProperty(builder, element, "isDefaultShipTo", "isDefaultShipTo");
                                parseProperty(builder, element, "multiLineStr", "multiLineStr");
                                parseProperty(builder, element, "stCustomer", "stCustomer");
                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        parseProperty(_customerBuilder, _customerChildElement, "defaultShipTo", "defaultShipTo");
                        parseListAndSetProperty(_customerChildElement, _customerBuilder, "creditCards", "credit-cards", "credit-card", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CreditCardExpressionHolder.class);
                                parseProperty(builder, element, "mtime", "mtime");
                                parseProperty(builder, element, "ctime", "ctime");
                                parseProperty(builder, element, "owner", "owner");
                                parseProperty(builder, element, "ownerName", "ownerName");
                                parseProperty(builder, element, "objID", "objID");
                                parseProperty(builder, element, "type", "type");
                                parseProperty(builder, element, "lastFour", "lastFour");
                                parseProperty(builder, element, "month", "month");
                                parseProperty(builder, element, "year", "year");
                                parseProperty(builder, element, "expiry", "expiry");
                                parseProperty(builder, element, "name", "name");
                                parseProperty(builder, element, "number", "number");
                                parseProperty(builder, element, "cvv", "cvv");
                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        if (!parseObjectRef(_customerChildElement, _customerBuilder, "user-group", "userGroup")) {
                            BeanDefinitionBuilder __userGroupBuilder = BeanDefinitionBuilder.rootBeanDefinition(UserGroupExpressionHolder.class.getName());
                            Element __userGroupChildElement = DomUtils.getChildElementByTagName(_customerChildElement, "user-group");
                            if (__userGroupChildElement!= null) {
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "mtime", "mtime");
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "ctime", "ctime");
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "owner", "owner");
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "ownerName", "ownerName");
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "objID", "objID");
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "name", "name");
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "id", "id");
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "parent", "parent");
                                parseListAndSetProperty(__userGroupChildElement, __userGroupBuilder, "categories", "categories", "category", new ParseDelegate<String>() {


                                    public String parse(Element element) {
                                        return element.getTextContent();
                                    }

                                }
                                );
                                parseProperty(__userGroupBuilder, __userGroupChildElement, "resourceUri", "resourceUri");
                                _customerBuilder.addPropertyValue("userGroup", __userGroupBuilder.getBeanDefinition());
                            }
                        }
                        if (!parseObjectRef(_customerChildElement, _customerBuilder, "customer-group", "customerGroup")) {
                            BeanDefinitionBuilder __customerGroupBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomerGroupExpressionHolder.class.getName());
                            Element __customerGroupChildElement = DomUtils.getChildElementByTagName(_customerChildElement, "customer-group");
                            if (__customerGroupChildElement!= null) {
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "mtime", "mtime");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "ctime", "ctime");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "owner", "owner");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "ownerName", "ownerName");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "objID", "objID");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "name", "name");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "id", "id");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "currency", "currency");
                                parseProperty(__customerGroupBuilder, __customerGroupChildElement, "resourceUri", "resourceUri");
                                _customerBuilder.addPropertyValue("customerGroup", __customerGroupBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(_customerBuilder, _customerChildElement, "shippingMethod", "shippingMethod");
                        parseProperty(_customerBuilder, _customerChildElement, "paymentTerms", "paymentTerms");
                        parseProperty(_customerBuilder, _customerChildElement, "currency", "currency");
                        parseProperty(_customerBuilder, _customerChildElement, "locale", "locale");
                        parseProperty(_customerBuilder, _customerChildElement, "resourceUri", "resourceUri");
                        orderBuilder.addPropertyValue("customer", _customerBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(orderChildElement, orderBuilder, "bill-to", "billTo")) {
                    BeanDefinitionBuilder _billToBuilder = BeanDefinitionBuilder.rootBeanDefinition(AddressExpressionHolder.class.getName());
                    Element _billToChildElement = DomUtils.getChildElementByTagName(orderChildElement, "bill-to");
                    if (_billToChildElement!= null) {
                        parseProperty(_billToBuilder, _billToChildElement, "mtime", "mtime");
                        parseProperty(_billToBuilder, _billToChildElement, "ctime", "ctime");
                        parseProperty(_billToBuilder, _billToChildElement, "owner", "owner");
                        parseProperty(_billToBuilder, _billToChildElement, "ownerName", "ownerName");
                        parseProperty(_billToBuilder, _billToChildElement, "objID", "objID");
                        parseProperty(_billToBuilder, _billToChildElement, "id", "id");
                        parseProperty(_billToBuilder, _billToChildElement, "name", "name");
                        parseProperty(_billToBuilder, _billToChildElement, "street", "street");
                        parseProperty(_billToBuilder, _billToChildElement, "street2", "street2");
                        parseProperty(_billToBuilder, _billToChildElement, "city", "city");
                        parseProperty(_billToBuilder, _billToChildElement, "state", "state");
                        parseProperty(_billToBuilder, _billToChildElement, "postcode", "postcode");
                        parseProperty(_billToBuilder, _billToChildElement, "country", "country");
                        parseProperty(_billToBuilder, _billToChildElement, "phone", "phone");
                        parseProperty(_billToBuilder, _billToChildElement, "fax", "fax");
                        parseProperty(_billToBuilder, _billToChildElement, "isDefaultShipTo", "isDefaultShipTo");
                        parseProperty(_billToBuilder, _billToChildElement, "multiLineStr", "multiLineStr");
                        parseProperty(_billToBuilder, _billToChildElement, "stCustomer", "stCustomer");
                        parseProperty(_billToBuilder, _billToChildElement, "resourceUri", "resourceUri");
                        orderBuilder.addPropertyValue("billTo", _billToBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(orderChildElement, orderBuilder, "ship-to", "shipTo")) {
                    BeanDefinitionBuilder _shipToBuilder = BeanDefinitionBuilder.rootBeanDefinition(AddressExpressionHolder.class.getName());
                    Element _shipToChildElement = DomUtils.getChildElementByTagName(orderChildElement, "ship-to");
                    if (_shipToChildElement!= null) {
                        parseProperty(_shipToBuilder, _shipToChildElement, "mtime", "mtime");
                        parseProperty(_shipToBuilder, _shipToChildElement, "ctime", "ctime");
                        parseProperty(_shipToBuilder, _shipToChildElement, "owner", "owner");
                        parseProperty(_shipToBuilder, _shipToChildElement, "ownerName", "ownerName");
                        parseProperty(_shipToBuilder, _shipToChildElement, "objID", "objID");
                        parseProperty(_shipToBuilder, _shipToChildElement, "id", "id");
                        parseProperty(_shipToBuilder, _shipToChildElement, "name", "name");
                        parseProperty(_shipToBuilder, _shipToChildElement, "street", "street");
                        parseProperty(_shipToBuilder, _shipToChildElement, "street2", "street2");
                        parseProperty(_shipToBuilder, _shipToChildElement, "city", "city");
                        parseProperty(_shipToBuilder, _shipToChildElement, "state", "state");
                        parseProperty(_shipToBuilder, _shipToChildElement, "postcode", "postcode");
                        parseProperty(_shipToBuilder, _shipToChildElement, "country", "country");
                        parseProperty(_shipToBuilder, _shipToChildElement, "phone", "phone");
                        parseProperty(_shipToBuilder, _shipToChildElement, "fax", "fax");
                        parseProperty(_shipToBuilder, _shipToChildElement, "isDefaultShipTo", "isDefaultShipTo");
                        parseProperty(_shipToBuilder, _shipToChildElement, "multiLineStr", "multiLineStr");
                        parseProperty(_shipToBuilder, _shipToChildElement, "stCustomer", "stCustomer");
                        parseProperty(_shipToBuilder, _shipToChildElement, "resourceUri", "resourceUri");
                        orderBuilder.addPropertyValue("shipTo", _shipToBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(orderChildElement, orderBuilder, "credit-card", "creditCard")) {
                    BeanDefinitionBuilder _creditCardBuilder = BeanDefinitionBuilder.rootBeanDefinition(CreditCardExpressionHolder.class.getName());
                    Element _creditCardChildElement = DomUtils.getChildElementByTagName(orderChildElement, "credit-card");
                    if (_creditCardChildElement!= null) {
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "mtime", "mtime");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "ctime", "ctime");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "owner", "owner");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "ownerName", "ownerName");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "objID", "objID");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "type", "type");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "lastFour", "lastFour");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "month", "month");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "year", "year");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "expiry", "expiry");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "name", "name");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "number", "number");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "cvv", "cvv");
                        parseProperty(_creditCardBuilder, _creditCardChildElement, "resourceUri", "resourceUri");
                        orderBuilder.addPropertyValue("creditCard", _creditCardBuilder.getBeanDefinition());
                    }
                }
                parseProperty(orderBuilder, orderChildElement, "userGroup", "userGroup");
                parseProperty(orderBuilder, orderChildElement, "category", "category");
                parseListAndSetProperty(orderChildElement, orderBuilder, "lines", "lines", "line", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(SalesOrderLineExpressionHolder.class);
                        parseProperty(builder, element, "mtime", "mtime");
                        parseProperty(builder, element, "ctime", "ctime");
                        parseProperty(builder, element, "owner", "owner");
                        parseProperty(builder, element, "ownerName", "ownerName");
                        parseProperty(builder, element, "objID", "objID");
                        parseProperty(builder, element, "isku", "isku");
                        parseProperty(builder, element, "vsku", "vsku");
                        parseProperty(builder, element, "sku", "sku");
                        parseProperty(builder, element, "barcode", "barcode");
                        parseProperty(builder, element, "item", "item");
                        parseProperty(builder, element, "description", "description");
                        parseProperty(builder, element, "qty", "qty");
                        parseProperty(builder, element, "unitPrice", "unitPrice");
                        parseProperty(builder, element, "notes", "notes");
                        parseProperty(builder, element, "listPrice", "listPrice");
                        parseProperty(builder, element, "discount", "discount");
                        parseProperty(builder, element, "percentageDiscount", "percentageDiscount");
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseProperty(orderBuilder, orderChildElement, "lastEdited", "lastEdited");
                parseProperty(orderBuilder, orderChildElement, "manufacturerIds", "manufacturerIds");
                parseProperty(orderBuilder, orderChildElement, "manufacturerNames", "manufacturerNames");
                parseProperty(orderBuilder, orderChildElement, "status", "status");
                parseProperty(orderBuilder, orderChildElement, "shippingMethod", "shippingMethod");
                parseProperty(orderBuilder, orderChildElement, "paymentTerms", "paymentTerms");
                parseProperty(orderBuilder, orderChildElement, "notes", "notes");
                parseProperty(orderBuilder, orderChildElement, "customerPO", "customerPO");
                parseProperty(orderBuilder, orderChildElement, "emailSent", "emailSent");
                parseProperty(orderBuilder, orderChildElement, "startShipDate", "startShipDate");
                parseProperty(orderBuilder, orderChildElement, "cancelDate", "cancelDate");
                parseProperty(orderBuilder, orderChildElement, "freeShipping", "freeShipping");
                parseProperty(orderBuilder, orderChildElement, "shipPartial", "shipPartial");
                parseProperty(orderBuilder, orderChildElement, "signatureURL", "signatureURL");
                parseListAndSetProperty(orderChildElement, orderBuilder, "photoURLs", "photo-u-r-ls", "photo-u-r-l", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(orderBuilder, orderChildElement, "resourceUri", "resourceUri");
                parseProperty(orderBuilder, orderChildElement, "totalOffDiscount", "totalOffDiscount");
                parseProperty(orderBuilder, orderChildElement, "percentDiscount", "percentDiscount");
                builder.addPropertyValue("order", orderBuilder.getBeanDefinition());
            }
        }
        parseProperty(builder, element, "apiKey", "apiKey");
        parseProperty(builder, element, "securityToken", "securityToken");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
