package br.com.vagasapi.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RestController
@Api(description = "This is my Candidatura Controller")
@RequestMapping("/v1/candidaturas")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CandidaturaController {
}
