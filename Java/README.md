# Gilded Rose starting position in Java

## Run the TextTest Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

You should make sure the gradle commands shown above work when you execute them in a terminal before trying to use TextTest (see below).


## Run the TextTest approval test that comes with this project

There are instructions in the [TextTest Readme](../texttests/README.md) for setting up TextTest. What's unusual for the Java version is there are two executables listed in [config.gr](../texttests/config.gr) for Java. The first uses Gradle wrapped in a python script. Uncomment these lines to use it:

    executable:${TEXTTEST_HOME}/Java/texttest_rig.py
    interpreter:python

The other relies on your CLASSPATH being set correctly in [environment.gr](../texttests/environment.gr). Uncomment these lines to use it instead:

    executable:com.gildedrose.TexttestFixture
    interpreter:java

## My approach

* Get 100% test coverage. - commit
* One by one create a private function for each item type, making sure tests continue passing along the way.  These were really code replacing.  I did not use refactoring tools or careful extraction techniques I just reimplemented the requirements.  I did so in a way that only one item type was broken at a time, so the noise of tests failing for all types wouldn't distract me. - commit
* Pull the quality boundary code into the main method so each private function can be simpler. - commit
* Create "handlers" that have a quality and sellIn function.  Create a handler for each item type in a Map by item name. - commit
