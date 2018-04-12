org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/today'
    }
    response {
        status 200
        body([
          "date": $(regex('[0-9]{4}-[0-9]{2}-[0-9]{2}'))
        ])
    }
}