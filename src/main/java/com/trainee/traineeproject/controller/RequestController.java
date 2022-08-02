package com.trainee.traineeproject.controller;

import com.trainee.traineeproject.entity.Request;
import com.trainee.traineeproject.entity.dto.RequestDTO;
import com.trainee.traineeproject.service.RequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping(path = "/{id}")
    public RequestDTO read(@PathVariable Integer id) {
        return requestService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Request update(@PathVariable Integer id, @RequestBody Request updatedRequest) {
        return requestService.update(id, updatedRequest);
    }

}
