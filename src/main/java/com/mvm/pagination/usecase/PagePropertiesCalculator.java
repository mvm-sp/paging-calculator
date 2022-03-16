package com.mvm.pagination.usecase;

import com.mvm.pagination.domain.PaginationProperties;
import org.springframework.stereotype.Service;

@Service
public class PagePropertiesCalculator {

    private final int PAGE_SOURCE = 163;

    public PaginationProperties getProperties(int pageSize, int totalRecords, int page){
        PaginationProperties paginationProperties = new PaginationProperties();
        int totalPagesSource = roundPlus(totalRecords , PAGE_SOURCE);
        int totalPagesLocal = roundPlus(totalRecords , pageSize);
        int initCall = (page * pageSize) / PAGE_SOURCE;
        int nextPagingRecord = initCall * PAGE_SOURCE;
        int qtdNewCalls = (nextPagingRecord + pageSize/ PAGE_SOURCE) - initCall;
        int absoluteRecordPosition = ((page * pageSize)) - pageSize +1;
        int relativeRecordPosition = absoluteRecordPosition - 0;
        paginationProperties.page = page;
        paginationProperties.totalPagesSource = totalPagesSource;
        paginationProperties.absoluteRecordPosition = absoluteRecordPosition;
        paginationProperties.qtdNewCalls = qtdNewCalls;
        paginationProperties.totalPagesLocal = totalPagesLocal;
        paginationProperties.initCall = initCall;
        paginationProperties.nextPagingRecord = nextPagingRecord;
        paginationProperties.totalRecords = totalRecords;
        return paginationProperties;
    }

    private int roundPlus(int number, int divisor) {
        int rounded= (number + divisor - 1) / divisor;
        return rounded;
    }
}
