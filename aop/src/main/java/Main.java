import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Calculator;
import config.AppCtx;
import service.RecCalculator;

public class Main {
    public static void main(String[] args) {
        // proxy
//        ExeTimeCalculator exeTimeImplCalculator = new ExeTimeCalculator(new ImplCalculator());
//        System.out.printf("Impl result: %d\n", exeTimeImplCalculator.factorial(20));
//
//        ExeTimeCalculator exeTimeRecCalculator = new ExeTimeCalculator(new RecCalculator());
//        System.out.printf("Rec result: %d\n", exeTimeRecCalculator.factorial(20));

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        RecCalculator cal = ctx.getBean("calculator", RecCalculator.class);
        long fiveFact = cal.factorial(5);
        System.out.println("cal.factorial(5)="+fiveFact);
        System.out.println(cal.getClass().getName());
        ctx.close();
    }
}
