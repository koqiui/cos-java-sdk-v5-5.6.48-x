package com.qcloud.cos.demo.ci;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ciModel.auditing.TextAuditingRequest;
import com.qcloud.cos.model.ciModel.auditing.TextAuditingResponse;

/**
 * 内容审核 文本审核接口相关demo 详情见https://cloud.tencent.com/document/product/436/56289
 */
public class TextAuditingJobDemo {

    public static void main(String[] args) {
        // 1 初始化用户身份信息（secretId, secretKey）。
        COSClient client = ClientUtils.getTestClient();
        // 2 调用要使用的方法。
        describeAuditingTextJob(client);
    }

    /**
     * createAuditingTextJobs 接口用于创建文本审核任务。
     */
    public static void createAuditingTextJobs(COSClient client) {
        //1.创建任务请求对象
        TextAuditingRequest request = new TextAuditingRequest();
        //2.添加请求参数 参数详情请见api接口文档
        request.setBucketName("demo-123456789");
        //2.1设置对象地址
        request.getInput().setObject("1.txt");
        //2.2设置审核类型参数
        request.getConf().setDetectType("Porn,Terrorism,Politics,Ads");
        //2.3设置审核模板（可选）
        request.getConf().setBizType("aa3e9d84a6a079556b0109a935c*****");
        //3.调用接口,获取任务响应对象
        TextAuditingResponse response = client.createAuditingTextJobs(request);
        System.out.println(response);
    }

    /**
     * DescribeAuditingJob 接口用于查询文本审核任务。
     *
     * @param client
     */
    public static void describeAuditingTextJob(COSClient client) {
        //1.创建任务请求对象
        TextAuditingRequest request = new TextAuditingRequest();
        //2.添加请求参数 参数详情请见api接口文档
        request.setBucketName("demo-123456789");
        request.setJobId("st84cee320df1c11eb8441525400*****");
        //3.调用接口,获取任务响应对象
        TextAuditingResponse response = client.describeAuditingTextJob(request);
    }
}
