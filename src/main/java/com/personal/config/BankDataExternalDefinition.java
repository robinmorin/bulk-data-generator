package com.personal.config;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class BankDataExternalDefinition {

    @JsonProperty("external-definitions")
    private List<Convenio> externalDefinitions;

    // TODO: Documento fala de 5 digitos para Agencia, evaluar trocar a Integer ou deixar o espaço em branco que fica depois
    // TODO: Documento fala de 12 digitos para Conta, lembrar que ele completa com espaços em branco

    public record Convenio(String cnpj, String nome, Integer contrato,
                           String agencia, @JsonAlias("agencia-digito") String agenciaDigito,
                           String conta, @JsonAlias("conta-digito") String contaDigito,
                           Integer carteira, Integer variacao) {

        public static final String CONVENIO_CONTRATO = "contrato";
        public static final String CONVENIO_CNPJ = "cnpj";
        public static final String CONVENIO_CARTEIRA = "carteira";
        public static final String CONVENIO_VARIACAO = "variacao";
        public static final String CONVENIO_AGENCIA = "agencia";
        public static final String CONVENIO_AGENCIA_DIGITO = "agenciaDigito";
        public static final String CONVENIO_CONTA = "conta";
        public static final String CONVENIO_CONTA_DIGITO = "contaDigito";
        public static final String CONVENIO_NOME = "nome";

        @JsonIgnore
        public <T> T getValueByFieldName(String fieldName){
            Map<String,T> mapValues = new ObjectMapper().convertValue(this, Map.class);
            return Optional.ofNullable(mapValues.get(fieldName)).orElse(null);
        }
    }

}
