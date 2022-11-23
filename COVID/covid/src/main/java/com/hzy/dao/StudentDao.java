package com.hzy.dao;

import com.hzy.pojo.Res;
import com.hzy.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentDao {
    @Select("select sid, name,password, bid, phone, level, status from student where sid=#{sid} and password = #{password}")
    Student login(Student student);

    @Select("select student.sid,student.name,student.bid,student.phone,student.status " +
            "from student,(SELECT bid FROM banji " + "WHERE tid = #{id}) AS A " +
            "WHERE student.bid = a.bid")
    List<Student> getAllStudent(Integer id);

    @Select("select * from res where bid = #{id}")
    List<Res> getAllRes(Integer id);
}
