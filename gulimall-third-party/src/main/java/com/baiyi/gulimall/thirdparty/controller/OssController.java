package com.baiyi.gulimall.thirdparty.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.baiyi.gulimall.common.utils.R;
import com.baiyi.gulimall.thirdparty.config.OssProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: oss控制器
 * @author: liaozicai
 * @date: 2023/11/21 16:59
 */
@RestController
@Slf4j
public class OssController {

    @Resource
    private OssProperties ossProperties;

    @Resource
    private OSSClient ossClient;

    @RequestMapping("/oss/policy")
    public R policy() {
        // 填写Host地址，格式为https://bucketname.endpoint。
        String host = "https://" + ossProperties.getBucketName() + "." + ossProperties.getEndpoint();
        String dirName = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        // 无需来进行/拼接，前端会自己做拼接操作
        String dir = dirName;

        Map<String, String> respMap = null;
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
            // 生成签名
            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            respMap = new LinkedHashMap<>();
            respMap.put("accessid", ossProperties.getAccessKey());
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
        } catch (Exception e) {
           log.error("oss进行服务端签名出现异常: {}", e.getMessage(), e);
        }
        return R.ok().put("data", respMap);
    }

}
