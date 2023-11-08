package com.edu.zhy.api.api.windows.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: 这里有可能会有变化的是 jwt_toke和auth认证Bearer，需要一起替换，有效期12天
 * *mac版本
 *
 * @author laoliangliang
 * @version 1.0
 * @date 2021/11/6
 **/
@Slf4j
public class UrlManager {
    // 认证信息
    public static String authorization = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imxhb2xpYW5nbGlhbmciLCJncm91cCI6bnVsbCwiZGVwdCI6Ilx1NTQwZVx1N2FlZlx1NzgxNFx1NTNkMSIsInVzZXJfaWQiOjEyMzEyLCJhdmF0YXIiOiJodHRwczovL2ludGVybmFsLnl6Y2RuLmNuL3lvdXJlbi8yMDE4LzAzLzA5LzliZjdhMDFkLTExNmUtNDk0MS05YjgyLThhYzliZTFjYmZiOC5qcGciLCJ0aW1lc3RhbXAiOjE2NDY2MjU4NTgsImtleSI6Imxhb2xpYW5nbGlhbmciLCJpc19hZG1pbiI6ZmFsc2V9.mO6h_6mdPOekXqF8W0LiOWJC8sdZdd1ioFGDcUYi_5c";
    // dubbo调用的cookie https://funeng.qima-inc.com/
    public static String cookie = "KDTSESSIONID=YZ953072776101126144YZqY6TRqdU;TSID=23636c9d61ca43ccb27ecf84fa0066df";
    // https://shopcenter-console.prod.qima-inc.com/#/shopDetail 从这里获得
    public static String shopCookie = "yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; dfp=20be9c839e764ace476c3257bac472e3; _ga=GA1.2.2119578531.1630485217; shopcenter-console.sid=DlPd5Yj0C0l6UxgIT1qijY6yiZ65MoBcrdKhJsO5sPv1PefKl+q8BvWaMhJtkocGv/KAYV5CS8B0QT+jXJQfaOJNrqBKBulroOCW2HK07OslLlq4mV0T3TTngvmM2TlJZMO7dKYt5oU04wyXT5VPcaq8mPqK9Oga7klBx9/MR2bEQhpD41X32aYvsO3m+p6l/xp1T76K0dLUY5SpiBKS/A==; shopcenter-console.sid.sig=sKiQyO5nnONxH1KxcJq7uQAtwJo; loc_dfp=8c81c208b0fb0cd9feb6e5b04c170a1a; cas=dc103d40e672977703683a53c620dc28bf832abf33ba6092d1fe6cbe2e901b8c98; KDTSESSIONID=YZ945686221825343488YZIPmYqQkn; cas_username=laoliangliang; access_user=12312_1; TSID=7b0005be38914583820761866313a5df; yz_log_seqn=24/KAYV5CS8B0QT+jXJQfaOJNrqBKBulroOCW2HK07OslLlq4mV0T3TTngvmM2TlJZMO7dKYt5oU04wyXT5VPcaq8mPqK9Oga7klBx9/MR2bEQhpD41X32aYvsO3m+p6l/xp1T76K0dLUY5SpiBKS/A==; shopcenter-console.sid.sig=sKiQyO5nnONxH1KxcJq7uQAtwJo";

    public static String getKdtSessionId = "curl -k -i --raw -o 0.dat \"{url}\" -H \"Host: funeng.qima-inc.com\" -H \"Connection: keep-alive\" -H \"Upgrade-Insecure-Requests: 1\" -H \"User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36\" -H \"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\" -H \"Sec-Fetch-Site: cross-site\" -H \"Sec-Fetch-Mode: navigate\" -H \"Sec-Fetch-User: ?1\" -H \"Sec-Fetch-Dest: document\" -H \"sec-ch-ua: \\\" Not;A Brand\\\";v=\\\"99\\\", \\\"Google Chrome\\\";v=\\\"97\\\", \\\"Chromium\\\";v=\\\"97\\\"\" -H \"sec-ch-ua-mobile: ?0\" -H \"sec-ch-ua-platform: \\\"macOS\\\"\" -H \"Accept-Encoding: gzip, deflate, br\" -H \"Accept-Language: zh-CN,zh;q=0.9\" -H \"Cookie: loc_dfp=8c81c208b0fb0cd9feb6e5b04c170a1a; dfp=a51c99997810fff26b34f9dc26c7a8ef; TSID={TSID}; yz_log_ftime=1646210219364; yz_log_uuid=40b2da09-dccb-654b-d344-4ba979323f15; yz_log_seqb=1646223712470; yz_log_seqn=5; cas_username=laoliangliang; access_user=12312_1; cas={cas}\"";
    public static String errorTraceIdUrl = "curl 'https://ops.qima-inc.com/v3/skynet/log/search/search' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'Content-Type: application/json;charset=UTF-8' \\\n" +
            "  -H 'Accept: application/json, text/plain, */*' \\\n" +
            "  -H 'X-yz-bu: main' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36' \\\n" +
            "  -H 'X-yz-env: prod' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/skynet/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            " -H 'Cookie: _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1639054622%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.405.1639055523.1639054622.; buId=1; authority=user; is_admin=false; username=laoliangliang; loc_dfp=bc6285dcb1dd51f78b77803ed6899a96; cas_username=laoliangliang; access_user=12312_1; cas=e5e34fbb8178eb1d11444c41cbbdce2fd5f763d81ec716b9b80206c7d09b9090131; yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; KDTSESSIONID=YZ925491478631493632YZyjUpPAl3; OPS_JWT_TOKEN=" + authorization + "; TSID=7b0005be38914583820761866313a5df; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-gateway,bifrost-youzan-oauth,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; yz_log_seqb=1641054457700; yz_log_seqn=11' \\\n" +
            "  --data-raw '{\"app\":\"{appName}\",\"timestampBeginMs\":{startTime},\"timestampEndMs\":{endTime},\"queryString\":\"{queryString}\",\"level\":\"{level}\",\"tagConditions\":[{traceId}],\"direction\":\"{order}\",\"after\":{after},\"limit\":{limit}}' \\\n" +
            "  --compressed";

    public static String skip = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons/nsq/channel/ack_msg' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/applications/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; buId=1; loc_dfp=590b481074bb30db5d6cd6fd60e553fd; dfp=a37bbbc98d2703399be89b636546acd1; cas=d1836150df3742f548f5bb9f5919817894536de2583a1255cc8a4747054cee5831; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; OPS_JWT_TOKEN=" + authorization + "; RontgenEnv=prod; yz_log_seqb=1637227051456; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1637227209%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.320.1637227536.1637227209.; yz_log_seqn=31' \\\n" +
            "  --data-raw '{\"internal_id\":\"1125899936304525\",\"region\":\"bd\",\"app_addon_id\":159617}' \\\n" +
            "  --compressed";
    public static String skipNsqUrl = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons/nsq/channel/ack_msg' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/applications/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; buId=1; loc_dfp=590b481074bb30db5d6cd6fd60e553fd; dfp=a37bbbc98d2703399be89b636546acd1; cas=d1836150df3742f548f5bb9f5919817894536de2583a1255cc8a4747054cee5831; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; OPS_JWT_TOKEN=" + authorization + "; RontgenEnv=prod; yz_log_seqb=1637227051456; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1637227209%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.320.1637227536.1637227209.; yz_log_seqn=31' \\\n" +
            "  --data-raw '{\"internal_id\":\"{0}\",\"region\":\"{1}\",\"app_addon_id\":{appAddonId}}' \\\n" +
            "  --compressed";
    public static String reStartService = "curl 'https://ops.qima-inc.com/api/v3.0/cd_platform/api/v1/project/{envCode}/app/batch-deploy' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Content-Type: application/json;charset=UTF-8' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; buId=1; loc_dfp=590b481074bb30db5d6cd6fd60e553fd; dfp=a37bbbc98d2703399be89b636546acd1; cas=d1836150df3742f548f5bb9f5919817894536de2583a1255cc8a4747054cee5831; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; OPS_JWT_TOKEN=" + authorization + "; RontgenEnv=prod; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1637242120%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.321.1637242120.1637242120.; _pk_ses.1.9bec=*; yz_log_seqn=1' \\\n" +
            "  --data-raw '{\"apps\":[{\"deploy_type\":1,\"commit\":\"{commit}\",\"app_name\":\"{appName}\",\"debug\":0,\"standard_env\":\"qa\",\"hotswap_enable\":1,\"id\":{appId}}]}' \\\n" +
            "  --compressed";

    public static String generalPhoneNum = "curl 'https://api.uutool.cn/phone/generate_batch' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: enote_app/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/x-www-form-urlencoded; charset=UTF-8' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://uutool.cn' \\\n" +
            "  -H 'Sec-Fetch-Site: same-site' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://uutool.cn/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  --data-raw 'phone_num=20&area=&segment=' \\\n" +
            "  --compressed";

    public static String kvdsOldReadUrl = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons/kvds/exec_kv_cmd?addon_id=32871&cmd=GET&kv_key=youzan%3Aowl-contract_asset_origin%3A{assetNo}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Authorization: Bearer xx" + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.93 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/applications/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; loc_dfp=ea87c3ff736bc67c481261a23b621e00; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; cas=bcf2fad885f482f41558348628919675a42bf0288d046903ed5c669719c6059f483; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1639054622%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.405.1639055523.1639054622.; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; buId=1; buName=youzan; RontgenEnv=prod; OPS_JWT_TOKEN=" + authorization + "; yz_log_seqb=1639567769342; yz_log_seqn=26' \\\n" +
            "  --compressed";

    public static String kvdsReadUrl = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons/kvds/exec_kv_cmd?addon_id=31660&cmd=GET&kv_key=youzan%3Aowl-contract_asset_origin%3A{assetNo}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: application/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/applications/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; iamp.sid=hI9dyq0WvKZaOEVn5fD0daWR6hLs8oeja+3Mrw/o+znlBVTB41JeIAv5X4dlmE5uOvS0qEBuDX8zFpcTK4cEwwqg2iZThxrIRflzA5i3/PrJG2K6PSn5mTv3mA/eJVxGFS0WNubn+uBUou7siFxh8/h0kD6YTy6iifMLPkZCJHrAGP255kvcpatW4je6jKVPxTriWRM1joItRNPXKSEUGw==; loc_dfp=978f3b86e8621359938d1249a8e78007; dfp=76e75f99774fdf85f278cec5897d0b32; cas=1eb6e2fdfb07519c16ce9104a189ebe8e47f47f9ff9cfadfbec834369f5ea1a3812; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; RontgenEnv=qa; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636605781%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.285.1636605886.1636605781.; yz_log_seqn=1' \\\n" +
            "  --compressed";

    public static String appNameList = "curl 'https://ops.qima-inc.com/api/v1.0/opsproject/api/v2.0/projects/{envCode}/apps?standard_env={env}&page=1&per_page=100&filter_option=all' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; yz_log_seqb=1636808208571; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636808398%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.296.1636808398.1636808398.; _pk_ses.1.9bec=*; yz_log_seqn=44' \\\n" +
            "  --compressed";

    public static String appNamePreList = "curl 'https://ops.qima-inc.com/api/v1.0/opsproject/api/v2.0/projects/{envCode}/apps?standard_env={env}&new_pre=1&filter_option=all&page=1&per_page=100' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; loc_dfp=ea87c3ff736bc67c481261a23b621e00; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; RontgenEnv=prod; yz_log_seqb=1638373867762; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1638374057%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.365.1638374058.1638374057.; yz_log_seqn=28' \\\n" +
            "  --compressed";

    public static String recentlyCommit = "curl 'https://ops.qima-inc.com/api/v1.0/opsproject/api/v1.0/app/commits?repo={gitRepo}&branch={branch}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; yz_log_seqb=1636808208571; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636808398%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.296.1636808398.1636808398.; _pk_ses.1.9bec=*; yz_log_seqn=41' \\\n" +
            "  --compressed";

    public static String masterDiff = "curl 'https://ops.qima-inc.com/api/v1.0/opsproject/api/v2.0/projects/{envCode}/apps/{appName}/commit-master-diff' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Content-Type: application/json;charset=UTF-8' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; buId=1; buName=youzan; OPS_JWT_TOKEN=" + authorization + "; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636946093%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; RontgenEnv=qa; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.300.1636946174.1636946093.; yz_log_seqn=1' \\\n" +
            "  --data-raw '{}' \\\n" +
            "  --compressed";

    public static String commitList = "curl 'https://ops.qima-inc.com/api/v1.0/ops/application/commits?repo={gitRepo}&branch={branch}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636888371%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; yz_log_seqb=1636892241786; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.297.1636892622.1636888371.; yz_log_seqn=33' \\\n" +
            "  --compressed";

    public static String pkgApp = "curl 'https://ops.qima-inc.com/api/v1.0/pkg/api/v1.0/jar_pkgs/' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636808398%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.296.1636808398.1636808398.; yz_log_seqb=1636888125939; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; yz_log_seqn=21' \\\n" +
            "  --data-raw '{\"release_reason\":\"{reason}\",\"branch\":\"{branch}\",\"commit\":\"{commit}\",\"group\":\"{group}\",\"version\":\"{version}\",\"packaging\":\"{packaging}\",\"dependency\":\"\",\"boot_type\":3,\"jar_pkg_config_id\":\"{pkgId}\"}' \\\n" +
            "  --compressed";

    public static String pkgPkName = "curl 'https://ops.qima-inc.com/api/v1.0/pkg/api/v1.0/jar_pkg_configs/{pkgId}/' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; yz_log_seqb=1636888125939; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636888371%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.297.1636889638.1636888371.; yz_log_seqn=46' \\\n" +
            "  --compressed";
    public static String gitGroupVersion = "curl 'https://ops.qima-inc.com/api/v1.0/pkg/api/v1.0/jar_pkgs/group_version/?repo={repo}&file_path={api}&ref={commit}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; yz_log_seqb=1636888125939; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636888371%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.297.1636889143.1636888371.; yz_log_seqn=39' \\\n" +
            "  --compressed";

    public static String pkgResponse = "curl 'https://ops.qima-inc.com/api/v1.0/pkg/api/v1.0/jar_pkgs/{pkgRepId}/' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636808398%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.296.1636808398.1636808398.; yz_log_seqb=1636888125939; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; yz_log_seqn=22' \\\n" +
            "  --compressed";
    // -----
    public static String traceLogList = "curl 'https://ops.qima-inc.com/api/v1.0/rontgen/v2/span/spans:search' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'RontgenEnv: {env}' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'buId: 1' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636888371%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; yz_log_seqn=1; buId=1; RontgenEnv=prod; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.297.1636894469.1636888371.' \\\n" +
            "  --data-raw '{\"tagConditions\":{tag},\"appName\":\"\",\"operationName\":\"{search}\",\"minStartTimeNano\":\"{startTime}\",\"maxStartTimeNano\":\"{endTime}\",\"limit\":15,\"offset\":0}' \\\n" +
            "  --compressed";

    public static String analysisTraceUrl = "curl 'https://ops.qima-inc.com/api/v1.0/rontgen/v2/span/span_trees/{traceId}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'Bearer " + authorization + "' \\\n" +
            "  -H 'RontgenEnv: {env}' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'buId: 1' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _rdt_uuid=1630485218520.c81d8406-af4d-49f7-aef2-d18244a34c9d; KDTSESSIONID=YZ899969329471492096YZHGfCDhPU; TSID=0bd1fc32467e4c188f709b5c1770a201; loc_dfp=632195c820b95594409c4da5887d48cd; dfp=88ebc0bd727ae9924138602031d6efc6; cas=47f28b7a2629d811d4de4f74aee646b9048d14fe55b7dd1b5b9daccab41dbd4e689; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1636888371%2C%22https%3A%2F%2Fflow.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; buId=1; RontgenEnv=prod; yz_log_seqb=1636895428307; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.297.1636895453.1636888371.; yz_log_seqn=5' \\\n" +
            "  --compressed";
    //---
    public static String nsqConsumeTopic = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons/nsq-topics/{addonId}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/applications/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; cas=9f75281cab1184d83789e99d700c91568285ffc25bd26df07bd8f0b68a135b78673; loc_dfp=ea87c3ff736bc67c481261a23b621e00; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1638272246%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.357.1638272257.1638272246.; yz_log_seqb=1638273004006; yz_log_seqn=3' \\\n" +
            "  --compressed";
    public static String nsqConsumeChannel = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons/nsq-channels/{addonId}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/applications/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; cas=9f75281cab1184d83789e99d700c91568285ffc25bd26df07bd8f0b68a135b78673; loc_dfp=ea87c3ff736bc67c481261a23b621e00; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1638275094%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.358.1638275191.1638275094.; yz_log_seqb=1638275824530; yz_log_seqn=6' \\\n" +
            "  --compressed";

    public static String nsqList = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons?category={category}&app_name={appName}&region=&zone={env}&per_page=9999&bu_id=1' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/javascript, */*; q=0.01' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/applications/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; cas=9f75281cab1184d83789e99d700c91568285ffc25bd26df07bd8f0b68a135b78673; loc_dfp=ea87c3ff736bc67c481261a23b621e00; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1638275094%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.358.1638275191.1638275094.; yz_log_seqb=1638275824530; yz_log_seqn=4' \\\n" +
            "  --compressed";

    // ---pre
    String str = "curl 'https://ops.qima-inc.com/api/v3.0/cd_platform/api/v1/project/53839/app/batch-deploy' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Content-Type: application/json;charset=UTF-8' \\\n" +
            "  -H 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imxhb2xpYW5nbGlhbmciLCJncm91cCI6bnVsbCwiZGVwdCI6Ilx1NTQwZVx1N2FlZlx1NzgxNFx1NTNkMSIsInVzZXJfaWQiOjEyMzEyLCJhdmF0YXIiOiJodHRwczovL2ludGVybmFsLnl6Y2RuLmNuL3lvdXJlbi8yMDE4LzAzLzA5LzliZjdhMDFkLTExNmUtNDk0MS05YjgyLThhYzliZTFjYmZiOC5qcGciLCJ0aW1lc3RhbXAiOjE2NDY2MjU4NTgsImtleSI6Imxhb2xpYW5nbGlhbmciLCJpc19hZG1pbiI6ZmFsc2V9.mO6h_6mdPOekXqF8W0LiOWJC8sdZdd1ioFGDcUYi_5c' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1639054622%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.405.1639055523.1639054622.; yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; _ga=GA1.2.2119578531.1630485217; TSID=7b0005be38914583820761866313a5df; loc_dfp=1dba5ac63c25ec28126b3504923d7eb0; dfp=642784f573e4d1197ed7edcb5b9928b3; cas=4c6d8b693d33f9307285c09f648b803c03708d3c3779fa4d863ebd51c4c41ef3373; XIAOLV_SESSION_ID_prod=OVIF392Xce6AD663vOawjrYJVmBNNJjhXgyYpqon; KDTSESSIONID=YZ947872048499752960YZS6FVbCvo; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imxhb2xpYW5nbGlhbmciLCJncm91cCI6bnVsbCwiZGVwdCI6Ilx1NTQwZVx1N2FlZlx1NzgxNFx1NTNkMSIsInVzZXJfaWQiOjEyMzEyLCJhdmF0YXIiOiJodHRwczovL2ludGVybmFsLnl6Y2RuLmNuL3lvdXJlbi8yMDE4LzAzLzA5LzliZjdhMDFkLTExNmUtNDk0MS05YjgyLThhYzliZTFjYmZiOC5qcGciLCJ0aW1lc3RhbXAiOjE2NDY2MjU4NTgsImtleSI6Imxhb2xpYW5nbGlhbmciLCJpc19hZG1pbiI6ZmFsc2V9.mO6h_6mdPOekXqF8W0LiOWJC8sdZdd1ioFGDcUYi_5c; buId=1; buName=youzan; yz_log_seqb=1646104735759; yz_log_seqn=73' \\\n" +
            "  --data-raw '{\"new_pre\":1,\"standard_env\":\"pre\",\"apps\":[{\"app_name\":\"ebiz-owl\",\"branch\":\"feature/edu_suspension_task\",\"standard_env\":\"pre\",\"reason\":null,\"commit\":\"2dc41800\"}]}' \\\n" +
            "  --compressed";
    public static String restartPre = "curl 'https://ops.qima-inc.com/api/v3.0/cd_platform/api/v1/project/{envCode}/app/batch-deploy' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Content-Type: application/json;charset=UTF-8' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; loc_dfp=ea87c3ff736bc67c481261a23b621e00; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy; RontgenEnv=prod; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1638374057%2C%22https%3A%2F%2Fcas.qima-inc.com%2F%22%5D; _pk_ses.1.9bec=*; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.365.1638374058.1638374057.; yz_log_seqn=1' \\\n" +
            "  --data-raw '{requestBody}' \\\n" +
            "  --compressed";

    public static String preAppStatus = "curl 'https://ops.qima-inc.com/api/v1.0/opsproject/api/v2.0/project/{envCode}/aggregation-app-deploy-record?standard_env=pre&app_name={appName}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; loc_dfp=ea87c3ff736bc67c481261a23b621e00; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; cas=ea886921d3d4bc9fb1e064bca4f2e726adbada399a16b3efbd864b3a424a9d49948; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; buId=1; buName=youzan; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1638414781%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.368.1638414994.1638414781.; yz_log_seqb=1638419824414; yz_log_seqn=1' \\\n" +
            "  --compressed";

    // es

    public static String esAssetQuery = "curl 'https://data.qima-inc.com/garden-api-request/search/api/search' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/plain, */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.93 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://data.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://data.qima-inc.com/search/structsearch' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; dfp=478ee3a27f99cdf0718b19eb0255bfff; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ913999213575446528YZPpUUA3jK; garden-front-prod.sid=d3ImvQqFUrnqS6ugfkp4hFrLzKdQR2wqZ1+gdhefrNQ8liNYL4OQJ75Hd5ELCRUFsoqdhtPNuNQNJdvLlr7criUn4RpUT0bp1+rjZ7OkvTTFmy+dTETxZGnfFnttNT3Hsa5avM34+tAihh6a5s9yScotljsDz8Vj3SImlFOlOtxSc42CaYTmj19GG1csrIt4NIlgZJEe7ZOaVU7OaoOaWA==; garden-front-prod.sid.sig=w2uBMgjTnwT0t0S1k-xKjjV0SXY; dpToken=fZK+rkLS1k9RRNIkGfdUs3fq6QUpyJhhBh2jm2HtwqiSnPac86Gn7xZ/8QbSpUBb+xpIpeHAH2ImmXqr3n7rlw==; dpToken.sig=55k2efGxR4z4IaEMcZ4_gVRykZQ; token=fZK+rkLS1k9RRNIkGfdUs3fq6QUpyJhhBh2jm2HtwqiSnPac86Gn7xZ/8QbSpUBb+xpIpeHAH2ImmXqr3n7rlw==; token.sig=kTJLMwD7t645VOy_pYlrHKCDHKs; cas_username=laoliangliang; access_user=12312_1; iamp.sid=hI9dyq0WvKZaOEVn5fD0daWR6hLs8oeja+3Mrw/o+znlBVTB41JeIAv5X4dlmE5uOvS0qEBuDX8zFpcTK4cEwwqg2iZThxrIRflzA5i3/PrJG2K6PSn5mTv3mA/eJVxGFS0WNubn+uBUou7siFxh8/h0kD6YTy6iifMLPkZCJHrAGP255kvcpatW4je6jKVPxTriWRM1joItRNPXKSEUGw==; iamp-qa.sid=ISwAEbHDp3k+ej/UQydlGvOsp8PMs5MYgGwO2f5EqvibxFq+iVrYfa/5A0MdU8ualZAXQ83/DIvzX6cHajrTCI581eIcXQxAGxiGjBBf8O5bcc6c0+BpizjuXLIlaEFpke8rJBFn08VZSOC+Fs+jSKxpLyA7In0NEsE4tAzI60HyPhWFDpsxO+jP7ij4diQ81Q0uXCnnsVxgk6wLS91MxA==; loc_dfp=bb585e9144bf50c0e4e5ef8ef9d3a90f; cas=f9d961c2fe5e57e02f5c96a9e2694d8536fefca23ab6fdbc6fc29d7eab14b9ad661; yz_log_seqn=68; yz_log_seqb=1639659917298; yz_log_seqn=69' \\\n" +
            "  --data-raw '{query}' \\\n" +
            "  --compressed";
    public static String esQuery = "curl 'https://data.qima-inc.com/garden-api-request/search/api/search' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json, text/plain, */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://data.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://data.qima-inc.com/search/structsearch' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: loc_dfp=bc6285dcb1dd51f78b77803ed6899a96; yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; KDTSESSIONID=YZ925491478631493632YZyjUpPAl3; TSID=7b0005be38914583820761866313a5df; iamp-qa.sid=ISwAEbHDp3k+ej/UQydlGvOsp8PMs5MYgGwO2f5EqvibxFq+iVrYfa/5A0MdU8ualZAXQ83/DIvzX6cHajrTCI581eIcXQxAGxiGjBBf8O5bcc6c0+BpizjuXLIlaEFpke8rJBFn08VZSOC+Fs+jSKxpLyA7In0NEsE4tAzI60HyPhWFDpsxO+jP7ij4diQ81Q0uXCnnsVxgk6wLS91MxA==; iamp.sid=hI9dyq0WvKZaOEVn5fD0daWR6hLs8oeja+3Mrw/o+znlBVTB41JeIAv5X4dlmE5uOvS0qEBuDX8zFpcTK4cEwwqg2iZThxrIRflzA5i3/PrJG2K6PSn5mTv3mA/eJVxGFS0WNubn+uBUou7siFxh8/h0kD6YTy6iifMLPkZCJHrAGP255kvcpatW4je6jKVPxTriWRM1joItRNPXKSEUGw==; garden-front-prod.sid=d3ImvQqFUrnqS6ugfkp4hFrLzKdQR2wqZ1+gdhefrNQ8liNYL4OQJ75Hd5ELCRUFsoqdhtPNuNQNJdvLlr7criUn4RpUT0bp1+rjZ7OkvTTFmy+dTETxZGnfFnttNT3Hsa5avM34+tAihh6a5s9yScotljsDz8Vj3SImlFOlOtxSc42CaYTmj19GG1csrIt4NIlgZJEe7ZOaVU7OaoOaWA==; garden-front-prod.sid.sig=w2uBMgjTnwT0t0S1k-xKjjV0SXY; dpToken=fZK+rkLS1k9RRNIkGfdUs3fq6QUpyJhhBh2jm2HtwqiSnPac86Gn7xZ/8QbSpUBb+xpIpeHAH2ImmXqr3n7rlw==; dpToken.sig=55k2efGxR4z4IaEMcZ4_gVRykZQ; token=fZK+rkLS1k9RRNIkGfdUs3fq6QUpyJhhBh2jm2HtwqiSnPac86Gn7xZ/8QbSpUBb+xpIpeHAH2ImmXqr3n7rlw==; token.sig=kTJLMwD7t645VOy_pYlrHKCDHKs; cas=af5b29655d246f9f1a2a26689dd3d7f4a03c9339feefc76236df295ff324342d119; cas_username=laoliangliang; access_user=12312_1; yz_log_seqb=1641366001659; yz_log_seqn=11' \\\n" +
            "  --data-raw '{\"indexName\":\"{indexName}\",\"esQuery\":\"{\\\"query\\\":{\\\"bool\\\":{\\\"should\\\":[],\\\"must\\\":[],\\\"must_not\\\":[],\\\"filter\\\":[{\\\"term\\\":{\\\"kdt_id\\\":\\\"{kdtId}\\\"}},{\\\"term\\\":{\\\"is_deleted\\\":\\\"0\\\"}}]}},\\\"from\\\":0,\\\"size\\\":1,\\\"sort\\\":[]}\"}' \\\n" +
            "  --compressed";

    public static String getAppId = "curl 'https://ops.qima-inc.com/api/v1.0/search/suggest/?q={appName}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=c332fecb-cfce-6c35-5499-76f9f522fdd2; yz_log_ftime=1628822653089; _ga=GA1.2.2119578531.1630485217; _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1639054622%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.405.1639055523.1639054622.; dfp=c3e098843ad198fb50988b7dec2b340a; loc_dfp=bc6285dcb1dd51f78b77803ed6899a96; cas=3bfd14e8d70533b9bac44890d57a53dd4c0812148629f5842f66c542f1eeb53a842; buId=1; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=" + authorization + "; KDTSESSIONID=YZ925083587991330816YZa2BYUsuO; yz_log_seqn=1' \\\n" +
            "  --compressed";
    public static String getShop = "curl 'https://shopcenter-console.prod.qima-inc.com/shop/chain/descendent?kdtId={kdtId}&shopRoles=2&pageNum=1&pageSize=40' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'X-Requested-With: XMLHttpRequest' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://shopcenter-console.prod.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: " + shopCookie + "' \\\n" +
            "  --compressed";
    public static String getCpu = "curl 'https://ops.qima-inc.com/api/v1.0/skynet/app/{appName}/server_metric' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTIzMTIsImtleSI6Imxhb2xpYW5nbGlhbmciLCJhbGlhc25hbWUiOiLkuZDlpKkiLCJpc19hZG1pbiI6ZmFsc2UsIm1vYmlsZSI6IjE1MDY4NjEwNjE2IiwidGltZXN0YW1wIjoxNjQxODE0ODQ2LCJnZW5kZXIiOmZhbHNlLCJyZWFsbmFtZSI6IuWKs-aigeaigSIsImV4cCI6MTY0MjgxNDg0NSwidXNlcm5hbWUiOiJsYW9saWFuZ2xpYW5nIiwiZW1haWwiOiJsYW9saWFuZ2xpYW5nQHlvdXphbi5jb20iLCJ1c2VyX2lkIjoxMjMxMn0.Q4jQtTcXj04MAjbgMKB_97SMYt8Gmy6x_TOWrb4FQ9w' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1639054622%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.405.1639055523.1639054622.; loc_dfp=bc6285dcb1dd51f78b77803ed6899a96; yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; KDTSESSIONID=YZ925491478631493632YZyjUpPAl3; TSID=7b0005be38914583820761866313a5df; iamp-qa.sid=ISwAEbHDp3k+ej/UQydlGvOsp8PMs5MYgGwO2f5EqvibxFq+iVrYfa/5A0MdU8ualZAXQ83/DIvzX6cHajrTCI581eIcXQxAGxiGjBBf8O5bcc6c0+BpizjuXLIlaEFpke8rJBFn08VZSOC+Fs+jSKxpLyA7In0NEsE4tAzI60HyPhWFDpsxO+jP7ij4diQ81Q0uXCnnsVxgk6wLS91MxA==; iamp.sid=hI9dyq0WvKZaOEVn5fD0daWR6hLs8oeja+3Mrw/o+znlBVTB41JeIAv5X4dlmE5uOvS0qEBuDX8zFpcTK4cEwwqg2iZThxrIRflzA5i3/PrJG2K6PSn5mTv3mA/eJVxGFS0WNubn+uBUou7siFxh8/h0kD6YTy6iifMLPkZCJHrAGP255kvcpatW4je6jKVPxTriWRM1joItRNPXKSEUGw==; cas=af5b29655d246f9f1a2a26689dd3d7f4a03c9339feefc76236df295ff324342d119; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; buId=1; buName=youzan; OPS_JWT_TOKEN=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTIzMTIsImtleSI6Imxhb2xpYW5nbGlhbmciLCJhbGlhc25hbWUiOiLkuZDlpKkiLCJpc19hZG1pbiI6ZmFsc2UsIm1vYmlsZSI6IjE1MDY4NjEwNjE2IiwidGltZXN0YW1wIjoxNjQxODE0ODQ2LCJnZW5kZXIiOmZhbHNlLCJyZWFsbmFtZSI6IuWKs-aigeaigSIsImV4cCI6MTY0MjgxNDg0NSwidXNlcm5hbWUiOiJsYW9saWFuZ2xpYW5nIiwiZW1haWwiOiJsYW9saWFuZ2xpYW5nQHlvdXphbi5jb20iLCJ1c2VyX2lkIjoxMjMxMn0.Q4jQtTcXj04MAjbgMKB_97SMYt8Gmy6x_TOWrb4FQ9w; UnitWhiteList=java-demo,ump-manage,uic,ump-trade,sam,shop-prod,trade-rp,scrm-level,retail-scrm,shopcenter,scrm-behavior,retail-stock,retail-stock-scm,trade-invoice,ic,pay-gateway,scrm-api,retail-ump-calculation,shop-config,retail-pay,trade-plugin,retail-trade-cart,trade-dc,retail-shop,retail-ump,retail-trademanager,ump-asset,shop-center,scrm,yop,ump-deal,mall-trade-seller,marketing,retail-ofc-dispatcher,delivery,scrm-cmc,carmen-oauth,uic-user,yz-cardvoucher-biz,scrm-cmc-core,trade,scrm-credit,scrm-coc,trade-safeguard,trade-refund,retail-ofc,shop-configretail-scrm,price-center,cert,trade-detail,sc,retail-trade-core,trade-core,pay-gateway,pay-ucashier,ump-voucher-core,pay-assetcenter,pay-customer,bifrost-token-proxy,pay-gateway,pay-ucashier,pay-customer,pay-customercore,pay-merchant,pay-login,pay-assetcenter,pay-trading-core,pay-payment-core,pay-fund-channel,pay-acctrans,pay-microacctrans,pay-user,pay-usercore,pay-cashier,pay-cardvoucher,pay-cardvoucherop,pay-payment-recharge,bifrost-youzan-oauth,bifrost-youzan-gateway,paas-test-provider,paas-test-consumer,paas-test-node,yz7test-tool,bifrost-proxy,item-core; yz_log_seqb=1641818463629; yz_log_seqn=44' \\\n" +
            "  --data-raw '{\"env\":\"{env}\",\"region\":\"all\",\"view\":\"host\",\"start\":{startTime},\"end\":{endTime}}' \\\n" +
            "  --compressed";
    public static String getHqKdtId = "curl 'https://shopcenter-console.prod.qima-inc.com/shop/meta/{kdtId}' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'X-Requested-With: XMLHttpRequest' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://shopcenter-console.prod.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: " + shopCookie + "' \\\n" +
            "  --compressed";
    public static String getApolloWhite = "curl 'http://apollo-portal.prod.qima-inc.com/apps/owl-pc/envs/{env}/clusters/default/namespaces' \\\n" +
            "  -H 'Proxy-Connection: keep-alive' \\\n" +
            "  -H 'Accept: application/json, text/plain, */*' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'Referer: http://apollo-portal.prod.qima-inc.com/config.html' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: loc_dfp=bc6285dcb1dd51f78b77803ed6899a96; yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; KDTSESSIONID=YZ925491478631493632YZyjUpPAl3; TSID=7b0005be38914583820761866313a5df; cas=af5b29655d246f9f1a2a26689dd3d7f4a03c9339feefc76236df295ff324342d119; cas_username=laoliangliang; access_user=12312_1; yz_log_seqb=1641887543845; yz_log_seqn=65; APOLLO_USER_NAME={apolloUserName}' \\\n" +
            "  --compressed \\\n" +
            "  --insecure";

    public static String getSQL = "curl 'https://ops.qima-inc.com/api/v1.0/yuri/api/v1.0/addons/mysql/dispatch' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Content-Type: application/json;charset=UTF-8' \\\n" +
            "  -H 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imxhb2xpYW5nbGlhbmciLCJncm91cCI6bnVsbCwiZGVwdCI6Ilx1NTQwZVx1N2FlZlx1NzgxNFx1NTNkMSIsInVzZXJfaWQiOjEyMzEyLCJhdmF0YXIiOiJodHRwczovL2ludGVybmFsLnl6Y2RuLmNuL3lvdXJlbi8yMDE4LzAzLzA5LzliZjdhMDFkLTExNmUtNDk0MS05YjgyLThhYzliZTFjYmZiOC5qcGciLCJ0aW1lc3RhbXAiOjE2NDY2MjU4NTgsImtleSI6Imxhb2xpYW5nbGlhbmciLCJpc19hZG1pbiI6ZmFsc2V9.mO6h_6mdPOekXqF8W0LiOWJC8sdZdd1ioFGDcUYi_5c' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ops.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/rds/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1639054622%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.405.1639055523.1639054622.; yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; _ga=GA1.2.2119578531.1630485217; loc_dfp=1dba5ac63c25ec28126b3504923d7eb0; dfp=642784f573e4d1197ed7edcb5b9928b3; XIAOLV_SESSION_ID_prod=OVIF392Xce6AD663vOawjrYJVmBNNJjhXgyYpqon; cas=87368ece0b14e002aa17ba6bf13511a58b42405eaa900d67b29b5f194ccdbc59257; KDTSESSIONID=YZ948252166443155456YZsp4Cs9c8; TSID=929a0e16ef844934854bf4edab26bd92; cas_username=laoliangliang; access_user=12312_1; authority=user; is_admin=false; username=laoliangliang; OPS_JWT_TOKEN=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imxhb2xpYW5nbGlhbmciLCJncm91cCI6bnVsbCwiZGVwdCI6Ilx1NTQwZVx1N2FlZlx1NzgxNFx1NTNkMSIsInVzZXJfaWQiOjEyMzEyLCJhdmF0YXIiOiJodHRwczovL2ludGVybmFsLnl6Y2RuLmNuL3lvdXJlbi8yMDE4LzAzLzA5LzliZjdhMDFkLTExNmUtNDk0MS05YjgyLThhYzliZTFjYmZiOC5qcGciLCJ0aW1lc3RhbXAiOjE2NDY2MjU4NTgsImtleSI6Imxhb2xpYW5nbGlhbmciLCJpc19hZG1pbiI6ZmFsc2V9.mO6h_6mdPOekXqF8W0LiOWJC8sdZdd1ioFGDcUYi_5c; buId=1; buName=youzan; yz_log_seqn=1' \\\n" +
            "  --data-raw $'{\"bu_id\":1,\"rds_env\":\"{env}\",\"action\":\"dml.operateExec\",\"parms\":{\"schemaId\":{schemaId},\"dml\":\"{SQL}\",\"defaultLimit\":1,\"username\":\"laoliangliang\"}}' \\\n" +
            "  --compressed";
    public static String dubboInvoke = "curl 'https://ticket.qima-inc.com/api/v1/dubbo/invoke' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: application/json, text/plain, */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'X-Requested-With: XMLHttpRequest' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ticket.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ticket.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: " + cookie + "' \\\n" +
            "  --data-raw '{\"app\":\"wusuowei\",\"env\":\"{env}\",\"service\":\"{service}\",\"method\":\"{method}\",\"args\":{args},\"sc\":\"{sc}\",\"timeout\":10000,\"retries\":0}' \\\n" +
            "  --compressed";
    public static String dubboInvokeQa = "curl -XPOST -H 'Content-Type: application/json' -H \"X-Request-Protocol:dubbo\" -H 'X-Service-Chain:{\"name\":\"{sc}\"}' 'http://tether-qa.s.qima-inc.com:8680/soa/{service}/{method}' -d '{args}'";
    public static String esSqlSearch = "curl 'https://ticket.qima-inc.com/api/v1/es/search' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: application/json, text/plain, */*' \\\n" +
            "  -H 'Content-Type: application/x-www-form-urlencoded; charset=UTF-8' \\\n" +
            "  -H 'X-Requested-With: XMLHttpRequest' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ticket.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ticket.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: " + cookie + "' \\\n" +
            "  --data-raw $'sql={SQL}' \\\n" +
            "  --compressed";
    public static String getProjectId = "curl 'https://ops.qima-inc.com/api/v1.0/opsproject/api/v2.0/projects?page=1&per_page=10&angle=ALL&status=ALL&state=doing&keyword={keyword}&cd_type=ALL&sort_field=created_at&sort_order=desc&business_id=' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: application/json' \\\n" +
            "  -H 'Authorization: Bearer " + authorization + "' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ops.qima-inc.com/v3/cd/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: _pk_ref.1.9bec=%5B%22%22%2C%22%22%2C1639054622%2C%22https%3A%2F%2Fmuse-yzflow.qima-inc.com%2F%22%5D; _pk_id.1.9bec=43e7b6a920e3805e.1628822683.405.1639055523.1639054622.; yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; TSID=7b0005be38914583820761866313a5df; KDTSESSIONID=YZ933018543192649728YZ7ps7hIRd; buId=1; loc_dfp=8562849c8deea7dafec1637c2e3cad6b; dfp=a3fcdff16268a2292c18f14a4fd4338a; cas_username=laoliangliang; access_user=12312_1; cas=3c206fd123042e830372e955d859e2c364543384a90c21f0d18a09bcbeb3ae28404; OPS_JWT_TOKEN=" + authorization + "; yz_log_seqn=1' \\\n" +
            "  --compressed";
    public static String test = "https://cas.qima-inc.com/public/oauth/authorize?name=ops-apisix&qs=redirect_url:https%3A%2F%2Fops.qima-inc.com%2F%23%2Fpkg%2Fjar_pkg%2F1526%2Frelease%2F70286";
    public static String test2 = "https://ops.qima-inc.com/apisix/plugin/jwt/oauth-callback?code=aa3cb7e2-43e1-4165-a001-1d6026d3f065&qs=redirect_url%3Ahttps%3A%2F%2Fops.qima-inc.com%2F%23%2Fpkg%2Fjar_pkg%2F1526%2Frelease%2F70286";
    public static String testPost = "curl 'https://cas.qima-inc.com/public/oauth/authorize?name=ops-apisix&qs=redirect_url:https%3A%2F%2Fops.qima-inc.com%2F%23%2Fpkg%2Fjar_pkg%2F1526%2Frelease%2F70286'\\\n" +
            "  -H 'Host:cas.qima-inc.com'\\\n" +
            "  -H 'Connection:keep-alive'\\\n" +
            "  -H 'sec-ch-ua:\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"'\\\n" +
            "  -H 'sec-ch-ua-mobile:?0'\\\n" +
            "  -H 'sec-ch-ua-platform:\"macOS\"'\\\n" +
            "  -H 'Upgrade-Insecure-Requests:1'\\\n" +
            "  -H 'User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36'\\\n" +
            "  -H 'Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9'\\\n" +
            "  -H 'Sec-Fetch-Site:same-origin'\\\n" +
            "  -H 'Sec-Fetch-Mode:navigate'\\\n" +
            "  -H 'Sec-Fetch-User:?1'\\\n" +
            "  -H 'Sec-Fetch-Dest:document'\\\n" +
            "  -H 'Referer:https://cas.qima-inc.com/public/oauth?name=ops-apisix&qs=redirect_url:https%3A%2F%2Fops.qima-inc.com%2F%23%2Fpkg%2Fjar_pkg%2F1526%2Frelease%2F70286'\\\n" +
            "  -H 'Accept-Encoding:gzip, deflate, br'\\\n" +
            "  -H 'Accept-Language:zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4'\\\n" +
            "  -H 'Cookie:yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; KDTSESSIONID=YZ933018543192649728YZ7ps7hIRd; TSID=7b0005be38914583820761866313a5df; cas_username=laoliangliang; access_user=12312_1; loc_dfp=e1765ba79b30cbaaef9045b978bdfbaa; dfp=77b192e8f222353122d68921f29e4a8f; yz_log_seqn=1; cas=984a220fd260f10400624c74192faa04bae61141b84bf7c626f412b41c04db45627'\\\n" +
            "  -H 'Content-Length:0'\\\n" +
            "  -H 'Content-Type:text/plain'";

    public static String invokeDubboSc = "curl 'https://ticket.qima-inc.com/api/v1/dubbo/invoke' \\\n" +
            "  -H 'Connection: keep-alive' \\\n" +
            "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
            "  -H 'Accept: application/json, text/plain, */*' \\\n" +
            "  -H 'Content-Type: application/json' \\\n" +
            "  -H 'X-Requested-With: XMLHttpRequest' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'Origin: https://ticket.qima-inc.com' \\\n" +
            "  -H 'Sec-Fetch-Site: same-origin' \\\n" +
            "  -H 'Sec-Fetch-Mode: cors' \\\n" +
            "  -H 'Sec-Fetch-Dest: empty' \\\n" +
            "  -H 'Referer: https://ticket.qima-inc.com/' \\\n" +
            "  -H 'Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ja;q=0.6,fr;q=0.5,und;q=0.4' \\\n" +
            "  -H 'Cookie: yz_log_uuid=05b9ad8e-2c7f-4c21-a507-4a2593b7a7d7; yz_log_ftime=1640681190465; TSID=7b0005be38914583820761866313a5df; loc_dfp=4515093560645248bf0a2fcd2e380969; dfp=7b63cf15eb1438f8e2ceceee5c53bfcf; cas=42b0f931dbc3d5aef260e115f6db77bff39b65794c07bd44211b2193f22fceda819; KDTSESSIONID=YZ940546625903271936YZc6YLHWsF; XIAOLV_SESSION_ID_prod=7ov9jjPdZi-cnQO0Wx9q33WxxB9ehMTaLbhZ2PyS; cas_username=laoliangliang; access_user=12312_1; yz_log_seqn=6' \\\n" +
            "  --data-raw '{\"app\":\"owl-edu\",\"env\":\"pre\",\"service\":\"com.youzan.owl.edu.api.fix.FixFacade\",\"method\":\"fixStudentLessonRemove\",\"args\":[\"{param}\"],\"sc\":\"prj0046324\",\"timeout\":10000,\"retries\":0}' \\\n" +
            "  --compressed";

}
