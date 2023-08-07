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
import java.util.Objects;

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

        //        System.err.println(ss);

String s1 ="{\"result\":{\"goods_info_with_sku_vo_list\":[{\"category_name\":\"足天龄种鸡\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":12580,\"max_on_sale_group_price\":12580,\"rank\":1,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":12580,\"goods_status\":1,\"goods_name\":\"『招牌』未打鸣公鸡\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/67275167f20247e1a19b0b0e5686eadb_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774159454,\"weight\":0,\"source_type\":1,\"goods_desc\":\"适合炒木耳，炒辣椒等，炒着吃！含生长激素，孩子长身体更要吃！\",\"labels\":[],\"min_on_sale_group_price\":12580,\"max_on_sale_normal_price\":12580,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[],\"quantity\":9999,\"price_in_yuan\":\"125.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081313207,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[],\"price\":12580,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":285378,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/67275167f20247e1a19b0b0e5686eadb_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"足天龄种鸡\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":12580,\"max_on_sale_group_price\":12580,\"rank\":2,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":12580,\"goods_status\":1,\"goods_name\":\"『招牌』 260天种鸡(母鸡)\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/7ec5d13db178447a9927bd9a52817531_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774142867,\"weight\":0,\"source_type\":1,\"goods_desc\":\"点击图片下拉查看邻居好评~适合：煲汤，铜盆蒸，水晶鸡等，几乎所有鸡的做法，鸡胸肉炒着吃最好吃！\",\"labels\":[],\"min_on_sale_group_price\":12580,\"max_on_sale_normal_price\":12580,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[],\"quantity\":9999,\"price_in_yuan\":\"125.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081305442,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[],\"price\":12580,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":285379,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/7ec5d13db178447a9927bd9a52817531_suffix.jpg\",\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/0e8be33bfd8941f5b5e6417479dc5c8d_suffix.jpg\",\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/f41b9f548b784d8c919d98b46bcaa34c_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"足天龄种鸡\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":17580,\"max_on_sale_group_price\":17580,\"rank\":3,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":17580,\"goods_status\":1,\"goods_name\":\"『招牌』 460天种鸡(母鸡)\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/c24a0e0a53e144d58bd93eda302b491f_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774175209,\"weight\":0,\"source_type\":1,\"goods_desc\":\"适合煲汤，红烧，焖，鸡煲，炖蘑菇.板栗.粉条等！\",\"labels\":[],\"min_on_sale_group_price\":17580,\"max_on_sale_normal_price\":17580,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[],\"quantity\":9999,\"price_in_yuan\":\"175.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081323182,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[],\"price\":17580,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":285380,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/c24a0e0a53e144d58bd93eda302b491f_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"足天龄种鸡\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":15580,\"max_on_sale_group_price\":15580,\"rank\":4,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":15580,\"goods_status\":1,\"goods_name\":\"『招牌』黑白土鸡\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/6a3ab0c41b4b405bad440d97a9e61dc7_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774181056,\"weight\":0,\"source_type\":1,\"goods_desc\":\"黑白土鸡，黑羽的是黑脚，白羽的是黄脚，肉滑，骨细，皮脆，椰子鸡，等（白切鸡推荐）\",\"labels\":[],\"min_on_sale_group_price\":15580,\"max_on_sale_normal_price\":15580,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[],\"quantity\":9999,\"price_in_yuan\":\"155.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081314400,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[],\"price\":15580,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":285382,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/6a3ab0c41b4b405bad440d97a9e61dc7_suffix.jpg\",\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/4b0170d12d76476684210bc54ba80944_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"足天龄种鸡\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":9680,\"max_on_sale_group_price\":9680,\"rank\":5,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":9680,\"goods_status\":1,\"goods_name\":\"『招牌』种鸡初生蛋\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/6d7d57fe2fe44ecf981b2a8b113c2e14_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774163339,\"weight\":0,\"source_type\":1,\"goods_desc\":\"初生蛋个头偏小\",\"labels\":[],\"min_on_sale_group_price\":9680,\"max_on_sale_normal_price\":9680,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[],\"quantity\":9999,\"price_in_yuan\":\"96.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081293646,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[],\"price\":9680,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":285383,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/6d7d57fe2fe44ecf981b2a8b113c2e14_suffix.jpg\",\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/ddef1677556342a7b2d9c935cd1d0396_suffix.jpg\",\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/84c0b7dec5e843dd808be1cfd024f3bd_suffix.jpg\",\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/7f5ccad52eda4056a83468568457f554_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":5980,\"max_on_sale_group_price\":5980,\"rank\":6,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":5980,\"goods_status\":1,\"goods_name\":\"金津麒麟西瓜8424\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/abce93e306a744cea9e8cd6ef4e9a3b2_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774148497,\"weight\":0,\"source_type\":1,\"goods_desc\":\"特别甄选。金津麒麟西瓜，中国西瓜第一品牌，8424原种。20年种植历史，让您吃到最原始上海的味。汁多超爽的甜！\",\"labels\":[],\"min_on_sale_group_price\":5980,\"max_on_sale_normal_price\":5980,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[],\"quantity\":9999,\"price_in_yuan\":\"59.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081319127,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[],\"price\":5980,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":285403,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/abce93e306a744cea9e8cd6ef4e9a3b2_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":1190,\"max_on_sale_group_price\":1190,\"rank\":7,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":1190,\"goods_status\":1,\"goods_name\":\"甄选柠檬2粒\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/9391775df90a475b9f65543cfc993352_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774131997,\"weight\":0,\"source_type\":1,\"goods_desc\":\"柠檬中含有丰富的柠檬酸，因此被誉为“柠檬酸仓库”。它的果实汁多肉脆，有浓郁的芳香气。因为味道特酸，故只能作为上等调味料，用来调制饮料菜肴、化妆品和药品。 此外，柠檬富含维生素C，能化痰止咳，生津健胃。用于支气管炎，百日咳，食欲不振，维生素缺乏，中暑烦渴等症状，它是'坏血病'的克星。\",\"labels\":[],\"min_on_sale_group_price\":1190,\"max_on_sale_normal_price\":1190,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[],\"quantity\":9999,\"price_in_yuan\":\"11.90\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081332038,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[],\"price\":1190,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":285849,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/cleric_task/2020-07-06/9391775df90a475b9f65543cfc993352_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":11800,\"max_on_sale_group_price\":11800,\"rank\":8,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":11800,\"goods_status\":1,\"goods_name\":\"★龙泉驿水蜜桃\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2021-05-27/632bb39d-a246-4b77-bafa-5b13f00962a7_suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774179119,\"weight\":0,\"source_type\":1,\"goods_desc\":\"龙泉驿水蜜桃\uD83C\uDF51\uD83C\uDF51\uD83C\uDF51正式开启2023年桃季\uD83C\uDF51\\\\n\\\\n受今年春天雨水多，温度低影响，我们甄选的春夏季水果都不去抢先上市，都是等口感上来才上市直供给邻居。希望邻居一吃到就是满意口感\\\\n因此我们荔枝也比上市晚一点，东魁杨梅也是精挑细选上，都是针对今年春天雨水多\uD83C\uDF27温度低造成的果品甜度化淡的问题。\\\\n目前看我们晚上市的策略，虽然让我们订单有点下降但好评确实比往年同期多\\\\n所以吃时令水果请跟上亚农甄选的节奏。让您花钱值当\\\\n\uD83C\uDF51\uD83C\uDF51\uD83C\uDF51\",\"labels\":[\"亚农基地直供\",\"新品上市\"],\"min_on_sale_group_price\":11800,\"max_on_sale_normal_price\":11800,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[18797167356],\"quantity\":10000000,\"price_in_yuan\":\"118.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081310960,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"份\",\"spec_id\":18797167356,\"name\":\"12-15头/4.5斤+\"}],\"price\":11800,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":5500}],\"min_buy\":0,\"foreign_goods_id\":286040,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2021-05-27/632bb39d-a246-4b77-bafa-5b13f00962a7_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-27/17e50458-1766-441e-8353-332b6496bde7_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-27/eaae10cc-2cc8-45e4-9a92-54f05f703ddd_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-27/a905038d-d732-43e3-8a3c-97614357dae9_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-27/959172bc-e9de-4442-9f1f-a98425b01583_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-27/ba676518-6ced-4fee-9743-be61932ae85b_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-27/5c1614a1-b214-488d-9061-2b98831e4c29_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":4880,\"max_on_sale_group_price\":4880,\"rank\":9,\"total_quantity\":9999,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":4880,\"goods_status\":1,\"goods_name\":\"★招牌黄金西瓜\",\"quantity\":9999,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2021-01-20/be3b16c5-df38-4d00-99a8-004b637d832f_suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774131983,\"weight\":0,\"source_type\":1,\"goods_desc\":\"原种黄金西瓜来自我2003年教过他如何种好西瓜的农户，转眼17年成就了中国第一瓜值得您品鉴\\\\n今年黄金瓜因天冷，产量少，估计只能做1-3轮，随时停，这个可以抢啊\",\"labels\":[\"爆款返场\",\"团长推荐\"],\"min_on_sale_group_price\":4880,\"max_on_sale_normal_price\":4880,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[6295084120],\"quantity\":9999,\"price_in_yuan\":\"48.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081329027,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":6295084120,\"name\":\"1个装4-5斤左右\"}],\"price\":4880,\"quantity_type\":0,\"total_quantity\":9999,\"foreign_sku_id\":0,\"cost_price\":1500}],\"min_buy\":0,\"foreign_goods_id\":286394,\"quantity_type\":0,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2021-01-20/be3b16c5-df38-4d00-99a8-004b637d832f_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-01-20/7ea88100-f55d-4137-b901-b8b4b9db7035_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":19800,\"max_on_sale_group_price\":19800,\"rank\":10,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":19800,\"goods_status\":1,\"goods_name\":\"★精选-无锡阳山核心产区湖景水蜜桃\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2020-07-16/aa31770f-ea04-47d1-8f1e-0bd03d2a7916_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774152520,\"weight\":0,\"source_type\":1,\"goods_desc\":\"阳山水蜜桃进入湖景品种了；我们情愿早湖景当白凤价给朋友与邻居\uD83D\uDC6C\\\\n都不让湖景里掺白凤推荐给您\\\\n\\\\n因为当阳山水蜜桃进入湖景品种时\uD83C\uDF51代表全国可以说全世界的桃，到达年度最佳最高水平\uD83D\uDEF0️我们不能让这最佳最高水平打丁点折\\\\n\\\\n湖景桃上市；也是桃季的分水岭⛰️\\\\n湖景走后桃一个比一个差丢丢⬇️湖景之前的桃一个比一个好吃⬆️\\\\n\\\\n今年为了突出我们对湖景级别不同市场；果农坚决给我们落实。8两➕。6两➕的桃\uD83C\uDF51\\\\n往年湖景都要小一个规格上市。今年就不同，我们提质不提价，就是想您认可亚农甄选\uD83D\uDD2C\\\\n\\\\n无锡阳山核心产区等级➕湖景水蜜桃\uD83C\uDF51欢迎下单啊\uD83C\uDF51\\\\n湖景的香甜会让您心情喜悦消暑\",\"labels\":[\"亚农基地直供\",\"热门推荐\"],\"min_on_sale_group_price\":19800,\"max_on_sale_normal_price\":19800,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[20069986511],\"quantity\":10000000,\"price_in_yuan\":\"198.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081307433,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":20069986511,\"name\":\"8头(6两以上)\"}],\"price\":19800,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":8000}],\"min_buy\":0,\"foreign_goods_id\":340633,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2020-07-16/aa31770f-ea04-47d1-8f1e-0bd03d2a7916_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":23800,\"max_on_sale_group_price\":23800,\"rank\":11,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":23800,\"goods_status\":1,\"goods_name\":\"★特选/无锡阳山核心产区湖景水蜜桃\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2020-07-16/c3548e78-1254-4cb9-b08c-25a612caadea_suffix.jpg\",\"subscribe\":false,\"goods_id\":509774145728,\"weight\":0,\"source_type\":1,\"goods_desc\":\"阳山水蜜桃进入湖景品种了；我们情愿早湖景当白凤价给朋友与邻居\uD83D\uDC6C\\\\n都不让湖景里掺白凤推荐给您\\\\n\\\\n因为当阳山水蜜桃进入湖景品种时\uD83C\uDF51代表全国可以说全世界的桃，到达年度最佳最高水平\uD83D\uDEF0️我们不能让这最佳最高水平打丁点折\\\\n\\\\n湖景桃上市；也是桃季的分水岭⛰️\\\\n湖景走后桃一个比一个差丢丢⬇️湖景之前的桃一个比一个好吃⬆️\\\\n\\\\n今年为了突出我们对湖景级别不同市场；果农坚决给我们落实。8两➕。6两➕的桃\uD83C\uDF51\\\\n往年湖景都要小一个规格上市。今年就不同，我们提质不提价，就是想您认可亚农甄选\uD83D\uDD2C\\\\n\\\\n无锡阳山核心产区等级➕湖景水蜜桃\uD83C\uDF51欢迎下单啊\uD83C\uDF51\\\\n湖景的香甜会让您心情喜悦消暑\",\"labels\":[\"亚农基地直供\",\"限量供应\"],\"min_on_sale_group_price\":23800,\"max_on_sale_normal_price\":23800,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[20070016739],\"quantity\":10000000,\"price_in_yuan\":\"238.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081323180,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":20070016739,\"name\":\"6头(8两以上)\"}],\"price\":23800,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":11200}],\"min_buy\":0,\"foreign_goods_id\":340637,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2020-07-16/c3548e78-1254-4cb9-b08c-25a612caadea_suffix.jpg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":4900,\"max_on_sale_group_price\":4900,\"rank\":12,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":4900,\"goods_status\":1,\"goods_name\":\"★鲜甜多汁-库尔勒香梨(母梨)\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2020-10-15/41da5fd1-24cb-447d-9d7f-0341a2f84535_suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774169209,\"weight\":0,\"source_type\":1,\"goods_desc\":\"库尔勒香梨全母梨甄选第二季\uD83C\uDF50去年许多邻居理解了水果也分公母梨\uD83C\uDF50\\\\n邻居也说“母梨各个爽甜，是库尔勒梨正统的香味，与15年前的库尔勒香梨一摸一样滴”\\\\n希望您品尝到邻居说的味道\",\"labels\":[],\"min_on_sale_group_price\":4900,\"max_on_sale_normal_price\":4900,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3916906034],\"quantity\":10000000,\"price_in_yuan\":\"49.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081331090,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3916906034,\"name\":\"3斤\"}],\"price\":4900,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":2520}],\"min_buy\":0,\"foreign_goods_id\":794430,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2020-10-15/41da5fd1-24cb-447d-9d7f-0341a2f84535_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-12-07/09efda61-4b31-42f0-a467-db7c862f9752_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-10-15/575895f3-4640-416b-8890-1f4403f6f3b4_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-10-15/c4b369ca-d239-40ac-af58-0e3d1b9bb6d6_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-10-15/8f58fce4-2735-4997-9155-34afb30920c4_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-10-15/58a7b8e2-2faf-470d-a040-e3f717352410_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-10-15/96cee5ea-74ee-4b3d-8a91-7805f53d1466_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":2280,\"max_on_sale_group_price\":2280,\"rank\":13,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":2280,\"goods_status\":1,\"goods_name\":\"水果木瓜\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2020-11-24/a93f910b-53bc-424a-84e3-2cecff37ca29_suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774157647,\"weight\":0,\"source_type\":1,\"goods_desc\":\"因光照原因，木瓜有一面很光滑，另一面较粗糙并有部分小点，特此注意!\\\\n1.外皮颜色\\\\n青木瓜因外皮为青色而得名，只有熟到快要掉地时，才会略显微黄色；水果木瓜未成熟时外观虽然和青木瓜相同，但成熟后外皮为明显的深黄色，品相诱人。\\\\n2.果肉颜色\\\\n成熟的青木瓜果肉颜色为微黄色，而水果木瓜的果肉呈红色，果肉较为厚实细致。\\\\n3.口感味道\\\\n水果清甜香浓、软滑多汁，口感好于其他木瓜；新鲜的青木瓜一般带有点苦、涩味，果浆味也比较浓，在口感上是略差于水果木瓜。\\\\n4.食用方式\\\\n之所以称为水果木瓜，是因为一般把它当做水果食用，红心木瓜就是其中优质的代表；而青木瓜基本上只作为蔬菜食用，只有到了成熟后才可能会当做水果鲜食。\\\\n5.保存方法\\\\n青木瓜不容易烂，保存时间比一般木瓜略长；水果木瓜成熟后皮保存时间很短，很容易变质。\",\"labels\":[],\"min_on_sale_group_price\":2280,\"max_on_sale_normal_price\":2280,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[5335792587],\"quantity\":10000000,\"price_in_yuan\":\"22.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081317356,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":5335792587,\"name\":\"3.7-4斤\"}],\"price\":2280,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":1070414,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2020-11-24/a93f910b-53bc-424a-84e3-2cecff37ca29_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-11-24/f4d25b5a-d59b-4b51-b18f-426f7dd3f7ca_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-11-24/f5a9ad12-ab42-41eb-b999-7c21383e4863_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":4980,\"max_on_sale_group_price\":4980,\"rank\":14,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":4980,\"goods_status\":1,\"goods_name\":\"★海南大路黑金刚莲雾\",\"quantity\":10000000,\"goods_cover\":\"https://commimg.pddpic.com/monica/2022-12-03/0905c48a-fdad-4bc7-b1ca-db7afe37bac5.jpeg.suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774172183,\"weight\":0,\"source_type\":1,\"goods_desc\":\"海南大路黑金刚莲雾是亚农2014年创业初期就甄选的产品，当时只有我们甄选的莲雾口感清甜，汁多生津，不涩口，邻居说“特能抗击雾霾对肺部的伤害”\\\\n\\\\n大概是2019年这种口感就没了，然后2020，2021口感也没恢复过来。今年基地说一定要把疫情前口感找回来\\\\n才有了我们的浓重推荐\\\\n【黑金刚莲雾特别娇嫩，表皮非常薄。哪怕只是指甲轻轻划一下就会受伤。别看它叫金刚，其实莲雾是水果中的玻璃，一不小心就会碰坏。\\\\n\\\\n别的水果在争【鲜】时，她已然成【仙】\\\\n① 莲雾含水量约90% \\\\n② 0脂肪 \\\\n③ 热量相当于苹果的50%\\\\n莲雾有是拜佛最佳果\\\\n多吃有益老人孩子冬日润肺必吃\",\"labels\":[\"亚农基地直供\"],\"min_on_sale_group_price\":4980,\"max_on_sale_normal_price\":4980,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3908559039],\"quantity\":10000000,\"price_in_yuan\":\"49.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081252990,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3908559039,\"name\":\"1斤\"}],\"price\":4980,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":2428}],\"min_buy\":0,\"foreign_goods_id\":1346199,\"quantity_type\":1,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2022-12-03/0905c48a-fdad-4bc7-b1ca-db7afe37bac5.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-12-03/68080700-20c2-4d72-984b-965feb56a199.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-12-03/998ac641-d000-4e3e-8184-9d19d74630d6.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-12-03/8f1af611-ac9f-4293-8c35-3d52acb4cd82.jpeg.suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-12-30/ce9299ac-b402-4365-a0f9-7520ff26733d_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2020-12-30/f56379b3-4f34-45f9-8f43-5ef12fc71275_suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-12-03/ada139cd-ee61-4e6a-b281-96a1037f0845.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-12-03/9128b903-f201-4f3f-a339-4a2ffc70e99a.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-12-03/22aaf5f6-c4c3-4242-a35f-8d70014a7474.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":1580,\"max_on_sale_group_price\":1580,\"rank\":15,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":1580,\"goods_status\":1,\"goods_name\":\"佳沃黄香蕉\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2021-03-27/f5cb4c45-69b3-4d3a-92be-90d18c01dcce_suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774139819,\"weight\":0,\"source_type\":1,\"goods_desc\":\"表面有划痕、花皮、蕉皮发黑都属正常现象，介意勿拍！\",\"labels\":[],\"min_on_sale_group_price\":1580,\"max_on_sale_normal_price\":1580,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3908559039],\"quantity\":10000000,\"price_in_yuan\":\"15.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081316328,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3908559039,\"name\":\"1斤\"}],\"price\":1580,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":1960234,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2021-03-27/f5cb4c45-69b3-4d3a-92be-90d18c01dcce_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-03-27/85399ac7-32f2-40c6-b42a-95342faa4138_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":8900,\"max_on_sale_group_price\":8900,\"rank\":16,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":8900,\"goods_status\":1,\"goods_name\":\"佳沛奇异果\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2021-05-10/5970ca90-d2f9-4233-a168-2f4d6bc8f5d2_suffix.png\",\"subscribe\":false,\"goods_id\":509774140884,\"weight\":0,\"source_type\":1,\"goods_desc\":\"单果130～155克，佳沛阳光金果：水润香甜，果香四溢；细腻软糯，饱满多汁。富含天然VC，还有叶酸，膳食纤维，钾，VE等多种营养，激发健康力。\",\"labels\":[\"团长推荐\"],\"min_on_sale_group_price\":8900,\"max_on_sale_normal_price\":8900,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3925258949],\"quantity\":10000000,\"price_in_yuan\":\"89.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081290993,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3925258949,\"name\":\"6个/份\"}],\"price\":8900,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0}],\"min_buy\":0,\"foreign_goods_id\":2393531,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2021-05-10/5970ca90-d2f9-4233-a168-2f4d6bc8f5d2_suffix.png\",\"https://t16img.yangkeduo.com/monica/2021-05-10/d1b5c04c-6c43-4760-8d37-f22ef452ba37_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-10/172f54ab-eeac-4139-938e-b413e49acb6a_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-10/818aeb7a-3066-4cfe-ae0d-874e1f815a0f_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-10/8595861f-0995-4616-8963-bbced2842b01_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-10/5198e1b5-de25-4413-96aa-569197fd6234_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-10/4bcb286b-c491-4de2-ad7e-f3d4afb01f96_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-05-10/197e7b87-ab92-4b2c-970f-b90de037099f_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":10800,\"max_on_sale_group_price\":10800,\"rank\":17,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":10800,\"goods_status\":1,\"goods_name\":\"★一藤福安巨峰葡萄\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2021-07-04/05e73108-42f7-4e44-9492-e2083011201d_suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774178061,\"weight\":0,\"source_type\":1,\"goods_desc\":\"福安巨峰一藤葡萄\uD83C\uDF47\\\\n开启今年好吃葡萄季了\uD83C\uDF47\\\\n今年的福安葡萄比去年一开季口感好；果肉细嫩紧致、爆甜、汁香满溢，应该是一上手，就停下口的葡萄\uD83C\uDF47\",\"labels\":[],\"min_on_sale_group_price\":10800,\"max_on_sale_normal_price\":10800,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3920143319],\"quantity\":10000000,\"price_in_yuan\":\"108.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081300757,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3920143319,\"name\":\"4斤\"}],\"price\":10800,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":5000}],\"min_buy\":0,\"foreign_goods_id\":3036000,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2021-07-04/05e73108-42f7-4e44-9492-e2083011201d_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-07-04/c0eef0e6-b087-4d95-8b83-3bf6a439ac3e_suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-07-04/83281592-e01b-418d-a555-b013795c362c_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":3680,\"max_on_sale_group_price\":3680,\"rank\":18,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":3680,\"goods_status\":1,\"goods_name\":\"★甜心小番茄\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2021-11-29/14a697ed-fdab-4a29-8f10-b39054031864_suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774143753,\"weight\":0,\"source_type\":1,\"goods_desc\":\"\",\"labels\":[],\"min_on_sale_group_price\":3680,\"max_on_sale_normal_price\":3680,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3922004784],\"quantity\":10000000,\"price_in_yuan\":\"36.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081326253,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3922004784,\"name\":\"1.5斤左右\"}],\"price\":3680,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":1400}],\"min_buy\":0,\"foreign_goods_id\":5212474,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2021-11-29/14a697ed-fdab-4a29-8f10-b39054031864_suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":1500,\"max_on_sale_group_price\":1500,\"rank\":19,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":1500,\"goods_status\":1,\"goods_name\":\"★紫色百香果\",\"quantity\":10000000,\"goods_cover\":\"https://commimg.pddpic.com/monica/2022-03-28/ee999b7e-8733-413a-93f8-f352bc3f2ba4.jpeg\",\"subscribe\":false,\"goods_id\":509774136951,\"weight\":0,\"source_type\":1,\"goods_desc\":\"口感较酸\",\"labels\":[],\"min_on_sale_group_price\":1500,\"max_on_sale_normal_price\":1500,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3908559039],\"quantity\":10000000,\"price_in_yuan\":\"15.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081313202,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3908559039,\"name\":\"1斤\"}],\"price\":1500,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":900}],\"min_buy\":0,\"foreign_goods_id\":6936225,\"quantity_type\":1,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2022-03-28/ee999b7e-8733-413a-93f8-f352bc3f2ba4.jpeg\",\"https://commimg.pddpic.com/monica/2022-03-28/d9ca8659-35eb-43a8-b1b2-54cee35916da.jpeg\",\"https://commimg.pddpic.com/monica/2022-03-28/15e8d698-ddf0-45b1-93ad-58aa39b61867.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":1,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":2980,\"max_on_sale_group_price\":2980,\"rank\":20,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":2980,\"goods_status\":1,\"goods_name\":\"★即食牛油果\",\"quantity\":9999999,\"goods_cover\":\"https://commimg.pddpic.com/monica/2022-08-11/b8abe09c-a412-43c1-b59a-f51576213032.jpeg.suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774147708,\"weight\":0,\"source_type\":1,\"goods_desc\":\"即食牛油果\\\\n解决牛油果靠等熟的烦恼\\\\n我们精心挑选八成熟左右牛油果直供给您\uD83D\uDC02\\\\n确保最佳口感与最佳香味让您随心方便即食\\\\n常温存放可放3天左右，收到完全可以马上吃\uD83D\uDE0B\\\\n牛油果补钾相当不错滴。放松肌肉，缓解压力，那是数第一滴️\\\\n到时求您吃法分享，我们好分享给更多朋友健康有益产品。\",\"labels\":[],\"min_on_sale_group_price\":2980,\"max_on_sale_normal_price\":2980,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3934788827],\"quantity\":9999999,\"price_in_yuan\":\"29.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081286781,\"sold_quantity\":1,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3934788827,\"name\":\"2个装\"}],\"price\":2980,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":1000}],\"min_buy\":0,\"foreign_goods_id\":11523971,\"quantity_type\":1,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2022-08-11/b8abe09c-a412-43c1-b59a-f51576213032.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-08-11/231484a9-55a3-4cb4-be0e-04b325fab6f2.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-08-11/62111ef5-c176-4a7b-91f9-43b3aa832cf9.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-08-11/b339cb37-7ff4-46f9-9fc5-f34426f509f5.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-08-11/b040af07-d0d6-4ccf-90f9-50c19e066b37.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-08-11/5cedc438-c9c3-4370-90d0-07ddd3fe823a.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":1},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":5980,\"max_on_sale_group_price\":5980,\"rank\":21,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":5980,\"goods_status\":1,\"goods_name\":\"★小蜜香瓜\",\"quantity\":10000000,\"goods_cover\":\"https://commimg.pddpic.com/monica/2022-09-20/ddce8b57-b88c-4887-85e6-281f64efe8f4.jpeg.suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774145759,\"weight\":0,\"source_type\":1,\"goods_desc\":\"小蜜香瓜\\\\n来自九峰山高山种植的香瓜⛰\\\\n这是我们第二年甄选\uD83D\uDD2C\\\\n与其它香瓜比，我们更接近小时候味道，不似其它香瓜有小时候模样没小时候味道\\\\n盼望您第一口就肯定回到小时候\\\\n瓜香扑鼻、甜香津津，去皮吃香甜，带皮吃脆甜。柄有点苦要去掉\",\"labels\":[],\"min_on_sale_group_price\":5980,\"max_on_sale_normal_price\":5980,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3922680994],\"quantity\":10000000,\"price_in_yuan\":\"59.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081325106,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3922680994,\"name\":\"2.5斤\"}],\"price\":5980,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":1830}],\"min_buy\":0,\"foreign_goods_id\":12423760,\"quantity_type\":1,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2022-09-20/ddce8b57-b88c-4887-85e6-281f64efe8f4.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-09-20/691c6e30-75cc-4628-b8dc-4148d5d3533b.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2022-09-20/a9bbf902-d305-424e-b6ae-3427ac6d0012.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":13800,\"max_on_sale_group_price\":14900,\"rank\":22,\"total_quantity\":20000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":13800,\"goods_status\":1,\"goods_name\":\"★宜兴水蜜桃\",\"quantity\":20000000,\"goods_cover\":\"https://commimg.pddpic.com/monica/2023-06-27/c86223cd-66f8-4481-a736-4a8438276948.jpeg.suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774136934,\"weight\":0,\"source_type\":1,\"goods_desc\":\"邻居都在催无锡阳山水蜜桃\uD83C\uDF51\\\\n其实每年无锡阳山水蜜桃都是7月5号左右开园\uD83C\uDF0B\\\\n今年许多平台都上了阳山水蜜桃为何有？当然是知道您想要，所以就有\\\\n其实就是这款宜兴水蜜桃\uD83C\uDF51当阳山水蜜桃买\\\\n一样的桃香扑鼻，一样的蜜桃成熟的美丽，一样的汁水丰富\uD83C\uDF79不过就是与阳山水蜜桃有丢丢区别。就是那丢丢的酸口我不提醒或许您感觉不到滴\\\\n不过依然硬吃口感脆甜爽口，软吃鲜甜多汁\uD83C\uDF79\\\\n逼迫推荐。不过真的可以，只是别人当阳山水蜜桃卖给您\\\\n我们把真实告知您\",\"labels\":[],\"min_on_sale_group_price\":13800,\"max_on_sale_normal_price\":14900,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[19447772032],\"quantity\":10000000,\"price_in_yuan\":\"138.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081326250,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"份\",\"spec_id\":19447772032,\"name\":\"8个装（5两果）\"}],\"price\":13800,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":5230},{\"thumb_url\":\"\",\"spec_id_list\":[19447758416],\"quantity\":10000000,\"price_in_yuan\":\"149.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081326251,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"份\",\"spec_id\":19447758416,\"name\":\"6个装（6两果）\"}],\"price\":14900,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":4750}],\"min_buy\":0,\"foreign_goods_id\":20135326,\"quantity_type\":1,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2023-06-27/c86223cd-66f8-4481-a736-4a8438276948.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-06-27/1588b88e-077e-4fa0-af85-476a6bcf24fa.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-06-27/8400481a-eafd-445a-875b-aad4d1428d36.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-06-27/25c5439c-7b92-4293-9306-5c76cd37e693.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-06-27/6afe10b0-226c-4297-80e2-a12dc9a273aa.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":6280,\"max_on_sale_group_price\":11800,\"rank\":23,\"total_quantity\":20000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":6280,\"goods_status\":1,\"goods_name\":\"★大荔冰糖枣\",\"quantity\":20000000,\"goods_cover\":\"https://commimg.pddpic.com/monica/2023-07-06/e1dd9b5e-6db9-45d0-a807-874782e05b58.jpeg.suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774181080,\"weight\":0,\"source_type\":1,\"goods_desc\":\"大荔冰糖枣\\\\n皮脆，肉甜，汁津甜\uD83D\uDC1D\\\\n值得推荐，下午休闲，晨早爽心都可以来几粒啊\uD83C\uDF33\",\"labels\":[],\"min_on_sale_group_price\":6280,\"max_on_sale_normal_price\":11800,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[4181848009],\"quantity\":10000000,\"price_in_yuan\":\"62.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081330291,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"份\",\"spec_id\":4181848009,\"name\":\"1斤\"}],\"price\":6280,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":2400},{\"thumb_url\":\"\",\"spec_id_list\":[3970853748],\"quantity\":10000000,\"price_in_yuan\":\"118.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081330292,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"份\",\"spec_id\":3970853748,\"name\":\"2斤\"}],\"price\":11800,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":4800}],\"min_buy\":0,\"foreign_goods_id\":20332765,\"quantity_type\":1,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2023-07-06/e1dd9b5e-6db9-45d0-a807-874782e05b58.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-07-06/5ca412b3-e9b1-4436-8bfe-ca0aff52329f.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-07-06/0d937b18-769e-4675-999d-260b8aa3f9e6.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-07-06/e624ed44-323d-4714-ac71-9fcd02431db5.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-07-06/322a537c-b67f-491e-a834-99b5f2650a74.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":5200,\"max_on_sale_group_price\":5200,\"rank\":24,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":5200,\"goods_status\":1,\"goods_name\":\"★带叶夏橙\",\"quantity\":10000000,\"goods_cover\":\"https://t16img.yangkeduo.com/monica/2021-07-09/00209a36-ae9c-4a92-b518-851f53dbfb55.jpeg.suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774148527,\"weight\":0,\"source_type\":1,\"goods_desc\":\"新上架带叶夏橙\\\\n夏橙现在不太酸了。还有清新的味道了，满足橙友们喜欢的新鲜\\\\n做果汁，鲜吃都挺好\",\"labels\":[],\"min_on_sale_group_price\":5200,\"max_on_sale_normal_price\":5200,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3908559000],\"quantity\":10000000,\"price_in_yuan\":\"52.00\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081310961,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3908559000,\"name\":\"5斤\"}],\"price\":5200,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":1900}],\"min_buy\":0,\"foreign_goods_id\":20332980,\"quantity_type\":1,\"pic_url_list\":[\"https://t16img.yangkeduo.com/monica/2021-07-09/00209a36-ae9c-4a92-b518-851f53dbfb55.jpeg.suffix.jpeg\",\"https://t16img.yangkeduo.com/monica/2021-07-09/348eb86d-0716-48b9-9f72-2643847e1ec6.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-07-05/5018997d-7d63-4b66-beec-6260d9406c38.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-07-05/b3482826-0366-4bc0-9d92-016767dc60c5.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0},{\"category_name\":\"时令水果\",\"is_virtual_goods\":false,\"sold_quantity\":0,\"goods_activity_type\":0,\"ignore_vip_discount\":false,\"price\":11980,\"max_on_sale_group_price\":11980,\"rank\":25,\"total_quantity\":10000000,\"is_zero_yuan\":false,\"min_on_sale_normal_price\":11980,\"goods_status\":1,\"goods_name\":\"★伦晚橙\",\"quantity\":10000000,\"goods_cover\":\"https://commimg.pddpic.com/monica/2023-07-07/32716475-1b7a-4e05-9594-77a1f4e88fa6.jpeg.suffix.jpeg\",\"subscribe\":false,\"goods_id\":509774174200,\"weight\":0,\"source_type\":1,\"goods_desc\":\"伦晚橙酸甜可口，橙汁鲜美，VC满满，盼望大家快来下单。\\\\n95+果，老果树，表皮有斑点，介意勿拍。\",\"labels\":[],\"min_on_sale_group_price\":11980,\"max_on_sale_normal_price\":11980,\"start_buy\":0,\"sku_list\":[{\"thumb_url\":\"\",\"spec_id_list\":[3922275223],\"quantity\":10000000,\"price_in_yuan\":\"119.80\",\"external_sku_id\":\"\",\"reserve_quantity\":0,\"sku_id\":1433081307429,\"sold_quantity\":0,\"is_on_sale\":1,\"spec_list\":[{\"parent_name\":\"默认规格\",\"spec_id\":3922275223,\"name\":\"6斤\"}],\"price\":11980,\"quantity_type\":1,\"total_quantity\":10000000,\"foreign_sku_id\":0,\"cost_price\":4500}],\"min_buy\":0,\"foreign_goods_id\":20361754,\"quantity_type\":1,\"pic_url_list\":[\"https://commimg.pddpic.com/monica/2023-07-07/32716475-1b7a-4e05-9594-77a1f4e88fa6.jpeg.suffix.jpeg\",\"https://commimg.pddpic.com/monica/2023-07-07/e13b4bf3-465d-4d89-beab-0654f03d97df.jpeg.suffix.jpeg\"],\"cost_template_id\":\"0\",\"limit_buy\":0,\"sold_count\":0}],\"image_text_vos\":[{\"cover\":\"\",\"video_md5\":\"\",\"audit_status\":0,\"type\":3,\"content\":\"补差/运费专用，请与客服沟通后拍下！支付后请截图客服核实，谢谢！\"}],\"title\":\"【亚农直供选甄栈】补差/运费专用\",\"collection_activity_no\":\"0inp746lk-a83rw4oCLFMNtjFQglVUEg\"}}\n";
//        if (Objects.isNull(s1)){
//            System.err.println(s1);
//        }
//
//        try {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setName(s1);
//            System.err.println(userDTO);
//        }catch (Exception e){
//
//            System.err.println("e:{}"+e);
//        }


//        try {
////            //先读取excel的数据
////            List<String> list = readExcelXls();
////            System.err.println(list);
//
//           List<String> lists = readExcelXlsx();
//            System.err.println(lists);
//        } catch (Exception e) {
//            log.error("失败了 e:{}", e);
//        }


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
