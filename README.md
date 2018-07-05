# How to run the App
1. Go to terminal and run ```mvn clean package```

2. Run ```java -jar target/siteminder-0.0.1-SNAPSHOT.jar```

# How to test the App

1. App will run at http://localhost:8080/
2. Use Postman to make POST to `http://localhost:8080/broker/purchaseSummary` with the following body

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

3. Use `curl` to inert data into DB `data.json` where the json file on current path
````
curl -vX POST "http://localhost:8080/broker/purchaseSummary" -d @data.json --header "Content-Type: application/json"
````