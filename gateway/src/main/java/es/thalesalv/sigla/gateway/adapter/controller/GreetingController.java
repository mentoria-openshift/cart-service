package es.thalesalv.sigla.gateway.adapter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/auth/data")
    public Map<String, Map<String, String>> authData(@AuthenticationPrincipal OidcUser oidcUser,
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client) {

        Map<String, String> userData = new HashMap<>();
        userData.put("username", oidcUser.getPreferredUsername());
        userData.put("email", oidcUser.getEmail());
        userData.put("fullName", oidcUser.getFullName());

        Map<String, String> tokens = new HashMap<>();
        tokens.put("idToken", oidcUser.getIdToken().getTokenValue());
        tokens.put("accessToken", client.getAccessToken().getTokenValue());

        Map<String, Map<String, String>> authData = new HashMap<>();
        authData.put("userData", userData);
        authData.put("tokens", tokens);
        return authData;
    }
}
