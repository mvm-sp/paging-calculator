package com.mvm.pagination.controller;

import com.mvm.pagination.domain.PaginationProperties;
import com.mvm.pagination.usecase.PagePropertiesCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaginationController {

    @Autowired
    PagePropertiesCalculator pagePropertiesCalculator;

    @GetMapping("/calculate")
    public PaginationProperties calcPaginationProperties(
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam int totalRecords
    ){
        return pagePropertiesCalculator.getProperties(pageSize,totalRecords,page);
    }

}
