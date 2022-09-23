package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.controller.model.request.CategoryRequest;
import br.com.fiap.fordclub.controller.model.request.CustomerRequest;
import br.com.fiap.fordclub.controller.model.response.CategoryResponse;
import br.com.fiap.fordclub.controller.model.response.CustomerResponse;
import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.entity.RewardCategory;
import br.com.fiap.fordclub.service.CreateCategoryService;
import br.com.fiap.fordclub.service.CreateCustomerService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CreateCategoryController {

    private final CreateCategoryService createCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse execute(@RequestBody @Valid CategoryRequest request) throws ServiceException {

        var createdCategory = this.createCategoryService.execute(RewardCategory.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build());

        return CategoryResponse.builder()
                .uuid(createdCategory.getUuid())
                .name(createdCategory.getName())
                .description(createdCategory.getDescription())
                .build();
    }
}
