package com.pj3.Project3.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public interface LopAndKhoa {

    Long getMa_lop();

    String getTen_lop();

    String getTen_khoa();

    @Temporal(TemporalType.DATE)
    Date getNam_nhap_hoc();

    int getHoc();
}
