package com.edu.zhy.api.api.dto;


/**
 * @author heyixin
 **/
@lombok.Data
public class LinkCourseHandleContext {
    private Long kdtId;
//    private com.edu.zhy.api.api.dto.LinkCourseHandleContext.RequestInfo requestInfo = new com.edu.zhy.api.api.dto.LinkCourseHandleContext.RequestInfo();
    private com.edu.zhy.api.api.dto.LinkCourseHandleContext.MiddleInfo middleInfo = new com.edu.zhy.api.api.dto.LinkCourseHandleContext.MiddleInfo();

//    @lombok.Data
//    static class RequestInfo {
//        private LinkCourseCommand linkCourseCommand;
//    }
//
//    public LinkCourseHandleContext(Long kdtId, LinkCourseCommand linkCourseCommand) {
//        this.kdtId = kdtId;
//        this.requestInfo.setLinkCourseCommand(linkCourseCommand);
//    }

    @lombok.Data
    static class MiddleInfo {
//        /**
//         * 订单信息
//         */
//        private FullOrderInfo orderInfo;
//        /**
//         * 查询的线下课商品数据
//         */
//        private java.util.Map<String, ProductDTO> goodsInfos;
//        /**
//         * 生成的 orderItemId -> 商品映射，orderItemId 用于在订单内唯一标识一件商品
//         */
//        private java.util.Map<Long, CourseChoiceDetailDTO> orderItemIdGoodsMap;
//        /**
//         * 保存或更新后的学员
//         */
//        private OrderCreateStudentDTO formattedStudentDTO;
//        /**
//         * 查询的线下课课程数据
//         */
//        private java.util.Map<String, CourseDetailLittleDTO> courseInfos;
//        /**
//         * 查询的 sku 信息
//         */
//        private CourseSkuBag courseSkuBag;
//        /**
//         * 合同简要信息
//         */
//        private SaleContractSimpleDTO saleContractSimpleDTO;
//        /**
//         * 分摊后的信息
//         */
//        private DevideResponseDTO devideResponseDTO;
//        /**
//         * 落库的每个商品可退金额
//         */
//        private java.util.List<OwlItemRpInfoDO> owlITemRpInfos;
//        /**
//         * 赠品信息
//         */
//        private java.util.List<GiveawayTermItemDTO> giveawayTermItemDTOS;
//        /**
//         * 补充到订单扩展的商品信息
//         */
//        private ExtEduInfoDTO extEduInfoDTO;
//        /**
//         * 价格校验汇总结果
//         */
//        private PriceCheckResult priceCheckResult;
        /**
         * 报名提交时间
         */
        private java.util.Date submitTime;
    }
}
