package com.tt.admin.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ThreadPoolExecutorComponent {

    private ThreadPoolExecutor threadPoolExecutor;

    public void submit(Runnable runnable) {
        threadPoolExecutor.submit(runnable);
    }

    @PostConstruct
    public void init() {
        threadPoolExecutor = new ThreadPoolExecutor(3, 50, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(512), new ThreadFactory() {
            private final AtomicInteger integer = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "系统线程池-" + integer.getAndIncrement());
            }
        });
    }
}
