package ru.antonc.fiftyshots.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ru.antonc.fiftyshots.data.db.dao.ImageDAO;
import ru.antonc.fiftyshots.data.db.dao.ShotDAO;
import ru.antonc.fiftyshots.data.domain.Image;
import ru.antonc.fiftyshots.data.domain.Shot;

import static ru.antonc.fiftyshots.app.Constants.DATABASE_NAME;
import static ru.antonc.fiftyshots.app.Constants.DATABASE_VERSION;

/**
 * Created by antonc on 22.02.2018.
 */

public class OrmDBHelper extends OrmLiteSqliteOpenHelper {

    private ShotDAO mShotDAO = null;
    private ImageDAO mImageDAO = null;


    OrmDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Shot.class);
            TableUtils.createTable(connectionSource, Image.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Shot.class, true);
            TableUtils.dropTable(connectionSource, Image.class, true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    ShotDAO getShotDAO() throws SQLException {
        if (mShotDAO == null) {
            mShotDAO = new ShotDAO(getConnectionSource(), Shot.class);
        }
        return mShotDAO;
    }

    ImageDAO getImageDAO() throws SQLException {
        if (mImageDAO == null) {
            mImageDAO = new ImageDAO(getConnectionSource(), Image.class);
        }
        return mImageDAO;
    }


    @Override
    public void close() {
        super.close();
        mShotDAO = null;
        mImageDAO = null;

    }
}
