package config;

import aspect.CacheAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import aspect.ExeTimeAspect;
import service.Calculator;
import service.RecCalculator;


@Configuration
@EnableAspectJAutoProxy
public class AppCtxWithCache {

    @Bean
    public ExeTimeAspect exeTimeAspect() { return new ExeTimeAspect(); }

    @Bean
    public CacheAspect cacheAspect() { return new CacheAspect(); }

    // 빈 설정 순서가 aspect 실행 순서에도 영향을 미친다.

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
