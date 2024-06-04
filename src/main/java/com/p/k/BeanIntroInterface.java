package com.p.k;

import javax.ejb.Remote;

@Remote
public interface BeanIntroInterface {
    String getMessage();
    void setName(String name);
}