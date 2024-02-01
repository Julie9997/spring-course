package ru.julie.crudremaster.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.julie.crudremaster.models.User;
import ru.julie.crudremaster.models.UserQueries;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;

    /**
     * Объект с запросами к бд.
     */
    private final UserQueries userQueries;

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(userQueries.getFindAll(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(userQueries.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        jdbc.update(userQueries.getDeleteById(), String.valueOf(id));
    }

    public User getUserById(int id) {
        return jdbc.queryForObject(userQueries.getGetUserById(),
                new Object[]{id}, BeanPropertyRowMapper.newInstance(User.class));
    }

    public User update(User user) {
        jdbc.update(userQueries.getUpdate(),
                user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}