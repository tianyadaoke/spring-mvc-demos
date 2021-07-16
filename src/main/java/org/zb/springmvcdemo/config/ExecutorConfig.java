package org.zb.springmvcdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.zb.springmvcdemo.service.VisibleThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {
    public static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);
    @Value("${async.executor.thread.core_pore_size}")
    private int corePoolSize;
    @Value("${async.executor.thread.max_pore_size}")
    private int maxPoolSize;
    @Value("${async.executor.thread.queue_capacity}")
    private int queryCapacity;
    @Value("${async.executor.thread.name_prefix}")
    private String namePrefix;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor(){
        logger.info("---- start asyncServiceExecutor ----");
        VisibleThreadPoolTaskExecutor executor = new VisibleThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queryCapacity);
        executor.setThreadNamePrefix(namePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
