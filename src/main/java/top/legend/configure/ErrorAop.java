package top.legend.configure;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by Legend on 2017/10/15.
 */
@Aspect
@Component
public class ErrorAop {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Pointcut("execution(* top.legend.controller..*(*,org.springframework.validation.BindingResult))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public  void onBefore(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        if (args!=null&&args.length!=0) {
            BindingResult  result=null;
            for (Object arg : args) {
                if (arg instanceof BindingResult) {
                    result= (BindingResult) arg;
                    break;
                }
            }
            if (result!=null) {
                if (result.hasErrors()) {
                    logger.error("error message={}",result.getFieldError().getDefaultMessage());
                }
            }
        }
        logger.info("execution(* top.legend.controller.*(org.springframework.validation.BindingResult))");
    }
}
