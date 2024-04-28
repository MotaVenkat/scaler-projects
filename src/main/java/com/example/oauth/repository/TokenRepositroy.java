package com.example.oauth.repository;

import com.example.oauth.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepositroy extends JpaRepository<Token,Long> {
}
