#wicket-foundation

Integrates [Apache Wicket](http://wicket.apache.org/) 7.x and [Zurb Foundation](http://foundation.zurb.com/) 5.x

<br>

## Build status and test coverage:

![Build status](https://travis-ci.org/iluwatar/wicket-foundation.svg?branch=master)
&nbsp;&nbsp;&nbsp;
[![Coverage Status](https://coveralls.io/repos/iluwatar/wicket-foundation/badge.png?branch=master)](https://coveralls.io/r/iluwatar/wicket-foundation?branch=master)

<br>

## Usage

Wicket-Foundation is available in the Sonatype Nexus. Add the following dependency to the project pom.xml:

```xml
<dependency>
    <groupId>com.iluwatar</groupId>
    <artifactId>wicket-foundation-core</artifactId>
    <version>0.0.1</version>
</dependency>
```

<br>

## Screenshot from the sample application (shows project progress status):

![alt text](https://github.com/iluwatar/wicket-foundation/blob/master/catalog.jpg "Samples catalog")



## Build instructions

```
mvn clean install
cd wicket-foundation-samples
mvn jetty:run
```
Now open browser and navigate to http://localhost:8080 to see the sample application.



## License

Wicket-foundation is distributed under the terms of the Apache Software Foundation
license, version 2.0. The text is included in the file LICENSE.md in the root
of the project.
