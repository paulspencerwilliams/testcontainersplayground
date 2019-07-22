package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    @Autowired
    JdbcTemplate template;

    public Person getPerson(String username) {
        return template.queryForObject(
                "select * from people where username = ?", new String[] {username},
                (rs, rowNum) -> {
                    Person person = new Person();
                    person.setUsername(rs.getString("username"));
                    return person;
                });
    }

    public void clear() {
        template.update("delete from people");
    }

    public void save(Person toSave) {
        template.update("insert into people (username) values (?)", toSave.getUsername());
    }
}
