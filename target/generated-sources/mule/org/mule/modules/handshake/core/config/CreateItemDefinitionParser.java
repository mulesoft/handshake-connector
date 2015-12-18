
package org.mule.modules.handshake.core.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.handshake.core.holders.CategoryExpressionHolder;
import org.mule.modules.handshake.core.holders.ItemExpressionHolder;
import org.mule.modules.handshake.core.holders.VariantExpressionHolder;
import org.mule.modules.handshake.core.processors.CreateItemMessageProcessor;
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
public class CreateItemDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateItemDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateItemMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-item] within the connector [handshake] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-item] within the connector [handshake] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createItem");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        if (!parseObjectRef(element, builder, "item", "item")) {
            BeanDefinitionBuilder itemBuilder = BeanDefinitionBuilder.rootBeanDefinition(ItemExpressionHolder.class.getName());
            Element itemChildElement = DomUtils.getChildElementByTagName(element, "item");
            if (itemChildElement!= null) {
                parseProperty(itemBuilder, itemChildElement, "mtime", "mtime");
                parseProperty(itemBuilder, itemChildElement, "ctime", "ctime");
                parseProperty(itemBuilder, itemChildElement, "owner", "owner");
                parseProperty(itemBuilder, itemChildElement, "ownerName", "ownerName");
                parseProperty(itemBuilder, itemChildElement, "objID", "objID");
                parseProperty(itemBuilder, itemChildElement, "sku", "sku");
                parseProperty(itemBuilder, itemChildElement, "name", "name");
                parseProperty(itemBuilder, itemChildElement, "longDesc", "longDesc");
                parseProperty(itemBuilder, itemChildElement, "barcode", "barcode");
                parseProperty(itemBuilder, itemChildElement, "unitPrice", "unitPrice");
                parseProperty(itemBuilder, itemChildElement, "minQty", "minQty");
                parseProperty(itemBuilder, itemChildElement, "multQty", "multQty");
                if (!parseObjectRef(itemChildElement, itemBuilder, "category", "category")) {
                    BeanDefinitionBuilder _categoryBuilder = BeanDefinitionBuilder.rootBeanDefinition(CategoryExpressionHolder.class.getName());
                    Element _categoryChildElement = DomUtils.getChildElementByTagName(itemChildElement, "category");
                    if (_categoryChildElement!= null) {
                        parseProperty(_categoryBuilder, _categoryChildElement, "mtime", "mtime");
                        parseProperty(_categoryBuilder, _categoryChildElement, "ctime", "ctime");
                        parseProperty(_categoryBuilder, _categoryChildElement, "owner", "owner");
                        parseProperty(_categoryBuilder, _categoryChildElement, "ownerName", "ownerName");
                        parseProperty(_categoryBuilder, _categoryChildElement, "objID", "objID");
                        parseProperty(_categoryBuilder, _categoryChildElement, "name", "name");
                        parseProperty(_categoryBuilder, _categoryChildElement, "id", "id");
                        parseProperty(_categoryBuilder, _categoryChildElement, "categoryPosition", "categoryPosition");
                        parseProperty(_categoryBuilder, _categoryChildElement, "parent", "parent");
                        parseProperty(_categoryBuilder, _categoryChildElement, "subType", "subType");
                        parseListAndSetProperty(_categoryChildElement, _categoryBuilder, "subcategories", "subcategories", "subcategory", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        parseProperty(_categoryBuilder, _categoryChildElement, "resourceUri", "resourceUri");
                        itemBuilder.addPropertyValue("category", _categoryBuilder.getBeanDefinition());
                    }
                }
                parseProperty(itemBuilder, itemChildElement, "categoryPosition", "categoryPosition");
                parseListAndSetProperty(itemChildElement, itemBuilder, "variants", "variants", "variant", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(VariantExpressionHolder.class);
                        parseProperty(builder, element, "mtime", "mtime");
                        parseProperty(builder, element, "ctime", "ctime");
                        parseProperty(builder, element, "owner", "owner");
                        parseProperty(builder, element, "ownerName", "ownerName");
                        parseProperty(builder, element, "objID", "objID");
                        parseProperty(builder, element, "sku", "sku");
                        parseProperty(builder, element, "unitPrice", "unitPrice");
                        parseProperty(builder, element, "barcode", "barcode");
                        parseProperty(builder, element, "resourceUri", "resourceUri");
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseMapAndSetProperty(itemChildElement, itemBuilder, "additionalPrices", "additional-prices", "additional-price", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(itemBuilder, itemChildElement, "manufacturer", "manufacturer");
                parseListAndSetProperty(itemChildElement, itemBuilder, "imageURLs", "image-u-r-ls", "image-u-r-l", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(itemChildElement, itemBuilder, "thumbnailURLs", "thumbnail-u-r-ls", "thumbnail-u-r-l", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(itemBuilder, itemChildElement, "thumbnailURL", "thumbnailURL");
                parseProperty(itemBuilder, itemChildElement, "resourceUri", "resourceUri");
                builder.addPropertyValue("item", itemBuilder.getBeanDefinition());
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
