package config;

import aspect.CacheAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import aspect.ExeTimeAspect;
import service.Calculator;
import service.RecCalculator;


@Configuration
//@ComponentScan
@EnableAspectJAutoProxy // @Aspect 애노테이션이 붙은 빈 객체를 찾아 빈 객체의 @Pointcut 설정과 @Around 설정을 사용함
public class AppCtx {

    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
