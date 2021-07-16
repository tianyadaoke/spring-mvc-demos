package org.zb.springmvcdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService{

    public static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        logger.info(" ---start execute async---");
        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入");
        logger.info("--- end execute async---");
    }
}
