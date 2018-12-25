package br.com.virtualstore.virtualstoresecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	
	
	private String clientId = "virtualstoresecurity";
	private String clientSecret = "my-secret";
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\r\n"+
			"MIICWwIBAAKBgQDCdtFy4CN2SNsX7QMTpbeH+ra9VyQ7GOTfm2u4gpK4wokaWXGy\r\n"+
			"B9Ws2XLVpaYORMpFQXG0Cpt+R3lXS2eixbFfxnNeyosluEWetuuXBfzuENW/IvQu\r\n"+
			"h5JwevH/v15idYye5t6PSu6L9mZLs9qhPBk6GSbNZSL2Ukxkx0YGhmCXkwIDAQAB\r\n"+
			"AoGAexA6aBpUFszwaenB4rMivFj7QENfWE7euGtg9jkbpPTnUtd7zhCLNoG93Fqi\r\n"+
			"BbGe18kcrbVwxa9xqL69bRLytfEcjFeT/pk6MlUTIxATOyRDkvmnS2He+VxoOasr\r\n"+
			"dQMrxKSb3Fg/lp2fpFCeEUF2+NxxXpO1cqC4t3p+fCgoOvECQQDlXBl60JOY9nb3\r\n"+
			"FI8rFtlwhZABx949SN5VVdElLzbS6hFpYAggdCOslUet+ywnCvUYopkBM9a2aj4t\r\n"+
			"tmzoGl+HAkEA2Q0dNr2CASIGPKoU1amhrAMOhMWFppoKd0Z+jYLhn2VPVJRcTZmv\r\n"+
			"OmIukyj19JlfNtiAwBoxghxkxkmTIhSSlQJAEoxkMx5zEUe9TzYGbgGnDAaBIuO7\r\n"+
			"AVHHSTdrdope8KelSNRPU/CQggCAj31kkLO+JoPfw80hbBcjeCbsn8iiOQJACD8h\r\n"+
			"TwUgPV7HkeJ8bCnHxLtQ/+ZpT40mvKVnBYVlgSLeQr5oS2J9b+BvGJRD1AlHvtO3\r\n"+
			"AJV+MA1YHtiIyJCziQJAH1DZo83sYTZfM5ae2/cghRnQVDJT5YOJjxXTqZKQcp0O\r\n"+
			"hXjxUu6gO1aLmbba8eH6knKVpLHH34e0G6Yomz5RvQ==\r\n"+
			"-----END RSA PRIVATE KEY-----";
	
	private String publicKey = "public-key";
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}


	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient(clientId).secret(clientSecret).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
				.refreshTokenValiditySeconds(20000);

	}


}
