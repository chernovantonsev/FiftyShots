package ru.antonc.fiftyshots.data.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import ru.antonc.fiftyshots.data.domain.Image;

/**
 * Created by antonc on 22.02.2018.
 */

public class ImageDAO extends BaseDaoImpl<Image, Integer> {
    public ImageDAO(ConnectionSource connectionSource, Class<Image> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
