package ru.antonc.fiftyshots.data.rest;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.antonc.fiftyshots.data.domain.Shot;

public interface ShotsService {

    @GET("shots")
    Observable<List<Shot>> fetchShots(@Query("page") int page, @Query("per_page") int perPage, @Query("sort") String sort);
}
