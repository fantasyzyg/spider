package com.nowcoder.spider.service.spider.strategy;

import us.codecraft.webmagic.Page;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class CoolProcessor extends FilterProcessor {

    private static final String PREFIX = "https://book.douban.com";
    private static final Set<Integer> SET = new HashSet<>();
    private static final ReentrantLock LOCK = new ReentrantLock();

    public CoolProcessor() {
        super(new IteratorProcessor());
    }

    public CoolProcessor(ProcessStrategy processStrategy) {
        super(processStrategy);
    }

    @Override
    public void doProcess(Page page) {
        List<String> urls = page.getHtml().xpath("//*[@id=\"subject_list\"]/div[2]/a/@href").all();

        for (String url: urls) {
            // 加入重入锁，防止重爬一些url
            LOCK.lock();
            int num = Integer.parseInt(url.split("=")[1].split("&")[0]);
            if (!SET.contains(num)) {
                System.out.println(url + " 已经加入爬取队列！");
                SET.add(num);
                page.addTargetRequest(PREFIX + url);
            }

            LOCK.unlock();
        }

        processStrategy.doProcess(page);
    }
}
