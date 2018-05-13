# How to run the App

Go to terminal and run java -jar target/email-service-0.0.1-SNAPSHOT.jar

# How to test the App

1. App will run at http://localhost:8080/
2. Use Postman to make POST to http://localhost:8080/rest/email/send with the following body

```
{
  "from": "xxx@xxx.com",
  "to": [
    "sendon1982@gmail.com"
  ],
  "cc": [
    "mjiang@tripadvisor.com"
  ],
  "bcc": [
    "mjiang@viator.com"
  ],
  "subject": "This is subject",
  "body": "This is body"
}
```

3. If response is 200, then email sending is successful.


# TODO list if more time allowed
1. I would build 4 web service, one as central control service to route all the requests, one registry service to record 
available email service list, register or remove from the list based on the situation and two email services to serve the 
coming request. In this way, we can easily add or remove email services dynamically via registry service lookup.

2. Each Email Service should be a separated web service which will communicate with the remote third party email service provider 
such as SendGrid and MailGun.

3. Add a health between email service to remote service provider to add or remove email services in good or bad status.

4. Add more tests