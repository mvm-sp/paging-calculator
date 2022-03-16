package com.mvm.pagination.domain;

import org.springframework.stereotype.Component;

@Component
public class PaginationProperties {

    public int page;
    public int totalPagesSource;
    public int totalPagesLocal;
    public int absoluteRecordPosition;
    public int relativeRecordPosition;
    public int totalRecords;
    public int initCall;
    public int qtdNewCalls;
    public int nextPagingRecord;

}
