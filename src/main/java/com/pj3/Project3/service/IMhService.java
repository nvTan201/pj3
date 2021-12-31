package com.pj3.Project3.service;

import com.pj3.Project3.model.monHoc;

import java.util.List;

public interface IMhService {
    public List<monHoc> getAll();
    public monHoc addMh(monHoc monHoc);
    public monHoc editMh(long id, monHoc monHoc);
}
