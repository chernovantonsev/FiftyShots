package ru.antonc.fiftyshots.data.db;

import android.content.Context;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import ru.antonc.fiftyshots.data.domain.Image;
import ru.antonc.fiftyshots.data.domain.Shot;

import static ru.antonc.fiftyshots.app.Constants.SHOTS_PER_PAGE;

/**
 * Created by antonc on 22.02.2018.
 */

public class ShotsDatabase {

    private static ShotsDatabase instance;

    public static ShotsDatabase getInstance(Context context) {
        if (instance == null) {
            try {
                instance = new ShotsDatabase(context);
            } catch (Exception e) {
                Log.e("ShotsDatabase", " e - " + e.getMessage());
            }
        }
        return instance;
    }


    private OrmDBHelper mOrmDBHelper;

    private ShotsDatabase(Context context) {
        mOrmDBHelper = new OrmDBHelper(context);
    }


    public void saveListOfShots(List<Shot> shots) {
        Observable.fromIterable(shots)
                .map(this::saveShot)
                .toList()
                .subscribeOn(Schedulers.io())
                .subscribe(r -> clearOldShots());
    }

    private void clearOldShots() {
        List<Shot> allShots = getListOfShots();
        if (allShots.size() > SHOTS_PER_PAGE)
            for (Shot oldShot : allShots.subList(SHOTS_PER_PAGE, allShots.size())) {
                deleteShot(oldShot);
            }
    }

    private void deleteShot(Shot shot) {
        try {
            mOrmDBHelper.getImageDAO().delete(shot.getImage());
            mOrmDBHelper.getShotDAO().delete(shot);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Shot saveShot(Shot shot) {
        try {
            mOrmDBHelper.getShotDAO().createOrUpdate(shot);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Image imageShot = shot.getImage();
        imageShot.setShotId(shot.getId());
        saveImage(imageShot);

        return shot;
    }

    private Image saveImage(Image image) {
        try {
            mOrmDBHelper.getImageDAO().createOrUpdate(image);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }


    public List<Shot> getListOfShots() {
        List<Shot> shots = new ArrayList<>();
        try {
            shots = mOrmDBHelper.getShotDAO().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Collections.sort(shots, (s1, s2) -> s2.getDateUpdate().compareTo(s1.getDateUpdate()));

        for (Shot shot : shots)
            shot.setImage(getImageShot(shot.getId()));

        return shots;
    }

    private Image getImageShot(String shotID) {
        Image image = null;
        try {
            List<Image> list = mOrmDBHelper.getImageDAO().queryForEq(Image.SHOT_ID, shotID);
            if (list.size() > 0) {
                image = list.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }
}
