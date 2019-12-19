package com.codelink.humiandtemp.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class HumiAndTemp implements Serializable {

    private static final long serialVersionUID = -4312603417509542093L;

    private Integer collectnum;
    private String tempvalue;
    private String humivalue;
    private Timestamp valuetime;

    public HumiAndTemp(){
        super();
    }

    public HumiAndTemp(Integer collectnum, String tempvalue, String humivalue, Timestamp valuetime) {
        this.collectnum = collectnum;
        this.tempvalue = tempvalue;
        this.humivalue = humivalue;
        this.valuetime = valuetime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(Integer collectnum) {
        this.collectnum = collectnum;
    }

    public String getTempvalue() {
        return tempvalue;
    }

    public void setTempvalue(String tempvalue) {
        this.tempvalue = tempvalue;
    }

    public String getHumivalue() {
        return humivalue;
    }

    public void setHumivalue(String humivalue) {
        this.humivalue = humivalue;
    }

    public Timestamp getValuetime() {
        return valuetime;
    }

    public void setValuetime(Timestamp valuetime) {
        this.valuetime = valuetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumiAndTemp that = (HumiAndTemp) o;
        return collectnum.equals(that.collectnum) &&
                tempvalue.equals(that.tempvalue) &&
                humivalue.equals(that.humivalue) &&
                valuetime.equals(that.valuetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectnum, tempvalue, humivalue, valuetime);
    }

    @Override
    public String toString() {
        return "HumiAndTemp{" +
                "collectnum=" + collectnum +
                ", tempvalue='" + tempvalue + '\'' +
                ", humivalue='" + humivalue + '\'' +
                ", valuetime=" + valuetime +
                '}';
    }
}
