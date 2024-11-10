rootProject.name = "fintech"
include("api")
include("api:consumer")
findProject(":api:consumer")?.name = "consumer"
include("gateway")
