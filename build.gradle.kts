plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
    id("io.freefair.lombok") version "8.11"
}

group = "org.sandbox"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.qameta.allure:allure-junit-platform:2.12.0")
    implementation("com.microsoft.playwright:playwright:1.48.0")
    implementation("com.github.automatedowl:allure-environment-writer:1.0.0")
    implementation("org.aeonbits.owner:owner:1.0.12")
    // Add SLF4J implementation to fix warning
    implementation("org.slf4j:slf4j-simple:2.0.12")
    // Add AspectJ runtime for Java 23 compatibility
    implementation("org.aspectj:aspectjrt:1.9.21")
    implementation("org.aspectj:aspectjweaver:1.9.21")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.release.set(11)
}

// Configure AspectJ for Java 23 compatibility
allure {
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                enabled.set(true)
            }
        }
    }
}
