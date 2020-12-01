package com.opts.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

@RestController
@RequestMapping(value = "/pessoa")
@Api(value = "API REST pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {
}
