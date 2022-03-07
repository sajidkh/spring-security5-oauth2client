package com.sajid.example.oauth2client.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.reactive.function.client.WebClient;

//
//@Configuration
//@PropertySource("classpath:application.properties")
//@OAuth2ClientSecurityMarker
public class WebClientConfig {
	
//	@Value("${spring.security.oauth2.client.provider.dc.token-uri}")
//	private String tokenUri;
//	@Value("${spring.security.oauth2.client.registration.dc.client-id}")
//	private String clientId;
//	@Value("${spring.security.oauth2.client.registration.dc.client-secret}")
//	private String clientSecret;
//	@Value("${spring.security.oauth2.client.registration.dc.scope}")
//	private String scope;
//
//	private static List<String> clients = Arrays.asList("google", "facebook","dc");
//	
////	@Bean
////	WebClient webClient(ClientRegistration clientRegistrations) {
////		
////		
////		return WebClient.builder().build();
////		
////		
////	    
////	}
//	
//	@Bean("cr")
//	ClientRegistration getRegistration() {
//        ClientRegistration registration = ClientRegistration
//                .withRegistrationId("dc")
//                .tokenUri(tokenUri)
//                .clientId(clientId)
//                .clientSecret(clientSecret).scope(scope)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .build();
//        return registration;
//    }
//	
//	@Bean
//	WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
//	    ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client =
//	            new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
//	    oauth2Client.setDefaultClientRegistrationId("dc");
//	    return WebClient.builder()
//	            .apply(oauth2Client.oauth2Configuration())
//	            .build();
//	}
//	
//	   @Bean
//	    public ClientRegistrationRepository clientRegistrationRepository() {
//	        List<ClientRegistration> registrations = clients.stream()
//	          .map(c -> getRegistration())
//	          .filter(registration -> registration != null)
//	          .collect(Collectors.toList());
//	        
//	        return new InMemoryClientRegistrationRepository(registrations);
//	    }
//	
////	@Bean
////	public OAuth2AuthorizedClientManager authorizedClientManager( ClientRegistrationRepository clientRegistrationRepository,OAuth2AuthorizedClientRepository authorizedClientRepository) {
////
////		OAuth2AuthorizedClientProvider authorizedClientProvider =
////	            OAuth2AuthorizedClientProviderBuilder.builder()
////	                    .clientCredentials()
////	                    .build();
////
////		
////	    DefaultOAuth2AuthorizedClientManager authorizedClientManager =
////	            new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,authorizedClientRepository);
////	    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
////
////	    return authorizedClientManager;
////	}	
//	
//
//	
////	
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////	    http.authorizeRequests().anyRequest().authenticated()
////	      .and()
////	      .oauth2Login()
////	      .clientRegistrationRepository(clientRegistrationRepository())
////	      .authorizedClientService(authorizedClientService());
////	}
//
////	@Bean
////	public OAuth2AuthorizedClientService authorizedClientService() {
////	    return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
////	}

	
}