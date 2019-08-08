package by.peshkur.aopdemo.aspect;

import by.peshkur.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        //display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments

        //get args
        Object[] objects = joinPoint.getArgs();

        //loop thru args
        for (Object object : objects){
            System.out.println(object);

            if (object instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) object;
                System.out.println("account name: " + account.getName());
                System.out.println("account name: " + account.getLevel());
            }
        }


    }

}
