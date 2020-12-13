# kademo-publisher

notes:
- first run this and wait for about 30 seconds
`docker-compose up -d`

- To create the topic on a new container (should only need to run this once)
`docker-compose exec broker kafka-topics --create --topic DIA_TEST --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181`


- To get the name of the containers: `docker-compose ps`

- This: `docker-compose exec broker bash`

- `cd /usr/bin`

- `kafka-console-producer --bootstrap-server broker:9092 --topic DIA_TEST`

- `kafka-console-consumer --bootstrap-server broker:9092 --topic DIA_TEST --from-beginning`
