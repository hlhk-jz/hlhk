package com.aspect.test;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

//声明这是一个切面
@Aspect
@Component
public class AspectDemo {
    //切点，使用注解表达式
    @Pointcut("@annotation(com.aspect.test.Files)")
    public void show(){}



    @Around("show()")
    public Object huanrao(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res = null;
        long time = System.currentTimeMillis();
        try {
            System.out.println("先执行的操作！");
            res = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                //方法执行完成后增加日志
                addOperationLog(joinPoint, res, time);
            } catch (Exception e) {
                System.out.println("LogAspect 操作失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //可以得到自定义注解中的属性，返回结果也可以得到可以在这里吧返回结果进行日志保存
    private void addOperationLog(ProceedingJoinPoint joinPoint, Object res, long time) {
        Files annotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Files.class);
        String biaoti = annotation.biaoti();
        System.out.println("标题 = "+biaoti);
        System.out.println("返回结果 = "+res);
    }
}

