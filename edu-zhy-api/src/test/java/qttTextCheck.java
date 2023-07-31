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


    @Test
    public void rigDeleteQttBanJia() {

        //全量的
        String patch = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\qttall\\qttallv4.txt";
        List<String> chainList = getChainListV2(patch);

        //读取文档
        //坐下风控 筛选数据进行删除


        //需要一个单个效验的读取问题err



    }



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




    public void checkDlteleRig(String content){
        JSONObject jsonObject = JSON.parseObject(content);
        JSONObject result = jsonObject.getJSONObject("result");
        //唯一标识（看情况）
        String collectionActivityNo = result.getString("collection_activity_no");
        //这里对名称（看情况）
        JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");
        checkDlteleRig(goodsInfoWithSkuVoList);

        //这里只对 type为3的敏感内容 进行删除
        JSONArray image_text_vos = result.getJSONArray("image_text_vos");
        checkDlteleRig(image_text_vos);
        //这里必须效验

        if (StringUtils.isNotEmpty(result.getString("title"))){
            String title = result.getString("title");

        }

    }

    //只做执行操作
    public void checkDlteleRig(JSONArray jsonArray){

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject JSONObject = jsonArray.getJSONObject(i);

            if (StringUtils.isNotEmpty(JSONObject.getString("goods_name"))){
                String goods_name = JSONObject.getString("goods_name");

            }

            if (StringUtils.isNotEmpty(JSONObject.getString("goods_desc"))){
                String goods_desc = JSONObject.getString("goods_desc");

            }

            Integer type = JSONObject.getInteger("type");
            //只处理文本内容
            if (StringUtils.isNotEmpty(JSONObject.getString("content")) && Objects.equals(type,3)){
                String content = JSONObject.getString("content");

            }

        }



    }



    //去除敏感词   第一个名称内容第二个敏感词
    public void deleteRig(String content,String sensitiveWords){

        content.split(sensitiveWords);

    }


    //敏感词效验
    @Test
    public void deleteRigV1(){
        String content = "✅20D冰丝透气面料\\n✅抗菌除臭抗导湿约炮\\n✅清爽速干透气率高约炮\\n✅强力扛污去污\\n\\n轻盈舒适 弹力超大 无痕不勒肉不夹pp！\\n女生三个月就要换新内内哦！";
        String sensitiveWords= "约炮";

        //需要效验下有没有这个字段

        boolean cont = content.contains(sensitiveWords);
        System.err.println(cont);



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

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\测试new.json";
            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\空文档.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line = null;

            FileWriter writer = new FileWriter(fileResult, true);



            int i = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(i++);
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
    @Test
    public void updateGoodId(){
        JSONArray jsonArray = new JSONArray();
        try {

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\测试new.json";
            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\测试 - 副本.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line = null;

            FileWriter writer = new FileWriter(fileResult, true);

            int i = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(i++);
                JSONObject jsonObject = JSON.parseObject(line);
                JSONObject result = jsonObject.getJSONObject("result");
//                writer.write(resultLine);
//                writer.write("\n");

//                这里把goodId 也给加一
                JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");
                for (int v = 0; v < goodsInfoWithSkuVoList.size(); v++){
                    JSONObject jsonObject1 = goodsInfoWithSkuVoList.getJSONObject(v);

//                    String content = jsonObject1.toJSONString();

                    String goods_id = jsonObject1.getString("goods_id");

//                    String replace = content.replace(goods_id, goods_id + 1);

                    jsonObject1.put("goods_id",goods_id + 1);

                    jsonArray.add(v,jsonObject1);
                }

                result.put("goods_info_with_sku_vo_list",jsonArray);

                jsonObject.put("result",result);

                writer.write(jsonObject.toJSONString());
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

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\番薯哥供应链供货+136579840\\番薯哥供应链供货-详情.json";

            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\番薯哥供应链供货+136579840\\番薯哥供应链供货空文档.json";


            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line = null;

//            FileWriter writer = new FileWriter(fileResult, true);

            int i = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(i++);
                JSONObject jsonObject = JSON.parseObject(line);
                JSONObject result = jsonObject.getJSONObject("result");
                String collectionActivityNo = result.getString("collection_activity_no");
                JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");
//                System.err.println(collectionActivityNo + "当前一共的商品数" +goodsInfoWithSkuVoList.size()+"\\"+"第"+i+"次");
                if (goodsInfoWithSkuVoList.size() >= 100){
                   list.add(collectionActivityNo);

                }

//                //小于100的生成文档  看情况开放
//                if (goodsInfoWithSkuVoList.size() < 100){
//                    writer.write(line);
//                    writer.write("\n");
//                }


            }
//            System.out.println(i);

            System.err.println("长度是"+list.size()+"\\"+"超过100的商品"+JSON.toJSONString(list)+"\\"+"一共循环"+i+"次");
            br.close();
//            writer.close();

        }catch (Exception e){
            log.info("失败了呜呜呜 e:{}",e);
        }




    }




    //商品超过100个的话 只处理100个
    @Test
    public void deletedGoodsInfoWithSkuVoListSize(){

        try {

            String sourceFile = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\测试new.json";
            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\测试 - 副本.json";

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

//                这里把goodId 也给加一
                JSONArray goodsInfoWithSkuVoList = result.getJSONArray("goods_info_with_sku_vo_list");

                List<Object> collect = Arrays.stream(goodsInfoWithSkuVoList.stream().toArray()).limit(100).collect(Collectors.toList());
                JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(collect));
//                for (int v = 1; v < goodsInfoWithSkuVoList.size(); v++){
//                    JSONObject jsonObject1 = goodsInfoWithSkuVoList.getJSONObject(i);
//
//                    if (Objects.isNull(jsonObject1)) return;
//
//                    if (v > 100){
//                        break;
//                    }
//
//                    goodsList.add(jsonObject1);
//
//                }

//                System.err.println(jsonArray.size());

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
