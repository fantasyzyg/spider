package com.nowcoder.spider.dao;

import com.nowcoder.spider.model.OriginBook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDAO {

    String table_name = " book ";
    String insert_fields = " name, score, image, originUrl ";

    @Insert({"insert into ", table_name, "(", insert_fields,")", " values(" +
            "#{name}, #{score}, #{img}, #{originUrl})"})
    void insert(OriginBook book);

    @Select({"select count(*) as count from ", table_name, " where name = #{name}"})
    int select(String name);
}
