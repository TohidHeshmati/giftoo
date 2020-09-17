package com.project.giftoo.config;

import com.project.giftoo.entities.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImplimentation implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication() == null)
            return Optional.of("username");

        return Optional.of(((User) SecurityContextHolder.getContext().getAuthentication()
                                    .getPrincipal()).getUsername());
    }
}
