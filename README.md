# Saga Participant

A saga participant provider for Java 17+. It is used to standardize the interaction between the orchestrator and the saga participants. 
It is recommended to use the `com.github.avor42:saga-orchestrator:2.0.0` library within the orchestrator service.

## 1. Include to project

### Maven
```xml
<repositories>
    <repository>
        <id>github-pages-maven</id>
        <url>https://avor42.github.io/java-libs/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.avor42</groupId>
        <artifactId>saga-participant</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### Gradle
By Kotlin DSL:
```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://avor42.github.io/java-libs/")
    }
}

dependencies {
    implementation("com.github.avor42:saga-participant:1.0.0")
}
```

By Groovy DSL:
```groovy
repositories {
    mavenCentral()
    maven {
        url = uri("https://avor42.github.io/java-libs/")
    }
}

dependencies {
    implementation "com.github.avor42:saga-participant:1.0.0"
}
```

## 2. Usage example

Coming soon...
in next versions