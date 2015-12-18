
package org.mule.modules.handshake.core.processors;

import java.lang.reflect.Type;
import javax.annotation.Generated;
import org.mule.streaming.processor.AbstractDevkitBasedPageableMessageProcessor;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public abstract class AbstractPagedConnectedProcessor
    extends AbstractDevkitBasedPageableMessageProcessor
    implements ConnectivityProcessor
{

    protected Object apiKey;
    protected String _apiKeyType;
    protected Object securityToken;
    protected String _securityTokenType;

    public AbstractPagedConnectedProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Sets securityToken
     * 
     * @param value Value to set
     */
    public void setSecurityToken(Object value) {
        this.securityToken = value;
    }

    /**
     * Retrieves securityToken
     * 
     */
    @Override
    public Object getSecurityToken() {
        return this.securityToken;
    }

    /**
     * Sets apiKey
     * 
     * @param value Value to set
     */
    public void setApiKey(Object value) {
        this.apiKey = value;
    }

    /**
     * Retrieves apiKey
     * 
     */
    @Override
    public Object getApiKey() {
        return this.apiKey;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public Type typeFor(String fieldName)
        throws NoSuchFieldException
    {
        return AbstractPagedConnectedProcessor.class.getDeclaredField(fieldName).getGenericType();
    }

}
