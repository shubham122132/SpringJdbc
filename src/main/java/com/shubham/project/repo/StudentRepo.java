package com.shubham.project.repo;

import com.shubham.project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Student s){
        String sql = "insert into student (id,name,age) values (?,?,?)";

        template.update(sql,s.getId(),s.getName(),s.getAge());
    }

    public List<Student> findAll(){
        String sql = "select * from student";
//        RowMapper<Student> mapper = (rs, rowNum) ->{
//                Student s = new Student();
//                s.setId(rs.getInt("id"));
//                s.setName(rs.getString("name"));
//                s.setAge(rs.getInt("age"));
//                return s;
//
//        };
//    List<Student> students=template.query(sql,mapper);

//     can also use this
        List<Student> students = template.query(sql, (rs, rowNum) ->{
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                return s;

        });

        return students;
    }
}
