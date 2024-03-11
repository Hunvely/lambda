package com.rod.api.common;

import com.rod.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// DB에 테이블이 존재하면 CRUD 기능을 만들어야 함.
public abstract class AbstractService<T> {


    public abstract Messenger save(T t) throws SQLException;

    public abstract List<T> findAll() throws SQLException;

    public abstract Optional<T> findById(Long id);

    public abstract String count();

    public abstract Optional<T> getOne(String id);

    public abstract String delete(T t);

    public abstract String deleteAll();

    public abstract Boolean existsById(Long id);

}
