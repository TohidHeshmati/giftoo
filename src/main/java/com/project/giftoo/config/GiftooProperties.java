package com.project.giftoo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter @Getter
@RequiredArgsConstructor
@ConfigurationProperties("giftoo")
public class GiftooProperties {
    /**
     * active profile indicator
     */
    private String activeProfiles = "{name of active profile}";
}
