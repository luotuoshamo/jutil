![](https://github.com/topicstudy/files/blob/main/img/logo/logo-jutil.png?raw=true)

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://github.com/topicstudy/jutil/blob/master/LICENSE)

[![maven](https://img.shields.io/maven-central/v/io.github.topicstudy/jutil.svg?style=flat-square)](https://search.maven.org/search?q=g:io.github.topicstudy%20AND%20a:jutil)

## What is Jutil?

Jutil aggregates code for utility commonly used in Java development, including text processing, date processing, common model definitions, and more, eliminating common code in multiple projects.

## Links

- [Documentation](https://topicstudys-organization.gitbook.io/open-source-doc/jutil)
- [Samples](https://github.com/topicstudy/jutil/tree/master/src/test/java/cn/topicstudy/jutil)

## Features

-   Commonly used text, number, date, time, collection,  and more processing.
-   The commonly used result model is defined, see CommonResult.
-   A good error code and exception management mode, see CommonAssertUtil.
-   A lightweight implementation of validating fields with annotations, see FieldConstraintValidator.
-   Obtain hardware resource information about the host, see DiskUtil and MemoryUtil.

## Getting started

- Add jutil dependency

  - Latest Version: [![maven](https://img.shields.io/maven-central/v/io.github.topicstudy/jutil.svg?style=flat-square)](https://search.maven.org/search?q=g:io.github.topicstudy%20AND%20a:jutil)

  - Maven:

    ```xml
    <dependency>
        <groupId>io.github.topicstudy</groupId>
        <artifactId>jutil</artifactId>
        <version>Latest Version</version>
    </dependency>
    ```

  - Gradle

    ```groovy
    compile group: 'io.github.topicstudy', name: 'jutil', version: 'Latest Version'
    ```

- Find the required tool class (either through documentation or through code): 

  such as StringUtil
  
- Use it

  -  Determine whether the name of the item is empty: 
  
  ``` java
  if (StringUtil.isBlank(itemName)) {
      
  }
  ```

  - Determines whether the price is a numeric value, to determine whether the user input is valid

    ```
    if(!StringUtil.isNumber(price)){
       thr Exception
    }
    ```
  
    

> This showcase is just one part of jutil features. If you want to learn more, please refer to the [documentation](https://topicstudys-organization.gitbook.io/open-source-doc/jutil).

## License

Jutil is under the Apache 2.0 license. See the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0) file for details.
