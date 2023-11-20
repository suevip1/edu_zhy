import com.edu.zhy.api.api.contract.AssetOperationType;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin.
 * Time 2023/11/17 16:19
 * Desc 文件描述
 * *资产的表cont_asset_ops 的操作
 */
public class contractTest {

    /**
     * * 直接获取全部的资产操作项
      */
   private static List<AssetOperationType> operationTypes = AssetOperationType.getAssetOperationType();

   private static HashMap<AssetOperationType,Integer> operationTypeIntegerHashMap = new HashMap<>();

    /**
     * * 获取全部的资产操作值
     * *{CHANGE_OWNER=131072, CHANGE_VALUE=4096,
     * * REMOVE_SCOPE=512, CHANGE_VALIDITY_INTERVAL=16384, DELETE=2,
     * * CREATE=1, VALIDITY_ACTIVATE=65536, ADD_TAG=1024, REMOVE_TAG=2048,
     * * UNLOCK=8, UNCONSUME=32, REMOVE_USER=128, ADD_USER=64, CONSUME=16,
     * * CHANGE_VALIDITY_TIME_AMOUNT=32768, DEDUCT_VALUE=8192, ADD_SCOPE=256, LOCK=4}
     */
    @Test
    public void  getAssetOptType(){
        operationTypes.stream().forEach(assetOperationType -> {
            operationTypeIntegerHashMap.put(assetOperationType,AssetOperationType.combine(Collections.singletonList(assetOperationType)));
        });
        System.err.println(operationTypeIntegerHashMap);

    }




}
