package com.gyd.encrypt.v2;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyd.encrypt.annotation.MixedDecrypt;
import com.gyd.encrypt.annotation.MixedEncrypt;
import org.apache.tomcat.util.codec.binary.Base64;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

/**
 * AES + RSA 加解密AOP处理
 */
@Aspect
@Component
public class SafetyAspect {

    /**
     * Pointcut 切入点
     * 匹配
     */
    @Pointcut(value = "execution(public * com.gyd.controller..*.*(..))")
    public void safetyAspect() {}

    /**
     * 环绕通知
     */
    @Around(value = "safetyAspect()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            // request对象
            HttpServletRequest request = attributes.getRequest();
            // http请求方法  post get
            String httpMethod = request.getMethod().toLowerCase();
            // method方法
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();
            // method方法上面的注解
            Annotation[] annotations = method.getAnnotations();
            // 方法的形参参数
            Object[] args = pjp.getArgs();
            // 是否有@Decrypt
            boolean hasDecrypt = false;
            // 是否有@Encrypt
            boolean hasEncrypt = false;
            for (Annotation annotation : annotations) {
                hasDecrypt = annotation.annotationType() == MixedDecrypt.class;
                hasEncrypt = annotation.annotationType() == MixedEncrypt.class;
            }
            ObjectMapper mapper = new ObjectMapper();
            // jackson 序列化和反序列化 date处理
            mapper.setDateFormat( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            // 执行方法之前解密
            if (hasDecrypt) {
                // 此处填坑，后端是用如下的方式获取前端所传参数的，get请求没有问题，但post请求获取body参数时就涉及到request流只能读一次的问题，为了能获取到参数规定前端post请求时使用表单传参，有要求的可自行修改。
                // AES加密后的数据
                String dataTmp = request.getParameter("data");
                System.out.println("前端数据：["+dataTmp+"]");
                // 后端RSA公钥加密后的AES的key
                String aesKey = request.getParameter("aesKey");
                System.out.println("AES的加密key：["+aesKey+"]");
                // 后端私钥解密的到AES的key
                byte[] plaintext = RSAUtils.decryptByPrivateKey(Base64.decodeBase64(aesKey), RSAUtils.getPrivateKey());
                aesKey = new String(plaintext);
                System.out.println("解密出来的AES的key：["+aesKey+"]");

                // AES解密得到明文data数据
                String decrypt = AESUtilsV2.decrypt(dataTmp, aesKey);
                System.out.println("解密出来的data数据：["+decrypt+"]");

                // 设置到方法的形参中，目前只能设置只有一个参数的情况
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                if(args.length > 0){
                    args[0] = mapper.readValue(decrypt, args[0].getClass());
                }
            }
            // 执行并替换最新形参参数 method方法要public修饰的才能设置值
            Object o = pjp.proceed(args);

            // 返回结果之前加签名
            if (hasEncrypt) {
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                // 每次响应之前随机获取AES的key，加密data数据
                String key = AESUtilsV2.getKey();
                System.out.println("本次响应加密前AES key：["+key+"]");

                String dataString = mapper.writeValueAsString(o);
                System.out.println("需要加密的data数据：["+dataString+"]");

                String data = AESUtilsV2.encrypt(dataString, key);
                System.out.println("加密后的data数据：["+data+"]");

                //对key用私钥加密
                String keySignData = RSAUtils.encryptByPrivateKey(key.getBytes(),RSAUtils.getPrivateKey());
                System.out.println("加密后的AES密钥数据：["+keySignData+"]");
//                // 对key 用私钥加签
//                String sign = RSAUtils.sign(key.getBytes(), RSAUtils.getPrivateKey());
//                // 转json字符串并转成Object对象，并赋值给返回值o
//                System.out.println("加签后的签名数据：["+sign+"]");
                String json1 = "{\"data\":\""+data+"\",\"aesKey\":\""+key+"\",\"keySignData\":\""+keySignData+"\"}";
                Object ob = mapper.readValue(json1, Object.class);
                o = ResultWrapper.SUCCESS(ob);
            }
            return o;
        } catch (Throwable e) {
            System.out.println("error:"+e.getMessage());
            // ResultWrapper为后端统一返回类
            return ResultWrapper.FAILURE(e.getMessage());
        }
    }
}
