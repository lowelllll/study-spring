import config.AppCtxWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Calculator;

public class MainAspectWithCache
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);

        Calculator cal = ctx.getBean(Calculator.class);

        cal.factorial(7);
        cal.factorial(7);
        cal.factorial(5);
        cal.factorial(5);
        ctx.close();
    }
}
