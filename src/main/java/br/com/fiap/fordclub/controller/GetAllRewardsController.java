package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.entity.Reward;
import br.com.fiap.fordclub.entity.RewardCategory;
import br.com.fiap.fordclub.service.GetAllCategoriesService;
import br.com.fiap.fordclub.service.GetAllRewardsService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rewards")
@RequiredArgsConstructor
public class GetAllRewardsController {

    private final GetAllRewardsService getAllRewardsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Reward> execute() throws ServiceException {

        return this.getAllRewardsService.execute();
    }
}

