package com.edu.zhy.api.api.visibility;

import com.alibaba.fastjson.JSON;
import com.edu.zhy.biz.dubboBean.Result.CommonResult;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Auther: zishan
 * @Date: 2019-08-05
 */
@Slf4j
public class VisibilityClient {

//    public VisibilityClient(HidingFacade hidingConfigFacade) {
//        this.hidingConfigFacade = hidingConfigFacade;
//    }
//
//    private HidingFacade hidingConfigFacade;

    /**
     * 获取信息隐藏配置
     *
     * @param reference
     * @return
     */
    public List<HidingConfigDTO> getReferenceConfig(String reference) {
        CommonResult<List<HidingConfigDTO>> result = null ;
        try {
//            CommonResult<List<HidingConfigDTO>> result = hidingConfigFacade.queryListByReference(reference);
            if (result != null && result.isSuccess()) {
                return result.getData();
            }
        } catch (Exception e) {
            log.info("VisibilityClient.getReferenceConfig error, reference:{}", reference, e);
        }
        return null;
    }


    /**
     * 获取信息隐藏是否展示
     *
     * @param indicatorId
     * @return true：展示  false：隐藏
     */
    public VisibilityConfigDTO queryDisplayByConfig(Long kdtId, String indicatorId, SwitchDisplayQuery query) {
        CommonResult<VisibilityConfigDTO> result = null;
        try {
//            CommonResult<VisibilityConfigDTO> result = hidingConfigFacade.queryDisplayByConfig(kdtId, indicatorId, query);
            if (result != null && result.isSuccess()) {
                return result.getData();
            }
        } catch (Exception e) {
            log.warn("VisibilityClient.queryDisplayByConfig error, kdtId:{}, indicatorId{}, query:{}", kdtId, indicatorId, JSON.toJSONString(query), e);
        }
        return null;
    }

}
