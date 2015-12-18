
package org.mule.modules.handshake.core.connectivity;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.handshake.core.adapters.HandshakeConnectorConnectionIdentifierAdapter;
import org.mule.modules.handshake.core.connection.ConnectionManager;
import org.mule.modules.handshake.core.process.HandshakeConnectorManagedConnectionProcessInterceptor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.process.ProcessCallbackProcessInterceptor;
import org.mule.security.oauth.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeConnectorManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, HandshakeConnectorConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, HandshakeConnectorConnectionIdentifierAdapter> processInterceptor;

    public HandshakeConnectorManagedConnectionProcessTemplate(ConnectionManager<HandshakeConnectorConnectionKey, HandshakeConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, HandshakeConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, HandshakeConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, HandshakeConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new HandshakeConnectorManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, HandshakeConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, HandshakeConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, HandshakeConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, HandshakeConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
