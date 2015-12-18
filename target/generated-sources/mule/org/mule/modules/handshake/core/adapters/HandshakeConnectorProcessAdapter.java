
package org.mule.modules.handshake.core.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.handshake.core.HandshakeConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>HandshakeConnectorProcessAdapter</code> is a wrapper around {@link HandshakeConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeConnectorProcessAdapter
    extends HandshakeConnectorLifecycleAdapter
    implements ProcessAdapter<HandshakeConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, HandshakeConnectorCapabilitiesAdapter> getProcessTemplate() {
        final HandshakeConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,HandshakeConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, HandshakeConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, HandshakeConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
