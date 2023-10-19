import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edu.zhy.api.api.dto.*;
import com.edu.zhy.api.api.service.impl.zhyService;
import com.google.common.collect.Lists;
import jxl.Sheet;
import jxl.Workbook;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class excelXlTest {

    //导入文件的路径
    private static final String PATH = "C:\\Users\\Admin\\Downloads\\20231010190048a2291c65.xls";

    private static final String COPY_PATH = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\有赞小红书类目映射.xls";


    private static final String PATHV1 = "";
    private static final String PATHV2 = "";
    private static final String PATHV3 = "";


    //需要提前新建目录  写入的文件名称
    private static final String FILE_NAME = "C:\\Users\\Admin\\Desktop\\excel\\9-20导出.xlsx";


    //每行的行数
//    private static  final Integer LINE_NUMBER =14;
    private static  final Integer LINE_NUMBER =1;

    private static List<String> pashList = Lists.newArrayList(PATH, PATHV1, PATHV2, PATHV2);

    //数字限制
    private static final Integer NUM = 14;

    private static List<String> newArrayListist = Lists.newArrayList("跟团号"
            , "下单人", "支付时间", "商品", "订单金额", "订单退款", "订单状态", "收货人", "联系电话", "详细地址");


    @Resource
    private zhyService zhyService;


    @Test
    public void hotfixSignUp() {
        //报名表单  创建接口数据解析,打印成文档
        List<hotfix> list = new ArrayList<>();

        try {
            int i = 0;
            String line;

            String sourceFile = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\hotfix1111.txt";

//            String fileResult = "C:\\Users\\Admin\\Desktop\\qtt搬家\\ceshi\\空文档.json";

            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

//            FileWriter writer = new FileWriter(fileResult, true);

            while ((line = br.readLine()) != null) {
                i++;
                JSONObject jsonObject = JSON.parseObject(line);
                String format = jsonObject.getString("format");


                hotfixList(format,list);
//                writer.write(resultLine);
//                writer.write("\n");
            }
            System.out.println(i);
            br.close();
//            writer.close();


        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(FILE_NAME, hotfix.class).sheet("有赞报名表单提交数据").doWrite(list);

        //写数据
        }catch (Exception e){
            log.error("失败了 e:{}", e);
        }



    }

    /**
     * *解析数据收拢到list里面
     * @param format
     * @param list
     */
    public void hotfixList(String format,List<hotfix> list){

        //读取
//        String format = "\n[_facade]\ntags [ class=EnrollFacadeImpl, method=createRegistrationInfo, success=true, timeCost=79, multiple=0 ]\n__req:[116310406,{\"checkCaptcha\":false,\"featureAlias\":\"q4Njmkefez\",\"isHomepage\":false,\"regInfo\":[{\"itemId\":10811933,\"itemValue\":\"1\"},{\"itemId\":10811946,\"itemValue\":\"15001100271\"},{\"itemId\":10811948,\"itemValue\":\"北京\"},{\"itemId\":10843102,\"itemValue\":\"800元—💗*1\"}],\"smsCaptcha\":\"\",\"stuName\":\"\",\"stuTel\":\"15001100271\",\"userId\":17249689809}]\n__rsp:{\"code\":200,\"data\":240392,\"message\":\"successful\",\"statusCode\":\"01@@@554@010200\",\"success\":true}";
        //先拿string截取
        String s = subBeforePushStream(format);

        String s1 = subAfterStreamKeyUrl(s);

//        int indexOf = s1.indexOf(":", 0);

//        String s2 = Optional.ofNullable(s1.substring(indexOf+1)).orElse(null);

        int indexOf1 = s1.indexOf(",", 0);

        String s3 = Optional.ofNullable(s1.substring(indexOf1+1)).orElse(null);

        int indexOf2 = s3.lastIndexOf("]");

        String s4 = Optional.ofNullable(s3.substring(0,indexOf2)).orElse(null);


        JSONObject object = JSON.parseObject(s4);


        JSONArray regInfo = object.getJSONArray("regInfo");

        hotfix hotfix = new hotfix();
        for (Integer v = 0;v < regInfo.size();v++){
            JSONObject imageTextVo = regInfo.getJSONObject(v);

            int itemId = imageTextVo.getInteger("itemId");

            String itemValue = imageTextVo.getString("itemValue");

            Map<String, String> map = appedHotfix(itemId, itemValue);

            if (map.containsKey("姓名")){
                hotfix.setName(map.get("姓名"));
            }

            if (map.containsKey("手机")){
                hotfix.setPhone(map.get("手机"));
            }

            if (map.containsKey("地址")){
                hotfix.setAdress(map.get("地址"));
            }

            if (map.containsKey("捐赠")){
                hotfix.setPay(map.get("捐赠"));
            }


        }

        list.add(hotfix);


    }



    public Map<String,String> appedHotfix(int itemId, String itemValue){
        Map<String,String> map = new HashMap<>() ;
        switch (itemId) {
            case 10811933:
            case 10904700:
//                System.out.print("姓名：" + itemValue);
                map.put("姓名",itemValue);
                break;

            case 10811946:
//                System.out.print(", 联系人手机：" + itemValue);
                map.put("手机",itemValue);
                break;
            case 10811948:
//                System.out.print(", 礼品地址：" + itemValue);
                map.put("地址",itemValue);
                break;
            case 10843102:
//                System.out.print(", 爱心捐赠：" + itemValue);
                map.put("捐赠",itemValue);

                break;
        }

        return map;
    }



    /**
     * *长码截取 获取服务器地址
     * @param url
     * @return
     */
    public String subBeforePushStream(String url) {
        if (StringUtils.isEmpty(url)){
            return null;
        }
        //前置截取
        int indexOf = url.lastIndexOf("_");

        return Optional.ofNullable(url.substring(0, indexOf-1)).orElse(null);
    }

    /**
     * *长码截取 获取串流密钥/推广码
     * @param url
     * @return
     */
    public String subAfterStreamKeyUrl(String url) {
        if (StringUtils.isEmpty(url)){
            return null;
        }

        int indexOf = url.lastIndexOf("_");

        return Optional.ofNullable(url.substring(indexOf+1)).orElse(null);
    }



    @Test
    public void m2() {

        try {
//            //先读取excel的数据
//            List<String> list = readExcelXls();


            List<ExcelKttOrderDTO> excelKttOrderDTOS = readExcelXlsx();

//            List<String> collect = excelKttOrderDTOS.stream().filter(Objects::nonNull).map(ExcelKttOrderDTO::getPackageNumber).collect(Collectors.toList());
//            System.err.println(JSON.toJSONString(collect));
            List<yzScrmExcelDTO> yzScrmExcelDTOS = data2(excelKttOrderDTOS);

            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            EasyExcel.write(FILE_NAME, yzScrmExcelDTO.class).sheet("有赞会员数据").doWrite(yzScrmExcelDTOS);

//
//            try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
//                workbook.write(fileOutputStream);
//
//            }


        } catch (Exception e) {
            log.error("失败了 e:{}", e);
        }


//        筛选匹配数据（这里应该需要加接口查询）这步先不要，目前只做转换数据


//        生成excel写入本地


    }


    /**
     * *读取本地文件
     *
     * @throws Exception  不能用
     */
    public List<String> readExcelXls() throws Exception {
        //获取每列第一行的下标
        Integer num = 1;

        List<String> list = new ArrayList<>();

        //根据文件位置找到需要读取的excel文件
        File file = new File(COPY_PATH);

        //根据路径生成 FileInputStream字节流
        FileInputStream fileInputStream = new FileInputStream(file);

        //将FileInputStream转换为Workbook
        Workbook workbook = Workbook.getWorkbook(fileInputStream);

        // 默认获取第一张工作表，可以自定义
        Sheet sheet = workbook.getSheet(0);

        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果没有标题行，i从 0 开始
        // sheet.getRows() 获取总行数
        for (int i = 1; i < sheet.getRows(); i++) {
            num++;
            // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            String content = sheet.getCell(num, i).getContents();
//            // 获取第二列的第 i 行信息
//            String content2 = sheet.getCell(1,i).getContents();
            list.add(content);
            //后面根据需要以此类推
        }

        return list;
    }

    //这里需要一个转换接口

    //可以用
    public List<ExcelKttOrderDTO> readExcelXlsx() throws Exception {
        Integer num = 0;

        List<ExcelKttOrderDTO> listArrayList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(PATH));
            //获取工作簿下sheet的个数
            int sheetNum = xssfWorkbook.getNumberOfSheets();
//            System.out.println("该excel文件中总共有：" + sheetNum + "个sheet");
            //遍历工作簿中的所有数据
            for (int i = 0; i < sheetNum; i++) {
                //只读第一张表
                if (i >= 1) break;
                //读取第i个工作表
//                System.out.println("读取第" + (i + 1) + "个sheet");
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
                //获取最后一行的num，即总行数。此处从0开始
                int maxRow = sheet.getLastRowNum();
                for (int row = 0; row <= maxRow; row++) {
                    //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                    int maxRol = sheet.getRow(row).getLastCellNum();
//                    System.out.println("--------第" + row + "行的数据如下--------");
                    for (int rol = 0; rol < maxRol; rol++) {
//                        System.out.print(sheet.getRow(row).getCell(rol) + "  ");
//                        XSSFCell cell = sheet.getRow(row).getCell(rol);
//                        System.err.println(cell);
                        num++;

                        list.add(String.valueOf(sheet.getRow(row).getCell(rol)));
                        if (num % LINE_NUMBER == 0){
                         //这里转换 需要把list数据循环赋值转成dto
                            listArrayList.add(data(list));
                            list.clear();
                        }

                    }

//                    System.out.println();
                }
            }


            return listArrayList;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("失败了哈啊哈哈哈哈哈 E:{}",e);
            return new ArrayList<>();
        }

    }


    //低级的数据取值
    private ExcelKttOrderDTO data(List<String> list){
//        System.err.println("长度:"+list.size()+"数据data:"+ JSON.toJSON(list));
        ExcelKttOrderDTO excelKttOrderDTO = new ExcelKttOrderDTO();
        excelKttOrderDTO.setPackageNumber(list.get(0));
//        excelKttOrderDTO.setPayOrderName(list.get(1));
//        excelKttOrderDTO.setPayDate(list.get(3));
//        excelKttOrderDTO.setProduct(list.get(5));
//        excelKttOrderDTO.setPayPrice(list.get(6));
//        excelKttOrderDTO.setRefundPrice(list.get(7));
//        excelKttOrderDTO.setStatus(list.get(8));
//        excelKttOrderDTO.setConsignee(list.get(10));
//        excelKttOrderDTO.setPhone(list.get(11));
//        excelKttOrderDTO.setDetailedAddress(list.get(12));

        return excelKttOrderDTO;
    }



    //数据转换处理
    private List<yzScrmExcelDTO> data2(List<ExcelKttOrderDTO> excelKttOrderDTOS){
        List<yzScrmExcelDTO> list = excelKttOrderDTOS.stream().filter(Objects::nonNull).map(o -> {
            yzScrmExcelDTO yzScrmExcelDTO = new yzScrmExcelDTO();
            yzScrmExcelDTO.setPhone(o.getPhone());
            yzScrmExcelDTO.setName(o.getPayOrderName());
            //省
            yzScrmExcelDTO.setProvince(getSubstringData(o.getDetailedAddress(),AddressTypeEnum.PROVINCE.getType()));

            //市
            yzScrmExcelDTO.setTheCity(getSubstringData(o.getDetailedAddress(),AddressTypeEnum.TEAMCITY.getType()));

            //区/县
            yzScrmExcelDTO.setAreaCounty(getSubstringData(o.getDetailedAddress(),AddressTypeEnum.ACCOUNT.getType()));

            return yzScrmExcelDTO;
        }).filter(Objects::nonNull).collect(Collectors.toList());

        return list;
    }



    /**
     * *截取省/市/区,县
     * @param data 数据
     * @param type 类型    AddressTypeEnum
     * @return 获取值
     */
    private static String getSubstringData(String data, Integer type){
        AddressTypeEnum value = AddressTypeEnum.getByValue(type);
        switch (value){
            case PROVINCE:

                return getSubstring(data,AddressTypeEnum.PROVINCE.getContent(),null);

            case TEAMCITY:

                return getSubstring(data,AddressTypeEnum.TEAMCITY.getContent(),AddressTypeEnum.PROVINCE.getContent());

            case ACCOUNT:

                return getSubstring(data,null,AddressTypeEnum.TEAMCITY.getContent());
            default:
                return null;
        }

    }


    /**
     * *
     * @param data
     * @param beforeValue 要去除的本值
     * @param afterValue 要去除的前置/后置值
     * @return
     */
    private static String getSubstring(String data, String beforeValue, String afterValue){
        //第一次
        if (Objects.isNull(afterValue)){
            int indexOf = data.lastIndexOf(beforeValue);

            return data.substring(0, indexOf+1);
        }


        if (Objects.isNull(beforeValue)){
            int indexOf = data.lastIndexOf(afterValue);
            return data.substring(indexOf+1);
        }


        //要把前面的截掉
        int indexOf = data.lastIndexOf(beforeValue);
        int indexOf1 = data.lastIndexOf(afterValue);

        return data.substring(indexOf1+1, indexOf+1);

    }



    //数据
    private List<UserDTO> data(){
        List<UserDTO> list = new ArrayList<>();

        //算上标题，做多可写65536行
        //超出：java.lang.IllegalArgumentException: Invalid row number (65536) outside allowable range (0..65535)
        for (int i = 0; i < 65535; i++) {
            UserDTO data = new UserDTO();
            data.setName("Helen" + i);
            list.add(data);
        }

        return list;
    }


    //1:最简单的写入方法  xlsx 版本的Excel最多一次可写0...1048575行
    public void simpleWriteXlsx() {
        String fileName = "d:/excel/simpleWrite.xlsx"; //需要提前新建目录
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, UserDTO.class).sheet("模板").doWrite(data());
    }

    //第二次写入方法   xls 版本的Excel最多一次可写0 ...65535行
    public void simpleWriteXls() {
        String fileName = "d:/excel/simpleWrite.xls";
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, UserDTO.class).excelType(ExcelTypeEnum.XLS).sheet("模板").doWrite(data());
    }



}
