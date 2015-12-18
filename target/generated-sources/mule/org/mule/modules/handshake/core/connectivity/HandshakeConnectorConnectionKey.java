
package org.mule.modules.handshake.core.connectivity;

import javax.annotation.Generated;


/**
 * A tuple of connection parameters
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeConnectorConnectionKey {

    /**
     * 
     */
    private String apiKey;
    /**
     * 
     */
    private String securityToken;

    public HandshakeConnectorConnectionKey(String apiKey, String securityToken) {
        this.apiKey = apiKey;
        this.securityToken = securityToken;
    }

    /**
     * Sets securityToken
     * 
     * @param value Value to set
     */
    public void setSecurityToken(String value) {
        this.securityToken = value;
    }

    /**
     * Retrieves securityToken
     * 
     */
    public String getSecurityToken() {
        return this.securityToken;
    }

    /**
     * Sets apiKey
     * 
     * @param value Value to set
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

    /**
     * Retrieves apiKey
     * 
     */
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public int hashCode() {
        int result = ((this.apiKey!= null)?this.apiKey.hashCode(): 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HandshakeConnectorConnectionKey)) {
            return false;
        }
        HandshakeConnectorConnectionKey that = ((HandshakeConnectorConnectionKey) o);
        if (((this.apiKey!= null)?(!this.apiKey.equals(that.apiKey)):(that.apiKey!= null))) {
            return false;
        }
        return true;
    }

}
