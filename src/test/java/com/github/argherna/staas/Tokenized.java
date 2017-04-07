package com.github.argherna.staas;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tokenized extends ResourceSupport {

  private final List<String> tokens;

  private final String originalString;

  private final String delimiter;

  @JsonCreator
  public Tokenized(List<String> tokens, String originalString, String delimiter) {
    this.tokens = tokens;
    this.originalString = originalString;
    this.delimiter = delimiter;
  }

  public List<String> getTokens() {
    return tokens;
  }

  @JsonProperty("original_string")
  public String getOriginalString() {
    return originalString;
  }

  public String getDelimiter() {
    return delimiter;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((delimiter == null) ? 0 : delimiter.hashCode());
    result = prime * result + ((originalString == null) ? 0 : originalString.hashCode());
    result = prime * result + ((tokens == null) ? 0 : tokens.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (!(obj instanceof Tokenized)) {
      return false;
    }
    Tokenized other = (Tokenized) obj;
    if (delimiter == null) {
      if (other.delimiter != null) {
        return false;
      }
    } else if (!delimiter.equals(other.delimiter)) {
      return false;
    }
    if (originalString == null) {
      if (other.originalString != null) {
        return false;
      }
    } else if (!originalString.equals(other.originalString)) {
      return false;
    }
    if (tokens == null) {
      if (other.tokens != null) {
        return false;
      }
    } else if (!tokens.equals(other.tokens)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Tokenized [tokens=" + tokens + ", originalString=" + originalString + ", delimiter="
        + delimiter + "]";
  }
}
