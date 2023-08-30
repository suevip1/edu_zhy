import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.dto.OfflineOrderHandleContext;
import com.edu.zhy.api.api.dto.TradeOrderEvent;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    private static final String CREATE = "2022-12-01 23:59:59";

    private static final String UPDATE = "2022-12-09 23:59:59";


    private static final String DATE = "2022-12-31 23:59:59";
    /**
     * 默认时间格式
     */
    public static final String DEFAULT_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    private static final com.edu.zhy.api.api.spring.FrameworkThreadPoolExecutor threadPool
            = new com.edu.zhy.api.api.spring.FrameworkThreadPoolExecutor(4, 10, 30L
            , java.util.concurrent.TimeUnit.MILLISECONDS
            , new java.util.concurrent.LinkedBlockingQueue<>(50)
            , new com.google.common.util.concurrent.ThreadFactoryBuilder().setNameFormat("DowngradeWscTeacherPool-%d").build());

//    @javax.annotation.Resource
//    private HandleChainSelector handleChainSelector;
//    @javax.annotation.Resource
//    private DefaultHandlerChainSelector defaultHandlerChainSelector;
//
//    @org.junit.Test
//     public void m1 (){
//
//
//         // 逆向相关的责任链
////         RefundChainLoader refundChainLoader = DubboReflectionUtils.doWithFields(new RefundChainLoader(), DubboReflectionUtils.DEFAULT_DUBBO_FCV2, true);
//         com.edu.zhy.api.api.spring.HandleChainSelector handleChainSelector = org.mockito.Mockito.mock(com.edu.zhy.api.api.spring.HandleChainSelector.class);
//         org.mockito.stubbing.OngoingStubbing<com.edu.zhy.api.api.spring.HandleChain> when = org.mockito.Mockito.when(handleChainSelector.ofScene(com.edu.zhy.api.api.dto.HandleChainScene.REFUND.getName()));
//         System.err.println(when);
////         DubboReflectionUtils.targetClassContext.put(HandleChainSelector.class, handleChainSelector);
//
//
//     }

//    public static void main(String[] args) {
//
//        org.springframework.web.context.WebApplicationContext currentWebApplicationContext
//                = org.springframework.web.context.ContextLoader.getCurrentWebApplicationContext();
//
//        Object handlerChainRegistry = currentWebApplicationContext.getBean("defaultHandlerChainSelector");
//
//        String name = handlerChainRegistry.getClass().getName();
//        System.err.println(name);
//        try {
//            java.lang.reflect.Method ofScene = handlerChainRegistry.getClass().getClass().getDeclaredMethod("ofScene");
//            System.err.println(ofScene);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    @org.junit.jupiter.api.Test
    public void m12 (){

        java.util.List<String> a1 = new java.util.ArrayList<>(3);
        java.util.List<String> list = java.util.Arrays.asList("1","2","3","5","11","00","1010","2929","19191","122","1101");


        java.util.concurrent.CompletableFuture.runAsync(() -> {
            String name = Thread.currentThread().getName();
            for (String b1 : list){
                 a1.add(b1);
                System.err.println("当前执行的线程是"+name +"////"+a1);
            }

        },threadPool);

//        java.util.concurrent.CompletableFuture.runAsync(() -> {
//            String name = Thread.currentThread().getName();
//            for (String b1 : list){
//                a1.add(b1);
//                System.err.println("当前执行的线程是"+name +"////"+a1);
//            }
//
//        },threadPool);



//        java.util.List<String> a2 = new java.util.ArrayList<>(3);
//        java.util.List<String> list2 = java.util.Arrays.asList("1","2","3","5","11","00","1010","2929","19191","122","1101");
//
//
//        java.util.concurrent.CompletableFuture.runAsync(() -> {
//            String name = Thread.currentThread().getName();
//            for (String b1 : list2){
//                a2.add(b1);
//                System.err.println("当前执行的线程是"+name +"////"+a2);
//            }
//
//        },threadPool);
//
    }


    @org.junit.Test
    public void timeM1 (){
        List<Integer> list = new ArrayList<>();

        System.err.println(convertTimeUpdatedAt(CREATE).before(convertTimeUpdatedAt(DATE)));

        if (convertTimeUpdatedAt(CREATE).before(convertTimeUpdatedAt(DATE))
                && convertTimeUpdatedAt(UPDATE).before(convertTimeUpdatedAt(DATE))){
            list.add(1);
        }

        System.err.println(list);

    }

    @org.junit.Test
    public void timeM2 (){
        OfflineOrderHandleContext context = new OfflineOrderHandleContext();

//        Long is = 113L;
//
//        if (context.getKdtId().equals(is)){
//            System.err.println(1);
//        }
        Class<? extends OfflineOrderHandleContext> aClass = context.getClass();
//        System.err.println(aClass);

        String simpleName = aClass.getSimpleName();
//        System.err.println(simpleName);
//
//        ClassLoader classLoader = aClass.getClassLoader();
//        System.err.println(classLoader);

        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field ff:declaredFields){
            System.err.println(ff.getName());
        }


        try {
          Field contractNo = aClass.getDeclaredField("contractNo");
//            System.err.println(contractNo);
        } catch (NoSuchFieldException e) {


        }


    }


    @org.junit.Test
    public void hotfixString(){
        //错误文档
        String errorFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\hotfix.txt";

        List<String> lines1 = readLinesFromFile(errorFilePath);

        String toJSONString = lines1.get(0);

        System.err.println(toJSONString);

        String s = JSON.toJSONString(toJSONString);


//        System.err.println(s);


        TradeOrderEvent tradeOrderEvent = JSON.parseObject(toJSONString, TradeOrderEvent.class);

//        System.err.println(tradeOrderEvent);

//        System.err.println(JSON.toJSON(tradeOrderEvent));




//        System.err.println(toJSONString);

//        System.err.println(lines1.get(0));



//        TradeOrderEvent tradeOrderEvent = JSON.parseObject(toJSONString, TradeOrderEvent.class);
//
//        System.err.println(JSON.toJSON(tradeOrderEvent));

//
//        String sss = "{\"type\":2,\"origin\":1,\"data\":\"{\\\"activityType\\\":1,\\\"bizCategory\\\":\\\"COMMON\\\",\\\"bizTags\\\":{\\\"edu\\\":false,\\\"flowTypeValue\\\":839122975,\\\"fx\\\":false,\\\"fxModeType\\\":0,\\\"multiGoodsTypeModelType\\\":0,\\\"normal\\\":true,\\\"purchase\\\":false,\\\"salesModelType\\\":0,\\\"wholesaleOrder\\\":false},\\\"buyerDTO\\\":{\\\"beneficiary\\\":\\\"\\\",\\\"buyerId\\\":16062409576,\\\"buyerPhone\\\":\\\"18842778053\\\",\\\"fansId\\\":11747276020,\\\"fansType\\\":9},\\\"channelType\\\":\\\"YOUZAN\\\",\\\"closeReason\\\":\\\"\\\",\\\"closeType\\\":\\\"NORMAL\\\",\\\"closeTypeValue\\\":0,\\\"consumeStatus\\\":\\\"\\\",\\\"contractId\\\":2959404371319717908,\\\"createTime\\\":1692843877000,\\\"expiredTime\\\":1692845677987,\\\"extra\\\":{\\\"IS_OFFLINE\\\":\\\"0\\\",\\\"forceConsignmentMode\\\":\\\"0\\\",\\\"IS_ALL_SUB_ORDER_CANCEL\\\":\\\"1\\\",\\\"weAppPrepayId\\\":\\\"wx24102445989507de0c2b75cf64e9ef0000\\\",\\\"IS_MEMBER\\\":\\\"false\\\",\\\"PRRINCIPAL_CERT_TYPE\\\":\\\"2\\\",\\\"NEED_STOCK_UP\\\":\\\"0\\\",\\\"IS_USE_PARAM_PRICE\\\":\\\"0\\\",\\\"IS_SPLIT_STOCK_DEDUCT\\\":\\\"true\\\",\\\"BRAND_CERT_TYPE\\\":\\\"1\\\",\\\"OWNER_ID\\\":\\\"0\\\",\\\"FEE_MIGRATE_CHARGE_BY_TC\\\":\\\"true\\\",\\\"excludePayToolCode\\\":\\\"56,49,40\\\",\\\"CREATE_BY_NEW_TABLE\\\":\\\"1\\\",\\\"BUYER_PHONE\\\":\\\"18842778053\\\",\\\"PREPAY_RESULT\\\":\\\"{\\\\\\\"cashierSign\\\\\\\":\\\\\\\"19A7B226F5DEEAB647AD8D32B7DD388C\\\\\\\",\\\\\\\"acquireOrder\\\\\\\":\\\\\\\"2308241024382622060538\\\\\\\",\\\\\\\"cashierUrl\\\\\\\":\\\\\\\"https://cashier.youzan.com/pay/buyer?prepay_id=PT1775075462479873&cashier_sign=19A7B226F5DEEAB647AD8D32B7DD388C&cashier_salt=1692843878350&partner_id=810006274300&from=trade-core\\\\\\\",\\\\\\\"cashierSalt\\\\\\\":\\\\\\\"1692843878350\\\\\\\",\\\\\\\"partnerId\\\\\\\":\\\\\\\"810006274300\\\\\\\",\\\\\\\"prepayId\\\\\\\":\\\\\\\"PT1775075462479873\\\\\\\"}\\\",\\\"IS_BOS_FLOW\\\":\\\"true\\\",\\\"excludePayTool\\\":\\\"PF_OFFLINE_PAY,INSTALMENT,PRIOR_USE\\\",\\\"ENABLE_ACROSS_SHOP_VERIFY\\\":\\\"1\\\",\\\"WX_PAY_SYNC_SUCCESS\\\":\\\"true\\\",\\\"bankCardWaterNo\\\":\\\"\\\",\\\"WEAPP_TRADE_MODULE_STATUS\\\":\\\"1\\\",\\\"PAY_RETURN_URL\\\":\\\"https://shop42398976.youzan.com/wscvis/order/paid-status?orderNo={orderNo}&alias=2ovd28urkes1k&kdt_id=42206808\\\",\\\"FROM_CART\\\":\\\"true\\\",\\\"INNER_TRANSACTION_NO\\\":\\\"2308241024450002150538\\\",\\\"channelPayerId\\\":\\\"o0evEw3FHXxqSc9ratR60USIHzj0\\\",\\\"extend_version\\\":\\\"5\\\",\\\"USE_NEW_SNAPSHOT\\\":\\\"1\\\",\\\"IS_PREPAY\\\":\\\"true\\\",\\\"DECREASE\\\":\\\"5748\\\",\\\"ORDER_FROM_METHOD\\\":\\\"create\\\",\\\"IS_MERGE_PREPAY\\\":\\\"0\\\",\\\"OUTER_TRANSACTION_NO\\\":\\\"4200001949202308246520667139\\\",\\\"channelAppId\\\":\\\"wx818e0889f5f66323\\\",\\\"srcEnv\\\":\\\"prod\\\",\\\"SHOP_TOPIC\\\":\\\"1\\\",\\\"IS_POINTS_ORDER\\\":\\\"0\\\",\\\"USE_STORED_CUSTOMER_DISCOUNT\\\":\\\"false\\\",\\\"ATTR_FINANCE_TURNOVER_RANGE\\\":\\\"0011\\\",\\\"FANS\\\":\\\"{\\\\\\\"fansId\\\\\\\":11747276020,\\\\\\\"fansNickName\\\\\\\":\\\\\\\"印章公司副总裁\\\\\\\",\\\\\\\"outerUserId\\\\\\\":\\\\\\\"oHIuuji58OnsZnZh_IDLWW8cIMKY\\\\\\\",\\\\\\\"type\\\\\\\":9,\\\\\\\"youzanFansId\\\\\\\":11747276020}\\\",\\\"RISK_CONTROL_SEQ\\\":\\\"1775075457499882\\\",\\\"mchId\\\":\\\"181205100826000003\\\",\\\"IS_NEW_CROSS_BORDER_TARIFF_STRATEGY\\\":\\\"false\\\",\\\"PREPAY_SUCCESS\\\":\\\"true\\\",\\\"ORDER_TYPE\\\":\\\"0\\\",\\\"WEAPP_TRADE_MODULE_TICKET\\\":\\\"0\\\",\\\"BIZ_ORDER_ATTRIBUTE\\\":\\\"{\\\\\\\"EDU_ORDER_EVALUATE_STATE\\\\\\\":\\\\\\\"1\\\\\\\"}\\\",\\\"payTool\\\":\\\"WX_JS\\\",\\\"STOCK_DEDUCT_SCENE\\\":\\\"0\\\",\\\"FISSION_TICKET_NUM\\\":\\\"0\\\",\\\"WECHAT_SYNC_SHOPPING_LIST\\\":\\\"0\\\",\\\"AD_CPS_SHOP\\\":\\\"1\\\",\\\"REAL_PAY_AMOUNT\\\":\\\"15745\\\",\\\"BUYER_NAME\\\":\\\"印章公司副总裁\\\"},\\\"goodsType\\\":31,\\\"id\\\":2959404371319717909,\\\"logisticsDTO\\\":{\\\"extra\\\":{},\\\"logisticsType\\\":\\\"NONE\\\",\\\"receiverName\\\":\\\"\\\"},\\\"logisticsType\\\":3,\\\"memo\\\":\\\"\\\",\\\"orderItemDTOGroup\\\":[{\\\"extra\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"HEAD_SHOP_GOODS_STOCK\\\":\\\"1\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{}\\\",\\\"RECOMMEND_GIFT\\\":\\\"{\\\\\\\"buyerId\\\\\\\":0,\\\\\\\"fansId\\\\\\\":0,\\\\\\\"fansType\\\\\\\":0}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"cartCreateTime\\\\\\\":0,\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"extension\\\\\\\":{\\\\\\\"biz\\\\\\\":\\\\\\\"wsc\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"11747276020\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"h5\\\\\\\"}}\\\",\\\"FX_MODE\\\":\\\"1\\\"},\\\"goodsInfo\\\":{\\\"alias\\\":\\\"2ovd28urkes1k\\\",\\\"bizMarkCode\\\":\\\"000000000031\\\",\\\"buy_way\\\":1,\\\"categoryList\\\":[\\\"其他\\\"],\\\"class1\\\":0,\\\"class2\\\":\\\"\\\",\\\"extra\\\":{\\\"weight\\\":0.0},\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[10037,10020,90003,10023]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100000\\\"},\\\"goods_id\\\":446176469,\\\"goods_no\\\":\\\"突击课·C语言\\\",\\\"img_url\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fj-ac9t9Sh3qOrqh-LBI9_Bvm7dD.png\\\",\\\"isSupportInstallment\\\":false,\\\"is_virtual\\\":2,\\\"mark\\\":0,\\\"needCustomsCheck\\\":false,\\\"needCustomsInfo\\\":false,\\\"needCustomsPicture\\\":false,\\\"new_goods_no\\\":\\\"突击课·C语言\\\",\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"purchaseRight\\\":false,\\\"quota\\\":0,\\\"quotaType\\\":\\\"NO\\\",\\\"title\\\":\\\"《C语言》3h突击课\\\"},\\\"id\\\":2959404371319717910,\\\"memo\\\":\\\"\\\",\\\"num\\\":1,\\\"quotaNum\\\":0,\\\"realPay\\\":2738,\\\"skuDTO\\\":{\\\"currentPrice\\\":3999,\\\"imageUrl\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fj-ac9t9Sh3qOrqh-LBI9_Bvm7dD.png\\\",\\\"name\\\":\\\"《C语言》3h突击课\\\",\\\"originPrice\\\":3999,\\\"skuCode\\\":\\\"\\\",\\\"skuCompositeId\\\":{\\\"goodsId\\\":446176469,\\\"skuId\\\":36257816},\\\"skuMap\\\":\\\"[]\\\",\\\"type\\\":\\\"KNOWLEDGE\\\"},\\\"snapShot\\\":\\\"2dc4c135de174ad4e8c0e963601f729d\\\",\\\"tags\\\":{\\\"IS_VIRTUAL\\\":true}},{\\\"extra\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"HEAD_SHOP_GOODS_STOCK\\\":\\\"1\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{}\\\",\\\"RECOMMEND_GIFT\\\":\\\"{\\\\\\\"buyerId\\\\\\\":0,\\\\\\\"fansId\\\\\\\":0,\\\\\\\"fansType\\\\\\\":0}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"cartCreateTime\\\\\\\":0,\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"extension\\\\\\\":{\\\\\\\"biz\\\\\\\":\\\\\\\"wsc\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"11747276020\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"h5\\\\\\\"}}\\\",\\\"FX_MODE\\\":\\\"1\\\"},\\\"goodsInfo\\\":{\\\"alias\\\":\\\"26u6ybv2p95nc\\\",\\\"bizMarkCode\\\":\\\"000000000031\\\",\\\"buy_way\\\":1,\\\"categoryList\\\":[\\\"其他\\\"],\\\"class1\\\":0,\\\"class2\\\":\\\"\\\",\\\"extra\\\":{\\\"weight\\\":0.0},\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[10037,10020,90003,10023]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100001\\\"},\\\"goods_id\\\":448367503,\\\"goods_no\\\":\\\"突击课·气体与热力学\\\",\\\"img_url\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fni-whW2IUzMWZmAW_Uhm4AOqx8e.png\\\",\\\"isSupportInstallment\\\":false,\\\"is_virtual\\\":2,\\\"mark\\\":0,\\\"needCustomsCheck\\\":false,\\\"needCustomsInfo\\\":false,\\\"needCustomsPicture\\\":false,\\\"new_goods_no\\\":\\\"突击课·气体与热力学\\\",\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"purchaseRight\\\":false,\\\"quota\\\":0,\\\"quotaType\\\":\\\"NO\\\",\\\"title\\\":\\\"《气体与热力学》1.5h突击课\\\"},\\\"id\\\":2959404371319717911,\\\"memo\\\":\\\"\\\",\\\"num\\\":1,\\\"quotaNum\\\":0,\\\"realPay\\\":1368,\\\"skuDTO\\\":{\\\"currentPrice\\\":1999,\\\"imageUrl\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fni-whW2IUzMWZmAW_Uhm4AOqx8e.png\\\",\\\"name\\\":\\\"《气体与热力学》1.5h突击课\\\",\\\"originPrice\\\":1999,\\\"skuCode\\\":\\\"\\\",\\\"skuCompositeId\\\":{\\\"goodsId\\\":448367503,\\\"skuId\\\":36261195},\\\"skuMap\\\":\\\"[]\\\",\\\"type\\\":\\\"KNOWLEDGE\\\"},\\\"snapShot\\\":\\\"1d9aaed88ec8decf47a532bbd55fc8a4\\\",\\\"tags\\\":{\\\"IS_VIRTUAL\\\":true}},{\\\"extra\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"HEAD_SHOP_GOODS_STOCK\\\":\\\"1\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{}\\\",\\\"RECOMMEND_GIFT\\\":\\\"{\\\\\\\"buyerId\\\\\\\":0,\\\\\\\"fansId\\\\\\\":0,\\\\\\\"fansType\\\\\\\":0}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"cartCreateTime\\\\\\\":0,\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"extension\\\\\\\":{\\\\\\\"biz\\\\\\\":\\\\\\\"wsc\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"11747276020\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"h5\\\\\\\"}}\\\",\\\"FX_MODE\\\":\\\"1\\\"},\\\"goodsInfo\\\":{\\\"alias\\\":\\\"2xk7sse9qqgs8\\\",\\\"bizMarkCode\\\":\\\"000000000031\\\",\\\"buy_way\\\":1,\\\"categoryList\\\":[\\\"其他\\\"],\\\"class1\\\":0,\\\"class2\\\":\\\"\\\",\\\"extra\\\":{\\\"weight\\\":0.0},\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[10037,10020,90003,10023]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100002\\\"},\\\"goods_id\\\":446691245,\\\"goods_no\\\":\\\"突击课·振动与波动\\\",\\\"img_url\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fow1sWamOYkHlm11xnQkMlxjSzW-.png\\\",\\\"isSupportInstallment\\\":false,\\\"is_virtual\\\":2,\\\"mark\\\":0,\\\"needCustomsCheck\\\":false,\\\"needCustomsInfo\\\":false,\\\"needCustomsPicture\\\":false,\\\"new_goods_no\\\":\\\"突击课·振动与波动\\\",\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"purchaseRight\\\":false,\\\"quota\\\":0,\\\"quotaType\\\":\\\"NO\\\",\\\"title\\\":\\\"《振动与波动》1h突击课\\\"},\\\"id\\\":2959404371319717912,\\\"memo\\\":\\\"\\\",\\\"num\\\":1,\\\"quotaNum\\\":0,\\\"realPay\\\":683,\\\"skuDTO\\\":{\\\"currentPrice\\\":999,\\\"imageUrl\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fow1sWamOYkHlm11xnQkMlxjSzW-.png\\\",\\\"name\\\":\\\"《振动与波动》1h突击课\\\",\\\"originPrice\\\":999,\\\"skuCode\\\":\\\"\\\",\\\"skuCompositeId\\\":{\\\"goodsId\\\":446691245,\\\"skuId\\\":36253167},\\\"skuMap\\\":\\\"[]\\\",\\\"type\\\":\\\"KNOWLEDGE\\\"},\\\"snapShot\\\":\\\"8e5f545ebf5cc4651aa94c403a6202e3\\\",\\\"tags\\\":{\\\"IS_VIRTUAL\\\":true}},{\\\"extra\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"HEAD_SHOP_GOODS_STOCK\\\":\\\"1\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{}\\\",\\\"RECOMMEND_GIFT\\\":\\\"{\\\\\\\"buyerId\\\\\\\":0,\\\\\\\"fansId\\\\\\\":0,\\\\\\\"fansType\\\\\\\":0}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"cartCreateTime\\\\\\\":0,\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"extension\\\\\\\":{\\\\\\\"biz\\\\\\\":\\\\\\\"wsc\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"11747276020\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"h5\\\\\\\"}}\\\",\\\"FX_MODE\\\":\\\"1\\\"},\\\"goodsInfo\\\":{\\\"alias\\\":\\\"3eo3xbp8jblq0\\\",\\\"bizMarkCode\\\":\\\"000000000031\\\",\\\"buy_way\\\":1,\\\"categoryList\\\":[\\\"其他\\\"],\\\"class1\\\":0,\\\"class2\\\":\\\"\\\",\\\"extra\\\":{\\\"weight\\\":0.0},\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[10037,10020,90003,10023]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100003\\\"},\\\"goods_id\\\":446196541,\\\"goods_no\\\":\\\"突击课·力学\\\",\\\"img_url\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fu4irVaYaDayVFy1x-67cIFe3N5g.png\\\",\\\"isSupportInstallment\\\":false,\\\"is_virtual\\\":2,\\\"mark\\\":0,\\\"needCustomsCheck\\\":false,\\\"needCustomsInfo\\\":false,\\\"needCustomsPicture\\\":false,\\\"new_goods_no\\\":\\\"突击课·力学\\\",\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"purchaseRight\\\":false,\\\"quota\\\":0,\\\"quotaType\\\":\\\"NO\\\",\\\"title\\\":\\\"《力学》3h突击课\\\"},\\\"id\\\":2959404371319717913,\\\"memo\\\":\\\"\\\",\\\"num\\\":1,\\\"quotaNum\\\":0,\\\"realPay\\\":1368,\\\"skuDTO\\\":{\\\"currentPrice\\\":1999,\\\"imageUrl\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fu4irVaYaDayVFy1x-67cIFe3N5g.png\\\",\\\"name\\\":\\\"《力学》3h突击课\\\",\\\"originPrice\\\":1999,\\\"skuCode\\\":\\\"\\\",\\\"skuCompositeId\\\":{\\\"goodsId\\\":446196541,\\\"skuId\\\":36256659},\\\"skuMap\\\":\\\"[]\\\",\\\"type\\\":\\\"KNOWLEDGE\\\"},\\\"snapShot\\\":\\\"1312aa8796731ea2cc149a366845c50c\\\",\\\"tags\\\":{\\\"IS_VIRTUAL\\\":true}},{\\\"extra\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"HEAD_SHOP_GOODS_STOCK\\\":\\\"1\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{}\\\",\\\"RECOMMEND_GIFT\\\":\\\"{\\\\\\\"buyerId\\\\\\\":0,\\\\\\\"fansId\\\\\\\":0,\\\\\\\"fansType\\\\\\\":0}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"cartCreateTime\\\\\\\":0,\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"extension\\\\\\\":{\\\\\\\"biz\\\\\\\":\\\\\\\"wsc\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"11747276020\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"h5\\\\\\\"}}\\\",\\\"FX_MODE\\\":\\\"1\\\"},\\\"goodsInfo\\\":{\\\"alias\\\":\\\"361pp4y4z7at4\\\",\\\"bizMarkCode\\\":\\\"000000000031\\\",\\\"buy_way\\\":1,\\\"categoryList\\\":[\\\"其他\\\"],\\\"class1\\\":0,\\\"class2\\\":\\\"\\\",\\\"extra\\\":{\\\"weight\\\":0.0},\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[10037,10020,90003,10023]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100004\\\"},\\\"goods_id\\\":446127374,\\\"goods_no\\\":\\\"速成课·高数下\\\",\\\"img_url\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/FjK69VhPkaAv_x8RHcOvD3jDRjMR.png\\\",\\\"isSupportInstallment\\\":false,\\\"is_virtual\\\":2,\\\"mark\\\":0,\\\"needCustomsCheck\\\":false,\\\"needCustomsInfo\\\":false,\\\"needCustomsPicture\\\":false,\\\"new_goods_no\\\":\\\"速成课·高数下\\\",\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"purchaseRight\\\":false,\\\"quota\\\":0,\\\"quotaType\\\":\\\"NO\\\",\\\"title\\\":\\\"《高数下》4h突击课\\\"},\\\"id\\\":2959404371319717914,\\\"memo\\\":\\\"\\\",\\\"num\\\":1,\\\"quotaNum\\\":0,\\\"realPay\\\":2738,\\\"skuDTO\\\":{\\\"currentPrice\\\":3999,\\\"imageUrl\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/FjK69VhPkaAv_x8RHcOvD3jDRjMR.png\\\",\\\"name\\\":\\\"《高数下》4h突击课\\\",\\\"originPrice\\\":3999,\\\"skuCode\\\":\\\"\\\",\\\"skuCompositeId\\\":{\\\"goodsId\\\":446127374,\\\"skuId\\\":36262289},\\\"skuMap\\\":\\\"[]\\\",\\\"type\\\":\\\"KNOWLEDGE\\\"},\\\"snapShot\\\":\\\"0fc73b2ebb2ff68c8319c0b4ae2cc9bd\\\",\\\"tags\\\":{\\\"IS_VIRTUAL\\\":true}},{\\\"extra\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"HEAD_SHOP_GOODS_STOCK\\\":\\\"1\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{}\\\",\\\"RECOMMEND_GIFT\\\":\\\"{\\\\\\\"buyerId\\\\\\\":0,\\\\\\\"fansId\\\\\\\":0,\\\\\\\"fansType\\\\\\\":0}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"cartCreateTime\\\\\\\":0,\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"extension\\\\\\\":{\\\\\\\"biz\\\\\\\":\\\\\\\"wsc\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"11747276020\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"h5\\\\\\\"}}\\\",\\\"FX_MODE\\\":\\\"1\\\"},\\\"goodsInfo\\\":{\\\"alias\\\":\\\"2onz62r3d5uzs\\\",\\\"bizMarkCode\\\":\\\"000000000031\\\",\\\"buy_way\\\":1,\\\"categoryList\\\":[\\\"其他\\\"],\\\"class1\\\":0,\\\"class2\\\":\\\"\\\",\\\"extra\\\":{\\\"weight\\\":0.0},\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[10037,10020,90003,10023]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100005\\\"},\\\"goods_id\\\":885260841,\\\"goods_no\\\":\\\"突击课·信号与系统\\\",\\\"img_url\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/FgPboE2Gt0Ih8dVzGMcLRy-e4YqL.png\\\",\\\"isSupportInstallment\\\":false,\\\"is_virtual\\\":2,\\\"mark\\\":0,\\\"needCustomsCheck\\\":false,\\\"needCustomsInfo\\\":false,\\\"needCustomsPicture\\\":false,\\\"new_goods_no\\\":\\\"突击课·信号与系统\\\",\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"purchaseRight\\\":false,\\\"quota\\\":0,\\\"quotaType\\\":\\\"NO\\\",\\\"title\\\":\\\"《信号与系统》4h突击课\\\"},\\\"id\\\":2959404371319717915,\\\"memo\\\":\\\"\\\",\\\"num\\\":1,\\\"quotaNum\\\":0,\\\"realPay\\\":4110,\\\"skuDTO\\\":{\\\"currentPrice\\\":5999,\\\"imageUrl\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/FgPboE2Gt0Ih8dVzGMcLRy-e4YqL.png\\\",\\\"name\\\":\\\"《信号与系统》4h突击课\\\",\\\"originPrice\\\":5999,\\\"skuCode\\\":\\\"\\\",\\\"skuCompositeId\\\":{\\\"goodsId\\\":885260841,\\\"skuId\\\":37126555},\\\"skuMap\\\":\\\"[]\\\",\\\"type\\\":\\\"KNOWLEDGE\\\"},\\\"snapShot\\\":\\\"db1b1c06053134393c6345f038625767\\\",\\\"tags\\\":{\\\"IS_VIRTUAL\\\":true}},{\\\"extra\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"HEAD_SHOP_GOODS_STOCK\\\":\\\"1\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{}\\\",\\\"RECOMMEND_GIFT\\\":\\\"{\\\\\\\"buyerId\\\\\\\":0,\\\\\\\"fansId\\\\\\\":0,\\\\\\\"fansType\\\\\\\":0}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"cartCreateTime\\\\\\\":0,\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"extension\\\\\\\":{\\\\\\\"biz\\\\\\\":\\\\\\\"wsc\\\\\\\",\\\\\\\"uuid\\\\\\\":\\\\\\\"11747276020\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"h5\\\\\\\"}}\\\",\\\"FX_MODE\\\":\\\"1\\\"},\\\"goodsInfo\\\":{\\\"alias\\\":\\\"1y5d8u5xsvjrc\\\",\\\"bizMarkCode\\\":\\\"000000000031\\\",\\\"buy_way\\\":1,\\\"categoryList\\\":[\\\"其他\\\"],\\\"class1\\\":0,\\\"class2\\\":\\\"\\\",\\\"extra\\\":{\\\"weight\\\":0.0},\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[10037,10020,90003,10023]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100006\\\"},\\\"goods_id\\\":446197976,\\\"goods_no\\\":\\\"突击课·电路\\\",\\\"img_url\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fg45yInd-FIvbvzBNegrRX_YO1PX.png\\\",\\\"isSupportInstallment\\\":false,\\\"is_virtual\\\":2,\\\"mark\\\":0,\\\"needCustomsCheck\\\":false,\\\"needCustomsInfo\\\":false,\\\"needCustomsPicture\\\":false,\\\"new_goods_no\\\":\\\"突击课·电路\\\",\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"purchaseRight\\\":false,\\\"quota\\\":0,\\\"quotaType\\\":\\\"NO\\\",\\\"title\\\":\\\"《电路》4h突击课\\\"},\\\"id\\\":2959404371319717916,\\\"memo\\\":\\\"\\\",\\\"num\\\":1,\\\"quotaNum\\\":0,\\\"realPay\\\":2740,\\\"skuDTO\\\":{\\\"currentPrice\\\":3999,\\\"imageUrl\\\":\\\"https://img.yzcdn.cn/upload_files/2023/07/25/Fg45yInd-FIvbvzBNegrRX_YO1PX.png\\\",\\\"name\\\":\\\"《电路》4h突击课\\\",\\\"originPrice\\\":3999,\\\"skuCode\\\":\\\"\\\",\\\"skuCompositeId\\\":{\\\"goodsId\\\":446197976,\\\"skuId\\\":36262003},\\\"skuMap\\\":\\\"[]\\\",\\\"type\\\":\\\"KNOWLEDGE\\\"},\\\"snapShot\\\":\\\"498286e5a89844edee170a588e57b2d9\\\",\\\"tags\\\":{\\\"IS_VIRTUAL\\\":true}}],\\\"orderNo\\\":\\\"E20230824102437087200081\\\",\\\"orderStatus\\\":\\\"PAID\\\",\\\"orderType\\\":\\\"NORMAL\\\",\\\"outBizNo\\\":\\\"E20230824102437087200081\\\",\\\"payId\\\":\\\"2308241024382622060538\\\",\\\"payTime\\\":1692843894412,\\\"payType\\\":2,\\\"payWay\\\":\\\"WXPAY_DAIXIAO\\\",\\\"phase\\\":1,\\\"priceDTO\\\":{\\\"currentPrice\\\":15745,\\\"originPrice\\\":22993,\\\"postage\\\":0,\\\"promotionAmount\\\":0,\\\"totalPrice\\\":15745},\\\"promotion\\\":{\\\"changeType\\\":\\\"ump_order\\\",\\\"extra\\\":\\\"{\\\\\\\"condition\\\\\\\":\\\\\\\"满100元使用\\\\\\\",\\\\\\\"groupType\\\\\\\":7,\\\\\\\"couponType\\\\\\\":\\\\\\\"card\\\\\\\",\\\\\\\"couponId\\\\\\\":12943707130}\\\",\\\"newValue\\\":15745,\\\"oldValue\\\":17245,\\\"promotionAlias\\\":\\\"\\\",\\\"promotionId\\\":26813919,\\\"promotionName\\\":\\\"满100减15元券\\\",\\\"promotionType\\\":\\\"coupon\\\",\\\"promotionTypeId\\\":105,\\\"promotionTypeName\\\":\\\"优惠卡券\\\"},\\\"salesModelType\\\":0,\\\"sellerDTO\\\":{\\\"kdtId\\\":42206808,\\\"payKdtId\\\":42206808,\\\"rootKdtId\\\":0,\\\"shopId\\\":0,\\\"shopName\\\":\\\"蜂考旗舰店\\\",\\\"shopType\\\":\\\"NORMAL\\\",\\\"teamType\\\":\\\"WSC\\\"},\\\"source\\\":\\\"{\\\\\\\"bookKey\\\\\\\":\\\\\\\"ce3fe720-a17f-4d24-9505-efb555d12ef5\\\\\\\",\\\\\\\"clientIp\\\\\\\":\\\\\\\"112.41.192.56\\\\\\\",\\\\\\\"fromThirdApp\\\\\\\":false,\\\\\\\"isOnlineOrder\\\\\\\":true,\\\\\\\"isReceiveMsg\\\\\\\":1,\\\\\\\"newSource\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"platformEnum\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"WX\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"wxEntranceEnum\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"DIRECT_BUY\\\\\\\\\\\\\\\"}\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"weixin\\\\\\\",\\\\\\\"source\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"kdtId\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"42206808\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"clientIp\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"112.41.192.56\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"platform\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"weixin\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"isReceiveMsg\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"1\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"userAgent\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"Mozilla/5.0 (Linux; Android 8.1.0; BKK-AL10 Build/HONORBKK-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/9004425 MMWEBSDK/20230604 Mobile Safari/537.36 MMWEBID/2\\\\\\\",\\\\\\\"tradeMarks\\\\\\\":[]}\\\",\\\"tags\\\":{\\\"MESSAGE_NOTIFY\\\":true,\\\"IS_VIRTUAL\\\":true,\\\"USE_UMP_PROMOTION\\\":true,\\\"IS_SECURED_TRANSACTIONS\\\":true,\\\"USE_UMP_COUPON\\\":true,\\\"IS_PAYED\\\":true},\\\"updateTime\\\":1692843886219}\",\"orderType\":1,\"version\":2,\"extMap\":null,\"uniqueKey\":\"OTC_GtCqUvYcIqfFvChPmhpYCnJGsUZfuJYifDfJrmsASqAXEVOW\",\"__class__\":\"com.youzan.owl.goingmerry.api.event.TradeOrderEvent\"}";
//
//
//        System.err.println(sss.toString());

//         TradeOrderEvent tradeOrderEvent = JSON.parseObject(sss, TradeOrderEvent.class);
//
//         System.err.println(JSON.toJSON(tradeOrderEvent));

    }


    /**
     * *字符串转换为时间格式
     * @param date
     * @return
     */
    public static Date convertTimeUpdatedAt(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            date = StringUtils.trim(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_STR);
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }



    private static List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();

        // try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
