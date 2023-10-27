package com.edu.zhy.api.api.http.service.httputiljiagou.Generator;

import com.edu.zhy.api.api.http.enums.GeneratorType;
import com.edu.zhy.api.api.http.service.httputiljiagou.AbstractCreateGenerator;
import com.edu.zhy.api.api.http.service.httputiljiagou.Context.CommonContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.SendHttpContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.CommonParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommonGenerator extends AbstractCreateGenerator<CommonContext , CommonParam > {
    @Override
    public SendHttpContext generator(CommonContext commonContext, CommonParam commonParam) {

        //这里可以作为一些拓展来进行不同属性的转换
        SendHttpContext context = new SendHttpContext();

        context.setAbstractHttpRequest(commonContext);
        context.setAbstractHttpParam(commonParam);

        return context;
    }

    @Override
    public Integer generatorType() {
        return GeneratorType.COMMON_TYPE_GENERATOR.getType();
    }
}
