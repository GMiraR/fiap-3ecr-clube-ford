package br.com.fiap.fordclub.repository;

import br.com.fiap.fordclub.entity.RewardCategory;
import br.com.fiap.fordclub.repository.constants.DatabaseConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RewardCategoryRepository extends JpaRepository<RewardCategory, String> {

    @Query(value = DatabaseConstants.SELECT_CATEGORIES_BY_NAME, nativeQuery = true)
    List<RewardCategory> findCategoriesByName(@Param("name") String name);
}
