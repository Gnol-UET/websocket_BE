# Websocket Backend
### Framework - Project: Java Spring Boot
##### For Frontend please link to [Frontend](https://github.com/Gnol-UET/websocket_be).

Config:
> WebSocketConfig.java
```
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //Broker la dia chi tuong doi: no giong message mapping
        config.enableSimpleBroker("/topic/greetings");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Endpoint la dia chi tuong doi: no giong message mapping
        registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
    }

}

```

>

`configureMessageBroker`: enableSimpleBroker("Kênh quảng bá"): tạo kênh trung gian quảng bá tin nhắn  

`registerStompEndpoints`: registry.addEndpoint("endpoint"):  link mà server expose để sockJS chọc vào 

Stomp là một giao thức Simple text orienteated mesaging protocol  

Socket là nơi expose đường truyền, stompClient vận chuyển tin nhắn trên đường truyền này  

#
#

API:
> GreetingController.java
```
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting( message.getName());
    }
```
`@MesageMapping` giống `@RequestmMpping`, nếu tin nhắn đc gửi đến hello thì sẽ chuyển đến hàm greeting xử lý  

`@Sendto`  Kênh quảng bá, return tin nhắn đến những ai subscribe kênh ("topic/greetings") 
