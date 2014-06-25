**[FOR LEARNING]**

# Kaba API Fake Tool

A tool to define and fake Web APIs.
- [ ] Define API and build documents of it.
- [ ] Run a fake API server which responds according to API definition.
- [ ] Send specified host a request and verify result according to API definition.

## Features
### Define API
A Web API is defined like this using DSL.

```groovy
defapi {
  "api-name" {
    path "/books/{id:[0-9]{8}}/edit"
    method POST
    contentType "application/json"
  }
}
```

This means an API named `api-name` is waiting HTTP requests like this.
(This tool supports `utf-8` only.)

```
POST /books/01234567/edit HTTP/1.1
Host: api.example.com
Content-Type: application/json; charset=utf-8

{
  "bookId": "01234567"
, "isbn": "978-4-0000-0000-0"
, "title": "A book title"
, "author": "A book author"
}
```

## License

Kaba API Fake Tool is licensed under the Apache License, Version 2.0.
See [LICENSE](LICENSE) for more information.
