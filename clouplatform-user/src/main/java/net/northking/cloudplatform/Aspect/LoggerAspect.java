package net.northking.cloudplatform.Aspect;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by laodeng on 2017/11/23.
 */
@Aspect //切片
@Component
public class LoggerAspect {

        //切入点
        //1.时间：@Before ， @After , @AfterThrowing ,@Around（包含了前面三种)
        //点：* net.northking.cloudtest.controller.*(..))
        @Around("execution(* net.northking.cloudplatform.controller.RoleController.*(..))")
        //增强方法
        //ProceedingJoinPoint:包含当前拦截的方法的信息的对象
        public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
            //调用的方法的参数的数组
            Object[] objs =  pjp.getArgs();

            //类：
            String classType = pjp.getTarget().getClass().getName();
            Class<?> clazz = Class.forName(classType);

            //方法名
            String name = pjp.getSignature().getName();

            Logger logger = LoggerFactory.getLogger(clazz);
            logger.info(name+"  start param:  "+ StringUtils.join(objs));

            //相当于过滤器的dofilter方法，去调用控制器中被拦截的方法
            Object object  = pjp.proceed();

            logger.info(name+"  end param:  "+object);

            return object;
        }
    }
