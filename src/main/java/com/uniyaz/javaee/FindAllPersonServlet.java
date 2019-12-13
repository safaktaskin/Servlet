package com.uniyaz.javaee;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindAllPersonServlet implements Servlet {

    static List<Person> personelList = new ArrayList();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init metodu çalıştı");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig metodu çalıştı");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String islem = servletRequest.getParameter("islem");
        System.out.println(islem);

        if (islem.equals("kaydet")) {

            String ad = servletRequest.getParameter("ad");
            String soyad = servletRequest.getParameter("soyad");

            Person person = new Person();
            person.setAd(ad);
            person.setSoyad(soyad);

            personelList.add(person);

            servletResponse.getWriter().write("Kaydetme Islemi Yapildi");

        } else if (islem.equals("listele")) {

            for (Person person : personelList) {
                String html = person.getAd() + " " + person.getSoyad() + "\n";
                servletResponse.setCharacterEncoding("UTF-8");
                servletResponse.getWriter().write(html);
                System.out.println(person);
            }

        } else {
            System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz! ");
        }

    }

    @Override
    public String getServletInfo() {
        System.out.println("ServletInfo metodu çalıştı");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Service metodu çalıştı");
    }
}
