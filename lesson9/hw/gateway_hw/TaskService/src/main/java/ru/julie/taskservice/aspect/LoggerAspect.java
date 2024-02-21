package ru.julie.taskservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Around("@annotation(ru.julie.taskservice.aspect.TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getClass().toString();
        Object [] args = joinPoint.getArgs();

        System.out.println("Пользователь вызвал метод: " +
                methodName + ", в классе: " + className);
        System.out.println("Аргументы метода: " + Arrays.toString(args));

        Object proceed = joinPoint.proceed();

        System.out.println("Метод завершен.");
        return proceed;
    }

}
