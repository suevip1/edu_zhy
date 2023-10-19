package com.edu.zhy.api.api.visibility;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HideInfoTestBean implements ExtensionDataAware {

    private Long id;

    private Long kdtId;

    private String alias;

    private String name;

    private Long hideA;

    private Long hideB;

    private HideInfoTestBean bean;

    private List<HideInfoTestBean> beanList;

    private Map<String, HideInfoTestBean> beanMap;
    private String extensionData;

    @Override
    public String getExtensionData() {
        return extensionData;
    }

    @Override
    public void setExtensionData(String extensionData) {
        this.extensionData = extensionData;
    }

}
