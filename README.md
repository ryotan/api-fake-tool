**[FOR LEARNING]**

# Kaba API Fake Tool

A tool to define and fake Web APIs.
- [ ] Define API.
- [ ] Run a fake API server which responds according to API definition.
- [ ] Send specified host a request and verify result according to API definition.
- [ ] Build documents of defined API.

## Features
### Define API
A Web API is defined like this using DSL.

```groovy
defapi {
  "api-name" {
    path "/books/{id}" // URI template Level 1 (RFC6570)
    method GET

    // Normal response description
    response {
      contentType "application/json"
      body """
              {
                "bookId": "Description of 'bookId'"
              , "isbn": "Description of 'isbn'"
              , "title": "Description of 'title'"
              , "author": "Description of 'author'" 
              }
              """
    }
    
    // Fixtures for testing API.
    fixtures {
      "bookId 1" {
        request id: 1
        response """
              {
                "bookId": 1
              , "isbn": "978-4-0000-0000-0"
              , "title": "title of this book"
              , "author": "author of this book" 
              }
              """
      }
      "bookId 2 (not exists)" {
        request id: 2
        response {
          status 404
        }
      }
    }
  }
}
```

This means an API named `api-name` is waiting HTTP requests like this.
(This tool supports `utf-8` only.)

```
GET /books/1 HTTP/1.1
Host: api.example.com
```

And with fake api server, `api-name` responds like this if `id` is 1.

```
HTTP/1.1 200 OK
Content-Type: application/json; charset=utf-8
... other headers ...

{
  "bookId": 1
, "isbn": "978-4-0000-0000-0"
, "title": "A book title"
, "author": "A book author" 
}
```

If `id` is 2, responds with 404 NOT FOUND.

```
HTTP/1.1 404 Not Found
```

## License

Kaba API Fake Tool is licensed under the Apache License, Version 2.0.
See [LICENSE](LICENSE) for more information.
