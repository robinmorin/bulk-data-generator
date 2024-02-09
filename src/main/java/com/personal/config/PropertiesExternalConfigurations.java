package com.personal.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Slf4j
@Configuration
public class PropertiesExternalConfigurations {

    @Bean
    public BankDataExternalDefinition bankDataExternalDefinitions() {
        try {
            File file = ResourceUtils.getFile("classpath:config-data-external-definitions.json");
            return new ObjectMapper().readValue(file, new TypeReference<>(){});
        } catch (Exception e) {
            log.error("External Definitions is not loaded!!!");
            return new BankDataExternalDefinition(new ArrayList<>());
        }
    }

    @Bean
    public Manager getManager(BankDataExternalDefinition externalDefinitions){
        return new Manager(externalDefinitions.getExternalDefinitions());
    }

    @RequiredArgsConstructor
    public static class Manager {
        private final List<BankDataExternalDefinition.Convenio> externalDefinitions;

        public BankDataExternalDefinition.Convenio getBankDataExternalDefinition(String identification){
            return  externalDefinitions.stream()
                    .filter(Objects::nonNull)
                    .filter(dataExternalDefinition -> dataExternalDefinition.cnpj().equals(identification))
                    .findAny().orElseThrow(()-> new RuntimeException("Not exists this identification in BankDataExternalDefinition."));
        }
    }

}