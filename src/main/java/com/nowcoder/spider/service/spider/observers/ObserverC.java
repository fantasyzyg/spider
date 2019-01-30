package com.nowcoder.spider.service.spider.observers;

import com.nowcoder.spider.dao.BookDAO;
import com.nowcoder.spider.model.OriginBook;
import com.nowcoder.spider.service.spider.pipeline.CallablePipeline;
import com.nowcoder.spider.service.spider.pipeline.Observable;
import com.nowcoder.spider.service.spider.pipeline.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObserverC implements Observer {

    @Autowired
    BookDAO bookDAO;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(bookDAO == null);

//        if (o instanceof CallablePipeline) {
//            // System.out.println("ObserverC " + arg);
//            OriginBook book = (OriginBook)arg;
//            synchronized (BookDAO.class) {
//                System.out.println(book.getName());
//                if (bookDAO.select(book.getName()) == 0)
//                    bookDAO.insert(book);
//            }
//        }
    }
}
