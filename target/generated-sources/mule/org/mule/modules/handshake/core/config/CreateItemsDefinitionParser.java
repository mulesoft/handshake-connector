
package org.mule.modules.handshake.core.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.handshake.core.holders.CategoryExpressionHolder;
import org.mule.modules.handshake.core.holders.ItemExpressionHolder;
import org.mule.modules.handshake.core.holders.VariantExpressionHolder;
import org.mule.modules.handshake.core.processors.CreateItemsMessageProcessor;
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
public class CreateItemsDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateItemsDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateItemsMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-items] within the connector [handshake] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-items] within the connector [handshake] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createItems");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseListAndSetProperty(element, builder, "items", "items", "item", new ParseDelegate<BeanDefinition>() {


            public BeanDefinition parse(Element element) {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ItemExpressionHolder.class);
                parseProperty(builder, element, "mtime", "mtime");
                parseProperty(builder, element, "ctime", "ctime");
                parseProperty(builder, element, "owner", "owner");
                parseProperty(builder, element, "ownerName", "ownerName");
                parseProperty(builder, element, "objID", "objID");
                parseProperty(builder, element, "sku", "sku");
                parseProperty(builder, element, "name", "name");
                parseProperty(builder, element, "longDesc", "longDesc");
                parseProperty(builder, element, "barcode", "barcode");
                parseProperty(builder, element, "unitPrice", "unitPrice");
                parseProperty(builder, element, "minQty", "minQty");
                parseProperty(builder, element, "multQty", "multQty");
                if (!parseObjectRef(element, builder, "category", "category")) {
                    BeanDefinitionBuilder _categoryBuilder = BeanDefinitionBuilder.rootBeanDefinition(CategoryExpressionHolder.class.getName());
                    Element _categoryChildElement = DomUtils.getChildElementByTagName(element, "category");
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
                        builder.addPropertyValue("category", _categoryBuilder.getBeanDefinition());
                    }
                }
                parseProperty(builder, element, "categoryPosition", "categoryPosition");
                parseListAndSetProperty(element, builder, "variants", "variants", "variant", new ParseDelegate<BeanDefinition>() {


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
                parseMapAndSetProperty(element, builder, "additionalPrices", "additional-prices", "additional-price", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(builder, element, "manufacturer", "manufacturer");
                parseListAndSetProperty(element, builder, "imageURLs", "image-u-r-ls", "image-u-r-l", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(element, builder, "thumbnailURLs", "thumbnail-u-r-ls", "thumbnail-u-r-l", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(builder, element, "thumbnailURL", "thumbnailURL");
                parseProperty(builder, element, "resourceUri", "resourceUri");
                return builder.getBeanDefinition();
            }

        }
        );
        parseProperty(builder, element, "apiKey", "apiKey");
        parseProperty(builder, element, "securityToken", "securityToken");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
