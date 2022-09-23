package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.entity.Reward;
import br.com.fiap.fordclub.repository.RewardRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rewards")
@RequiredArgsConstructor
public class GetRewardsByUuidController {

    private final RewardRepository repository;

    @GetMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public Reward execute(@PathVariable String uuid) throws ServiceException {

        var reward = this.repository.findById(uuid);

        if(reward.isEmpty()){
            throw new ServiceException("Recompensa não existente.");
        }

        return reward.get();
    }
}

