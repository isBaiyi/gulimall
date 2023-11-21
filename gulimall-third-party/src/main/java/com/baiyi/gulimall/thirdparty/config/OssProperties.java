package com.baiyi.gulimall.thirdparty.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: oss配置信息
 * @author: liaozicai
 * @date: 2023/11/21 17:00
 */
@Data
@Component
public class OssProperties {

    /** oss bucket名称 */
    @Value("${spring.cloud.alicloud.oss.bucketname}")
    private String bucketName;

    /** oss公钥 */
    @Value("${spring.cloud.alicloud.access-key}")
    private String accessKey;

    /** oss上传节点地址*/
    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;
}
