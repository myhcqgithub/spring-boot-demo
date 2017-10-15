package top.legend.configure;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Legend on 2017/10/14.
 */

@Component
@Aspect
@Order(2)
public class AuthAop {

    private final Logger logger=LoggerFactory.getLogger(getClass());



    @Pointcut("execution(* top.legend.controller..*.*(..))")
    public  void method(){

    }

    @Before("method()")
    public  void onBefore(JoinPoint point){
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String auth = request.getHeader("auth");

        logger.info("onBefore auth={}",auth);

//        throw new RuntimeException("error");
    }
}
