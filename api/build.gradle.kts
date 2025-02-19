plugins {}

version = "0.0.1"

dependencies {
    // spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")

    implementation(project(":domain"))

    implementation("io.springfox:springfox-boot-starter:3.0.0")

    // Mock처리를 하는 의존성(kotlin의 test framework)
    implementation("io.mockk:mockk:1.12.0")
    // test code에서의 DB connection(외부 말고 인메모리 DB 테스트)
    runtimeOnly("com.h2database:h2")
}