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
[
  [
    {
      "code": "002927",
      "startdate": "2018-07-06",
      "stock_table_id": 90848,
      "date": "2018-07-06",
      "open": 39.0,
      "close": 39.18,
      "high": 39.18,
      "low": 39.0,
      "volume": 41663.0
    },
    {
      "code": "002927",
      "startdate": "2018-07-06",
      "stock_table_id": 90848,
      "date": "2018-07-09",
      "open": 41.0,
      "close": 40.85,
      "high": 43.1,
      "low": 40.14,
      "volume": 151809.0
    }
  ],
  [
    {
      "code": "600532",
      "startdate": "2018-07-06",
      "stock_table_id": 88508,
      "date": "2018-07-11",
      "open": 3.75,
      "close": 4.42,
      "high": 4.42,
      "low": 3.68,
      "volume": 614071.0
    },
    {
      "code": "600532",
      "startdate": "2018-07-06",
      "stock_table_id": 88508,
      "date": "2018-07-12",
      "open": 4.56,
      "close": 4.86,
      "high": 4.86,
      "low": 4.56,
      "volume": 643016.0
    }
  ]
]
```

2. Use `curl` to inert data into DB for stock trade history `data.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/stock/tradeHistory" -d @data.json --header "Content-Type: application/json"
````