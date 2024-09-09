
## URL
http://localhost:8100/v1/currency-conversion/from/USD/to/PHP/quantity/10

Using Feign client
http://localhost:8100/v1/currency-conversion/feign/from/USD/to/PHP/quantity/10

## Response Structure
{
    "id": 100001,
    "fromCurrency": "USD",
    "toCurrency": "PHP",
    "conversionRate": 56,
    "qty": 10,
    "totalCalculatedAmount": 560,
    "environment": "8000"
}

## Eureka Repo
https://github.com/princessLaion/naming-server
http://localhost:8761

## Others
[Additional Info for Project dependencies](https://github.com/princessLaion/api-gateway/blob/main/README.md)
