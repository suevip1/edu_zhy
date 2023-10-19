import com.edu.zhy.api.api.http.polyv.PolyvHttpUtil;
import com.edu.zhy.api.api.util.ApplicationContextHelper;
import com.edu.zhy.api.api.util.httpUtil;
import com.edu.zhy.biz.dubboBean.DubboTetherProxy.Builder;
import org.junit.Test;
import org.springframework.stereotype.Service;

/**
 * 访问网页接口Test
 */
@Service
public class httpTest {

    private PolyvHttpUtil httpUtil;

    @Test
    public void httpV1(){
        httpUtil enhance = Builder.enhance(httpUtil.class);


//        String url = "http://api.polyv.net/live/v3/channel/chat/send-reward-msg";
//
//        HttpRequestBase proxyMethod = enhance.getProxyMethod(url, false);
//
//        System.err.println(proxyMethod);

        httpUtil = ApplicationContextHelper.getBean(PolyvHttpUtil.class);



        System.err.println(httpUtil);



    }















}
