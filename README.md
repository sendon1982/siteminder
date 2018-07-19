# How to run the App
1. Go to terminal and run ```mvn clean package```

2. Run ```java -jar target/siteminder-0.0.1-SNAPSHOT.jar``` served at http://localhost:8080/

# How to test the App for broker data

1. Use Postman to make POST to `http://localhost:8080/broker/purchaseSummary` with the following body

```
{
  "Message": "",
  "Status": 0,
  "Data": [
    {
      "TableName": "RptLhbYybXQSumMap",
      "TotalPage": 1,
      "ConsumeMSecond": 94,
      "SplitSymbol": "|",
      "FieldName": "SName,YybCode,YybName,Smoney,Bmoney,JmMoney,YybBCount,YybSCount,TDate",
      "Data": [
        "[{\"CodeName\":\"珀莱雅\",\"SCode\":\"603605.SH\"}]|80052395|中国国际金融股份有限公司上海黄浦区湖滨路证券营业部||50535992.38|50535992.38|1|0|2018-06-29"
      ]
    }
  ]
}
```

2. Use `curl` to inert data into DB for broker buy summary `data.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/broker/purchaseSummary" -d @data.json --header "Content-Type: application/json"
````

# How to test the App for stock data

1. Use Postman to make POST to `http://localhost:8080/stock/tradeHistory` with the following body

```
{
  "code": 0,
  "msg": "",
  "data": {
    "sh600000": {
      "qfqday": [
        [
          "2017-01-03",
          "12.184",
          "12.251",
          "12.356",
          "12.153",
          "162371.000"
        ],
        [
          "2017-01-04",
          "12.244",
          "12.274",
          "12.289",
          "12.161",
          "296587.000"
        ]
      ]
    }
  }
}
```

2. Use `curl` to inert data into DB for stock trade history `data.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/stock/tradeHistory" -d @data.json --header "Content-Type: application/json"
````