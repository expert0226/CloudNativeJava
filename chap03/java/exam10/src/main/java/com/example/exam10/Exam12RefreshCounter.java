package com.example.exam10;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class Exam12RefreshCounter {
    private final Log log = LogFactory.getLog(getClass());
    private final AtomicLong counter = new AtomicLong(0);

    @EventListener
    public void refresh(RefreshScopeRefreshedEvent e) {
        this.log.info("The refresh counter is now at: " + this.counter.incrementAndGet());
    }
}
