import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edu.zhy.api.api.dto.*;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.google.common.collect.Lists;
import jxl.Sheet;
import jxl.Workbook;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class excelXlTest {
    private static  List<Integer> Ids = Arrays.asList();

    //导入文件的路径
    private static final String PATH_XLS = "C:\\Users\\Admin\\Desktop\\文件\\plvy\\【有赞】重制课件文件vid20231215.xlsx";

    private static final String PATH_XLSX = "C:\\Users\\Admin\\Downloads\\【有赞】重制课件文件vid20231215.xlsx";

    private static final String COPY_PATH = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\有赞小红书类目映射.xls";


    private static final String PATHV1 = "";
    private static final String PATHV2 = "";
    private static final String PATHV3 = "";


    //需要提前新建目录  写入的文件名称
    private static final String FILE_NAME = "C:\\Users\\Admin\\Desktop\\文件\\excel\\保利威要下载的实际的 v2版本.xlsx";


    //每行的行数
//    private static  final Integer LINE_NUMBER =14;
    private static  final Integer LINE_NUMBER = 3;

    private static List<String> pashList = Lists.newArrayList(PATH_XLS, PATHV1, PATHV2, PATHV2);

    //数字限制
    private static final Integer NUM = 14;

    private static List<String> newArrayListist = Lists.newArrayList("跟团号"
            , "下单人", "支付时间", "商品", "订单金额", "订单退款", "订单状态", "收货人", "联系电话", "详细地址");


    @Test
    public void danceshiPl(){
        String liveUrl = "C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\excel\\保利威是寄给的\\副本.xlsx";

        try {
            List<VideoHotfixDTO> videoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(liveUrl, 9), 9, false);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }


    }

    /**
     * 读取三方excel数据筛选数据
     */
    @Test
    public void videoYouZan() {
        List<VideoHotfixDTO> videoUrlList = new ArrayList<>();
        List<VideoHotfixDTO> videoHotfixDTOList = new ArrayList<>();
        String plUrl = "C:\\Users\\Admin\\Documents\\WeChat Files\\wxid_4egrh9j2kcc522\\FileStorage\\File\\2024-08\\youzan.xlsx";
        String liveUrl = "C:\\Users\\Admin\\Desktop\\文件\\excel\\有赞channel.xlsx";
        String videoUrl = "C:\\Users\\Admin\\Desktop\\文件\\excel\\保利威普通直播需要给链接的.xlsx";

        String txtUrl = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\plvyV3.txt";

        try {

            //读取数据三份excel数据
            //直播表关联关系
            //保利威表关联关系
            List<VideoHotfixDTO> plUrlVideoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(plUrl, 7),  7, false);
            //只是为了拿kdtId   这里可以弄个频道map
            List<VideoHotfixDTO> liveUrlVideoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(liveUrl, 21), 21 , false);
            Map<String, VideoHotfixDTO> liveUrlMap = liveUrlVideoHotfixDTOList.stream()
                    .filter(Objects::nonNull).collect(Collectors.toMap(VideoHotfixDTO::getChannelId, v -> v, (k1, k2) -> k1));

            //这里还要有个kdtIdList用来效验要不要处理
            List<String> stringList = readLinesFromFile(txtUrl);

            for (VideoHotfixDTO videoHotfixDTO : plUrlVideoHotfixDTOList) {
                VideoHotfixDTO videoHotfixDTO1 = liveUrlMap.get(videoHotfixDTO.getChannelId());
                if (videoHotfixDTO1 == null){
                    continue;
                }
                if (Objects.nonNull(videoHotfixDTO1.getKdtId()) && stringList.contains(videoHotfixDTO1.getKdtId())) {
                    videoHotfixDTOList.add(convert(videoHotfixDTO, videoHotfixDTO1));
                }

            }

            //普通视频直播表数据 追加的回放链接
            List<VideoHotfixDTO> videoUrlVideoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(videoUrl, 7), 7, true).stream()
                    .filter(o -> Objects.equals("2", o.getType())).collect(Collectors.toList());
            Map<String, VideoHotfixDTO> collect = plUrlVideoHotfixDTOList.stream()
                    .filter(Objects::nonNull).collect(Collectors.toMap(VideoHotfixDTO::getVidId, v -> v, (k1, k2) -> k1));


            videoUrlVideoHotfixDTOList.stream().forEach(videoHotfixDTO -> {
                if (Objects.nonNull(videoHotfixDTO.getVidId())){
                    VideoHotfixDTO videoHotfixDTO1 = collect.get(videoHotfixDTO.getVidId());
                    if (Objects.nonNull(videoHotfixDTO1)){
                        videoUrlList.add(convertV2(videoHotfixDTO, videoHotfixDTO1));
                    }else {
                        videoUrlList.add(videoHotfixDTO);
                    }
                }else {
                    videoUrlList.add(videoHotfixDTO);
                }
            });


            videoHotfixDTOList.addAll(videoUrlList);
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            //写入新格式表
            EasyExcel.write(FILE_NAME, VideoHotfixDTO.class).sheet("需要下载链接的回放").doWrite(videoHotfixDTOList);

        } catch (Exception e) {
            log.error("失败了 e:{}", e);
        }

    }


    /**
     * 读取三方excel数据筛选数据
     */
    @Test
    public void videoYouZanTestV2() {
        List<VideoHotfixDTO> videoUrlList = new ArrayList<>();
        List<VideoHotfixDTO> videoHotfixDTOList = new ArrayList<>();
//        String plUrl = "C:\\Users\\Admin\\Desktop\\文件\\excel\\test\\1 - 副本.xlsx";
//        String liveUrl = "C:\\Users\\Admin\\Desktop\\文件\\excel\\test\\1.xlsx";
//        String videoUrl = "C:\\Users\\Admin\\Desktop\\文件\\excel\\test\\1 - 副本 (2).xlsx";
        String plUrl = "C:\\Users\\Admin\\Documents\\WeChat Files\\wxid_4egrh9j2kcc522\\FileStorage\\File\\2024-08\\youzan.xlsx";
        String liveUrl = "C:\\Users\\Admin\\Desktop\\文件\\excel\\有赞channel.xlsx";
        String videoUrl = "C:\\Users\\Admin\\Desktop\\文件\\excel\\保利威普通直播需要给链接的.xlsx";

        String txtUrl = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\plvyV3.txt";

        String excelFile = "C:\\Users\\Admin\\Desktop\\文件\\plvy\\暂存处理名单8-16\\保利威要链接下载暂存视频.xlsx";
//        String excelFile = "C:\\Users\\Admin\\Desktop\\文件\\excel\\test\\1 - 副本 (4).xlsx";
        try {

            //读取数据三份excel数据
            //直播表关联关系
            //保利威表关联关系
            List<VideoHotfixDTO> plUrlVideoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(plUrl, 7),  7, false);
            //只是为了拿kdtId   这里可以弄个频道map
            List<VideoHotfixDTO> liveUrlVideoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(liveUrl, 21), 21, false);
            Map<String, VideoHotfixDTO> liveUrlMap = liveUrlVideoHotfixDTOList.stream()
                    .filter(Objects::nonNull).collect(Collectors.toMap(VideoHotfixDTO::getChannelId, v -> v, (k1, k2) -> k1));

            System.err.println(liveUrlMap);

            //这里还要有个kdtIdList用来效验要不要处理
            List<String> stringList = readLinesFromFile(txtUrl);

            for (VideoHotfixDTO videoHotfixDTO : plUrlVideoHotfixDTOList) {
                VideoHotfixDTO videoHotfixDTO1 = liveUrlMap.get(videoHotfixDTO.getChannelId());
                if (videoHotfixDTO1 == null) {
                    continue;
                }
                if (Objects.nonNull(videoHotfixDTO1.getKdtId()) && stringList.contains(videoHotfixDTO1.getKdtId())) {
                    videoHotfixDTOList.add(convert(videoHotfixDTO, videoHotfixDTO1));
                }

            }

            //普通视频直播表数据 追加的回放链接
            List<VideoHotfixDTO> videoUrlVideoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(videoUrl, 7), 7, true).stream()
                    .filter(o -> Objects.equals("2", o.getType())).collect(Collectors.toList());
            Map<String, VideoHotfixDTO> collect = plUrlVideoHotfixDTOList.stream()
                    .filter(Objects::nonNull).collect(Collectors.toMap(VideoHotfixDTO::getVidId, v -> v, (k1, k2) -> k1));

            videoUrlVideoHotfixDTOList.stream().forEach(videoHotfixDTO -> {
                if (Objects.nonNull(videoHotfixDTO.getVidId())){
                    VideoHotfixDTO videoHotfixDTO1 = collect.get(videoHotfixDTO.getVidId());
                    if (Objects.nonNull(videoHotfixDTO1)){
                        videoUrlList.add(convertV2(videoHotfixDTO, videoHotfixDTO1));
                    }else {
                        videoUrlList.add(videoHotfixDTO);
                    }
                }else {
                    videoUrlList.add(videoHotfixDTO);
                }
            });


            videoHotfixDTOList.addAll(videoUrlList);
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            //写入新格式表
            EasyExcel.write(excelFile, VideoHotfixDTO.class).sheet("需要下载链接的回放").doWrite(videoHotfixDTOList);

        } catch (Exception e) {
            log.error("失败了 e:{}", e);
        }

    }




    @Test
    public void videoYouZanTest() {
        String liveUrl = "C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\excel\\保利威是寄给的\\202409-09给三方全部副本.xlsx";

        String excelFile = "C:\\Users\\Admin\\Desktop\\暂存处理名单8-16\\excel\\保利威是寄给的\\过滤掉vid的20240913.xlsx";

        try {
            List<VideoHotfixDTO> videoHotfixDTOList = buildVideoHotfixDTO(readExcelXlsCommandV2(liveUrl, 9), 9, false);

            List<VideoHotfixDTO> videoHotfixDTOS = videoHotfixDTOList.stream().filter(Objects::nonNull)
                    //过滤掉没有vid的
                    .filter(videoHotfixDTO -> StringUtils.isBlank(videoHotfixDTO.getVidId()))
                    .collect(Collectors.toList());

//            List<VideoHotfixDTO> collect = videoHotfixDTOList.stream().filter(Objects::nonNull).filter(videoHotfixDTO -> checkTime(videoHotfixDTO.getTime())).collect(Collectors.toList());

            EasyExcel.write(excelFile, VideoHotfixDTO.class).sheet("没有vid实际可以删除暂存的").doWrite(videoHotfixDTOS);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
        }

    }

    @Test
    public void  test1() {

        Boolean aBoolean = checkTime("2021/08/31 00:00:00");
        System.err.println(aBoolean);

    }


    private Boolean checkTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime targetDateTime = LocalDateTime.parse(time, formatter);

        LocalDateTime currentDateTime = LocalDateTime.now();
//        System.err.println(currentDateTime);

//        LocalDateTime localDateTime = targetDateTime.plusYears(3);
//        System.err.println(localDateTime);

        if (currentDateTime.isBefore(targetDateTime.plusYears(3))) {
//            System.out.println("当前时间小于三年前的时间");
            return true;
        } else {
//            System.out.println("当前时间大于或等于三年前的时间");
            return false;
        }
    }



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


    @Test
    public void paoLivReadExcelHotfix(){
        List<String> list = new ArrayList<>();
        try {
            int i = 0;
            String line;

            String sourceFile = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\plvy.txt";

            String logAllFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\plvyV2.txt";


            File file1 = new File(sourceFile);

            FileInputStream fis = new FileInputStream(file1);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            while ((line = br.readLine()) != null) {
                i++;
                JSONObject jsonObject = JSON.parseObject(line);
                String format = jsonObject.getString("format");

                subLogList(format,list);

            }

            br.close();

//            Set<String> collect = list.stream().collect(Collectors.toSet());
//
//            System.err.println(collect.size() + "::" + collect);


            //这里是筛选数据
            List<String> readLinesFromFile = readLinesFromFile(logAllFilePath);

            Set<String> collect = readLinesFromFile.stream().filter(o -> !list.contains(o)).collect(Collectors.toSet());

            System.err.println(collect.size() + "::" + collect);


//            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//            EasyExcel.write(FILE_NAME, hotfix.class).sheet("有赞报名表单提交数据").doWrite(list);
        }catch (Exception e){
            log.error("失败了 e:{}", e);
        }
    }




    @Test
    public void readExcel() {

        try {

            List<ExcelKttOrderDTO> excelKttOrderDTOS = readExcelXls();

            List<yzScrmExcelDTO> yzScrmExcelDTOS = data2(excelKttOrderDTOS);

            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            EasyExcel.write(FILE_NAME, yzScrmExcelDTO.class).sheet("有赞会员数据").doWrite(yzScrmExcelDTOS);

        } catch (Exception e) {
            log.error("失败了 e:{}", e);
        }

    }

    @Test
    public void paoLivRead() throws Exception {
        List<Integer> convertSourceIds = new ArrayList<>();
        Set<String> sourceIds = new HashSet<>();
        List<String> list = Arrays.asList("3065856","3062316","3062315","3062312","3062307","2476172","2476168","2476141","2476131","2476128","2476074","2476026","2468838","2468754","2295950","2287889","2287875","2282192","2282189","2282185","2282181","2282174","2282171","2282167","2282164","2282159","2282157","2282153");

        List<ExcelKttOrderDTO> excelKttOrderDTOS = readExcelXls();

        excelKttOrderDTOS.remove(0);

//        System.err.println(excelKttOrderDTOS.get(0));

        //这里还需要一个转换把.0去掉
         excelKttOrderDTOS.stream().filter(Objects::nonNull).forEach(kk -> {
            if (Objects.nonNull(kk)
                    && Objects.nonNull(kk.getPayOrderName())) {
                convertSourceIds.add(Double.valueOf(kk.getPayOrderName()).intValue());
            }
        });

        List<String> collect = convertSourceIds.stream().map(Objects::toString).collect(Collectors.toList());

        collect.stream()
                .filter(Objects::nonNull)
                .filter(o -> {
                    if (list.contains(o)){
                        return false;
                    }
                    return true;
                })
                .forEach(k -> {
                    if (Objects.nonNull(k)){
                        sourceIds.add(k);
                    }
                });


        System.err.println("长度:"+ sourceIds.size() +","+"总数据:"+sourceIds);
    }







    /**
     * *读取本地文件
     *
     * @throws Exception  不能用
     */
    public List<String> readExcelXlsV1() throws Exception {
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
    public List<ExcelKttOrderDTO> readExcelXls() throws Exception {
        Integer num = 0;

        List<ExcelKttOrderDTO> listArrayList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(PATH_XLS));
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


    /**
     *  公共读取excel数据
     * @param url
     * @param sun
     * @return
     * @throws Exception
     */
    public List<List<String>> readExcelXlsCommand(String url, Integer sun) throws Exception {
        Integer num = 0;
        List<List<String>> listArrayList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(url));
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
                        if (num % sun == 0) {
                            System.err.println(list);
                            //这里转换 需要把list数据循环赋值转成dto
                            listArrayList.add(list);
                            list.clear();
                        }
                    }
                }
            }
            return listArrayList;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("readExcelXlsCommand 失败了哈啊哈哈哈哈哈 E:{}" + e);
            return new ArrayList<>();
        }
    }




    /**
     *  公共读取excel数据
     * @param url
     * @param sun
     * @return
     * @throws Exception
     */
    public List<List<String>> readExcelXlsCommandV2(String url, Integer sun) throws Exception {
        List<List<String>> listArrayList = new ArrayList<>();
        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(url));
            org.apache.poi.ss.usermodel.Sheet sheet = xssfWorkbook.getSheetAt(0);
            //当前有两种模版 一种是第一行是描述行第二行才是表头，另一种第一行就是表头，如果第一行是描述行则从第二行开始读
            List<String> row0 = readOneRow(sheet.getRow(0));
            int startRowNum = 1;
            if (row0.stream().filter(StringUtils::isNotBlank).count() != row0.size()) {
                startRowNum = startRowNum + 1;
            }
            // 第i行是表名，忽略，从第下一行开始读取
            for (int rowNum = startRowNum; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if(null == row){
                    System.err.println("解析excel文件，filePath:"+ url + ", 第"+ rowNum+"行是空行");
                    continue;
                }
                List<String> data = new ArrayList<>();
                for (int j = 0; j < sun; j++) {
                    // 定义每一个cell的数据类型
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        data.add("");
                    } else if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        String formattedDate = sdf.format(date);
                        data.add(formattedDate);
                    } else {
                        cell.setCellType(CellType.STRING);
                        // 取出cell中的value
                        data.add(cell.getStringCellValue());
                    }
                }
                listArrayList.add(data);
            }

            return listArrayList;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("readExcelXlsCommandV2 失败了哈啊哈哈哈哈哈 E:{}" + e);
            return new ArrayList<>();
        }
    }


    /**
     * 解析excel文件
     *
     * @param filePath
     *            文件地址
     * @param fileHeaderLength
     *            excel第一行标题个数
     * @return
     */
    public static List<List<String>> readExcel(String filePath, Integer fileHeaderLength) {
        org.apache.poi.ss.usermodel.Workbook workbook = null;
        List<List<String>> list = new ArrayList<>();
        try {
            workbook = getReadWorkBookType(filePath);
            // 获取第一个sheet
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
            //当前有两种模版 一种是第一行是描述行第二行才是表头，另一种第一行就是表头，如果第一行是描述行则从第二行开始读
            List<String> row0 = readOneRow(sheet.getRow(0));
            int startRowNum = 1;
            if (row0.stream().filter(StringUtils::isNotBlank).count() != row0.size()) {
                startRowNum = startRowNum + 1;
            }
            // 第i行是表名，忽略，从第下一行开始读取
            for (int rowNum = startRowNum; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if(null == row){
                    log.info("解析excel文件，filePath = {}, 第 {} 行是空行", filePath, rowNum);
                    continue;
                }
                List<String> data = new ArrayList<>();
                for (int j = 0; j < fileHeaderLength; j++) {
                    // 定义每一个cell的数据类型
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        data.add("");
                    } else {
                        cell.setCellType(CellType.STRING);
                        // 取出cell中的value
                        data.add(cell.getStringCellValue());
                    }
                }
                list.add(data);
            }
            return list;
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }


    /**
     * 根据文件后缀获取excel工作空间
     *
     * @param filePath
     *            文件路径
     * @return
     */
    private static org.apache.poi.ss.usermodel.Workbook getReadWorkBookType(String filePath) {
        // xls-2003, xlsx-2007
        InputStream is = null;
        try {
            if (filePath.toLowerCase().endsWith("xlsx")) {
                return new XSSFWorkbook(is);
            } else if (filePath.toLowerCase().endsWith("xls")) {
                return new HSSFWorkbook(is);
            } else {
                // 抛出自定义的业务异常
                throw new BusinessException(-100);
            }
        } catch (IOException e) {
            // 抛出自定义的业务异常
            throw new BusinessException(-100);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }



    private static List<String> readOneRow(Row row) {
        List<String> head = new ArrayList<>();
        if (null == row) {
            return head;
        }

        for (Cell cell : row) {
            head.add(cell.getStringCellValue());
        }
        return head;
    }

    //低级的数据取值
    private ExcelKttOrderDTO data(List<String> list){
//        System.err.println("长度:"+list.size()+"数据data:"+ JSON.toJSON(list));
        ExcelKttOrderDTO excelKttOrderDTO = new ExcelKttOrderDTO();
        excelKttOrderDTO.setPackageNumber(list.get(0));
        excelKttOrderDTO.setPayOrderName(list.get(1));
        excelKttOrderDTO.setPayDate(list.get(2));
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

            return yzScrmExcelDTO;
        }).filter(Objects::nonNull).collect(Collectors.toList());

        return list;
    }



    //数据转换处理
    private List<yzScrmExcelDTO> data3(List<ExcelKttOrderDTO> excelKttOrderDTOS){
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


    /**
     * 截取天网日志
     * */
    public void subLogList(String format,List<String> list){

        String s = subBeforePushStream(format);

        String s1 = subAfterStreamKeyUrl(s);

        int indexOf = s1.indexOf(":", 0);

        String substring = s1.substring(indexOf + 1);

//        int indexOf1 = s1.indexOf(",", 0);
//
//        String s3 = Optional.ofNullable(s1.substring(indexOf1+1)).orElse(null);
//
//        int indexOf2 = s3.lastIndexOf("]");
//
//        String s4 = Optional.ofNullable(s3.substring(0,indexOf2)).orElse(null);

        JSONArray jsonArray = JSON.parseArray(substring);

        for (Integer v = 0;v < jsonArray.size();v++){
            JSONObject imageTextVo = jsonArray.getJSONObject(v);

            Object channelId = imageTextVo.get("channelId");

            if (Objects.nonNull(channelId)){
                list.add(String.valueOf(channelId));
            }

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
     * 转换数据
     * @param list
     * @param num
     * @return
     */
    private List<VideoHotfixDTO> buildVideoHotfixDTO(List<List<String>> list, Integer num, boolean istttime){
        List<VideoHotfixDTO> videoHotfixDTOList = new ArrayList<>();

        for (List<String> stringList : list) {

            if (Objects.equals(7, num) && Objects.equals(false, istttime)) {
                VideoHotfixDTO videoHotfixDTO = new VideoHotfixDTO();
                videoHotfixDTO.setChannelId(stringList.get(0));
                videoHotfixDTO.setMonth(stringList.get(2));
                videoHotfixDTO.setTime(stringList.get(3));
                videoHotfixDTO.setByteSize(stringList.get(4));
                videoHotfixDTO.setVidId(stringList.get(6));
                videoHotfixDTOList.add(videoHotfixDTO);
            }

            if (Objects.equals(21, num)) {
                VideoHotfixDTO videoHotfixDTO = new VideoHotfixDTO();
                if (Objects.nonNull(stringList.get(5)) && !Objects.equals(stringList.get(5), "0")){
                    videoHotfixDTO.setKdtId(stringList.get(1));
                    videoHotfixDTO.setType(stringList.get(4));
                    videoHotfixDTO.setChannelId(stringList.get(5));
                    videoHotfixDTOList.add(videoHotfixDTO);
                }

            }


            if (Objects.equals(7, num) && Objects.equals(true, istttime)) {
                VideoHotfixDTO videoHotfixDTO = new VideoHotfixDTO();
                videoHotfixDTO.setKdtId(stringList.get(0));
                videoHotfixDTO.setChannelId(stringList.get(1));
                videoHotfixDTO.setVidId(Objects.nonNull(stringList.get(2)) ? stringList.get(2) : "");
                videoHotfixDTO.setType(stringList.get(4));
                videoHotfixDTO.setUrl(Objects.nonNull(stringList.get(5)) ? stringList.get(5) : "");
                videoHotfixDTO.setVideoBlack(String.valueOf(1));
                videoHotfixDTOList.add(videoHotfixDTO);
            }


            if (Objects.equals(9, num)) {
                VideoHotfixDTO videoHotfixDTO = new VideoHotfixDTO();
                videoHotfixDTO.setKdtId(stringList.get(0));
                videoHotfixDTO.setChannelId(stringList.get(1));
                videoHotfixDTO.setVidId(Objects.nonNull(stringList.get(2)) ? stringList.get(2) : "");
                videoHotfixDTO.setType(stringList.get(3));
                videoHotfixDTO.setMonth(stringList.get(4));
                videoHotfixDTO.setTime(stringList.get(5));
                videoHotfixDTO.setByteSize(stringList.get(6));
                videoHotfixDTO.setUrl(Objects.nonNull(stringList.get(7)) ? stringList.get(7) : "");
                videoHotfixDTO.setVideoBlack(Objects.nonNull(stringList.get(8)) ? stringList.get(8) : "");
                videoHotfixDTOList.add(videoHotfixDTO);
                System.err.println(videoHotfixDTO);
            }

        }

        return videoHotfixDTOList;
    }


    private VideoHotfixDTO convert(VideoHotfixDTO videoHotfixList, VideoHotfixDTO hotfixMap){
        VideoHotfixDTO videoHotfixDTO = new VideoHotfixDTO();
        videoHotfixDTO.setKdtId(hotfixMap.getKdtId());
        videoHotfixDTO.setChannelId(hotfixMap.getChannelId());
        videoHotfixDTO.setVidId(videoHotfixList.getVidId());
        videoHotfixDTO.setType(hotfixMap.getType());
        videoHotfixDTO.setMonth(videoHotfixList.getMonth());
        videoHotfixDTO.setTime(videoHotfixList.getTime());
        videoHotfixDTO.setByteSize(videoHotfixList.getByteSize());
        return videoHotfixDTO;
    }


    private VideoHotfixDTO convertV2(VideoHotfixDTO videoUrlHotfixList, VideoHotfixDTO videoHotfixList){
        VideoHotfixDTO videoHotfixDTO = new VideoHotfixDTO();
        videoHotfixDTO.setKdtId(videoUrlHotfixList.getKdtId());
        videoHotfixDTO.setChannelId(videoUrlHotfixList.getChannelId());
        videoHotfixDTO.setVidId(videoUrlHotfixList.getVidId());
        videoHotfixDTO.setType(videoUrlHotfixList.getType());
        videoHotfixDTO.setMonth(videoHotfixList.getMonth());
        videoHotfixDTO.setTime(videoHotfixList.getTime());
        videoHotfixDTO.setByteSize(videoHotfixList.getByteSize());
        videoHotfixDTO.setUrl(videoUrlHotfixList.getUrl());
        videoHotfixDTO.setVideoBlack(videoUrlHotfixList.getVideoBlack());
        return videoHotfixDTO;
    }




}
