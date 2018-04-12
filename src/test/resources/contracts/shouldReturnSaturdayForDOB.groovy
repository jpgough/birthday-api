org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        body([
               "date": "2018-09-29"
             ])
        url '/day'
        headers {
          header('Content-Type', 'application/json')
        }
    }
    response {
        status 200
        body([
          "dayOfWeek": "SATURDAY"
        ])
    }
}