
package org.mule.modules.handshake.core.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.handshake.core.holders.AddressExpressionHolder;
import org.mule.modules.handshake.core.holders.CreditCardExpressionHolder;
import org.mule.modules.handshake.core.holders.CustomerExpressionHolder;
import org.mule.modules.handshake.core.holders.CustomerGroupExpressionHolder;
import org.mule.modules.handshake.core.holders.UserGroupExpressionHolder;
import org.mule.modules.handshake.core.processors.CreateCustomerMessageProcessor;
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
public class CreateCustomerDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateCustomerDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateCustomerMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-customer] within the connector [handshake] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-customer] within the connector [handshake] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createCustomer");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        if (!parseObjectRef(element, builder, "customer", "customer")) {
            BeanDefinitionBuilder customerBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomerExpressionHolder.class.getName());
            Element customerChildElement = DomUtils.getChildElementByTagName(element, "customer");
            if (customerChildElement!= null) {
                parseProperty(customerBuilder, customerChildElement, "mtime", "mtime");
                parseProperty(customerBuilder, customerChildElement, "ctime", "ctime");
                parseProperty(customerBuilder, customerChildElement, "owner", "owner");
                parseProperty(customerBuilder, customerChildElement, "ownerName", "ownerName");
                parseProperty(customerBuilder, customerChildElement, "objID", "objID");
                parseProperty(customerBuilder, customerChildElement, "contact", "contact");
                parseProperty(customerBuilder, customerChildElement, "id", "id");
                parseProperty(customerBuilder, customerChildElement, "name", "name");
                parseProperty(customerBuilder, customerChildElement, "email", "email");
                parseProperty(customerBuilder, customerChildElement, "taxId", "taxId");
                if (!parseObjectRef(customerChildElement, customerBuilder, "bill-to", "billTo")) {
                    BeanDefinitionBuilder _billToBuilder = BeanDefinitionBuilder.rootBeanDefinition(AddressExpressionHolder.class.getName());
                    Element _billToChildElement = DomUtils.getChildElementByTagName(customerChildElement, "bill-to");
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
                        customerBuilder.addPropertyValue("billTo", _billToBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(customerChildElement, customerBuilder, "shipTos", "ship-tos", "ship-to", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(customerBuilder, customerChildElement, "defaultShipTo", "defaultShipTo");
                parseListAndSetProperty(customerChildElement, customerBuilder, "creditCards", "credit-cards", "credit-card", new ParseDelegate<BeanDefinition>() {


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
                if (!parseObjectRef(customerChildElement, customerBuilder, "user-group", "userGroup")) {
                    BeanDefinitionBuilder _userGroupBuilder = BeanDefinitionBuilder.rootBeanDefinition(UserGroupExpressionHolder.class.getName());
                    Element _userGroupChildElement = DomUtils.getChildElementByTagName(customerChildElement, "user-group");
                    if (_userGroupChildElement!= null) {
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "mtime", "mtime");
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "ctime", "ctime");
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "owner", "owner");
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "ownerName", "ownerName");
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "objID", "objID");
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "name", "name");
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "id", "id");
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "parent", "parent");
                        parseListAndSetProperty(_userGroupChildElement, _userGroupBuilder, "categories", "categories", "category", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        parseProperty(_userGroupBuilder, _userGroupChildElement, "resourceUri", "resourceUri");
                        customerBuilder.addPropertyValue("userGroup", _userGroupBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "customer-group", "customerGroup")) {
                    BeanDefinitionBuilder _customerGroupBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomerGroupExpressionHolder.class.getName());
                    Element _customerGroupChildElement = DomUtils.getChildElementByTagName(customerChildElement, "customer-group");
                    if (_customerGroupChildElement!= null) {
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "mtime", "mtime");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "ctime", "ctime");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "owner", "owner");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "ownerName", "ownerName");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "objID", "objID");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "name", "name");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "id", "id");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "currency", "currency");
                        parseProperty(_customerGroupBuilder, _customerGroupChildElement, "resourceUri", "resourceUri");
                        customerBuilder.addPropertyValue("customerGroup", _customerGroupBuilder.getBeanDefinition());
                    }
                }
                parseProperty(customerBuilder, customerChildElement, "shippingMethod", "shippingMethod");
                parseProperty(customerBuilder, customerChildElement, "paymentTerms", "paymentTerms");
                parseProperty(customerBuilder, customerChildElement, "currency", "currency");
                parseProperty(customerBuilder, customerChildElement, "locale", "locale");
                parseProperty(customerBuilder, customerChildElement, "resourceUri", "resourceUri");
                builder.addPropertyValue("customer", customerBuilder.getBeanDefinition());
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
