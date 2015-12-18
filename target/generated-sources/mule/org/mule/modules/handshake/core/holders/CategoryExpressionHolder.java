
package org.mule.modules.handshake.core.holders;

import java.util.List;
import javax.annotation.Generated;
import org.mule.modules.handshake.core.CategorySubType;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-12-18T03:29:05-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class CategoryExpressionHolder
    extends HandshakeObjectExpressionHolder
{

    protected Object name;
    protected String _nameType;
    protected Object id;
    protected String _idType;
    protected Object categoryPosition;
    protected Integer _categoryPositionType;
    protected Object parent;
    protected String _parentType;
    protected Object subType;
    protected CategorySubType _subTypeType;
    protected Object subcategories;
    protected List<String> _subcategoriesType;
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
     * Sets categoryPosition
     * 
     * @param value Value to set
     */
    public void setCategoryPosition(Object value) {
        this.categoryPosition = value;
    }

    /**
     * Retrieves categoryPosition
     * 
     */
    public Object getCategoryPosition() {
        return this.categoryPosition;
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
     * Sets subType
     * 
     * @param value Value to set
     */
    public void setSubType(Object value) {
        this.subType = value;
    }

    /**
     * Retrieves subType
     * 
     */
    public Object getSubType() {
        return this.subType;
    }

    /**
     * Sets subcategories
     * 
     * @param value Value to set
     */
    public void setSubcategories(Object value) {
        this.subcategories = value;
    }

    /**
     * Retrieves subcategories
     * 
     */
    public Object getSubcategories() {
        return this.subcategories;
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
