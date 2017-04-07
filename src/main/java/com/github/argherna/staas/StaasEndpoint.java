package com.github.argherna.staas;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tokens", produces = "application/json")
public class StaasEndpoint {

  private StaaService staaService;

  @Autowired
  public StaasEndpoint(StaaService staaService) {
    this.staaService = staaService;
  }

  @RequestMapping(value= "/{toTokenize}", method = RequestMethod.GET)
  public Tokenized getResource(
      @PathVariable("toTokenize") String toTokenize,
      @RequestParam(required = false, name = "delimiter", defaultValue = ",") String delimiter) {

    List<String> tokens = staaService.tokenize(toTokenize, delimiter);
    Tokenized tokenized = new Tokenized(tokens, toTokenize, delimiter);
    tokenized.add(
        linkTo(methodOn(StaasEndpoint.class).getResource(toTokenize, delimiter)).withSelfRel());
    return tokenized;
  }

}
