package com.github.argherna.staas;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StaaServiceImpl implements StaaService {

  @Override
  public List<String> tokenize(String toTokenize, String delimiter) {
    return Arrays.asList(toTokenize.split(delimiter));
  }

}
