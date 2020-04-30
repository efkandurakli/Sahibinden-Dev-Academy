package com.sahibinden.devakademi.repository;

import com.sahibinden.devakademi.domain.Advertisement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query("SELECT a FROM Advertisement a WHERE (:title is null or LOWER(a.title) LIKE LOWER(CONCAT('%',:title,'%')) ) and " +
            "(:description is null or LOWER(a.description) LIKE LOWER(CONCAT('%',:description,'%')) ) and " +
            "(:price is null or a.price = :price) and (:has_promotion is null or a.has_promotion = :has_promotion) and " +
            "(:view_count is null or a.view_count = :view_count) and (:city is null or LOWER(a.city) LIKE LOWER(CONCAT('%',:city,'%')) )" +
            "and (:town is null or LOWER(a.town) LIKE LOWER(CONCAT('%',:town,'%')) )" +
            "and (:c0 is null or LOWER(a.c0 ) LIKE LOWER(CONCAT('%',:c0 ,'%')) )" +
            "and (:c1 is null or LOWER(a.c1 ) LIKE LOWER(CONCAT('%',:c1 ,'%')) )" +
            "and (:c2 is null or LOWER(a.c2 ) LIKE LOWER(CONCAT('%',:c2 ,'%')) )" +
            "and (:c3 is null or LOWER(a.c3 ) LIKE LOWER(CONCAT('%',:c3 ,'%')) )" +
            "and (:c4 is null or LOWER(a.c4 ) LIKE LOWER(CONCAT('%',:c4 ,'%')) )" +
            "and (:c5 is null or LOWER(a.c5 ) LIKE LOWER(CONCAT('%',:c5 ,'%')) )" +
            "and (:c6 is null or LOWER(a.c6 ) LIKE LOWER(CONCAT('%',:c6 ,'%')) )")
    Page<Advertisement> search(@Param("title") String title, @Param("description") String description,
                               @Param("price") Double price, @Param("has_promotion") Integer has_promotion,
                               @Param("view_count") Integer view_count, @Param("city") String city, @Param("town") String town,
                               @Param("c0") String c0, @Param("c1") String c1, @Param("c2") String c2, @Param("c3") String c3,
                               @Param("c4") String c4, @Param("c5") String c5, @Param("c6") String c6, Pageable pageable);
}
