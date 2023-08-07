import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.derby.iapi.util.StringUtil;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class qttTextCheck {

    //风控筛选list
    private static List<String> stringList = Arrays.asList("内容","商品名称","标题");


    //图片筛选list
    private static List<Integer> imgeList = Arrays.asList(1,2,3,4);


    //基本读取单列数据
    @org.junit.Test
    public void fixColumn0425() {
        List<Object> argList = new java.util.ArrayList<>();
        String patch = "C:\\Users\\Admin\\IdeaProjects\\youzan-example\\src\\main\\resources\\test\\chain\\fixorder.txt";
        List<String> chainList = getChainListV2(patch);
        for (String array: chainList) {
            String orderNO = array;
//            Long subKdtId = array[1];
//            Long hqItemId = array[2];
            try {
                Map<String, Object> arg = new java.util.HashMap<>();
                arg.put("orderNO", orderNO);
//                arg.put("hqKdtId", hqKdtId);
//                arg.put("subKdtId", subKdtId);
                argList.add(arg);

                //下面是执行先不执行
//                invokeTicketV1(argList);
//                System.out.println("orderNO: " + orderNO
////                        + ", subKdtId: " + subKdtId
////                        + ", hqItemId: " +  hqItemId
//                        + " 同步成功");
            } catch (Exception e) {
                System.out.println("orderNO: " + orderNO
//                        + ", subKdtId: " + subKdtId
//                        + ", hqItemId: " +  hqItemId
                        + " 同步失败");
            }
        }
        System.err.println("全部的订单size"+argList.size()+"总量的订单编号"+argList);
    }



    //效验筛选文档数据对比
    //单列
    @org.junit.Test
    public void checkQttBanJia() {
        //全量的
        String patch = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\qttall\\qttallv4.txt";
        List<String> chainList = getChainListV2(patch);

        //后续出的
        String patch1 = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\qttchecktxt\\qttv4yizhi.txt";
        List<String> chainList1 = getChainListV2(patch1);


        Set<String> collect = chainList.stream().filter(Objects::nonNull).map(o -> {
            //只有全量的不包含后续出的
            if (!chainList1.contains(o)) {
                return o;
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toSet());

        System.err.println("长度"+collect.size()+"\\"+"没有执行的"+ JSON.toJSONString(collect));
    }


    //读取错误文档与全量文档数据  进行筛选
    //只处理敏感词（不是的错误日志打印出来就好）
    // 并写入附带敏感词
    //能用
    @Test
    public void checkQttLogErrorV2(){

        try {
        List<String> noSensitiveWordsList = new ArrayList<>();
        //错误文档
        String errorFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\logerror.txt";
        //全量文档
        String logAllFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\logall.txt";
        //写入结果
        String fileResult = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\ceshiall.txt";


        FileWriter writer = new FileWriter(fileResult, true);

        Integer i = 0;

        List<String> lines1 = readLinesFromFile(errorFilePath);
        List<String> lines2 = readLinesFromFile(logAllFilePath);

        for (String line : lines1) {
            i++;
            //这里读取错误文档
            JSONObject jsonObject = JSON.parseObject(line);
            String format = jsonObject.getString("format");
            String collectionActivityNo = subAfterStreamKeyUrl(format);

            String error = jsonObject.getString("error");
            String subBeforeError = subBeforePushStream(error);


            //这里check下只处理敏感词   不是敏感词的都打印出来
            Boolean aBoolean = checkSensitiveWords(subBeforeError);

            //只要不是敏感词就跳过
            if (!aBoolean){
                noSensitiveWordsList.add(collectionActivityNo);
                continue;
            }

            for (String lineAll : lines2) {
                JSONObject object = JSON.parseObject(lineAll);
                JSONObject resultAll = object.getJSONObject("result");
                String collectionActivityNoAll = resultAll.getString("collection_activity_no");
                //条件相同的写入进去
                if (Objects.equals(collectionActivityNo,collectionActivityNoAll)){

                    String streamV2 = subBeforePushStreamV2(subBeforeError);

                    object.put("error",streamV2);

                    writer.write(object.toString());
                    writer.write("\n");
                }

            }
        }

            System.out.println(i);

            System.err.println("不是敏感词的外部业务标识:"+noSensitiveWordsList);

            writer.close();


        }catch (IOException e){
            log.error("失败了呜呜呜 IOException:{}",e);
        }catch (Exception e){
            log.error("失败了呜呜呜 Exception:{}",e);
        }
    }

    //删除违禁字并写入数据成为新文档
    //并写入新文档
    @Test
    public void rigDeleteQttBanJia() {
//        String url="com.youzan.qtt.note.common.exception.DependencyException: 笔记内容含有敏感信息: 爆珠，请重新输入\n  com.youzan.qtt.note.common.utils.InvokerWrapper.invokeThird(InvokerWrapper.java:49)\n  com.youzan.qtt.note.adapter.fx.outservice.SupplierNoteOperateServiceClient.createSupplierNote(SupplierNoteOperateServiceClient.java:19)\n";
//        String s = subBeforePushStream(url);
//
//        String s1 = subBeforePushStreamV2(s);
//
//        System.err.println(s1);

        try {

            String sourceFile = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\ceshiall.txt";
            String fileResult = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\ceshixieruweijinci.txt";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line = null;

            FileWriter writer = new FileWriter(fileResult, true);

            int i = 0;

            while ((line = br.readLine()) != null) {
                i++;
                JSONObject jsonObject = JSON.parseObject(line);
                String error = jsonObject.getString("error");

                //获取已修复过后的内容
                String updateDeleteRig = updateDeleteRig(line, error);

                writer.write(updateDeleteRig);
                writer.write("\n");

            }
            System.out.println(i);
            br.close();
            writer.close();

        }catch (Exception e){
            log.error("有问题有问题 e:{}",e);
        }
    }


    //敏感词效验
    //测试
    @Test
    public void deleteRigV1(){
        String content = "✅20D冰丝透气面料\\n✅抗菌除臭抗导湿约,炮,要\\n✅清爽速干透气率高\\n✅强力扛污去污约,炮，要\\n\\n轻盈舒适 弹力超大 无痕不勒肉不夹pp！\\n女生三个月就要换新内内哦！";
        String sensitiveWords= "约炮要";
        String contentAll = null;
        Integer num = 1;

        boolean cont = content.contains(sensitiveWords);
        if (cont){
            contentAll = content.replace(sensitiveWords,"");
        }else {
            //没有的话单个拆分
            String[] split = sensitiveWords.split("");
            for (String cc:split){
                if (num == 1){
                    contentAll =  content.replace(cc,"");
                }

                if (split.length >= num && num !=1){
                    contentAll =  contentAll.replace(cc,"");
                }
                num++;
            }
        }
        System.err.println(contentAll);

        //这个不行不能采用截取的方法
//        int indexOf = content.lastIndexOf(sensitiveWords);
//
//        //前置截取
//        String substring1 = content.substring(0, indexOf);
//        //后置截取
//        String substring = content.substring(indexOf + sensitiveWords.length());
//
//        System.err.println(substring1+substring);
    }

    //更换collection_activity_no+1
    @Test
    public void updateActivityNo(){

        try {
            int i = 0;
            String line;

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\测试new.json";
            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\空文档.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            FileWriter writer = new FileWriter(fileResult, true);

            while ((line = br.readLine()) != null) {
                i++;
                JSONObject jsonObject = JSON.parseObject(line);
                JSONObject result = jsonObject.getJSONObject("result");
                String collectionActivityNo = result.getString("collection_activity_no");
                String resultLine = line.replace(collectionActivityNo, collectionActivityNo + "1");

                writer.write(resultLine);
                writer.write("\n");
            }
            System.out.println(i);
            br.close();
            writer.close();
        }catch (Exception e){

        }
    }


    //更换GoodId+1
    //更换collection_activity_no+1
    @Test
    public void updateGoodId(){
        JSONArray jsonArray = new JSONArray();
        try {
            String line;
            int i = 0;

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\选甄栈更换名称亚农生态农业直销+129727684\\亚农生态农业直销 - 副本.json";
            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\选甄栈更换名称亚农生态农业直销+129727684\\亚农生态农业直销 - 副本 - 副本.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            FileWriter writer = new FileWriter(fileResult, true);

            while ((line = br.readLine()) != null) {
                i++;
                JSONObject jsonObject = JSON.parseObject(line);
                JSONObject result = jsonObject.getJSONObject("result");
                //更换collection_activity_no+1
                String collectionActivityNo = result.getString("collection_activity_no");
                result.put("collection_activity_no",collectionActivityNo+"3221");

//                这里把goodId 也给加一
                JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");

                for (int v = 0; v < goodsInfoWithSkuVoList.size(); v++){
                    JSONObject jsonObject1 = goodsInfoWithSkuVoList.getJSONObject(v);
                    String goods_id = jsonObject1.getString("goods_id");
                    jsonObject1.put("goods_id",goods_id + "31009");
                }

                result.put("goods_info_with_sku_vo_list",goodsInfoWithSkuVoList);

                jsonObject.put("result",result);

                writer.write(jsonObject.toString());
                writer.write("\n");

            }
            System.out.println(i);
            br.close();
            writer.close();

        }catch (Exception e){
            log.error("有问题有问题 e:{}",e);
        }

    }


    //效验商品数是否超过100;超过一百的不处理
    //这里还需要加入写入功能生成新的文档
    @Test
    public void checkGoodsInfoWithSkuVoListSize(){
        List<String> list = new ArrayList<>();

        try {
            int i = 0;
            String line ;

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\番薯哥供应链供货+136579840\\番薯哥供应链供货-详情.json";

            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\番薯哥供应链供货+136579840\\番薯哥供应链供货空文档.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            //小于100的生成文档  看情况开放
//            FileWriter writer = new FileWriter(fileResult, true);

            while ((line = br.readLine()) != null) {
                System.out.println(i++);
                JSONObject jsonObject = JSON.parseObject(line);
                JSONObject result = jsonObject.getJSONObject("result");
                String collectionActivityNo = result.getString("collection_activity_no");
                JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");

                if (goodsInfoWithSkuVoList.size() >= 100){
                   list.add(collectionActivityNo);

                }

//                //小于100的生成文档  看情况开放
//                if (goodsInfoWithSkuVoList.size() < 100){
//                    writer.write(line);
//                    writer.write("\n");
//                }

            }

            System.err.println("长度是"+list.size()+"\\"+"超过100的商品"+JSON.toJSONString(list)+"\\"+"一共循环"+i+"次");
            br.close();
            //小于100的生成文档  看情况开放
//            writer.close();

        }catch (Exception e){
            log.info("失败了呜呜呜 e:{}",e);
        }




    }


    //商品超过200个的话 只处理200个
    @Test
    public void deletedGoodsInfoWithSkuVoListSize(){

        try {

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\选甄栈更换名称亚农生态农业直销+129727684\\亚农生态农业直销.json";
            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\选甄栈更换名称亚农生态农业直销+129727684\\亚农生态农业直销 - 副本.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line;

            FileWriter writer = new FileWriter(fileResult, true);

            int i = 0;

            while ((line = br.readLine()) != null) {
                JSONArray jsonArray ;
                i++;
                JSONObject jsonObject = JSON.parseObject(line);
                JSONObject result = jsonObject.getJSONObject("result");

//                这里把goodId 也给加一
                JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");

                //大于200的话只取200个
                if (goodsInfoWithSkuVoList.size() > 200){
                    List<Object>  collect = Arrays.stream(goodsInfoWithSkuVoList.stream().toArray()).limit(200).collect(Collectors.toList());
                    jsonArray = JSONArray.parseArray(JSON.toJSONString(collect));
                }else {
                    //没超过200的话就取元数据
                    jsonArray = goodsInfoWithSkuVoList;
                }


                //先给result 的list进行替换
                result.put("goods_info_with_sku_vo_list",jsonArray);

                //然后再将 jsonObject的result数据替换
                jsonObject.put("result",result);

                //写入文档
                writer.write(jsonObject.toString());
                writer.write("\n");
            }
            System.out.println(i);
            br.close();
            writer.close();

        }catch (Exception e){
            log.error("有问题一定有问题 e:{}",e);
        }

    }



    //去除不合规得图片
    @Test
    public void deletedWxImageTextVos(){

        JSONArray imgList = new JSONArray();
        try {

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\选甄栈更换名称亚农生态农业直销+129727684\\亚农生态农业直销 - 副本.json";
            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\选甄栈更换名称亚农生态农业直销+129727684\\亚农生态农业直销 - 副本 - 副本.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line;

            FileWriter writer = new FileWriter(fileResult, true);

            int i = 0;

            while ((line = br.readLine()) != null) {
                i++;
                JSONObject jsonObject = JSON.parseObject(line);
                JSONObject result = jsonObject.getJSONObject("result");


                JSONArray goodsInfoWithSkuVoList = result.getJSONArray("image_text_vos");

                for (Integer v = 0;v < goodsInfoWithSkuVoList.size();v++){
                    JSONObject imageTextVo = goodsInfoWithSkuVoList.getJSONObject(v);

                    int type = imageTextVo.getInteger("type");

                    if (imgeList.contains(type)){
                        imgList.add(v,imageTextVo);
                    }

                }

                //先给result 的list进行替换
                result.put("image_text_vos",imgList);

                //然后再将 jsonObject的result数据替换
                jsonObject.put("result",result);

                //写入文档
                writer.write(jsonObject.toJSONString());
                writer.write("\n");
            }
            System.out.println(i);
            br.close();
            writer.close();

        }catch (Exception e){
            log.error("有问题一定有问题 e:{}",e);
        }

    }



    //读取错误文档与全量文档数据  进行筛选
    //只处理敏感词（不是的错误日志打印出来就好）
    // 并写入附带敏感词
    //不能用
//    @Test
//    public void checkQttLogError() {
//        try {
//            int i = 0;
//            String line ;
//            String lineAll ;
//            List<String> noSensitiveWordsList = new ArrayList<>();
//
//            String sourceFile = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\logerror.txt";
//
//            String sourceFileAll = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\logall.txt";
//
//            String fileResult = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\ceshiall.txt";
//            //差外围的error
//            BufferedReader bufferedReader = toBufferedReader(sourceFile);
//            //查全部的
//            BufferedReader bufferedReaderAll = toBufferedReader(sourceFileAll);
//
//
//            FileWriter writer = new FileWriter(fileResult, true);
////            do {
////                String s1 = bufferedReader.readLine();
////                if (Objects.isNull(s1)) return;
////                //这里读取错误文档
////                JSONObject jsonObject = JSON.parseObject(s1);
////                String format = jsonObject.getString("format");
////                String collectionActivityNo = subAfterStreamKeyUrl(format);
////
////                String error = jsonObject.getString("error");
////                String subBeforeError = subBeforePushStream(error);
////
////
////                //这里check下只处理敏感词   不是敏感词的都打印出来
////                Boolean aBoolean = checkSensitiveWords(subBeforeError);
////                System.err.println(aBoolean+""+subBeforeError);
////                //只要不是敏感词就跳过
////                if (!aBoolean){
////                    noSensitiveWordsList.add(collectionActivityNo);
////                    continue;
////                }
////
////
////
////                do {
////
////                    String s2 = bufferedReaderAll.readLine();
////
////                    if (Objects.isNull(s2)) return;
////
////                    JSONObject object = JSON.parseObject(s2);
////                    JSONObject resultAll = object.getJSONObject("result");
////                    String collectionActivityNoAll = resultAll.getString("collection_activity_no");
////
////                    System.err.println("读取全量文档"+collectionActivityNoAll);
////
////                    //条件相同的写入进去
////                    if (Objects.equals(collectionActivityNo,collectionActivityNoAll)){
////
////                        String streamV2 = subBeforePushStreamV2(subBeforeError);
////
////                        object.put("error",streamV2);
////
////                        writer.write(object.toString());
////                        writer.write("\n");
////
////                    }
////
////
////                }while ((lineAll = bufferedReaderAll.readLine()) != null);
////
////
////                i++;
////
////            }while ((line = bufferedReader.readLine()) != null);
//            while ((line = bufferedReader.readLine()) != null) {
//                i++;
//
//                //这里读取错误文档
//                JSONObject jsonObject = JSON.parseObject(line);
//                String format = jsonObject.getString("format");
//                String collectionActivityNo = subAfterStreamKeyUrl(format);
//
//                String error = jsonObject.getString("error");
//                String subBeforeError = subBeforePushStream(error);
//
//
//                //这里check下只处理敏感词   不是敏感词的都打印出来
//                Boolean aBoolean = checkSensitiveWords(subBeforeError);
//
//                //只要不是敏感词就跳过
//                if (!aBoolean){
//                    noSensitiveWordsList.add(collectionActivityNo);
//                    continue;
//                }
//
//                bufferedReaderAll.mark(1000);
////                if ((lineAll = bufferedReaderAll.readLine()) != null){
////                    JSONObject object = JSON.parseObject(lineAll);
////                    int result = object.getJSONObject("result").size();
////                    for (Integer ii = 0; ii > result;ii++){
////                        JSONObject resultAll = object.getJSONObject("result");
////
////                        String collectionActivityNoAll = resultAll.getString("collection_activity_no");
////
////                        System.err.println("读取全量文档"+collectionActivityNoAll);
////
////                        //条件相同的写入进去
////                        if (Objects.equals(collectionActivityNo,collectionActivityNoAll)){
////
////                            String streamV2 = subBeforePushStreamV2(subBeforeError);
////
////                            object.put("error",streamV2);
////
////                            writer.write(object.toString());
////                            writer.write("\n");
////                    }
////                    }
////                }
//
//
//                //这里读取全量的文档
//                while ((lineAll = bufferedReaderAll.readLine()) != null) {
//                    JSONObject object = JSON.parseObject(lineAll);
//                    JSONObject resultAll = object.getJSONObject("result");
//                    String collectionActivityNoAll = resultAll.getString("collection_activity_no");
//
//                    System.err.println("读取全量文档"+collectionActivityNoAll);
//
//                    //条件相同的写入进去
//                    if (Objects.equals(collectionActivityNo,collectionActivityNoAll)){
//
//                        String streamV2 = subBeforePushStreamV2(subBeforeError);
//
//                        object.put("error",streamV2);
//
//                        writer.write(object.toString());
//                        writer.write("\n");
//                    }
//               }
//
//                bufferedReaderAll.reset();
//            }
//
//
//            System.err.println("一共次数"+i+"不是敏感词的外部业务标识:"+noSensitiveWordsList);
//
//            bufferedReaderAll.close();
//            bufferedReader.close();
//            writer.close();
//
//        }catch (IOException e){
//            log.error("失败了呜呜呜 e:{}",e);
//        }catch (Exception exception){
//
//        }
//
//    }


    /**
     * *基本读取转换
     * @param path
     * @return
     */
    public java.util.List<String> getChainListV2(String path) {

        try {
            java.util.List<String> lines = org.apache.commons.io.FileUtils.readLines(new java.io.File(path), java.nio.charset.Charset.defaultCharset());
            return java.util.Optional.ofNullable(lines).orElse(java.util.Collections.emptyList())
                    .stream()
                    .filter(org.apache.commons.lang3.StringUtils::isNotEmpty)
                    .map(each -> {
//                        try {
//                            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(/^[a-z0-9_-]{0,24}$/)");
////                            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(\\d+?)\\s*?,\\s*?(\\d+?)\\s*?,\\s*?(\\d+?)");
//                            java.util.regex.Matcher matcher = pattern.matcher(each);
//                            if (matcher.matches()) {
//                                return new Long[]{
////                                        Long.valueOf(matcher.group(1)),
////                                        Long.valueOf(matcher.group(2)),
//                                        Long.valueOf(matcher.group(1))};
//                            } else {
//                                System.out.println("格式不符合正则表达式. each: " + each);
//
//                                return new String(matcher);
//                            }
//                        } catch (Exception e) {
//                            System.out.println("解析异常 each: " + each + "e: " + e.getMessage());
//                        }
                        return each;
                    })
                    .filter(java.util.Objects::nonNull)
                    .collect(java.util.stream.Collectors.toList());
        } catch (java.io.IOException e) {

        }
        return java.util.Collections.emptyList();
    }




    /**
     * *读取资源并关闭
     * // try-with-resources 语句中创建reader2的实例。BufferedReader当执行退出try块时，
     * // 会自动调用close()每个实例的方法，释放关联的资源。BufferedReader
     * //        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
     * //             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
     * //            // Code to read and compare lines
     * //        } catch (IOException e) {
     * //            e.printStackTrace();
     * //        }
     * @param filePath
     * @return
     */
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


    /**
     * *判断标题
     * @param subBeforeError
     * @return
     */
    public Boolean checkSensitiveWords(String subBeforeError) {

        List<Boolean> booleanList = stringList.stream().
                map(o -> subBeforeError.contains(o)).collect(Collectors.toList());

        //只要有一个true就是敏感词风控
        return booleanList.contains(true);
    }




    /**
     * *前置截取
     * *长码截取 获取服务器地址
     * @param url
     * @return
     * *第一次截取完整的
     */
    public String subBeforePushStream(String url) {
        if (StringUtils.isEmpty(url)){
            return null;
        }
        //前置截取
        int indexOf = url.indexOf("\n");

        String substring = url.substring(0, indexOf + 1);


        int indexOf1 = substring.indexOf(":");


        return Optional.ofNullable(substring.substring(indexOf1 +1)).orElse(null);
    }

    /**
     * *全部截取
     * *二次加工
     * @param url
     * @return
     */
    public String subBeforePushStreamV2(String url) {
        if (StringUtils.isEmpty(url)){
            return null;
        }
        //前置截取
        int indexOf = url.indexOf("，");

        String substring = url.substring(0, indexOf );


        int indexOf1 = substring.indexOf(":");


        return Optional.ofNullable(substring.substring(indexOf1 +1)).orElse(null);
    }



    /**
     * 后置截取*
     * *长码截取 获取串流密钥/推广码
     * @param url
     * @return
     */
    public String subAfterStreamKeyUrl(String url) {
        if (StringUtils.isEmpty(url)){
            return null;
        }
        int indexOf = url.lastIndexOf(":");

        return Optional.ofNullable(url.substring(indexOf + 1)).orElse(null);
    }


    /**
     * 转换读取资源 BufferedReader
     * @param file
     * @return
     */
    private BufferedReader toBufferedReader(String file){

        try {

            File file1 = new File(file);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));


            return br;
        }catch (Exception e){

            return null;
        }

    }



    //传入json和完整的敏感词
    //或者在这里读取(先决定上层传入)

    //返回新的内容(已经做过敏感词过滤)
    public String updateDeleteRig(String content,String sensitiveWords){
        JSONObject jsonObject = JSON.parseObject(content);
        JSONObject result = jsonObject.getJSONObject("result");
//        //唯一标识（看情况）
//        String collectionActivityNo = result.getString("collection_activity_no");
        //这里对名称（看情况）
        JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");
        checkDeleteRigJsonArray(goodsInfoWithSkuVoList,sensitiveWords);
        result.put("goods_info_with_sku_vo_list",goodsInfoWithSkuVoList);

        //这里只对 type为3的敏感内容 进行删除
        JSONArray image_text_vos = result.getJSONArray("image_text_vos");
        checkDeleteRigJsonArray(image_text_vos,sensitiveWords);
        result.put("image_text_vos",image_text_vos);

        //这里必须效验
        if (StringUtils.isNotEmpty(result.getString("title"))){
            String title = result.getString("title");
            result.put("title",backHasDeleteRigBack(title,sensitiveWords));
        }

        jsonObject.put("result",result);

        //把这个删除了不需要了
        jsonObject.remove("error");

        return jsonObject.toString();
    }

    //只做执行操作
    public void checkDeleteRigJsonArray(JSONArray jsonArray,String sensitiveWords){

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

            if (StringUtils.isNotEmpty(object.getString("goods_name"))){
                String goods_name = object.getString("goods_name");


                object.put("goods_name",backHasDeleteRigBack(goods_name, sensitiveWords));

            }

            if (StringUtils.isNotEmpty(object.getString("goods_desc"))){
                String goods_desc = object.getString("goods_desc");

                object.put("goods_desc",backHasDeleteRigBack(goods_desc, sensitiveWords));
            }

            Integer type = object.getInteger("type");
            //只处理文本内容
            if (StringUtils.isNotEmpty(object.getString("content")) && Objects.equals(type,3)){
                String content = object.getString("content");

                object.put("content",backHasDeleteRigBack(content, sensitiveWords));

            }

        }



    }



    //去除敏感词   第一个名称内容第二个敏感词
    public String backHasDeleteRigBack(String content,String sensitiveWords){
        if (Objects.isNull(content) || Objects.isNull(sensitiveWords)){
            log.info("deleteRig 没有内容和违禁字段,content:{},sensitiveWords:{}",content,sensitiveWords);
            return null;
        }
        return  deleteContentSensitiveWords(content, sensitiveWords);

    }




    /**
     * *删除违禁字 返回删除后的content
     * @param content 内容
     * @param sensitiveWords 违禁字
     */
    private String deleteContentSensitiveWords(String content,String sensitiveWords){
        String contentAll = null;
        Integer num = 1;

        boolean cont = content.contains(sensitiveWords);
        if (cont){
            contentAll = content.replace(sensitiveWords,"");
        }else {
            //没有的话单个拆分
            String[] split = sensitiveWords.split("");
            for (String cc:split){
                if (num == 1){
                    contentAll =  content.replace(cc,"");
                }
                if (split.length >= num && num > 1){
                    contentAll =  contentAll.replace(cc,"");
                    continue;
                }
                num++;

            }
        }
        return contentAll;
    }








    //转换json数据递归
    public static JSONObject changeJsonObj(JSONObject jsonObj, Map<String, String> keyMap) {
        JSONObject json = new JSONObject();
        //获取json的key
        Set<String> keySet = jsonObj.keySet();
        for (String key : keySet) {
        //当前key在map的中为空,key是json的key,不为空是map的key(目标key)
            String newKey = keyMap.get(key) == null ? key : keyMap.get(key);
            try {
                JSONObject jsonObject = jsonObj.getJSONObject(key);
        //以防父级不用替换,子级要替换时的递归
                json.put(newKey, changeJsonObj(jsonObject, keyMap));
            } catch (Exception e) {
                try {
        //当前json是array,进行array的重组,不是则catch
                    JSONArray jsonArr = jsonObj.getJSONArray(key);
                    json.put(newKey, changeJsonArr(jsonArr, keyMap));
                } catch (Exception x) {
        //重组json的key和value
                    json.put(newKey, jsonObj.get(key));
                }
            }
        }
        return json;
    }

    public static JSONArray changeJsonArr(JSONArray jsonArr, Map<String, String> keyMap) {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
        //将一个jsonarray当成一个object进行替换
            jsonArray.add(changeJsonObj(jsonObj, keyMap));
        //替换完成后,add,return
        }
        return jsonArray;
    }






    //转换json数据递归
    public JSONObject replaceAssetValue(JSONObject request) {//将key全部替换成newKey;
        Iterator<String> keys = request.keySet().iterator();
        JSONObject resp = new JSONObject();//需要新建JSON，否则在迭代过程中会报错
        resp.putAll(request);
        while (keys.hasNext()) {
            String key = keys.next();
            if (key.equals("key")) {//参数为String格式，直接替换
                resp.remove(key);
                resp.put("newKey", request.getString(key));
            }
            if (request.get(key) instanceof JSONObject) {//有参数是JSON格式，进行迭代
                JSONObject keyJSon = replaceAssetValue(request.getJSONObject(key));
                resp.replace(key, keyJSon);
            }

            if (request.get(key) instanceof JSONArray) {//参数为JSONArray格式
                JSONArray keyArray = request.getJSONArray(key);
                JSONArray respArray = new JSONArray();
                for (int i = 0; i < keyArray.size(); i++) {
                    JSONObject keyObject = replaceAssetValue(keyArray.getJSONObject(i));
                    respArray.add(keyObject);
                }
                resp.replace(key, respArray);
            }
        }
        return resp;

    }






    }
