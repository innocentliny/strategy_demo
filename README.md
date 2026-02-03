# strategy_demo
Design pattern `strategy` demo

## Scenario
This is the simplified version of IP to geolocation service that I refactored.  
Originally the service used Maxmind to get geolocation data.  
New requirements:
* Support another new IP parsing service, here is IP2Location.
* Need to switch back to Maxmind if any considerations.

## The demo
* Call api to get fake geolocation data.  
  Example:
  ```shell
  curl "http://localhost:8080/api/ip/172.16.17.32"
  ```
  The response is:
  ```json
  {"country":"zw","province":"g4z","service":"IP2Location"}
  ```
  The `service` field shows which IP parsing service is used.


* Switch to another service  
  Edit `ip.service` value in `application.yaml`, eithers `ip2location` or `maxmind`.  
  then restart the spring boot application.

## Add more IP parsing services
* Add a new service class and implements `com.example.strategy.service.SearchService` interface.
* Add the below annotation and specify which condition to create the new service instance.
  ```java
  @ConditionalOnProperty(name = "ip.service", havingValue = "new_service_name")
  ```
* Note: only one IP parsing service can be used at the same time.

## k8s support
Edit `IP_SERVICE` in `.env` file to switch IP parsing service.