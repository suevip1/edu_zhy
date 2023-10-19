package com.edu.zhy.api.api.visibility;

public interface ExtensionDataAware {

    /**
     * 扩展字段getMethod
     * @return
     */
    String getExtensionData();

    /**
     * 扩展字段setMethod
     * @param extensionData
     */
    void setExtensionData(String extensionData);

}
