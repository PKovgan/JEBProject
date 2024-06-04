package com.p.k;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

//@Stateless(name = "FirstBean")
//@Stateless
@Stateful
public class BeanIntroImplementation implements BeanIntroInterface {

    @Resource
    private SessionContext context;

    public String name;

    @Override
    public String getMessage() {
        return String.format("Welcome %s, to the world of EJB!", name );
    }

    @Override
    public void setName(String givenName) {
        name = givenName;
    }
}
