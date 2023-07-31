import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.edu.zhy.api.api.dto.UserDTO;
import com.edu.zhy.api.api.dto.yzScrmExcelDTO;
import com.edu.zhy.api.api.service.impl.zhyService;
import com.google.common.collect.Lists;
import jxl.Sheet;
import jxl.Workbook;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestAop1 {

    //导入文件的路径
    private static final String PATH = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\跨团订单14_05_35.xlsx";

    private static final String COPY_PATH = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\有赞小红书类目映射.xls";


    private static final String PATHV1 = "";
    private static final String PATHV2 = "";
    private static final String PATHV3 = "";


    private static List<String> pashList = Lists.newArrayList(PATH, PATHV1, PATHV2, PATHV2);

    //数字限制
    private static final Integer NUM = 14;

    private static List<String> newArrayListist = Lists.newArrayList("跟团号"
            , "下单人", "支付时间", "商品", "订单金额", "订单退款", "订单状态", "收货人", "联系电话", "详细地址");


    @Resource
    private zhyService zhyService;


    @Test
    public void m1() {

        try {

            zhyService.afterProcess(1);
        } catch (Exception e) {
            log.error("调用接口有问题出错了 e:{}", e);
            return;
        }


    }


    @Test
    public void m2() {


        try {
//            //先读取excel的数据
//            List<String> list = readExcelXls();
//            System.err.println(list);

           List<String> lists = readExcelXlsx();
            System.err.println(lists);
        } catch (Exception e) {
            log.error("失败了 e:{}", e);
        }


        //筛选匹配数据（这里应该需要加接口查询）这步先不要，目前只做转换数据


        //生成excel写入本地


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
    public List<String> readExcelXlsx() throws Exception {
        Integer num = 1;

        List<List<String>> listArrayList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(PATH));
            //获取工作簿下sheet的个数
            int sheetNum = xssfWorkbook.getNumberOfSheets();
//            System.out.println("该excel文件中总共有：" + sheetNum + "个sheet");
            //遍历工作簿中的所有数据
            for (int i = 0; i < sheetNum; i++) {
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
//
//                        if (num % NUM == 0){
//                            listArrayList.add(list);
//                        }
                    }

//                    System.out.println();
                }
            }


            return list;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("失败了哈啊哈哈哈哈哈 E:{}",e);
            return new ArrayList<>();
        }

    }



    //数据
    private List<yzScrmExcelDTO> data2(List<String> newArrayListist){
        List<yzScrmExcelDTO> list = new ArrayList<>();

        //算上标题，做多可写65536行
        //超出：java.lang.IllegalArgumentException: Invalid row number (65536) outside allowable range (0..65535)
        for (int i = 0; i < newArrayListist.size(); i++) {
            yzScrmExcelDTO data = new yzScrmExcelDTO();


            list.add(data);
        }

        return list;
    }


    /**
     * *string转换为有赞格式数据
     * @param data
     * @return
     */
    private yzScrmExcelDTO convertData(String data){



        return new yzScrmExcelDTO();
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
