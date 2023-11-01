package com.edu.zhy.api.api.http.service.httputiljiagou.Generator;

import com.edu.zhy.api.api.http.enums.GeneratorType;
import com.edu.zhy.api.api.http.service.httputiljiagou.AbstractCreateGenerator;
import com.edu.zhy.api.api.http.service.httputiljiagou.Context.PolyvContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.SendHttpContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.PolyvParam;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
public class PolyvGenerator extends AbstractCreateGenerator<PolyvContext, PolyvParam> {

    @Override
    public SendHttpContext generator(PolyvContext polyvContext, PolyvParam polyvParam) {
        SendHttpContext context = new SendHttpContext();

        context.setAbstractHttpRequest(polyvContext);
        context.setAbstractHttpParam(polyvParam);

        return context;
    }

    @Override
    public Integer generatorType() {
        return GeneratorType.PAOLIVAY_TYPE_GENERATOR.getType();
    }
}
