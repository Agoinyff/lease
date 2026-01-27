package com.lease.webapp.service.serviceimpl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.lease.webapp.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private Client client;

    @Override
    public void sendCode(String phone, String code) {
        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setPhoneNumbers(phone);
        sendSmsRequest.setSignName("速通互联验证码");
        sendSmsRequest.setTemplateCode("100001");
        sendSmsRequest.setTemplateParam("{\"code\":\"" + code + "\"}");

        try {
            SendSmsResponse response = client.sendSms(sendSmsRequest);
            // 打印返回结果，便于调试
            System.out.println("========== 阿里云短信发送结果 ==========");
            System.out.println("Code: " + response.getBody().getCode());
            System.out.println("Message: " + response.getBody().getMessage());
            System.out.println("RequestId: " + response.getBody().getRequestId());
            System.out.println("BizId: " + response.getBody().getBizId());

            if (!"OK".equals(response.getBody().getCode())) {
                throw new RuntimeException("短信发送失败: " + response.getBody().getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
