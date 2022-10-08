
package com.example.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Hellow {

    private List<All> all = new ArrayList<All>();
    private List<OnLineList> onLineList = new ArrayList<OnLineList>();
    private List<OffLineList> offLineList = new ArrayList<OffLineList>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<All> getAll() {
        return all;
    }

    public void setAll(List<All> all) {
        this.all = all;
    }

    public List<OnLineList> getOnLineList() {
        return onLineList;
    }

    public void setOnLineList(List<OnLineList> onLineList) {
        this.onLineList = onLineList;
    }

    public List<OffLineList> getOffLineList() {
        return offLineList;
    }

    public void setOffLineList(List<OffLineList> offLineList) {
        this.offLineList = offLineList;
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
        return new HashCodeBuilder().append(all).append(onLineList).append(offLineList).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hellow) == false) {
            return false;
        }
        Hellow rhs = ((Hellow) other);
        return new EqualsBuilder().append(all, rhs.all).append(onLineList, rhs.onLineList).append(offLineList, rhs.offLineList).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
