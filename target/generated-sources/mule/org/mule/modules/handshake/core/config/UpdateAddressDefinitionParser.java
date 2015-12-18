
package org.mule.modules.handshake.core.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.handshake.core.holders.AddressExpressionHolder;
import org.mule.modules.handshake.core.processors.UpdateAddressMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
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
public class UpdateAddressDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateAddressDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateAddressMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-address] within the connector [handshake] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-address] within the connector [handshake] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateAddress");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "resourceUri", "resourceUri");
        if (!parseObjectRef(element, builder, "address", "address")) {
            BeanDefinitionBuilder addressBuilder = BeanDefinitionBuilder.rootBeanDefinition(AddressExpressionHolder.class.getName());
            Element addressChildElement = DomUtils.getChildElementByTagName(element, "address");
            if (addressChildElement!= null) {
                parseProperty(addressBuilder, addressChildElement, "mtime", "mtime");
                parseProperty(addressBuilder, addressChildElement, "ctime", "ctime");
                parseProperty(addressBuilder, addressChildElement, "owner", "owner");
                parseProperty(addressBuilder, addressChildElement, "ownerName", "ownerName");
                parseProperty(addressBuilder, addressChildElement, "objID", "objID");
                parseProperty(addressBuilder, addressChildElement, "id", "id");
                parseProperty(addressBuilder, addressChildElement, "name", "name");
                parseProperty(addressBuilder, addressChildElement, "street", "street");
                parseProperty(addressBuilder, addressChildElement, "street2", "street2");
                parseProperty(addressBuilder, addressChildElement, "city", "city");
                parseProperty(addressBuilder, addressChildElement, "state", "state");
                parseProperty(addressBuilder, addressChildElement, "postcode", "postcode");
                parseProperty(addressBuilder, addressChildElement, "country", "country");
                parseProperty(addressBuilder, addressChildElement, "phone", "phone");
                parseProperty(addressBuilder, addressChildElement, "fax", "fax");
                parseProperty(addressBuilder, addressChildElement, "isDefaultShipTo", "isDefaultShipTo");
                parseProperty(addressBuilder, addressChildElement, "multiLineStr", "multiLineStr");
                parseProperty(addressBuilder, addressChildElement, "stCustomer", "stCustomer");
                parseProperty(addressBuilder, addressChildElement, "resourceUri", "resourceUri");
                builder.addPropertyValue("address", addressBuilder.getBeanDefinition());
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
