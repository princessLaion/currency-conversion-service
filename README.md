
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
