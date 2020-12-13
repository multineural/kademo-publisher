# kademo-publisher

notes:
docker-compose up -d

docker-compose exec kafka  \
kafka-topics --create --topic DIA_TEST --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:2181
