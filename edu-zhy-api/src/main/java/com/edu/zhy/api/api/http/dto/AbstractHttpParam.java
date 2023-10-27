package com.edu.zhy.api.api.http.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractHttpParam implements Serializable {
    private static final long serialVersionUID = 894225858174287776L;

    //目前先不写到时候整合下参数  目前就是继承
    //参数给map
    Map<String, String> paramMap = new HashMap<>();


}
