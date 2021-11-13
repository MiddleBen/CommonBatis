package com.toluene.commonbatis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.toluene.commonbatis.criterion.Criterion;

public class Criteria {

    private List<Criterion> criteria = new ArrayList<Criterion>();

    public List<Criterion> getCriteria() {
        return Collections.unmodifiableList(criteria);
    }

    public void setCriteria(List<Criterion> criteria) {
        this.criteria = criteria;
    }

    public Criteria add(Criterion criterion) {
        criteria.add(criterion);
        return this;
    }

}
