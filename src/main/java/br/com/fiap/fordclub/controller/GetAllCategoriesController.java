package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.entity.RewardCategory;
import br.com.fiap.fordclub.service.GetAllCategoriesService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class GetAllCategoriesController {

    private final GetAllCategoriesService getAllCategoriesService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RewardCategory> execute() throws ServiceException {

        return this.getAllCategoriesService.execute();
    }
}

