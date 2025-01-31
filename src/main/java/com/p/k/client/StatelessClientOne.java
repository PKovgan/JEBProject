package com.p.k.client;

import com.p.k.BeanIntroImplementation;
import com.p.k.BeanIntroInterface;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

public class StatelessClientOne {

    public static void main(String[] args) throws Exception {

        invokeStatelessBean();
    }

    private static void invokeStatelessBean() throws Exception {

        BeanIntroInterface statelessBean = lookupRemoteStatelessBean();
        System.out.println("Obtained a remote stateless bean for invocation");

        statelessBean.setName("Loony Client One");
        String message = statelessBean.getMessage();
        System.out.println("Returned message: " + message);

    }


    private static BeanIntroInterface lookupRemoteStatelessBean() throws Exception {

        final Hashtable<String, String> jndiProperties = new Hashtable<>();

        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        final Context context = new InitialContext(jndiProperties);

        final String appName = "";
        final String moduleName = "JEBProject-1.0";
        final String distinctName = "";
        final String beanName = BeanIntroImplementation.class.getSimpleName();
        final String viewClassName = BeanIntroInterface.class.getName();

        return (BeanIntroInterface) context.lookup("ejb:" + appName + "/"
                + moduleName + "/" + distinctName + "/"
                + beanName + "!" + viewClassName);
    }
}