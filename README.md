# STaaS (String Tokenization as a Service)

Finally! An HTTP service that tokenizes strings.

## Installation and Operation

1. Set up a database
1. Edit `application.properties` to point to your database
1. Start the server with `java -jar staas.jar`

## Endpoint

```
GET /tokens/{toTokenize}
```
### Parameters

| Parameter | Required | Description |
| --------- | -------- | ----------- |
| `toTokenize` | Yes | The string to tokenize |
| `delimiter` |No | The delimiter to use; defaults to `,`|

### Output

```json
{
  "tokens":[
    "foo",
    "bar"
  ],
  "delimiter":":",
  "_links":{
    "self":{
      "href":"http://localhost:8080/tokens/foo:bar?delimiter=:"
      }
  },
  "original_string":"foo:bar"
}
```

## Why?

Why not? Just go with it.

## Pronunciation

STAHZ
