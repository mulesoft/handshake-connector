
package org.mule.modules.handshake.core.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.handshake.core.HandshakeConnector;


/**
 * A <code>HandshakeConnectorCapabilitiesAdapter</code> is a wrapper around {@link HandshakeConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeConnectorCapabilitiesAdapter
    extends HandshakeConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

}
