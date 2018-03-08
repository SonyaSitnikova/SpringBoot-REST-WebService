# SpringBoot-REST-WebService
To run the sample, follow these steps:

in Terminal :

`$ sudo -i -u postgres`

`$ psql`



in Intellij Idea :

`$ mvn package`

`$ mvn spring-boot:run`



in Terminal :

`$ curl "http://localhost:8080/items"` - Get List

`$ curl -v -H "Content-Type: application/json" \
   -d '{ "name": "new" }' "http://localhost:8080/items"` - Post new Item

`$ curl "http://localhost:8080/items/1"` - Get Item

`$ curl -v -X PUT -H "Content-Type: application/json" \
   -d '{ "name": "updated" }' "http://localhost:8080/items/1"` - Update Item

`$ curl -v -X PUT -H "Content-Type: application/json" \
   -d '{ "name": "updated" }' "http://localhost:8080/items/1"` - Delete Item