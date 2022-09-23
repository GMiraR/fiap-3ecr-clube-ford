package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.RewardCategory;
import br.com.fiap.fordclub.repository.RewardCategoryRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategoryService {

    private final RewardCategoryRepository rewardCategoryRepository;

    public RewardCategory execute(RewardCategory rewardCategory) throws ServiceException {
        try {
            var categories =
                    rewardCategoryRepository.findCategoriesByName(rewardCategory.getName());

            if(!categories.isEmpty()){
                throw new ServiceException("Categoria já cadastrada.");
            }

            return rewardCategoryRepository.save(rewardCategory);
        } catch (Exception e){
            throw new ServiceException("Problemas ao cadastrar cliente.");
        }

    }
}
