
package org.mule.modules.handshake.core.holders;

import java.util.Date;
import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class HandshakeObjectExpressionHolder {

    protected Object mtime;
    protected Date _mtimeType;
    protected Object ctime;
    protected Date _ctimeType;
    protected Object objID;
    protected String _objIDType;

    /**
     * Sets mtime
     * 
     * @param value Value to set
     */
    public void setMtime(Object value) {
        this.mtime = value;
    }

    /**
     * Retrieves mtime
     * 
     */
    public Object getMtime() {
        return this.mtime;
    }

    /**
     * Sets ctime
     * 
     * @param value Value to set
     */
    public void setCtime(Object value) {
        this.ctime = value;
    }

    /**
     * Retrieves ctime
     * 
     */
    public Object getCtime() {
        return this.ctime;
    }

    /**
     * Sets objID
     * 
     * @param value Value to set
     */
    public void setObjID(Object value) {
        this.objID = value;
    }

    /**
     * Retrieves objID
     * 
     */
    public Object getObjID() {
        return this.objID;
    }

}
