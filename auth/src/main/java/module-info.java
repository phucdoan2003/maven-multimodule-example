module auth {
    requires org.apache.tomcat.embed.core;
    requires spring.security.crypto;
    requires jjwt.api;
    requires jjwt.impl;
    requires user;
    requires spring.context;
    requires spring.beans;
    requires spring.security.core;
    requires spring.web;
    requires static lombok;
    requires spring.security.config;
    requires spring.security.web;
}