package com.p.k;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PetShopBeanInterface {

    List<String> getBreeds(String petType);
    void setBreeds(String petType, List<String> breeds);
}
