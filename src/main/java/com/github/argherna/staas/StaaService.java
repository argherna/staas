package com.github.argherna.staas;

import java.util.List;

public interface StaaService {

	List<String> tokenize(String toTokenize, String delimiter);
}
