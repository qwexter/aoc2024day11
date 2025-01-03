plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.benchmark)
}

group = "xyz.qwexter"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.benchmark)
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.params)
}

sourceSets {
    create("benchmark")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
    target {
        compilations.getByName("benchmark")
            .associateWith(compilations.getByName("main"))
    }
}

benchmark {
    targets {
        register("benchmark")
    }
}