package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.Partner;
import br.com.fiap.fordclub.entity.Reward;
import br.com.fiap.fordclub.entity.enums.RewardStatus;
import br.com.fiap.fordclub.repository.PartnerRepository;
import br.com.fiap.fordclub.repository.RewardCategoryRepository;
import br.com.fiap.fordclub.repository.RewardRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateRewardService {

    private final RewardRepository rewardRepository;
    private final RewardCategoryRepository categoryRepository;
    private final PartnerRepository partnerRepository;

    public Reward execute(Reward reward, String categoryId) throws ServiceException {
        try {
            // TODO: Implementar tempo de aluguel veicular e tempo de veículo por assinatura
            var rewardCategory = categoryRepository.findById(categoryId);
            Optional<Partner> partner;

            if (Objects.isNull(reward.getPartner())) {
                partner = this.partnerRepository.findById("ford-1");
                partner.ifPresent(reward::setPartner);
            }
            rewardCategory.ifPresent(reward::setCategory);

            var rewards =
                    rewardRepository.findRewardsByName(reward.getName());

            if(!rewards.isEmpty()){
                throw new ServiceException("Recompensa já cadastrada.");
            }

            if(reward.getCategory().getName().equals("Assinaturas")){
                reward.setExpireAt(LocalDateTime.now().plusDays(180));
            } else {
                reward.setExpireAt(LocalDateTime.now().plusDays(60));
            }

            reward.setStatus(RewardStatus.AVAILABLE);

            return rewardRepository.save(reward);
        } catch (Exception e){
            throw new ServiceException("Problemas ao cadastrar recompensa.");
        }

    }
}
