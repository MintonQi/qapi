package com.minton.qapi.client;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.util.DigestUtils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

public class QApiClient {
    private static final String BASE_URL = "http://localhost:8080";
    private final String apiKey;
    private final String apiSecret;

    public QApiClient(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public HttpResponse sendRequest(String method, String finalUrl, String body) {
        if (method == null || method.isEmpty()) {
            throw new IllegalArgumentException("HTTP方法不能为空");
        }

        String fullUrl = BASE_URL + finalUrl;

        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = UUID.randomUUID().toString();

        Map<String, String> headers = new HashMap<>();
        headers.put("api_key", apiKey);
        headers.put("timestamp", String.valueOf(timestamp));
        headers.put("nonce", nonce);
        headers.put("signature", generateSignature(body));

        // 根据方法发送请求
        HttpRequest request = switch (method.toUpperCase()) {
            case "GET" -> HttpRequest.get(fullUrl + "?" + body);
            case "POST" -> HttpRequest.post(fullUrl).body(body, "application/json");
            case "PUT" -> HttpRequest.put(fullUrl).body(body, "application/json");
            case "DELETE" -> {
                HttpRequest deleteRequest = HttpRequest.delete(fullUrl);
                if (!body.isEmpty()) {
                    deleteRequest.setUrl(fullUrl + "?" + body);
                }
                yield deleteRequest;
            }
            default -> throw new IllegalArgumentException("不支持的HTTP方法: " + method);
        };
        return request.addHeaders(headers).timeout(5000).execute();
    }
    private String generateSignature(String body) {
        Map<String, Object> params = JSONUtil.parseObj(body);
        String sortedParams = params.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(e -> e.getKey() + "=" + e.getValue())
            .collect(Collectors.joining("&"));
        return DigestUtils.md5DigestAsHex((sortedParams + apiSecret).getBytes());
    }

}
