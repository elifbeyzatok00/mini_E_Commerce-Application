
package com.example.beyzas;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BilgilerCevap {

    @SerializedName("bilgiler")
    @Expose
    private List<Bilgiler> bilgiler = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Bilgiler> getBilgiler() {
        return bilgiler;
    }

    public void setBilgiler(List<Bilgiler> bilgiler) {
        this.bilgiler = bilgiler;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
