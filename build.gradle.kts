

plugins {
    id 'java'
    id 'maven-publish'
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'com.squareup.okhttp3:okhttp:4.10.0'
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}

group = 'com.plugish.woominecraft'
version = '1.5.0-1.19.3'
description = 'WooMinecraft'

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

publishing {
    publications {
        maven(MavenPublication) {
            from(components.java)
        }
    }
}
processResources {
    filteringCharset "UTF-8"

    filesMatching("plugin.yml") {
        expand (
                "mainClass": mainClass,
                "project": project
        )
    }
}
jar {
}

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}
