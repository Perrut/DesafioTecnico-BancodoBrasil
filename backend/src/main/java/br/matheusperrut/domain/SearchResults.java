package br.matheusperrut.domain;

import java.util.List;

public class SearchResults {
    private Pagination pagination;
    private List<PovertyIndicator> povertyIndicatorList;

    public SearchResults(Pagination pagination, List<PovertyIndicator> povertyIndicatorList) {
        this.pagination = pagination;
        this.povertyIndicatorList = povertyIndicatorList;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<PovertyIndicator> getPovertyIndicatorList() {
        return povertyIndicatorList;
    }

    public void setPovertyIndicatorList(List<PovertyIndicator> povertyIndicatorList) {
        this.povertyIndicatorList = povertyIndicatorList;
    }
}
