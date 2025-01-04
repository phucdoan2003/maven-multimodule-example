module user {
    requires com.fasterxml.jackson.annotation;
    requires jakarta.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires spring.beans;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.security.core;
    requires spring.tx;
    requires spring.web;

    exports sead.assignment2.external.service;
    exports sead.assignment2.external.dto;
    exports sead.assignment2.external.enums;
}