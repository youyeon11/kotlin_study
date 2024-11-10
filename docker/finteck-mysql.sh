docker run -d \
--name fintech-mysql \
-e MYSQL_ROOT_PASSWORD="mysql" \
-e MYSQL_USER="root" \
-e MYSQL_PASSWORD="fintech" \
-e MYSQL_DATABASE="fintech" \
-p 3307:3306 \
mysql:latest
