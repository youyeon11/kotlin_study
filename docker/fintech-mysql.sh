docker run -d \
--name fintech-mysql \
-e MYSQL_ROOT_PASSWORD="tkfkdgo2001!" \
-e MYSQL_USER="root" \
-e MYSQL_DATABASE="fintech" \
-p 3306:3306 \
mysql:latest