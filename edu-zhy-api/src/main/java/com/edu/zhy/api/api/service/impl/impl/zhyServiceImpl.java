package com.edu.zhy.api.api.service.impl.impl;

import com.edu.zhy.api.api.service.impl.aop.ZhyAopLog;
import com.edu.zhy.api.api.service.impl.context.zhyAopEnum;
import com.edu.zhy.api.api.service.impl.zhyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class zhyServiceImpl implements zhyService {

    @Override
    @ZhyAopLog(after = zhyAopEnum.COLLECT_INFO_SET,before = zhyAopEnum.COLLECT_INFO_SET,subOptType ="afterProcess" )
    public void afterProcess(Integer type) {
        log.info("开始进来执行afterProcess接口"+type);
        return ;
    }

    @Override

    public Boolean checkProcess(Integer type) {
        return null;
    }

    @Override
    public void beforeProcess(Integer type) {
        return;
    }
}
