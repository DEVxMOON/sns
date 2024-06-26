package com.hr.sns.domain.auth.oauth.type

import com.hr.sns.exception.OAuthProviderNotFoundException
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class OAuthProviderConverter:Converter<String,OAuthProvider> {
    override fun convert(source: String): OAuthProvider {
        return runCatching {
            OAuthProvider.valueOf(source.uppercase())
        }.getOrElse {
            throw OAuthProviderNotFoundException("Provider not found")
        }
    }
}