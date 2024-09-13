import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.dto.OfflineOrderHandleContext;
import com.edu.zhy.api.api.dto.UserDTO;
import com.edu.zhy.api.api.http.service.httputiljiagou.HttpUtilService;
import com.edu.zhy.api.api.http.service.httputiljiagou.impl.CommonHttpUtilServiceImpl;
import com.edu.zhy.api.api.http.service.httputiljiagou.initutil.InitApplicationContextUtil;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.edu.zhy.text.BitStateTag;
import com.edu.zhy.text.EduLiveVideoFetchRequest;
import com.edu.zhy.text.StringMap;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test {

    //线程池
    private ThreadPoolExecutor threadPoolExecutor
            = new ThreadPoolExecutor(15, 30,
            0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),
            new ThreadFactoryBuilder().setNameFormat("ThreadPool-%d").build());



    public static String DATE_PATTERN_SIMPLE = "yyyy-MM-dd HH:mm:ss";


    private static final String CREATE = "2022-12-01 23:59:59";

    private static final String UPDATE = "2022-12-09 23:59:59";


    private static final String DATE = "2022-12-31 23:59:59";

    private static final String INTERVAL = ":";
    private static final String CQ = "cq";
    private static final String FA = "fa";
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
    public void readXlsTest(){

//        getFileInputStreamV2();

        getFileInputStreamV3();

    }

    @org.junit.Test
    public void bit(){

        Set<Integer> roles = getRoles(1L);

        System.err.println(roles);


    }


    public static Set<Integer> getRoles(Long bitState) {
        if (bitState == null) {
            return Sets.newHashSet(4);
        }
        return Arrays.stream(BitStateTag.values())
                .filter(b -> (bitState & (1 << b.getBitPosition())) != 0)
                .map(BitStateTag::getRole)
                .filter(i -> i != -1)
                .collect(Collectors.toSet());
    }


    @org.junit.Test
    public void mmmm11(){
        Long kdtId = 491391L;
        String bizKey ="recruit";

        String format = String.format("youzan:ebiz-salesman_sl_shop_st:%s_%s", bizKey, kdtId);

        System.err.println(format);

    }

    @org.junit.Test
    public void  sss233(){
        String url = "fa3f3ffyzqj0d9y";
        UserDTO  userDTO = new UserDTO();

        Boolean aBoolean = checkAddStateV2(userDTO.getName());
        System.err.println(aBoolean);

    }


    private Boolean checkAddState(String addState) {
        if (StringUtils.isEmpty(addState)) {
            return false;
        }
        //不包含:,cq,fa字符 直接返回
        //!addState.contains("cq") || !addState.contains("fa")
        if (!addState.contains(":") || !(addState.contains("cq") || addState.contains("fa"))) {
            System.err.println("不包含:,cq,fa字符 直接返回");
            return false;
        }
        int indexOf = addState.indexOf(":");
        //截取第一个: 开头字符
        String addChannel = addState.substring(0, indexOf);
        System.err.println(addChannel);
        return Objects.equals(addChannel, "cq") || Objects.equals(addChannel, "fa");
    }


    private Boolean checkAddStateV2(String addState) {
        if (StringUtils.isEmpty(addState)) {
            return false;
        }
        //不包含:,cq,fa字符 直接返回
        if (!addState.contains(INTERVAL)) {
            System.err.println(" 添加渠道非指定格式 添加渠道效验不通过 addState={}" + addState);
            return false;
        }
        if (!(addState.contains(CQ) || addState.contains(FA))) {
            System.err.println(" 不是去重活码或加粉链接 添加渠道效验不通过 addState={}" + addState);
            return false;
        }
        int indexOf = addState.indexOf(INTERVAL);
        //截取第一个: 开头字符
        String addChannel = addState.substring(0, indexOf);
        return Objects.equals(addChannel, CQ) || Objects.equals(addChannel, FA);
    }

    @org.junit.Test
    public void sss11(){
        String path = "upload_edu_live/yz-test-video/2024/07/01/237340/a5f3b134bb68895cd48b54b359a4e475.mp4";

        // 找到第二个 '/' 的位置
        int secondSlashIndex = path.indexOf('/', path.indexOf('/') + 1);

        // 找到第三个 '/' 的位置
        int thirdSlashIndex = path.indexOf('/', secondSlashIndex + 1);

        // 使用substring方法从路径中截取目标信息
        String targetInfo = path.substring(secondSlashIndex + 1, thirdSlashIndex);

        System.out.println("截取的中间部分信息为: " + targetInfo);

    }

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

//        Long i = Optional.ofNullable(1L).orElse(null);
//
//        System.err.println(15 % 1);

//        int totalPages = (int) Math.ceil(1 * 1.0 / 20);
//        System.err.println(totalPages);




        String s = buildRowKey(1, 43719199L, "15078479");

        System.err.println(s);


        String reverse = StringUtils.reverse("15078479");
        System.err.println(reverse);


    }
    public static String buildRowKey(Integer bizType, Long kdtId, String entityId) {
        return StringUtils.reverse(entityId) + "_" + kdtId + "_" + bizType;
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
        //错误文档
        String errorFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\text\\feild.txt";

        List<String> lines1 = readLinesFromFile(errorFilePath);

        String toJSONString = lines1.get(0);

        EduLiveVideoFetchRequest eduLiveVideoFetchRequest = JSON.parseObject(toJSONString, EduLiveVideoFetchRequest.class);
        System.err.println(eduLiveVideoFetchRequest);
        System.err.println(eduLiveVideoFetchRequest.getRequestBody());
        System.err.println(eduLiveVideoFetchRequest.getHeaders());
        StringMap put = new StringMap().put("requestBody", eduLiveVideoFetchRequest.getRequestBody()).put("headers", eduLiveVideoFetchRequest.getHeaders());

        System.err.println(put);

    }



    @org.junit.Test
    public void zhy12222(){
       String callBackBody = "{“requestBody”:{“bucket”:\"$(bucket)\",“persistentId”:\"$(persistentId)\",“fname”:\"$(fname)\",“avInfo”:\"$(avInfo)\",“key”:\"$(path)\",“mimeType”:\"$(mimeType)\",“size”:\"$(fsize)\",“ext”:\"$(ext)\"},“headers”:{“Authorization”:\"Qiniu \"}}";
        EduLiveVideoFetchRequest eduLiveVideoFetchRequest = JSON.parseObject(callBackBody, EduLiveVideoFetchRequest.class);
        System.err.println(eduLiveVideoFetchRequest);
        System.err.println(eduLiveVideoFetchRequest.getRequestBody());
        System.err.println(eduLiveVideoFetchRequest.getHeaders());
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
//        Date synt = new Date() ;
//
//        System.err.println(synt.getTime());



    }



    @org.junit.Test
    public void httpV1(){
        HttpUtilService instance = InitApplicationContextUtil
                .getInstance(CommonHttpUtilServiceImpl.class);

        System.err.println(instance);

        InitApplicationContextUtil.closeClient();



    }


    @org.junit.Test
    public void httpv2(){
//
//        HttpUtilService dispatch = ApplicationContextHelper
//                .dispatch(HttpUtilService.class, RequestType.COMMON_TYPE.getName(), "getHttpType");
//
//        System.err.println(dispatch);
//
//
//        CommonHttpUtilServiceImpl instance = InitApplicationContextUtil.getInstance(CommonHttpUtilServiceImpl.class);
//        System.err.println(instance);
//        instance.executeCommon();

    }






    /**
     * 校验商品活动时间 是否在 报名活动时间内
     * @param umpStart
     * @param umpEnd
     * @param start
     * @param end
     * @return
     */
    private boolean compareUmpDate(int umpStart, int umpEnd, Date start, Date end) {
        Date secKillBeginAt = transDate(umpStart, DATE_PATTERN_SIMPLE);

        System.err.println(secKillBeginAt);
//        Date secKillEndAt = transDate(umpEnd, DATE_PATTERN_SIMPLE);

        LocalDateTime secKillBeginLocalDt =
                toLocalDateTime(secKillBeginAt);
//        LocalDateTime secKillEndLocalDt =
//                toLocalDateTime(secKillEndAt);

        LocalDateTime startLocalDt = toLocalDateTime(start);
//        LocalDateTime endLocalDt = toLocalDateTime(end);

        System.out.println("star:"+secKillBeginLocalDt.compareTo(startLocalDt));

        if (secKillBeginLocalDt.compareTo(startLocalDt) != 0) {
//            LoggerUtil.info(
//                    log,
//                    "getUmpInfoWithTime,  goodsUmpStartTime not the same as start, goodsUmpStart={0}, start={1}",
//                    secKillBeginLocalDt,
//                    startLocalDt);

            System.err.println("开始时间效验start:{"+secKillBeginLocalDt.compareTo(startLocalDt));

            return false;
        }

//        if (secKillEndLocalDt.isBefore(endLocalDt)) {
////            LoggerUtil.info(
////                    log,
////                    "getUmpInfoWithTime, goodsUmpEndTime isBefore endTime, goodsUmpEnd={0}, end={1}",
////                    secKillEndLocalDt,
////                    endLocalDt);
//            System.err.println("结束时间效验end:{"+secKillEndLocalDt.isBefore(endLocalDt));
//
//
//            return false;
//        }
        return true;
    }




    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }


    /** 将int值转为Date */
    public static Date transDate(int dateTime, String pattern) {

        try {
            long timeLong = Long.valueOf(dateTime).longValue() * 1000;
            DateFormat sdf = new SimpleDateFormat(pattern);
            String format = sdf.format(timeLong);
            Date date = sdf.parse(format);
            return date;
        } catch (Exception e) {
           throw new BusinessException(-100,"");
        }
    }



    //以上限时折扣效验时间接口



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




    private void getFileInputStream() {

        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\新建文件夹\\副本保利威要链接下载暂存视频带日期过滤-处理404  - 副本.xlsx")) {
            // 读取xlsx文件
            XSSFWorkbook sheets = new XSSFWorkbook(fileIn);
            XSSFSheet sheetXlsx = sheets.getSheetAt(0);

            // 创建新的xls文件
            HSSFWorkbook workbookXls = new HSSFWorkbook();
            HSSFSheet sheetXls = workbookXls.createSheet("Sheet1");

            for (int i = sheetXlsx.getFirstRowNum(); i <= sheetXlsx.getLastRowNum() && i <= 65535; i++) {
                Row rowXlsx = sheetXlsx.getRow(i);
                Row rowXls = sheetXls.createRow(i);
                for (int j = rowXlsx.getFirstCellNum(); j < rowXlsx.getLastCellNum(); j++) {
                    Cell cellXlsx = rowXlsx.getCell(j);
                    Cell cellXls = rowXls.createCell(j);
                    if (cellXlsx != null) {
                        if (cellXlsx == null) {
                            cellXls.setCellValue("");
                        } else if (cellXlsx.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cellXlsx)) {
                            Date date = cellXlsx.getDateCellValue();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            String formattedDate = sdf.format(date);
                            cellXls.setCellValue(formattedDate);
                        } else if (cellXlsx.getCellType() == CellType.STRING){
                            cellXls.setCellType(CellType.STRING);
                            cellXls.setCellValue(cellXlsx.getStringCellValue());
                        } else {
                            // 取出cell中的value
                            cellXls.setCellValue(cellXlsx.toString());
                        }
                    }
                }
            }


            // 写入到xls文件
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\文件\\excel\\cesh.xls")) {
                workbookXls.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 限制读取行数
     */
    private void getFileInputStreamV2() {
        Integer rowNum = 30000;

        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\mp4处理\\保利威处理七牛名单MP4-12026-余下的全部.xls")) {
            // 读取xlsx文件
            XSSFWorkbook sheets = new XSSFWorkbook(fileIn);
            XSSFSheet sheetXlsx = sheets.getSheetAt(0);

            // 创建新的xls文件
            HSSFWorkbook workbookXls = new HSSFWorkbook();
            HSSFSheet sheetXls = workbookXls.createSheet("Sheet1");

            for (int i = sheetXlsx.getFirstRowNum(); i <= sheetXlsx.getLastRowNum() && i <= rowNum; i++) {
                Row rowXlsx = sheetXlsx.getRow(i);
                Row rowXls = sheetXls.createRow(i);
                for (int j = rowXlsx.getFirstCellNum(); j < rowXlsx.getLastCellNum(); j++) {
                    Cell cellXlsx = rowXlsx.getCell(j);
                    Cell cellXls = rowXls.createCell(j);
                    if (cellXlsx != null) {
                        switch (cellXlsx.getCellType()) {
                            case STRING:
                                cellXls.setCellValue(cellXlsx.getStringCellValue());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cellXlsx)){
                                    Date date = cellXlsx.getDateCellValue();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                    String formattedDate = sdf.format(date);
                                    cellXls.setCellValue(formattedDate);
                                }else {
                                    cellXls.setCellValue(cellXlsx.getNumericCellValue());
                                }
                                break;
                            case BOOLEAN:
                                cellXls.setCellValue(cellXlsx.getBooleanCellValue());
                                break;
                            case FORMULA:
                                cellXls.setCellFormula(cellXlsx.getCellFormula());
                                break;
                            default:
                                cellXls.setCellValue(cellXlsx.toString());
                        }
                    }
                }
            }


            // 写入到xls文件
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\mp4处理\\保利威处理七牛名单mp4-12026-前3万.xls")) {
                workbookXls.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 跳过读取行数
     * 带跳过属性
     */
    private void getFileInputStreamV3() {
        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\mp4处理\\副本保利威要链接下载暂存视频带日期过滤-处理404  - 副本.xlsx")) {
//            HSSFWorkbook workbookXlsx = new HSSFWorkbook(fileIn);
            Workbook workbookXlsx = new XSSFWorkbook(fileIn);
            Sheet sheetXlsx = workbookXlsx.getSheetAt(0);
            HSSFWorkbook workbookXls = new HSSFWorkbook();
            Sheet sheetXls = workbookXls.createSheet("Sheet1");

            int skipRows = 29063;
            for (int i = skipRows; i <= sheetXlsx.getLastRowNum(); i++) {
                Row rowXlsx = sheetXlsx.getRow(i);
                Row rowXls = sheetXls.createRow(i - skipRows);
                for (int j = rowXlsx.getFirstCellNum(); j < rowXlsx.getLastCellNum(); j++) {
                    Cell cellXlsx = rowXlsx.getCell(j);
                    Cell cellXls = rowXls.createCell(j);
                    if (cellXlsx != null) {
                        switch (cellXlsx.getCellType()) {
                            case STRING:
                                cellXls.setCellValue(cellXlsx.getStringCellValue());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cellXlsx)){
                                    Date date = cellXlsx.getDateCellValue();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    String formattedDate = sdf.format(date);
                                    cellXls.setCellValue(formattedDate);
                                }else {
                                    cellXls.setCellValue(cellXlsx.getNumericCellValue());
                                }
                                break;
                            case BOOLEAN:
                                cellXls.setCellValue(cellXlsx.getBooleanCellValue());
                                break;
                            case FORMULA:
                                cellXls.setCellFormula(cellXlsx.getCellFormula());
                                break;
                            default:
                                cellXls.setCellValue(cellXlsx.toString());
                        }
                    }
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\mp4处理\\保利威处理七牛名单mp4-12026-余下-时间-17039开始.xls")) {
                workbookXls.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
