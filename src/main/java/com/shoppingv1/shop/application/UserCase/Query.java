package com.shoppingv1.shop.application.UserCase;

import org.springframework.http.ResponseEntity;

public interface Query<TRequest, TResponse>{
    ResponseEntity<TResponse> handle(TRequest request);
}
