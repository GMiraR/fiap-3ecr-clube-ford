package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.RewardCategory;
import br.com.fiap.fordclub.repository.RewardCategoryRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCategoriesService {

    private final RewardCategoryRepository repository;

    public List<RewardCategory> execute() throws ServiceException {
        try {
            var categories = repository.findAll();

            if (categories.isEmpty()) {
                throw new ServiceException("Não há categories cadastradas.");
            }

            return categories;
        } catch (Exception e) {
            throw new ServiceException("Problemas ao buscar categorias.");
        }

    }
}