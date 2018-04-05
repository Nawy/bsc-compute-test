# Endpoints

Запросить портфель
```
GET http://localhost:8055/portfolio
```
Запросить портфель по определенному ID
```
GET http://localhost:8055/portfolio/{id}
```
Посчитать сделки
```
POST http://localhost:8055/deal
```
Посчитать сделки инвертированно, где тип поменяется: SELL -> BUY и BUY -> SELL
```
POST http://localhost:8055/deal/inverted
```

# Test cases

## 1) Запрос покупки обычной сделки
```
POST http://localhost:8055/deal
```       
### Тело запроса:
```json
{
	"account": "1213",
	"type": "buy",
	"securitySum": 10,
	"currencySum": 10
}
```
### Результат
```
GET http://localhost:8055/portfolio/1213
```
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

## 2) Запрос покупки инвертированной сделки, которая станет продажей
```
GET http://localhost:8055/portfolio/1212
```       
### Тело запроса:
```json
{
	"account": "1212",
	"type": "buy",
	"securitySum": 10,
	"currencySum": 10
}
```
### Результат
```
GET http://localhost:8055/portfolio/1212
```
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