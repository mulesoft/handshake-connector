
package org.mule.modules.handshake.core.process;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.handshake.core.adapters.HandshakeConnectorConnectionIdentifierAdapter;
import org.mule.modules.handshake.core.connection.ConnectionManager;
import org.mule.modules.handshake.core.connection.UnableToAcquireConnectionException;
import org.mule.modules.handshake.core.connection.UnableToReleaseConnectionException;
import org.mule.modules.handshake.core.connectivity.HandshakeConnectorConnectionKey;
import org.mule.modules.handshake.core.processors.ConnectivityProcessor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeConnectorManagedConnectionProcessInterceptor<T >
    extends ExpressionEvaluatorSupport
    implements ProcessInterceptor<T, HandshakeConnectorConnectionIdentifierAdapter>
{

    private static Logger logger = LoggerFactory.getLogger(HandshakeConnectorManagedConnectionProcessInterceptor.class);
    private final ConnectionManager<HandshakeConnectorConnectionKey, HandshakeConnectorConnectionIdentifierAdapter> connectionManager;
    private final MuleContext muleContext;
    private final ProcessInterceptor<T, HandshakeConnectorConnectionIdentifierAdapter> next;

    public HandshakeConnectorManagedConnectionProcessInterceptor(ProcessInterceptor<T, HandshakeConnectorConnectionIdentifierAdapter> next, ConnectionManager<HandshakeConnectorConnectionKey, HandshakeConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        this.next = next;
        this.connectionManager = connectionManager;
        this.muleContext = muleContext;
    }

    @Override
    public T execute(ProcessCallback<T, HandshakeConnectorConnectionIdentifierAdapter> processCallback, HandshakeConnectorConnectionIdentifierAdapter object, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        HandshakeConnectorConnectionIdentifierAdapter connection = null;
        HandshakeConnectorConnectionKey key = null;
        if (hasConnectionKeysOverride(messageProcessor)) {
            ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
            final String _transformedApiKey = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_apiKeyType"), null, connectivityProcessor.getApiKey()));
            if (_transformedApiKey == null) {
                throw new UnableToAcquireConnectionException("Parameter apiKey in method connect can't be null because is not @Optional");
            }
            final String _transformedSecurityToken = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_securityTokenType"), null, connectivityProcessor.getSecurityToken()));
            key = new HandshakeConnectorConnectionKey(_transformedApiKey, _transformedSecurityToken);
        } else {
            key = connectionManager.getEvaluatedConnectionKey(event);
        }
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(("Attempting to acquire connection using "+ key.toString()));
            }
            connection = connectionManager.acquireConnection(key);
            if (connection == null) {
                throw new UnableToAcquireConnectionException();
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug((("Connection has been acquired with [id="+ connection.getConnectionIdentifier())+"]"));
                }
            }
            return next.execute(processCallback, connection, messageProcessor, event);
        } catch (Exception e) {
            if (processCallback.getManagedExceptions()!= null) {
                for (Class exceptionClass: ((List<Class<? extends Exception>> ) processCallback.getManagedExceptions())) {
                    if (exceptionClass.isInstance(e)) {
                        if (logger.isDebugEnabled()) {
                            logger.debug((((("An exception ( "+ exceptionClass.getName())+") has been thrown. Destroying the connection with [id=")+ connection.getConnectionIdentifier())+"]"));
                        }
                        try {
                            if (connection!= null) {
                                connectionManager.destroyConnection(key, connection);
                                connection = null;
                            }
                        } catch (Exception innerException) {
                            logger.error(innerException.getMessage(), innerException);
                        }
                    }
                }
            }
            throw e;
        } finally {
            try {
                if (connection!= null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug((("Releasing the connection back into the pool [id="+ connection.getConnectionIdentifier())+"]"));
                    }
                    connectionManager.releaseConnection(key, connection);
                }
            } catch (Exception e) {
                throw new UnableToReleaseConnectionException(e);
            }
        }
    }

    /**
     * Validates that the current message processor has changed any of its connection parameters at processor level. If so, a new HandshakeConnectorConnectionKey must be generated
     * 
     * @param messageProcessor
     *     the message processor to test against the keys
     * @return
     *     true if any of the parameters in @Connect method annotated with @ConnectionKey was override in the XML, false otherwise  
     */
    private Boolean hasConnectionKeysOverride(MessageProcessor messageProcessor) {
        if ((messageProcessor == null)||(!(messageProcessor instanceof ConnectivityProcessor))) {
            return false;
        }
        ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
        if (connectivityProcessor.getApiKey()!= null) {
            return true;
        }
        return false;
    }

    public T execute(ProcessCallback<T, HandshakeConnectorConnectionIdentifierAdapter> processCallback, HandshakeConnectorConnectionIdentifierAdapter object, Filter filter, MuleMessage message)
        throws Exception
    {
        throw new UnsupportedOperationException();
    }

}
