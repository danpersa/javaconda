# Javaconda

## Running

    ./gradlew bootRun

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
        Latency    19.96ms   36.04ms 314.69ms   87.13%
        Req/Sec     2.28k   509.39     3.75k    72.25%
      91017 requests in 10.03s, 18.14MB read
    Requests/sec:   9070.13
    Transfer/sec:      1.81MB
