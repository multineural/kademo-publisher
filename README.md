# kademo-publisher

notes:
- first run this and wait for about 30 seconds
`docker-compose up -d`

- To create the topic on a new container (should only need to run this once) `docker-compose exec kafka1  \
kafka-topics --create --topic DIA_TEST --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:2181
`

- To get the name of the containers: `docker-compose ps`

- Then run this where the value after `--user root` should match the name of the kafka1 container from above. `docker exec -t -i --user root kademo-publisher_kafka1_1 /bin/bash`

- `cd /usr/bin`

- `kafka-console-consumer --bootstrap-server localhost:9091 --topic DIA_TEST --new-consumer --from-beginning --max-messages 4200`
