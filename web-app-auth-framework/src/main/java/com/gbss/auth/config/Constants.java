package com.gbss.auth.config;

/**
 * Created by Akshay Misra on 14-11-2018.
 */
public interface Constants {

    long ACCESS_TOKEN_VALIDITY_SECONDS = 60*60;
    String SIGNING_KEY = "rocky123bss";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    String AUTHORITIES_KEY = "scopes";
}
