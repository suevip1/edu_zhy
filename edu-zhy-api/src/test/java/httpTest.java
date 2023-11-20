import com.edu.zhy.api.api.http.polyv.PolyvHttpUtil;
import com.edu.zhy.api.api.http.service.httputiljiagou.executeabstract.CommonHttpUtil;
import com.edu.zhy.api.api.http.service.httputiljiagou.initutil.InitApplicationContextUtil;
import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.api.api.web.service.DelayTaskCallbackServiceImpl;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 访问网页接口Test
 */
@Service
public class httpTest extends CommonHttpUtil {

    @Resource
    private PolyvHttpUtil polyvHttpUtil;

    @Test
    public void httpV1(){
//        httpUtil enhance = Builder.enhance(httpUtil.class);
//
//
////        String url = "http://api.polyv.net/live/v3/channel/chat/send-reward-msg";
////
////        HttpRequestBase proxyMethod = enhance.getProxyMethod(url, false);
////
////        System.err.println(proxyMethod);
//
//        httpUtil = ApplicationContextHelper.getBean(PolyvHttpUtil.class);
//        HttpUtilService httpUtilService = httpUtilServiceMap.get(1);
//
//        System.err.println(httpUtilService);


        System.err.println(polyvHttpUtil);


    }






    @Test
    public void httpV2(){

        DelayTaskCallbackServiceImpl instance = InitApplicationContextUtil.getInstance(DelayTaskCallbackServiceImpl.class);
        DelayTaskMessage message = new DelayTaskMessage();
        message.setTaskType("");
        message.setBizExtraID("1");
        message.setBizID("1");
        message.setExtra("1");
        message.setDelayEndTime(System.currentTimeMillis());

        instance.tspCallBackExecuteCore(message);


    }










}
