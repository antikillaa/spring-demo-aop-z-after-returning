package by.peshkur.aopdemo;

import by.peshkur.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        // read spring congig class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call method to find the accounts
        List<Account> accountList = accountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----");
        System.out.println(accountList);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
