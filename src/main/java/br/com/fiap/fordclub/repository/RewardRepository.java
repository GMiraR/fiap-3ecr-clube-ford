package br.com.fiap.fordclub.repository;

import br.com.fiap.fordclub.entity.Reward;
import br.com.fiap.fordclub.repository.constants.DatabaseConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward, String> {

    @Query(value = DatabaseConstants.SELECT_REWARDS_BY_NAME, nativeQuery = true)
    List<Reward> findRewardsByName(@Param("name") String name);

    @Query(value = DatabaseConstants.SELECT_ALL_REWARDS, nativeQuery = true)
    List<Reward> findAllRewards();
}
