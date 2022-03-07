package com.sajid.example.oauth2client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthenticatedPrincipalOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OAuth2LoginConfig {
	
	@Value("${spring.security.oauth2.client.provider.dc.token-uri}")
	private String tokenUri;
	@Value("${spring.security.oauth2.client.registration.dc.client-id}")
	private String clientId;
	@Value("${spring.security.oauth2.client.registration.dc.client-secret}")
	private String clientSecret;
	@Value("${spring.security.oauth2.client.registration.dc.scope}")
	private String scope;
	
	   @Bean
	    public ClientRegistrationRepository clientRegistrationRepository() {
	        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
	    }

	    private ClientRegistration googleClientRegistration() {
	        return ClientRegistration.withRegistrationId("dc")
	            .clientId(clientId)
	            .clientSecret(clientSecret)
	            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
	            .scope(scope)
	            .tokenUri(tokenUri).clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)	            
	            .build();
	    }
	    
	    @Bean
	    public OAuth2AuthorizedClientManager authorizedClientManager(
	            ClientRegistrationRepository clientRegistrationRepository,
	            OAuth2AuthorizedClientRepository authorizedClientRepository) {

	        OAuth2AuthorizedClientProvider authorizedClientProvider =
	                OAuth2AuthorizedClientProviderBuilder.builder()
//	                        .authorizationCode()
//	                        .refreshToken()
	                        .clientCredentials()
//	                        .password()
	                        .build();

	        DefaultOAuth2AuthorizedClientManager authorizedClientManager =
	                new DefaultOAuth2AuthorizedClientManager(
	                        clientRegistrationRepository, authorizedClientRepository);
	        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

	        return authorizedClientManager;
	    }
	    
	    @Bean
	    public OAuth2AuthorizedClientService authorizedClientService(
	            ClientRegistrationRepository clientRegistrationRepository) {
	        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
	    }

	    @Bean
	    public OAuth2AuthorizedClientRepository authorizedClientRepository(
	            OAuth2AuthorizedClientService authorizedClientService) {
	        return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(authorizedClientService);
	    }
	    
	    @Bean
	    WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
	        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client =
	                new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
	        oauth2Client.setDefaultClientRegistrationId("dc");
	        return WebClient.builder()
	                .apply(oauth2Client.oauth2Configuration())
	                .build();
	    }
}
