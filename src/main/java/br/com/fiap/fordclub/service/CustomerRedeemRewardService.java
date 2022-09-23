package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.repository.CustomerRepository;
import br.com.fiap.fordclub.repository.RewardRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerRedeemRewardService {

    private final CustomerRepository customerRepository;
    private final RewardRepository rewardRepository;

    public Customer execute(String customerUuid, String rewardUuid) throws ServiceException {
        try {

            var customer = customerRepository.findById(customerUuid);

            if(customer.isEmpty()){
                throw new ServiceException("Cliente não existente.");
            }

            var reward = rewardRepository.findById(rewardUuid);

            if(reward.isEmpty()){
                throw new ServiceException("Recompensa não existente.");
            }

            if(customer.get().getWallet() < reward.get().getPoints()){
                throw new ServiceException("Pontos insuficientes para adquirir recompensa.");
            }

            customer.get().setWallet(customer.get().getWallet() - reward.get().getPoints());
            customer.get().setReward(reward.get());

            return customerRepository.save(customer.get());
        } catch (Exception e){
            throw new ServiceException("Problemas ao resgatar recompensa.");
        }

    }
}
