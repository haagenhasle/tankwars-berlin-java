# Java Tank for Serverless workshop

This example demonstrates how to setup a simple tankwars tank for the Serverless workshop using Java. 

To make any of this work, you need AWS credentials. [Read this](https://serverless.com/framework/docs/providers/aws/guide/credentials/) and do as it tells you!

If running serverless deploy doesn't work, it might be that you need to add some IAM permissions in AWS. Take a look at the instructions for setting up [claudiajs](https://claudiajs.com/tutorials/installing.html), it explains how to do this and what is needed. (Claudiajs ~= serverless in functionality, so the instructions probably apply to serverless as well..) 

When you are ready to run a tank wars match, go [here](https://tankwars.serverless.camp/pages/match.html) to start a match!

## Build

It is required to build prior to deploying. You can build the deployment artifact using Gradle or Maven.

### Gradle

In order to build using Gradle simply run

```bash
gradle wrapper # to build the gradle wrapper jar
./gradlew build # to build the application jar
```

The expected result should be similar to:

```bash
Starting a Gradle Daemon, 1 incompatible Daemon could not be reused, use --status for details
:compileJava
:processResources
:classes
:jar
:assemble
:buildZip
:compileTestJava UP-TO-DATE
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
:test UP-TO-DATE
:check UP-TO-DATE
:build

BUILD SUCCESSFUL

Total time: 8.195 secs
```

### Maven

In order to build using Maven simply run

```bash
mvn package
```

Note: you can install Maven with

1. [sdkman](http://sdkman.io/) using "sdk install maven" (yes, use as default)
2. sudo apt-get install mvn
3. brew install maven

If you use Maven to build, then in `serverless.yml` you have to replace

```yaml
package:
  artifact: build/distributions/aws-java-tank.zip
```
by
```yaml
package:
  artifact: target/aws-java-tank.jar
```
before deploying.

## Deploy

After having built the deployment artifact using Gradle or Maven as described above you can deploy by simply running

```bash
serverless deploy
```

The expected result should be similar to:

```bash
Serverless: Creating Stack...
Serverless: Checking Stack create progress...
.....
Serverless: Stack create finished...
Serverless: Uploading CloudFormation file to S3...
Serverless: Uploading service .zip file to S3 (1.83 MB)...
Serverless: Updating Stack...
Serverless: Checking Stack update progress...
.........................................................
Serverless: Stack update finished...
Service Information
service: aws-java-tank
stage: dev
region: us-east-1
api keys:
  None
endpoints:
  GET - https://XXXXXXX.execute-api.us-east-1.amazonaws.com/dev/tank/info
  POST - https://XXXXXXX.execute-api.us-east-1.amazonaws.com/dev/tank/command
functions:
  info: aws-java-tank-dev-info
  command: aws-java-tank-dev-command

```

## Usage

You can now invoke the Lambda function directly and even see the resulting log via

```bash
serverless invoke --function info --log
```

The expected result should be similar to:

```bash
{
    "statusCode": 200,
    "body": "{\"name\":\"Hågens tank\",\"owner\":\"Hågen\"}",
    "headers": {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Credentials": "true",
        "X-Powered-By": "AWS Lambda & Serverless",
        "Content-Type": "application/json"
    },
    "isBase64Encoded": false
}
--------------------------------------------------------------------
START RequestId: XXXXXXX Version: $LATEST
2017-03-17 12:48:19 <XXXXXXX> INFO  com.knowit.berlin.InfoHandler:18 - received: {}
END RequestId: XXXXXXX
REPORT RequestId: XXXXXXX Duration: 19.74 ms  Billed Duration: 100 ms   Memory Size: 1024 MB  Max Memory Used: 57 MB  
```

Finally you can send an HTTP request directly to the endpoint using a tool like curl

```bash
curl https://XXXXXXX.execute-api.us-east-1.amazonaws.com/dev/tank/info
```

The expected result should be similar to:

```bash
{"message": "Hello, the current time is Wed Jan 04 23:44:37 UTC 2017"}%  
```

