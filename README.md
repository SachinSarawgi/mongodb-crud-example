# mongodb-crud-example
Spring Boot with MongoDB CRUD Example

List of API's
Note the _id present in some JSON may vary in your machine.
GET API
curl -X GET \
  http://localhost:8080/orders/2 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 66c75a9b-f8ab-ea7f-edd7-9939e852daa2'
 
POST API
curl -X POST \
  http://localhost:8080/orders/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 39c96588-b221-1fce-b16e-04e065066839' \
  -d '{
    "orderId": 22,
    "orderDate": "2013-07-25 00:00:00.0",
    "orderCustomerId": 2711,
    "orderStatus": "PENDING",
    "orderItems": [
        {
            "orderItemId": 64,
            "orderId": 22,
            "productId": 897,
            "quantity": 3,
            "subtotal": 74.97,
            "productPrice": 24.99
        }
    ]
}'

PUT API
curl -X PUT \
  http://localhost:8080/orders/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 6e6c2d4f-ad06-b9ad-d340-83d003b64c08' \
  -d '{
	"_id": "5c45af8ee6b3215914777085",
    "orderId": 21,
    "orderDate": "2013-07-26 00:00:00.0",
    "orderCustomerId": 2711,
    "orderStatus": "PENDING",
    "orderItems": [
        {
        	"_id": "5c45af8ee6b3215914777086",
            "orderItemId": 64,
            "orderId": 21,
            "productId": 898,
            "quantity": 3,
            "subtotal": 74.97,
            "productPrice": 24.99
        }
    ]
}'

DELETE API
curl -X DELETE \
  http://localhost:8080/orders/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 996cf6b5-3e5e-356d-807a-ee9f3fb6b304'
