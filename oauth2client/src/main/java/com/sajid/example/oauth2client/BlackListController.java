package com.sajid.example.oauth2client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
@PropertySource("classpath:application.properties")
@RestController
@RequestMapping("/api/data")
public class BlackListController {


	@Autowired
	OAuth2AuthorizedClientManager clientManager;
	
	@GetMapping("/get")
	public void getBlackList() {
		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("dc").principal("sajid").build();
        OAuth2AuthorizedClient authorizedClient = this.clientManager.authorize(authorizeRequest);
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        
        String token ="Bearer "+accessToken.getTokenValue();

        
		WebClient.
		create().
		get().
		uri("").
				/* attributes(oauth2AuthorizedClient(authorizedClient)). */
		header("Authorization", token).
		retrieve()
				.bodyToMono(String.class).block();
        
		System.out.println(accessToken.getTokenValue());

	}
	
}
