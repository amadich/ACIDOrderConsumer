# 1. System Master Plan (System Architecture)
<img width="1264" height="216" alt="image" src="https://github.com/user-attachments/assets/6b6906b9-dfb9-4c48-9147-9ccf43635007" />

```js

This chart shows:

The user sends the request
The order is distributed via Load Balancer
The API is verified by Redis
The request is sent to RabbitMQ

Worker processes the request and saves it in the database
```


# 2. Sequence Diagram
<img width="1280" height="957" alt="image" src="https://github.com/user-attachments/assets/c510f141-98be-4758-963d-c4b870af04b0" />

# 3. Activity Diagram
<img width="638" height="1199" alt="image" src="https://github.com/user-attachments/assets/0d248c8e-4423-4d8a-9460-0af4b06a7ce7" />

# 4. Deployment Diagram
<img width="1314" height="256" alt="image" src="https://github.com/user-attachments/assets/56fbfbdc-9f92-4cfc-83a6-764d313c61be" />
This diagram shows the horizontal expansion of the system.

# 5. Synchronization problem diagram (Concurrency)
<img width="1050" height="585" alt="image" src="https://github.com/user-attachments/assets/630ccc38-84cb-4ab9-914e-4c41b94e66e0" />



```js
These diagrams explain:

Architecture
Request Flow
Concurrency Handling
Queue Processing
Distributed Deployment
```

They are the same ideas used in large e-commerce systems.
