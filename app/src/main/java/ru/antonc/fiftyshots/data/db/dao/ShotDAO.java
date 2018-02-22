package ru.antonc.fiftyshots.data.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import ru.antonc.fiftyshots.data.domain.Shot;

/**
 * Created by antonc on 22.02.2018.
 */

public class ShotDAO extends BaseDaoImpl<Shot, Integer> {
    public ShotDAO(ConnectionSource connectionSource, Class<Shot> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
