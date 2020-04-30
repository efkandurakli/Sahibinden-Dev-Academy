package com.sahibinden.devakademi.controller;
import com.sahibinden.devakademi.domain.Advertisement;
import com.sahibinden.devakademi.dto.SearchAdvertisementDTO;
import com.sahibinden.devakademi.dto.domain.AdvertisementDTO;
import com.sahibinden.devakademi.enumaration.Direction;
import com.sahibinden.devakademi.enumaration.OrderBy;
import com.sahibinden.devakademi.service.AdvertisementService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AdvertisementDTO get(@PathVariable Long id) {
        return modelMapper.map(advertisementService.get(id), AdvertisementDTO.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/search")
    public List<AdvertisementDTO> search(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                         @RequestParam(value = "size", defaultValue = "50", required = false) Integer size,
                                         @RequestParam(value = "orderBy", defaultValue = "TITLE", required = false) OrderBy orderBy,
                                         @RequestParam(value = "direction", defaultValue = "ASCENDING", required = false) Direction direction,
                                         @RequestBody(required = false) SearchAdvertisementDTO searchAdvertisementDTO) {

        List<Advertisement> advertisements = advertisementService.search(page, size, orderBy.getOrderByCode(),
                direction.getDirectionCode(), searchAdvertisementDTO.getTitle(), searchAdvertisementDTO.getDescription(),
                searchAdvertisementDTO.getPrice(), searchAdvertisementDTO.getHas_promotion(), searchAdvertisementDTO.getView_count(),
                searchAdvertisementDTO.getCity(), searchAdvertisementDTO.getTown(), searchAdvertisementDTO.getC0(), searchAdvertisementDTO.getC1(),
                searchAdvertisementDTO.getC2(), searchAdvertisementDTO.getC3(), searchAdvertisementDTO.getC4(), searchAdvertisementDTO.getC5(),
                searchAdvertisementDTO.getC6());

        Type listType = new TypeToken<List<AdvertisementDTO>>() {}.getType();
        return modelMapper.map(advertisements, listType);
    }


}
