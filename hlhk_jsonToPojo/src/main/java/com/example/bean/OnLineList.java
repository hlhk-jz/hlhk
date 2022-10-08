
package com.example.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class OnLineList {

    private Integer id;
    private String label;
    private List<Child_> children = new ArrayList<Child_>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Child_> getChildren() {
        return children;
    }

    public void setChildren(List<Child_> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(label).append(children).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OnLineList) == false) {
            return false;
        }
        OnLineList rhs = ((OnLineList) other);
        return new EqualsBuilder().append(id, rhs.id).append(label, rhs.label).append(children, rhs.children).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
