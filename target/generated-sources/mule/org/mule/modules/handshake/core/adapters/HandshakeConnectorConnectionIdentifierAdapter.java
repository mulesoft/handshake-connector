
package org.mule.modules.handshake.core.adapters;

import javax.annotation.Generated;
import org.mule.modules.handshake.core.HandshakeConnector;
import org.mule.modules.handshake.core.connection.Connection;


/**
 * A <code>HandshakeConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link HandshakeConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeConnectorConnectionIdentifierAdapter
    extends HandshakeConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
