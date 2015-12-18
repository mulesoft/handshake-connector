
package org.mule.modules.handshake.core.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.handshake.core.holders.CategoryExpressionHolder;
import org.mule.modules.handshake.core.processors.CreateCategoryMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
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
public class CreateCategoryDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateCategoryDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateCategoryMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-category] within the connector [handshake] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-category] within the connector [handshake] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createCategory");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        if (!parseObjectRef(element, builder, "category", "category")) {
            BeanDefinitionBuilder categoryBuilder = BeanDefinitionBuilder.rootBeanDefinition(CategoryExpressionHolder.class.getName());
            Element categoryChildElement = DomUtils.getChildElementByTagName(element, "category");
            if (categoryChildElement!= null) {
                parseProperty(categoryBuilder, categoryChildElement, "mtime", "mtime");
                parseProperty(categoryBuilder, categoryChildElement, "ctime", "ctime");
                parseProperty(categoryBuilder, categoryChildElement, "owner", "owner");
                parseProperty(categoryBuilder, categoryChildElement, "ownerName", "ownerName");
                parseProperty(categoryBuilder, categoryChildElement, "objID", "objID");
                parseProperty(categoryBuilder, categoryChildElement, "name", "name");
                parseProperty(categoryBuilder, categoryChildElement, "id", "id");
                parseProperty(categoryBuilder, categoryChildElement, "categoryPosition", "categoryPosition");
                parseProperty(categoryBuilder, categoryChildElement, "parent", "parent");
                parseProperty(categoryBuilder, categoryChildElement, "subType", "subType");
                parseListAndSetProperty(categoryChildElement, categoryBuilder, "subcategories", "subcategories", "subcategory", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(categoryBuilder, categoryChildElement, "resourceUri", "resourceUri");
                builder.addPropertyValue("category", categoryBuilder.getBeanDefinition());
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
