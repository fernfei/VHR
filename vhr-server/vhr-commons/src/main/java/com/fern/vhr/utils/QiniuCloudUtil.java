package com.fern.vhr.utils;

import java.io.IOException;


import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import org.springframework.util.StringUtils;

/**
 * 七牛云上传文件工具类
 *
 * 具体使用方法请访问官方文档 https://developer.qiniu.com/kodo/sdk/1239/java#server-upload
 */
public class QiniuCloudUtil {

    // 设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = "CxUew58wvk7ftL1FMrpxJ4MKw8CtaGSVUD_V_kwG";
    private static final String SECRET_KEY = "js8xszUxUrfAF_irMCPzyWVzcrfuvDVOe3hIM6H0";

    // 要上传的空间
    private static final String bucketname = "fern-images";

    // 密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //图片地址
    private static final String RETURN_PATH="http://image.hi-hufei.com/";

    //默认不指定key的情况下，以文件内容的hash值作为文件名
    private static String key = null;


    // 普通上传
    public static String upload(String filePath) throws QiniuException {
            //构造一个带指定Region对象的配置类
            Configuration cfg = new Configuration(Region.region0());
            // 创建上传对象
            UploadManager uploadManager = new UploadManager(cfg);
            // 调用put方法上传
            String token = auth.uploadToken(bucketname);

            Response response = uploadManager.put(filePath, key, token);
            // 打印返回的信息
            //System.out.println(response.bodyString());
            MyPutRet myPutRet = response.jsonToObject(MyPutRet.class);
            //key是返回的图片名
            return RETURN_PATH + myPutRet.key;
    }

    class MyPutRet {
        public String key;
        public String hash;
        public String bucket;
        public long fsize;
    }

}
