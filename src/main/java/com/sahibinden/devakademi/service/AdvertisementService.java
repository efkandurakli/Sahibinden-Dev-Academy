package com.sahibinden.devakademi.service;


import com.sahibinden.devakademi.domain.Advertisement;
import com.sahibinden.devakademi.exception.BadRequestException;
import com.sahibinden.devakademi.exception.ResourceNotFoundException;
import com.sahibinden.devakademi.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdvertisementService {


    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Advertisement get(Long id) {
        return advertisementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advertisement not found with given id : " + id));
    }

    public List<Advertisement> search(int page, int size, String orderBy, String direction, String title,
                                      String description, Double price, Integer has_promotion, Integer view_count,
                                      String city, String town, String c0, String c1, String c2, String c3,
                                      String c4, String c5, String c6) {

        if (direction.equals("ASC") || direction.equals("DESC")) {
            if (orderBy.equals("title") || orderBy.equals("description") || orderBy.equals("price")
                    || orderBy.equals("has_promotion") || orderBy.equals("view_count") || orderBy.equals("city")
                    || orderBy.equals("town") || orderBy.equals("C0") || orderBy.equals("c1") || orderBy.equals("c2")
                    || orderBy.equals("c3") || orderBy.equals("c4") || orderBy.equals("c5") || orderBy.equals("C6")) {

                Sort.Direction dir = null;
                if (direction.equals("ASC"))
                    dir = Sort.Direction.ASC;
                else
                    dir = Sort.Direction.DESC;

                PageRequest request = PageRequest.of(page, size, Sort.by(dir, orderBy));

                Page<Advertisement> resultPage = advertisementRepository.search(title, description, price, has_promotion,
                        view_count, city, town, c0, c1, c2, c3, c4, c5, c6, request);

                if (page > resultPage.getTotalPages())
                    throw new ResourceNotFoundException("Page not found");
                return resultPage.getContent();


            } else {
                throw new BadRequestException("Invalid order property");
            }
        }
        throw new BadRequestException("Invalid sort direction");
    }

}
