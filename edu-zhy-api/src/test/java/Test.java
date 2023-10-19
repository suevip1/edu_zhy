import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.dto.OfflineOrderHandleContext;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    //线程池
    private ThreadPoolExecutor threadPoolExecutor
            = new ThreadPoolExecutor(15, 30,
            0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),
            new ThreadFactoryBuilder().setNameFormat("ThreadPool-%d").build());




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

    @org.junit.Test
    public void m13 (){
//        Integer k =0;
//        List<TradeOrderEvent> list = new ArrayList();
//        TradeOrderEvent tradeOrderEvent2 = new TradeOrderEvent();
//        tradeOrderEvent2.setMin(10);
//        tradeOrderEvent2.setMax(15);
//        list.add(tradeOrderEvent2);
//
//        TradeOrderEvent tradeOrderEvent = new TradeOrderEvent();
//        tradeOrderEvent.setMin(8);
//        tradeOrderEvent.setMax(10);
//        list.add(tradeOrderEvent);
//
//        TradeOrderEvent tradeOrderEvent1 = new TradeOrderEvent();
//        tradeOrderEvent1.setMin(6);
//        tradeOrderEvent1.setMax(8);
//        list.add(tradeOrderEvent1);
//
//        for (int i = 0; i < list.size() - 1; i++) {
//            k++;
//            if (list.get(i).getMax() > list.get(i + 1).getMin()) {
//                System.err.println(list.get(i).getMax());
//                System.err.println(list.get(i + 1).getMin());
//            }
//
//            System.err.println("k"+k);
//        }


        System.err.println(15 % 1);


    }



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

//        List<Integer> list = new ArrayList<>();
//
//        System.err.println(convertTimeUpdatedAt(CREATE).before(convertTimeUpdatedAt(DATE)));
//
//        if (convertTimeUpdatedAt(CREATE).before(convertTimeUpdatedAt(DATE))
//                && convertTimeUpdatedAt(UPDATE).before(convertTimeUpdatedAt(DATE))){
//            list.add(1);
//        }
//
//        System.err.println(list);
        List<String> lists= Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19");
//        lists.parallelStream().forEach(o ->{
//
//            System.err.println(o+"时间:"+new Date());
//        });

        lists.stream().forEach(o ->{

            threadPoolExecutor.submit(() ->{

                System.err.println(o+"时间:"+ System.currentTimeMillis());
            });

        });






//        threadPoolExecutor.execute(() -> {
//            lists.stream().forEach(o ->{
//                System.err.println(o+"时间:"+ System.currentTimeMillis());
//            });
//
//        });



    }

    /**
     * *测试  CompletableFuture
     */
    public void  testCompletableFuture(List<String> lists){
        Integer i = 1;
//        lists.stream().map(o ->{
//
//            return o;
//        }).collect(Collectors.toList());

        for (String o : lists){
            i++;
            lists.add(String.valueOf(i));
        }


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
//        //错误文档
//        String errorFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\hotfix.txt";
//
//        List<String> lines1 = readLinesFromFile(errorFilePath);
//
//        String toJSONString = lines1.get(0);
//
//        System.err.println(toJSONString);
//
//        String s = JSON.toJSONString(toJSONString);
//
//
////        System.err.println(s);
//
//
//        TradeOrderEvent tradeOrderEvent = JSON.parseObject(toJSONString, TradeOrderEvent.class);

//        System.err.println(tradeOrderEvent);

//        System.err.println(JSON.toJSON(tradeOrderEvent));




//        System.err.println(toJSONString);

//        System.err.println(lines1.get(0));



//        TradeOrderEvent tradeOrderEvent = JSON.parseObject(toJSONString, TradeOrderEvent.class);
//
//        System.err.println(JSON.toJSON(tradeOrderEvent));


//        String sss = "[{\"attributeId\":8203224,\"attributeKey\":\"edu_stuName\",\"attributeTitle\":\"学员姓名\",\"dataType\":0,\"value\":\"潘萱\"},{\"attributeId\":8203231,\"attributeKey\":\"edu_stuContractPhone\",\"attributeTitle\":\"联系人手机\",\"dataType\":9,\"value\":\"15912523757\"},{\"attributeId\":8546731,\"attributeKey\":\"\",\"attributeTitle\":\"所在城市\",\"dataType\":7},{\"attributeId\":8213682,\"attributeKey\":\"edu_school\",\"attributeTitle\":\"就读学校\",\"dataType\":0},{\"attributeId\":8217414,\"attributeKey\":\"\",\"attributeTitle\":\"学生开学年级\",\"dataType\":7,\"value\":\"新4年级\"},{\"attributeId\":8688908,\"attributeKey\":\"\",\"attributeTitle\":\"礼品寄送地区\",\"dataType\":3,\"value\":\"云南省 昆明市 盘龙区\"},{\"attributeId\":8274126,\"attributeKey\":\"\",\"attributeTitle\":\"寄送详细地址\",\"dataType\":0,\"value\":\"美术小区\"},{\"attributeId\":8298915,\"attributeKey\":\"\",\"attributeTitle\":\"城市\",\"dataType\":0},{\"attributeId\":8465209,\"attributeKey\":\"\",\"attributeTitle\":\"上课手机号\",\"dataType\":1},{\"attributeId\":8609567,\"attributeKey\":\"\",\"attributeTitle\":\"在读班级\",\"dataType\":7},{\"attributeId\":8676705,\"attributeKey\":\"\",\"attributeTitle\":\"新学员年级\",\"dataType\":7},{\"attributeId\":8708233,\"attributeKey\":\"\",\"attributeTitle\":\"班级\",\"dataType\":0},{\"attributeId\":8711987,\"attributeKey\":\"\",\"attributeTitle\":\"介绍人联系方式\",\"dataType\":1},{\"attributeId\":10628702,\"attributeKey\":\"\",\"attributeTitle\":\"团长上课手机号\",\"dataType\":1,\"value\":\"0\"}]";
//        System.err.println(JSON.toJSON(sss));

        String ss1 ="{\"result\":{\"collection_activity_no\":\"0ju8be95j-fONmN30eJr2XQcA6t4x3SA\",\"goods_info_with_sku_vo_list\":[{\"goods_id\":527760301825,\"goods_name\":\"【资质齐全】Dyson戴森吹风机HD08护发 礼盒款\",\"goods_desc\":\"保证正品！送戴森气垫按摩梳，送完即止！\",\"price\":119900,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2023-05-27/ce5c5ed5-ea00-40a2-be1f-0c74d08bdb40.jpeg\",\"https://commimg.pddpic.com/monica/2023-05-27/83b547cc-1c12-447c-a7e1-ecb70c8c67d4.jpeg\",\"https://commimg.pddpic.com/monica/2023-05-27/ad5d1474-b28f-4490-b918-a37cc93b4ab5.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-05-27/44348c3c-c5c9-497a-a2d0-bdf8c103a83c.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-05-27/a5338e46-30ac-4964-aa3f-65185de42ff5.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-05-27/a949f488-ec82-480d-a336-bdd0c3287fdd.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-09-20/4ce648be-780c-483e-81af-59eb479a6718.jpeg.suffix.jpeg\"],\"quantity\":69999980,\"sold_quantity\":20,\"goods_status\":1,\"labels\":[],\"limit_buy\":0,\"start_buy\":0,\"min_buy\":0,\"foreign_goods_id\":19403706,\"category_name\":\"更多好货\",\"goods_activity_type\":0,\"subscribe\":false,\"source_type\":0,\"min_on_sale_group_price\":119900,\"max_on_sale_group_price\":119900,\"min_on_sale_normal_price\":119900,\"max_on_sale_normal_price\":119900,\"ignore_vip_discount\":false,\"weight\":0,\"is_zero_yuan\":false,\"cost_template_id\":\"0\",\"rank\":1,\"sold_count\":20,\"total_quantity\":70000000,\"quantity_type\":1,\"sku_list\":[{\"sku_id\":1458744174902,\"thumb_url\":\"\",\"is_on_sale\":1,\"spec_id_list\":[4059227455],\"spec_list\":[{\"spec_id\":4059227455,\"name\":\"紫红色\",\"parent_name\":\"默认规格\"}],\"price\":119900,\"price_in_yuan\":\"1199.00\",\"quantity_type\":1,\"quantity\":9999991,\"sold_quantity\":9,\"total_quantity\":10000000,\"reserve_quantity\":0,\"external_sku_id\":\"\",\"foreign_sku_id\":0},{\"sku_id\":1458744174903,\"thumb_url\":\"\",\"is_on_sale\":1,\"spec_id_list\":[3922352309],\"spec_list\":[{\"spec_id\":3922352309,\"name\":\"红色\",\"parent_name\":\"默认规格\"}],\"price\":119900,\"price_in_yuan\":\"1199.00\",\"quantity_type\":1,\"quantity\":9999999,\"sold_quantity\":1,\"total_quantity\":10000000,\"reserve_quantity\":0,\"external_sku_id\":\"\",\"foreign_sku_id\":0},{\"sku_id\":1458744174904,\"thumb_url\":\"\",\"is_on_sale\":1,\"spec_id_list\":[4012986402],\"spec_list\":[{\"spec_id\":4012986402,\"name\":\"银白色\",\"parent_name\":\"默认规格\"}],\"price\":119900,\"price_in_yuan\":\"1199.00\",\"quantity_type\":1,\"quantity\":9999998,\"sold_quantity\":2,\"total_quantity\":10000000,\"reserve_quantity\":0,\"external_sku_id\":\"\",\"foreign_sku_id\":0},{\"sku_id\":1458744174905,\"thumb_url\":\"\",\"is_on_sale\":1,\"spec_id_list\":[5085245505],\"spec_list\":[{\"spec_id\":5085245505,\"name\":\"黑镍色\",\"parent_name\":\"默认规格\"}],\"price\":119900,\"price_in_yuan\":\"1199.00\",\"quantity_type\":1,\"quantity\":9999999,\"sold_quantity\":1,\"total_quantity\":10000000,\"reserve_quantity\":0,\"external_sku_id\":\"\",\"foreign_sku_id\":0},{\"sku_id\":1458744174906,\"thumb_url\":\"\",\"is_on_sale\":1,\"spec_id_list\":[16300541249],\"spec_list\":[{\"spec_id\":16300541249,\"name\":\"亮铜镍色\",\"parent_name\":\"默认规格\"}],\"price\":119900,\"price_in_yuan\":\"1199.00\",\"quantity_type\":1,\"quantity\":9999999,\"sold_quantity\":1,\"total_quantity\":10000000,\"reserve_quantity\":0,\"external_sku_id\":\"\",\"foreign_sku_id\":0},{\"sku_id\":1458744174907,\"thumb_url\":\"\",\"is_on_sale\":1,\"spec_id_list\":[6697386943],\"spec_list\":[{\"spec_id\":6697386943,\"name\":\"紫红镍色\",\"parent_name\":\"默认规格\"}],\"price\":119900,\"price_in_yuan\":\"1199.00\",\"quantity_type\":1,\"quantity\":9999999,\"sold_quantity\":1,\"total_quantity\":10000000,\"reserve_quantity\":0,\"external_sku_id\":\"\",\"foreign_sku_id\":0},{\"sku_id\":1458744174908,\"thumb_url\":\"\",\"is_on_sale\":1,\"spec_id_list\":[6568035087],\"spec_list\":[{\"spec_id\":6568035087,\"name\":\"普鲁士蓝\",\"parent_name\":\"默认规格\"}],\"price\":119900,\"price_in_yuan\":\"1199.00\",\"quantity_type\":1,\"quantity\":9999995,\"sold_quantity\":5,\"total_quantity\":10000000,\"reserve_quantity\":0,\"external_sku_id\":\"\",\"foreign_sku_id\":0}],\"goods_cover\":\"https://commimg.pddpic.com/monica/2023-05-27/ce5c5ed5-ea00-40a2-be1f-0c74d08bdb40.jpeg\",\"is_virtual_goods\":false}],\"image_text_vos\":[{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-09-19/a0cc0f1d-d505-4d63-bb08-4f91d7aa3664.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-09-20/a2a4330d-8857-4563-8599-c0928d333509.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"进来的朋友第一个问题肯定是：是不是正品？\\n\\n我知道肯定有人有疑惑，想下手又不敢下手，这点我也是一样，再三跟渠道强调了，必须是正品！！\\n\\n大家买到手之后直接验证产品序列号，能在官网小程序验证就是正品！\\n\\n样品刚到手我就给大家验证了，肯定保真。\\n\\n为什么卖的便宜，懂的都懂！品牌清仓只能在私域，如果官方店铺直接降，品牌的价格体系就蹦了，对品牌伤害极大！\\n\\n这波福利太香了，缺点就是库存不多，拼手速！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-09-19/8eac7438-3e2f-4421-bd13-b0b8a2e9f3a5.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-09-19/108a0a3e-91dd-4a72-9420-ef9f8c292a8f.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-09-19/74c8fb4e-9d23-4537-a10f-db74f5d38eb7.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"要说吹风机哪个品牌最强，相信大部分人都会说是戴森吧？\\n\\n作为吹风机领域的“苹果”，戴森在消费者心理一直都是黑科技的代言词，特别是他家举世闻名的吹风机！！\\n\\n不仅可以快速干发，防止过高温度损伤秀发，还配有5款功能强大的风嘴，可以打造多款造型！\\n\\n采用数码马达&气流倍增技术，使得吹风机喷射3倍强劲气流，4分钟就能快速吹干！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/ca27d782-f871-490c-afd6-4c5045a09cdb.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/f361a26a-97e0-4939-b2db-282b4bc2139c.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"采用智能温控，同时又保证气流温度，通过柔和的大风量呵护头发与头皮，毛糙打结都是不存在的！\\n\\n自「戴森吹风机」一推出，许多博主就纷纷充当自来水军，到处安利。\\n\\n戴森吹风机得到过的评价有 图片\\n吹风机有两种，戴森和其他。\\n太好用了，会像对待初恋一样对待「戴森吹风机」。\\n吹完头发巨顺滑，还很自然。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/ff732746-1816-4691-abe8-cab658920a35.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/6235e66c-ad3c-48a6-a29f-3ca042fa4115.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/291013f1-ae19-41f9-98a6-10f5c9750843.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"实物是非常高级的磨砂质感，颜值真的非常高。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/40d98ccc-d512-4b89-9e5a-b0c70e856b29.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"七款颜色可选：紫红色、红色、银白色、黑镍色、亮铜镍色、紫红镍色、普鲁士蓝！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/c54b8b18-6ae3-47e4-9157-6785269fd236.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"好用是真的好用，但如果想买一只，真的要吃土，Dyson戴森官方旗舰店一只吹风机要3199元！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/71399052-a8cb-4068-a589-086e649c4869.png\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"今天在主播这只要1299元就能入手！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"戴森的创始人詹姆斯·戴森（James Dyson），出生于1947年。\\n\\n已经70多岁的戴森，是个不折不扣的黑科技发明家，被英国媒体誉为“英国设计之王”，有564项专利发明。\\n\\n戴森这家科技公司，由创始人詹姆斯戴森创立于1993年，在新加坡和英国皆设有研发和测试中心。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/5bf891b2-2094-4ba8-a625-2ad07f9a8f1c.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"发明的真空吸尘器、无扇叶空气净化风扇，俘获了一大票粉丝的芳心。\\n\\n这次耗时5年的研发出来的戴森吹风机，简直颠覆了大家对吹风机的认知！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"戴森吹风机配有V9数码马达，能够110,000转/分钟！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/2339e1c4-284b-46f8-b6ee-9ccec17e7190.png\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"它能产生高速、高压的强劲风力，快速吹走头发表面的水分，同时防止风温过高，实现温和吹干。\\n\\n戴森专利气流倍增技术，使吹风机喷射3倍强劲气流，强劲气流直达发根，快速吹走头发表面水分，干发无需过高温度。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/4bce5254-4561-4b30-bbe8-fc303f23b392.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"吹出丰盈靓丽秀发，让秀发保持水润柔亮飘逸，让美丽从头开始。\\n\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/9d2f0b4e-6eea-4515-b378-1e4444b667fd.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/7b25bfd3-f093-4b8f-bfef-4883bf46c22a.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"在戴森V9数码马达的支持下，高速气流将纳米大小的负离子从发根输送至发梢。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/0d227e95-084d-4045-a0d2-b9962ebebd17.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"负离子可以减少头发中的静电，帮助打造更顺滑的造型。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/90a445d7-6574-4b93-b1bd-938abf532fe5.png\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"还配有智能温控技术，每秒40余次精准监测，监测出风口温度，并将数据传达给处理器，确保风温不会超过150°C！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"减少头发毛躁，使发丝更加顺滑、更有光泽！\\n\\n\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/d9148236-8dc7-495d-a2f8-4ecf94f29471.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"除了吹风机本身，这款戴森吹风机还配备了5个不用的风嘴，方便我们在家都可以做出想要的造型。\\n\\n顺滑风嘴、造型风嘴、扩散风嘴、柔和风嘴、全新防飞翘风嘴。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/f3bf6b2e-420c-43a5-a39d-01da6f5489d8.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"顺滑风嘴：吹出顺滑直发\\n\\n搭配顺滑风嘴使用，能形成平滑、可控的气流，顺着发根到发尾的方向吹干，能减少头发毛躁，打造顺滑直发。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/1a40e657-2d4f-404b-9285-a8dd42f889fa.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"造型风嘴：做造型更顺利\\n\\n造型风嘴能让戴森吹风机的气流更宽更集中，搭配卷梳，帮你精准完成局部造型。\\n\\n更集中的气流，有助于避免在造型时吹乱其他头发，无论是帮助定型刘海，还是打造内扣发尾，都不在话下。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/806e94b6-80ba-44b6-9fd6-6622e932acf2.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"扩散风嘴：维持头发卷度\\n\\n在头发半干时，顺着卷发纹理，将发尾盘进扩散风嘴直至吹干，打造魅力卷发，营造蓬松度！\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/b1c86582-4429-49f6-9e37-3368ecbde062.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"柔和风嘴：打造蓬松造型\\n\\n风力更大更温和，吹出蓬松立体发型。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/7cc27e11-a415-41a3-870d-b302d7715ced.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"防飞翘风嘴：减少飞翘\\n\\n戴森在风嘴设计上更进一步，利用了神奇的康达效应，气流不仅帮你把较长的发丝自动吸引至表面，还能隐藏飞翘的头发。\\n\\n\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/e8d8bfc1-b742-4d87-9a5b-bd5fe25dadac.gif\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"握感舒适，专为手持平衡设计，单手握持轻巧方便。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/b668b49b-006f-484d-9de0-30bbcd7da4f2.jpeg\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"操作简单，滑动开关，3档精确风速设置，4档精确温度设置~\\n\\n内置滤网防止吸入灰尘和头发。\\n\\n\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":1,\"content\":\"https://commimg.pddpic.com/monica/2023-05-27/557b85f1-d11b-4c59-9bb1-95425b4855de.png\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0},{\"type\":3,\"content\":\"【品名】：【资质齐全】Dyson戴森吹风机HD08护发 礼盒款\\n【规格】：紫红色，紫红镍色，黑色，红色，亮铜镍色，普鲁士蓝，银白色\\n【产品原产国】：美国\\n【版本】：国行\\n【包装方式】：礼盒装\\n【快递】：顺丰\\n【发货地】：深圳\\n【运费模板】：全国包邮\\n【发货时效】：48小时\\n【售后政策】：支持七天无理由退换（不影响二次销售的基础上）\\n【质保】非人为因素，一年内免费质保，寄回维修，商家承担来回运费。\",\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0}],\"title\":\"\uD83D\uDC4F资质齐全！保证正品！Dyson戴森吹风机HD08护发 礼盒款\uD83C\uDF81立降2000元！！只要1199元\uD83D\uDCB5\uD83D\uDCB5巨划算‼️库存不多，今天下单还送同品牌气垫按摩发梳一个，送完即止‼️\\n\\n✅戴森集黑科技于一身的品牌\\n✅V9数码马达，强劲风力，快速吹干+\\n✅七款颜色可选，性价比真的好高\"}}\n";
        System.err.println(JSON.toJSONString(ss1));
    }









    @org.junit.Test
    public void hotfixStringV1(){
        String dateStr ="20230914";
        String pattern ="yyyyMMdd" ;
        //获取拉取时间
        System.err.println(parseDateString(dateStr,pattern));


//        //获取之前的时间
//        String DATE_PATTERN = "yyyy-MM-dd";
//
//        String format = format(new Date(), DATE_PATTERN);
//        System.err.println(format);
//
//        System.err.println(parseDateString(format,DATE_PATTERN));


    }







    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        FastDateFormat fdf = FastDateFormat.getInstance(pattern);
        return fdf.format(date);
    }




    public static Date parseDateString(String dateStr, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        if (StringUtils.isNotBlank(dateStr)) {
            try {
                date = format.parse(dateStr);
            } catch (ParseException e) {
            }
        }
        return date;
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
