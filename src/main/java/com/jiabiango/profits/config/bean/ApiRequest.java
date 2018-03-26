package com.jiabiango.profits.config.bean;

public class ApiRequest {
    private String clientVersion;
    private Long timestamp;
    private String clientSystem;
    private String systemVersion;
    private String clientPlatform;
    private String clientIp;
    private String network;
    private String token;
    
    public String getClientVersion() {
        return clientVersion;
    }
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public String getClientSystem() {
        return clientSystem;
    }
    public void setClientSystem(String clientSystem) {
        this.clientSystem = clientSystem;
    }
    public String getClientPlatform() {
        return clientPlatform;
    }
    public void setClientPlatform(String clientPlatform) {
        this.clientPlatform = clientPlatform;
    }
    public String getClientIp() {
        return clientIp;
    }
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
    public String getNetwork() {
        return network;
    }
    public void setNetwork(String network) {
        this.network = network;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getSystemVersion() {
        return systemVersion;
    }
    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }
}