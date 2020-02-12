package com.myzg.gymnasium.aliplay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class aliplayConfig {
    /** 应用id **/
    private  final String APP_ID = "2016101700711409";

    /** 应用私钥 **/
    private  final String PRIVATE_KEY="MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCwPLuO9tZT2uW5AoM4P/q5d+2jBRPy6t2X8E7Z/0U5afNlcRaXrhANA4r4dc3qlearjpeiIv/Hxn2fkcFHiVshzOnDtSMqhDYNlfuk3CtcVMqXqBa1tZwBEZ9/i7rpg0aSrF+2+dR3t3Aadd/4E52YOebGCxT472dWHFrZGBj86ibd36Uv1JUX9FiiLvJQyJqcqi6KSBjvdzFUkr7W1iBIKlxaLIeXettkqKVLnstXSYb1QY+Wi4Moq3L32fNAb9WNefwdSpc7UEkSjfPromsDzFbYDpIPvuauUIxEcwuoFiHOHEHZ0VAi73JcmCiqVJ8fdytXwzCa43XbL0nYUqmXAgMBAAECggEBAIl8p7mNWYELmQFvM11TlE7Sf6IY2Qo+LedVgr5QhfmXbVlrEvv7v+vXIrhYdu8WSGD4GdVURoTcla5BsC4VuvGwgYG7Mxb9E4ofwrRHStB6GZ6cdDMH3g97ZxnCsWtwjULplLYTSqymf5807CgFbYGPUjiX9qGJau1jq4AHa58J368/l+R1lDPRwbuFcWZiY1WcYA8RvFE3SAcy0NS/nIxnq4OID7x6+DkLoRTssN9thF7fI2+HVmgYjAN0QqDQhTp0CkC2+pi8QkURQP0ITYOi4qWZfpHtdc486SZqnEzn3D1eBhD4atZXJT2s1SjRWh+t3N+kpru24xH+Y6rGpCECgYEA/p3P0sfejKER5SeNp3gYrNQQedSEfCgLCL14RlQ3YoW1i4eIO0mq7iOznK0Tj1dxnsukysY7f51M0BIRSU3l3DNVA/56/TYrZv2bPYtyNY37NIoGnlykbQl0bKJYiLYYp/KQFTAd/KQiSYjm+Bc7UUBxE53mHqimX37T6UH98OcCgYEAsTHj5MCCjNN8n4aC2CddjsxVCiZM84ht//1uGY6ZlmDcbxFDYOfWmk92rYljzd3knbMOSLvE90ZWI371+6nenpfFW/+9kHpYzqChL5ZN1A04hmZs1b6rdU3m/LOnn8YXfMP/Zs5KTWho2Tq1aqYu+bIuD9jmclOrYCvuO75ue9ECgYEA5B3HgHUJcr0sJz6UryHuGYm1aTF5sTK/EAmQpJH3PRHGYUgASf3qYokh9pEqIRaa+UZCUlngHKl1lEVbr21XLz3eQUHSNuI9aHx2hWFV5Z1bHus6ms8tkXMTF/ErmPBsjqvHYvRFKYB0J6W8KTHHNzihFo41CerXhF9AxI8XUKkCgYEAoEcQbIn1jIx/3Yw+LmbtKY2KHnQmhuKRHUyPmm5yXqOewJhM6grLAyl9n9r2e/CKKlscQI4Xy9PDdrgQqGMvCyUdT+oz/cutKLoDEphSLc0HpAphx7WAQcsFdO7MYKk99Y0UKFnQu9QFgvinwKAxPYr+Pzdiu2cTTRpvk3rdVQECgYEA5GA1x8gBvu8dNzBah6T9K4bpppwPkjIDzMA+KJhVO83iL3uN9Oea6N9mN+lRhwAkrAUfLYYnuT5LPq74puzNLHR5S6iiKc6uNadg7Wb0MIGCH5BQvQ0ptKWCwXKlP258a8ErMR7lKif3UFJ3k3HwXqq/k6cVGi0vgTn++Qlw01s=";

    /** 异步回调地址 **/
    private  final String NOTIFY_URL="";

    /** 网关 **/
    private  final String URL= "https://openapi.alipaydev.com/gateway.do";

    /** 编码 **/
    private  final String CHARSET="utf-8";

    /** 响应格式 **/
    private  final String FORMAT="json";

    /** 签名方式 **/
    private  final String SIGN_TYPE="RSA2";

    /** 应用公钥证书路径 **/
    private final String  APP_CERT_PATH = "/Users/mac/alipay/appCertPublicKey_2016101700711409.crt";

    /** 支付宝公钥证书路径 **/
    private final String  ALIPAY_CERT_PATH = "/Users/mac/alipay/alipayCertPublicKey_RSA2.crt";

    /** 支付宝根公钥证书路径 **/
    private final String  ALIPAY_ROOT_CERT_PATH = "/Users/mac/alipay/alipayRootCert.crt";

    @Bean
    public AlipayClient alipayClient() {
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setAppId(APP_ID);
        certAlipayRequest.setCharset(CHARSET);
        certAlipayRequest.setFormat(FORMAT);
        certAlipayRequest.setServerUrl(URL);
        certAlipayRequest.setPrivateKey(PRIVATE_KEY);
        certAlipayRequest.setAlipayPublicCertPath(ALIPAY_CERT_PATH);
        certAlipayRequest.setRootCertPath(ALIPAY_ROOT_CERT_PATH);
        certAlipayRequest.setCertPath(APP_CERT_PATH);
        certAlipayRequest.setSignType(SIGN_TYPE);
        DefaultAlipayClient client = null;
        try {
            client = new DefaultAlipayClient(certAlipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(client != null){
            return client;
        }
        throw new ProgramException(ErrorEnum.ALIPAY_CLIENT_ERROR);
    }

}
