
package org.mule.modules.handshake.core.holders;

import java.util.List;
import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class UserGroupExpressionHolder
    extends HandshakeObjectExpressionHolder
{

    protected Object name;
    protected String _nameType;
    protected Object id;
    protected String _idType;
    protected Object parent;
    protected String _parentType;
    protected Object categories;
    protected List<String> _categoriesType;
    protected Object resourceUri;
    protected String _resourceUriType;

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

    /**
     * Sets id
     * 
     * @param value Value to set
     */
    public void setId(Object value) {
        this.id = value;
    }

    /**
     * Retrieves id
     * 
     */
    public Object getId() {
        return this.id;
    }

    /**
     * Sets parent
     * 
     * @param value Value to set
     */
    public void setParent(Object value) {
        this.parent = value;
    }

    /**
     * Retrieves parent
     * 
     */
    public Object getParent() {
        return this.parent;
    }

    /**
     * Sets categories
     * 
     * @param value Value to set
     */
    public void setCategories(Object value) {
        this.categories = value;
    }

    /**
     * Retrieves categories
     * 
     */
    public Object getCategories() {
        return this.categories;
    }

    /**
     * Sets resourceUri
     * 
     * @param value Value to set
     */
    public void setResourceUri(Object value) {
        this.resourceUri = value;
    }

    /**
     * Retrieves resourceUri
     * 
     */
    public Object getResourceUri() {
        return this.resourceUri;
    }

}
