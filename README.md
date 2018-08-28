# Javaconda

## Swagger

 - [Swagger File](http://localhost:8080/v2/api-docs)
 - [Swagger UI](http://localhost:8080/swagger-ui.html)

## Hystrix

 - [The Turbine Stream](http://localhost:8080/actuator/hystrix.stream)
 - [The Dashboard](http://localhost:8080/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8080%2Factuator%2Fhystrix.stream&title=Javaconda)

 ## Performance

Start the service in dev mode and try:

    wrk -t 4 -c 50 -d 10s http://localhost:8080/quotes/1

After some warm up (a few runs), you might get a result like this:

    Running 10s test @ http://localhost:8080/quotes/1
        4 threads and 50 connections
        Thread Stats   Avg      Stdev     Max   +/- Stdev
          Latency     6.69ms    6.01ms 139.57ms   91.02%
          Req/Sec     1.72k   494.46     3.84k    76.41%
        68519 requests in 10.07s, 11.97MB read
    Requests/sec:   6802.43
    Transfer/sec:      1.19MB
