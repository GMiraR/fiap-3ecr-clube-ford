package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.controller.model.request.RewardRequest;
import br.com.fiap.fordclub.entity.Reward;
import br.com.fiap.fordclub.service.CreateRewardService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rewards")
@RequiredArgsConstructor
public class CreateRewardController {

    private final CreateRewardService createRewardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reward execute(@RequestBody @Valid RewardRequest request) throws ServiceException {

        return this.createRewardService.execute(Reward.builder()
                .name(request.getName())
                .description(request.getDescription())
                .points(request.getPoints())
                .destination(request.getDestination())
                .details(request.getDetails())
                .build(), request.getCategoryId());
    }


}