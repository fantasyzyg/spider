package com.nowcoder.spider.service;

import com.nowcoder.spider.model.OriginBook;
import com.nowcoder.spider.service.spider.DefaultSpider;
import com.nowcoder.spider.service.spider.observers.ObserverA;
import com.nowcoder.spider.service.spider.observers.ObserverB;
import com.nowcoder.spider.service.spider.observers.ObserverC;
import com.nowcoder.spider.service.spider.pipeline.CallablePipeline;
import com.nowcoder.spider.service.spider.strategy.CoolProcessor;
import com.nowcoder.spider.service.spider.strategy.IteratorProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nowcoder on 2018/08/16 下午5:23
 */
@Service
public class SpiderService {

    @Autowired
    private DefaultSpider defaultSpider;

    @Autowired
    private CallablePipeline pipeline;      // 为什么会自动找到 OriginBookPipeline 呢？

    public void getLotsOfBooks(String beginUrl) {
        try {

            // 给pipeline添加观察者
            pipeline.addObserver(new ObserverA());
            pipeline.addObserver(new ObserverB());
            pipeline.addObserver(new ObserverC());
            defaultSpider.setProcessStrategy(new CoolProcessor());
            defaultSpider.getSpider()
                    .addUrl(beginUrl)
                    .addPipeline(pipeline)
                    .thread(1)
                    .run();

            OriginBook book = (OriginBook) pipeline.getResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
