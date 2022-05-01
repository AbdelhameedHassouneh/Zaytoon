docker-compose up -d
sleep 60
docker exec -i  backend  mysql --user="backend" --database="backend" --password="backend" < ddl.sql
