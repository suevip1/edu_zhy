package com.edu.zhy.api.api.http.service.httputiljiagou;

import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendHttpContext implements Serializable {
    private static final long serialVersionUID = -6324731013447672667L;

    //这里需要请求的共同参数
    private AbstractHttpRequest abstractHttpRequest;

    private AbstractHttpParam abstractHttpParam;


}
