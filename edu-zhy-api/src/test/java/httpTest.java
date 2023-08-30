import com.edu.zhy.api.api.util.httpUtil;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 访问网页接口Test
 */
@Service
public class httpTest {

    @Autowired
    private httpUtil httpUtil;

    @Test
    public void httpV1(){


        String url = "http://api.polyv.net/live/v3/channel/chat/send-reward-msg";

        HttpRequestBase proxyMethod = httpUtil.getProxyMethod(url, false);

        System.err.println(proxyMethod);


    }















}
