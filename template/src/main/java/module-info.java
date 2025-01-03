module template {
    requires jakarta.persistence;
    requires static lombok;
    requires spring.context;
    requires spring.web;
    requires spring.data.jpa;
    requires spring.beans;
    requires spring.data.commons;

    exports sead.assignment2.template.external.service;
    exports sead.assignment2.template.external.dto;
}