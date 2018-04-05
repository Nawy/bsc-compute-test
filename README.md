# EndPoints

Request portfolio
```
GET http://localhost:8055/portfolio
```
Request portfolio by id
```
GET http://localhost:8055/portfolio/{id}
```
Compute deal
```
POST http://localhost:8055/deal
```
Compute deal inverted type, SELL -> BUY; BUY -> SELL
```
POST http://localhost:8055/deal/inverted
```

# Test case

## 1) Deal request
```
POST http://localhost:8055/deal
```       
### Body:
```json
{
	"account": "1213",
	"type": "sell",
	"securitySum": 10,
	"currencySum": 10
}
```
### Result(order isn't important):
```json
{
    "account": "1213",
    "positions": [
        {
            "name": "RUB",
            "type": "currency",
            "valueTO": 0,
            "valueTN": 0
        },
        {
            "name": "XDDR",
            "type": "security",
            "valueTO": 0,
            "valueTN": 10
        }
    ]
}
```

## 2) Deal request
```
POST http://localhost:8055/deal/inverted
```       
### Body:
```json
{
	"account": "1212",
	"type": "buy",
	"securitySum": 10,
	"currencySum": 10
}
```
### Result(order isn't important):
```json
{
    "account": "1212",
    "positions": [
        {
            "name": "XDDR",
            "type": "security",
            "valueTO": 0,
            "valueTN": 0
        },
        {
            "name": "RUB",
            "type": "currency",
            "valueTO": 0,
            "valueTN": 10
        }
    ]
}
```