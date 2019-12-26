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

1.Use Postman to make POST to `http://localhost:8080/stock/tradeHistory` with the following body

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

2.Use `curl` to inert data into DB for stock trade history `data.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/stock/tradeHistory" -d @data.json --header "Content-Type: application/json"
````

3.Use `curl` to inert data into DB for stock info no `data.json` where the json file on current path
````
{
  "errorNo": 0,
  "errorMsg": "SUCCESS",
  "mashData": [
    {
      "date": 20170104,
      "kline": {
        "open": 12.060000419617,
        "high": 12.199999809265,
        "low": 11.880000114441,
        "close": 12.180000305176,
        "volume": 35789925,
        "amount": 431550246,
        "ccl": 0,
        "preClose": 12.130000114441,
        "netChangeRatio": 0.41220271959901
      },
      "ma5": {
        "volume": 31004170,
        "avgPrice": 11.892000198364,
        "ccl": null
      },
      "ma10": {
        "volume": 43825935,
        "avgPrice": 12.043999671936,
        "ccl": null
      },
      "ma20": {
        "volume": 38472043,
        "avgPrice": 11.694000244141,
        "ccl": null
      },
      "macd": {
        "diff": 0.26707058616027,
        "dea": 0.27386031689491,
        "macd": -0.013579461469285
      },
      "kdj": {
        "k": 60.772373213069,
        "d": 61.261942429595,
        "j": 59.793234780017
      },
      "rsi": {
        "rsi1": 63.204223181573,
        "rsi2": 59.82888529586,
        "rsi3": 58.419092680728
      }
    },
    {
      "date": 20170103,
      "kline": {
        "open": 11.729999542236,
        "high": 12.210000038147,
        "low": 11.659999847412,
        "close": 12.130000114441,
        "volume": 38435903,
        "amount": 462750060,
        "ccl": 0,
        "preClose": 11.659999847412,
        "netChangeRatio": 4.0308769792318
      },
      "ma5": {
        "volume": 31661035,
        "avgPrice": 11.883999824524,
        "ccl": null
      },
      "ma10": {
        "volume": 44471623,
        "avgPrice": 11.954999923706,
        "ccl": null
      },
      "ma20": {
        "volume": 37522489,
        "avgPrice": 11.609499931335,
        "ccl": null
      },
      "macd": {
        "diff": 0.25882444000284,
        "dea": 0.27555774957857,
        "macd": -0.033466619151453
      },
      "kdj": {
        "k": 58.574272096936,
        "d": 61.506727037858,
        "j": 52.709362215094
      },
      "rsi": {
        "rsi1": 61.653878978815,
        "rsi2": 59.09463768097,
        "rsi3": 58.048825870844
      }
    }
  ],
  "stock_code": "600000"
}
````

````
curl -vX POST "http://localhost:8080/stock/detail/no" -d @data.json --header "Content-Type: application/json"
````

4.Use `curl` to inert data into DB for stock info front `data.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/stock/detail/front" -d @data.json --header "Content-Type: application/json"
````

5.Use `curl` to inert data into DB for stock info back `data.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/stock/detail/back" -d @data.json --header "Content-Type: application/json"
````

6.Use `curl` to inert data into DB for stock smart watch `smartWatch.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/stock/smartWatch" -d @smartWatch.json --header "Content-Type: application/json"
````