package com.edu.zhy.api.api.http.service.httputiljiagou;

import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import com.edu.zhy.api.api.http.dto.AbstractHttpResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * *这点抽象出来
 */
@Slf4j
public abstract class
AbstractHttpService<K extends AbstractHttpRequest,V extends AbstractHttpParam,T extends AbstractHttpResponse>
        implements HttpUtilService<K , V , T > {




}
