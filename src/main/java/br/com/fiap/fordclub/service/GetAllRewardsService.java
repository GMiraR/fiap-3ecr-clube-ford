package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.entity.Reward;
import br.com.fiap.fordclub.repository.CustomerRepository;
import br.com.fiap.fordclub.repository.RewardRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetAllRewardsService {

    private final RewardRepository repository;

    public List<Reward> execute() throws ServiceException {
        try {
            var rewards = repository.findAllRewards();

            if (rewards.isEmpty()) {
                throw new ServiceException("Não há recompensas cadastradas.");
            }

            return rewards;
        } catch (Exception e) {
            throw new ServiceException("Problemas ao buscar recompensas.");
        }

    }
}