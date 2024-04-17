# Scala - Spark

## Important Links

Links:
- [The Scala home page](https://www.scala-lang.org/)
- [Scala documentation](https://docs.scala-lang.org/)
- [Spark documentation](https://spark.apache.org/docs/latest/)
- [Maven repository for Spark](https://mvnrepository.com/artifact/org.apache.spark)
- [Scala tour webpage](https://docs.scala-lang.org/tour/tour-of-scala.html)

## What is Scala?

Scala is a modern multi-paradigm programming language designed to express common programming patterns in a concise, elegant, and type-safe way. It smoothly integrates features of object-oriented and functional languages.

### Key Points:
- Scala code compiles to Java bytecode that can run on any Java Virtual Machine (JVM)
- Scala supports object-oriented and functional programming
- Scala is statically typed -- that is, the compiler performs data type checking (unlike dynamically typed languages like Python)
- Created by Martin Odersky and first released in 2004

## What is Apache Spark?

Apache Spark is an open-source distributed general-purpose cluster-computing framework. Spark provides an interface for programming entire clusters with implicit data parallelism and fault tolerance.

### Key Points:
- Spark is written in Scala
- Spark is designed to cover a wide range of workloads such as batch applications, iterative algorithms, interactive queries, and streaming
- Spark is designed to be fast and general-purpose
- Spark is designed to run on a cluster of machines and can be accessed through its own shell

## Scala & Spark setup

To work with Scala and Spark, check the [Spark latest version](https://spark.apache.org/docs/latest/) and Scala version compatibility. At the moment of writing this document, the latest `Spark` version is `3.5.1` and it is compatible with `Scala` 2.12 and/or 2.13 and `Java` 8/11/17.

### SBT - Scala Build Tool

To work with Scala and Spark, you can use `SBT` as a build tool. SBT is a build tool for Scala, Java, and more.

Once created a new project, add the following dependencies to `build.sbt` file:

```scala
val sparkVersion = "3.5.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)
```

### VM Options

To run `Spark` with `Java` 17 you need to add the following VM options: 

```shell
--add-exports java.base/sun.nio.ch=ALL-UNNAMED
```

Add it to the configuration in the IDE.


## Programming with Scala & Spark

Download [Stock Market dataset](https://www.kaggle.com/datasets/jacksoncrow/stock-market-dataset) from Kaggle.

- [Get Started](src/main/scala/get/started/README.md)
