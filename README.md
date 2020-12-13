# kademo-publisher

notes:
- first run this and wait for about 30 seconds
`docker-compose up -d`

- To create the topic on a new container (should only need to run this once)
`docker-compose exec broker kafka-topics --create --topic DIA_TEST --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181`


- To get the name of the containers: `docker-compose ps`

- This: `docker-compose exec broker bash`

- `cd /usr/bin`

- This is a quick, optional test to make sure kafka is working. The alternative is to skip this step and run the spring-boot application and watch the messages come in with the command in the next step... `kafka-console-producer --bootstrap-server broker:9092 --topic DIA_TEST` Then enter a few typed messages and end the session with ctrl-c

- Then use this to watch messages come in to the topic! `kafka-console-consumer --bootstrap-server broker:9092 --topic DIA_TEST --from-beginning`

