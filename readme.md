to import this library in your maven project

    <dependencies>
        <dependency>
            <groupId>org.revo</groupId>
            <artifactId>RevoWebSocket</artifactId>
            <version>0.1.RELEASE</version>
        </dependency>
    </dependencies>
    <repositories>
        <repository>
            <id>ashraf</id>
            <url>http://dl.bintray.com/ashraf/maven</url>
        </repository>
    </repositories>


simple example to use this library to send and receive from WebSocket 


        RevoWebSocket revoWebSocket = new RevoWebSocket("localhost:8080/hello", "revo", "revo");
        revoWebSocket.Connect();
        if (revoWebSocket.isConnected()) {
            revoWebSocket.subscribe("/user/topic/greetings", new RevoStompHandler<>(Message.class, m ->
                    System.out.println(m.getContent())
            ));
            revoWebSocket.send("/app/hello", new Message("lovex"));
            Thread.sleep(100);
        }
