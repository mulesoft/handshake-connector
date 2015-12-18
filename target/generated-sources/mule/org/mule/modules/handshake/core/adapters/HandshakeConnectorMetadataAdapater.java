
package org.mule.modules.handshake.core.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.modules.handshake.core.HandshakeConnector;


/**
 * A <code>HandshakeConnectorMetadataAdapater</code> is a wrapper around {@link HandshakeConnector } that adds support for querying metadata about the extension.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeConnectorMetadataAdapater
    extends HandshakeConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Handshake";
    private final static String MODULE_VERSION = "2.0.0";
    private final static String DEVKIT_VERSION = "3.5.3";
    private final static String DEVKIT_BUILD = "UNNAMED.2049.ec39f2b";
    private final static String MIN_MULE_VERSION = "3.5.0";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

}
