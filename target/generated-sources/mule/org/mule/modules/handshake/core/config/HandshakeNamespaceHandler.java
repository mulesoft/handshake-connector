
package org.mule.modules.handshake.core.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/handshake</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(HandshakeNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [handshake] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [handshake] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new HandshakeConnectorConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("find-orders", new FindOrdersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("find-orders", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-order", new GetOrderDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-order", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("find-customers", new FindCustomersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("find-customers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-customer", new GetCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-customer", new CreateCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-customer", new UpdateCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("find-items", new FindItemsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("find-items", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-item", new CreateItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-items", new CreateItemsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-items", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-item", new GetItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-item", new UpdateItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-category", new CreateCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-category", new GetCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-customer-group", new GetCustomerGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-customer-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-user-group", new GetUserGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-user-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-order", new CreateOrderDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-order", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-address", new GetAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-address", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-address", new CreateAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-address", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-address", new UpdateAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-address", "@Processor", ex);
        }
    }

}
