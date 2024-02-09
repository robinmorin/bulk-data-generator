package com.personal.config;

import com.personal.fields.FieldCPFRandom;
import com.personal.fields.FieldConstant;
import com.personal.fields.FieldDataConvenio;
import com.personal.fields.FieldDateTime;
import com.personal.fields.FieldDecimal;
import com.personal.fields.FieldNumber;
import com.personal.fields.FieldNumberAutoIncrementable;
import com.personal.fields.FieldRandomDecimalNumberValue;
import com.personal.fields.FieldRandomPositional;
import com.personal.fields.FieldRandomPositionalPriority;
import com.personal.fields.FieldString;
import com.personal.fields.IField;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.personal.config.FieldNameDefinition.*;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class FieldsLineBlockDefinitions {

    public static final String PATTERN_DATE = "DDMMYYYY";
    public static final String PATTERN_TIME = "HHmmss";
    public static final String CLIENTE = "CLIENTE TESTE ";
    public static final String ENDERECO = "ENDERECO DO CLIENTE DE TESTE";
    public static final String BAIRRO = "BAIRRO TESTE";
    public static final String CEP_PREFIX = "01000";
    public static final String CEP_SUFFIX = "000";
    public static final String CIDADE = "SAO PAULO";
    public static final String UF = "SP";

    public static List<IField<?>> getIFieldByHeaderFileOut() {
        LinkedList<IField<?>> fieldsHeaderFileOut = new LinkedList<>();
        fieldsHeaderFileOut.add(new FieldNumber(CODIGO_BANCO_COMPENSACAO,1, 3, 1L));
        fieldsHeaderFileOut.add(new FieldConstant<>(LOTE_SERVICO,4, 7, 0));
        fieldsHeaderFileOut.add(new FieldConstant<>(TIPO_REGISTRO,8, 8, 0));
        fieldsHeaderFileOut.add(new FieldConstant<>(FEBRABAN_CNAB,9, 17, ""));
        fieldsHeaderFileOut.add(new FieldConstant<>(TIPO_INSCRICAO_EMPRESA,18, 18, 2));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(NRO_INSCRICAO_EMPRESA, 19, 32, BankDataExternalDefinition.Convenio.CONVENIO_CNPJ));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(NRO_CONVENIO_COBRANCA,33, 41, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
        fieldsHeaderFileOut.add(new FieldConstant<>(COBRANCA_CEDENTE,42, 45, 14));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(CARTEIRA_COBRANCA,46, 47, BankDataExternalDefinition.Convenio.CONVENIO_CARTEIRA));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(VARIACAO_CARTEIRA_COBRANCA,48, 50, BankDataExternalDefinition.Convenio.CONVENIO_VARIACAO));
        fieldsHeaderFileOut.add(new FieldConstant<>(CAMPO_RESERVADO,51, 52, ""));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(NRO_AGENCIA_MANTENEDORA,53, 57, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_AGENCIA_MANTENEDORA,58, 58, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA_DIGITO));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(NRO_CONTA_CORRENTE,59, 70, BankDataExternalDefinition.Convenio.CONVENIO_CONTA));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_CONTA_CORRENTE,71, 71, BankDataExternalDefinition.Convenio.CONVENIO_CONTA_DIGITO));
        fieldsHeaderFileOut.add(new FieldConstant<>(DIGITO_VERIFICADOR_AGENCIA_CONTA,72, 72, 0));
        fieldsHeaderFileOut.add(new FieldDataConvenio<>(NOME_EMPRESA,73, 102, BankDataExternalDefinition.Convenio.CONVENIO_NOME));
        fieldsHeaderFileOut.add(new FieldConstant<>(NOME_BANCO,103, 132, "BANCO DO BRASIL S.A."));
        fieldsHeaderFileOut.add(new FieldConstant<>(FEBRABAN_CNAB,133, 142, ""));
        fieldsHeaderFileOut.add(new FieldNumber(CODIGO_REMESSA_RETORNO,143, 143, 1L));
        fieldsHeaderFileOut.add(new FieldDateTime(DATA_GERACAO_ARQUIVO,144, 151, PATTERN_DATE));
        fieldsHeaderFileOut.add(new FieldDateTime(HORA_GERACAO_ARQUIVO,152, 157, PATTERN_TIME));
        fieldsHeaderFileOut.add(new FieldNumberAutoIncrementable(NRO_SEQUENCIAL_ARQUIVO,158, 163, 1L, 999999L));
        fieldsHeaderFileOut.add(new FieldConstant<>(VERSAO_LAYOUT_ARQUIVO,164, 166, 0));
        fieldsHeaderFileOut.add(new FieldConstant<>(DENSIDADE_GRAVACAO_ARQUIVO,167, 171, 0));
        fieldsHeaderFileOut.add(new FieldConstant<>(RESERVADO_BANCO,172, 191, ""));
        fieldsHeaderFileOut.add(new FieldConstant<>(RESERVADO_EMPRESA,192, 211, ""));
        fieldsHeaderFileOut.add(new FieldConstant<>(FEBRABAN_CNAB,212, 240, ""));


        return Collections.unmodifiableList(fieldsHeaderFileOut);
    }

    public static List<IField<?>> getIFieldByHeaderFileIn() {
        LinkedList<IField<?>> fieldsHeaderFileIn = new LinkedList<>();
        fieldsHeaderFileIn.add(new FieldNumber(CODIGO_BANCO_COMPENSACAO,1, 3, 1L));
        fieldsHeaderFileIn.add(new FieldNumberAutoIncrementable(LOTE_SERVICO,4, 7, 1L, 9999L));
        fieldsHeaderFileIn.add(new FieldNumber(TIPO_REGISTRO,8, 8, 1L));
        fieldsHeaderFileIn.add(new FieldConstant<>(FEBRABAN_CNAB,9, 17, ""));
        fieldsHeaderFileIn.add(new FieldConstant<>(TIPO_INSCRICAO_EMPRESA,18, 18, 2));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(NRO_INSCRICAO_EMPRESA, 19, 32, BankDataExternalDefinition.Convenio.CONVENIO_CNPJ));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(NRO_CONVENIO_COBRANCA,33, 41, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
        fieldsHeaderFileIn.add(new FieldConstant<>(COBRANCA_CEDENTE,42, 45, 14));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(CARTEIRA_COBRANCA,46, 47, BankDataExternalDefinition.Convenio.CONVENIO_CARTEIRA));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(VARIACAO_CARTEIRA_COBRANCA,48, 50, BankDataExternalDefinition.Convenio.CONVENIO_VARIACAO));
        fieldsHeaderFileIn.add(new FieldConstant<>(CAMPO_RESERVADO,51, 52, ""));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(NRO_AGENCIA_MANTENEDORA,53, 57, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_AGENCIA_MANTENEDORA,58, 58, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA_DIGITO));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(NRO_CONTA_CORRENTE,59, 70, BankDataExternalDefinition.Convenio.CONVENIO_CONTA));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_CONTA_CORRENTE,71, 71, BankDataExternalDefinition.Convenio.CONVENIO_CONTA_DIGITO));
        fieldsHeaderFileIn.add(new FieldConstant<>(DIGITO_VERIFICADOR_AGENCIA_CONTA,72, 72, 0));
        fieldsHeaderFileIn.add(new FieldDataConvenio<>(NOME_EMPRESA,73, 102, BankDataExternalDefinition.Convenio.CONVENIO_NOME));
        fieldsHeaderFileIn.add(new FieldConstant<>(NOME_BANCO,103, 132, "BANCO DO BRASIL S.A."));
        fieldsHeaderFileIn.add(new FieldConstant<>(FEBRABAN_CNAB,133, 142, ""));
        fieldsHeaderFileIn.add(new FieldNumber(CODIGO_REMESSA_RETORNO,143, 143, 0L));
        fieldsHeaderFileIn.add(new FieldDateTime(DATA_GERACAO_ARQUIVO,144, 151, PATTERN_DATE));
        fieldsHeaderFileIn.add(new FieldDateTime(HORA_GERACAO_ARQUIVO,152, 157, PATTERN_TIME));
        fieldsHeaderFileIn.add(new FieldNumberAutoIncrementable(NRO_SEQUENCIAL_ARQUIVO,158, 163, 1L, 999999L));
        fieldsHeaderFileIn.add(new FieldConstant<>(VERSAO_LAYOUT_ARQUIVO,164, 166, 0));
        fieldsHeaderFileIn.add(new FieldConstant<>(DENSIDADE_GRAVACAO_ARQUIVO,167, 171, 0));
        fieldsHeaderFileIn.add(new FieldConstant<>(RESERVADO_BANCO,172, 191, ""));
        fieldsHeaderFileIn.add(new FieldConstant<>(RESERVADO_EMPRESA,192, 211, ""));
        fieldsHeaderFileIn.add(new FieldConstant<>(FEBRABAN_CNAB,212, 240, ""));

        return Collections.unmodifiableList(fieldsHeaderFileIn);
    }

    public static List<IField<?>> getIFieldBySectionLote() {
        LinkedList<IField<?>> fieldsHeaderLote = new LinkedList<>();
        fieldsHeaderLote.add(new FieldConstant<>(CODIGO_BANCO_COMPENSACAO,1, 3, 1));
        fieldsHeaderLote.add(new FieldNumberAutoIncrementable(LOTE_SERVICO,4, 7, 1L, 9999L));
        fieldsHeaderLote.add(new FieldConstant<>(TIPO_REGISTRO,8, 8, 1));
        fieldsHeaderLote.add(new FieldConstant<>(TIPO_OPERACAO,9,9,"R"));
        fieldsHeaderLote.add(new FieldConstant<>(TIPO_SERVICO,10,11,0));
        fieldsHeaderLote.add(new FieldConstant<>(FEBRABAN_CNAB,12, 13, ""));
        fieldsHeaderLote.add(new FieldConstant<>(VERSAO_LAYOUT_LOTE,14,16,0));
        fieldsHeaderLote.add(new FieldConstant<>(FEBRABAN_CNAB,17, 17, ""));
        fieldsHeaderLote.add(new FieldConstant<>(TIPO_INSCRICAO_EMPRESA,18, 18, 2));
        fieldsHeaderLote.add(new FieldNumber(NRO_INSCRICAO_EMPRESA,19, 32, 0L));
        fieldsHeaderLote.add(new FieldDataConvenio<>(NRO_CONVENIO_COBRANCA,34, 42, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
        fieldsHeaderLote.add(new FieldConstant<>(COBRANCA_CEDENTE,43, 46, 14));
        fieldsHeaderLote.add(new FieldDataConvenio<>(CARTEIRA_COBRANCA,47, 48, BankDataExternalDefinition.Convenio.CONVENIO_CARTEIRA));
        fieldsHeaderLote.add(new FieldDataConvenio<>(VARIACAO_CARTEIRA_COBRANCA,49, 51, BankDataExternalDefinition.Convenio.CONVENIO_VARIACAO));
        fieldsHeaderLote.add(new FieldConstant<>(IDENTIFICACAO_REMESSA_TESTE,52, 53, "TS"));
        fieldsHeaderLote.add(new FieldDataConvenio<>(NRO_AGENCIA_MANTENEDORA,54, 58, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA));
        fieldsHeaderLote.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_AGENCIA_MANTENEDORA,59, 59, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA_DIGITO));
        fieldsHeaderLote.add(new FieldDataConvenio<>(NRO_CONTA_CORRENTE,60, 71, BankDataExternalDefinition.Convenio.CONVENIO_CONTA));
        fieldsHeaderLote.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_CONTA_CORRENTE,72, 72, BankDataExternalDefinition.Convenio.CONVENIO_CONTA_DIGITO));
        fieldsHeaderLote.add(new FieldConstant<>(DIGITO_VERIFICADOR_AGENCIA_CONTA,73, 73, 0));
        fieldsHeaderLote.add(new FieldDataConvenio<>(NOME_EMPRESA,74, 103, BankDataExternalDefinition.Convenio.CONVENIO_NOME));
        fieldsHeaderLote.add(new FieldConstant<>(MENSAGEM_1,104, 143, ""));
        fieldsHeaderLote.add(new FieldConstant<>(MENSAGEM_2,144, 183, ""));
        fieldsHeaderLote.add(new FieldNumberAutoIncrementable(NRO_REMESSA_RETORNO,184, 191, 1L, 99999999L));
        fieldsHeaderLote.add(new FieldDateTime(DATA_GRAVACAO_REMESSA_RETORNO,192, 199, PATTERN_DATE));
        fieldsHeaderLote.add(new FieldDateTime(DATA_CREDITO,200, 207, PATTERN_DATE));
        fieldsHeaderLote.add(new FieldConstant<>(FEBRABAN_CNAB,208, 240, ""));


        return Collections.unmodifiableList(fieldsHeaderLote);
    }

    public static List<IField<?>> getIFieldByTrailerLote() {
        LinkedList<IField<?>> fieldsTrailerLote = new LinkedList<>();
        fieldsTrailerLote.add(new FieldConstant<>(SIMPLE_CONSTANT,1, 3, 1));
        fieldsTrailerLote.add(new FieldConstant<>(CODIGO_BANCO_COMPENSACAO,4, 7, 1));
        fieldsTrailerLote.add(new FieldConstant<>(TIPO_REGISTRO,8, 8, 5));
        fieldsTrailerLote.add(new FieldConstant<>(SIMPLE_CONSTANT,9, 17, ""));
        fieldsTrailerLote.add(new FieldNumber(QTA_REGISTROS_LOTE,18, 23, 0L));
        fieldsTrailerLote.add(new FieldNumber(QTA_TITULO_COBRANCA_SIMPLES,24, 29, 0L));
        fieldsTrailerLote.add(new FieldDecimal(VALOR_TOTAL_TITULO_CARTEIRA_SIMPLES,30, 46, BigDecimal.ZERO));
        fieldsTrailerLote.add(new FieldNumber(QTA_TITULO_COBRANCA_CAUCIONADA,47, 52, 0L));
        fieldsTrailerLote.add(new FieldDecimal(VALOR_TOTAL_TITULO_CARTEIRA_CAUCIONADA,53, 69, BigDecimal.ZERO));
        fieldsTrailerLote.add(new FieldNumber(QTA_TITULO_COBRANCA_DESCONTADA,70, 75, 0L));
        fieldsTrailerLote.add(new FieldDecimal(QTA_TITULO_CARTEIRA_DESCONTADA,76, 92, BigDecimal.ZERO));
        fieldsTrailerLote.add(new FieldConstant<>(SIMPLE_CONSTANT,93, 115, 0));
        fieldsTrailerLote.add(new FieldConstant<>(SIMPLE_CONSTANT,116, 240, ""));

        return Collections.unmodifiableList(fieldsTrailerLote);
    }

    public static List<IField<?>> getIFieldByTrailerFile() {
        LinkedList<IField<?>> fieldsTrailerArquivo = new LinkedList<>();
        fieldsTrailerArquivo.add(new FieldConstant<>(CODIGO_BANCO_COMPENSACAO,1, 3, 1));
        fieldsTrailerArquivo.add(new FieldNumberAutoIncrementable(LOTE_SERVICO,4, 7, 1L, 9999L));
        fieldsTrailerArquivo.add(new FieldConstant<>(TIPO_REGISTRO,8, 8, 9));
        fieldsTrailerArquivo.add(new FieldConstant<>(SIMPLE_CONSTANT,9, 17, ""));
        fieldsTrailerArquivo.add(new FieldNumber(QTA_LOTES_ARQUIVO,18, 23, 0L));
        fieldsTrailerArquivo.add(new FieldNumber(QTA_REGISTROS_ARQUIVO,24, 29, 0L));
        fieldsTrailerArquivo.add(new FieldConstant<>(SIMPLE_CONSTANT,30, 35, 0));
        fieldsTrailerArquivo.add(new FieldConstant<>(SIMPLE_CONSTANT,36, 240, ""));

        return Collections.unmodifiableList(fieldsTrailerArquivo);
    }

    public static List<IField<?>> getSegmentP() {
        List<IField<?>> fieldsSegmentP = new LinkedList<>();
        fieldsSegmentP.add(new FieldNumber(CODIGO_BANCO_COMPENSACAO,1, 3, 1L));
        fieldsSegmentP.add(new FieldNumber(LOTE_SERVICO,4, 7, 1L));
        fieldsSegmentP.add(new FieldConstant<>(TIPO_REGISTRO,8, 8, 1));
        fieldsSegmentP.add(new FieldNumberAutoIncrementable(SEQUENCIAL_REGISTRO_LOTE,9, 13, 1L, 99999L));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_SEGMENTO_REGISTRO_DETALHE,14,14,"P"));
        fieldsSegmentP.add(new FieldConstant<>(FEBRABAN_CNAB,15, 15, ""));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_MOVIMENTO_REMESSA,16,17,"47"));
        fieldsSegmentP.add(new FieldDataConvenio<>(NRO_AGENCIA_MANTENEDORA,18, 22, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA));
        fieldsSegmentP.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_AGENCIA_MANTENEDORA,23, 23, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA_DIGITO));
        fieldsSegmentP.add(new FieldDataConvenio<>(NRO_CONTA_CORRENTE,24, 35, BankDataExternalDefinition.Convenio.CONVENIO_CONTA));
        fieldsSegmentP.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_CONTA_CORRENTE,36, 36, BankDataExternalDefinition.Convenio.CONVENIO_CONTA_DIGITO));
        fieldsSegmentP.add(new FieldConstant<>(DIGITO_VERIFICADOR_AGENCIA_CONTA,37, 37, 0));
        fieldsSegmentP.add(new FieldConstant<>(MODALIDADE_CARTEIRA_SINCO,38, 38, 2));
        fieldsSegmentP.add(new FieldConstant<>(MODALIDADE_CARTEIRA_SIGCB,39, 40, 25));
        fieldsSegmentP.add(new FieldDataConvenio<>(NOSSO_NUMERO,41, 47, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
        fieldsSegmentP.add(new FieldNumberAutoIncrementable(NOSSO_NUMERO_SEQ,48, 57, 1L, 9999999999L));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_CARTEIRA,58, 58, 7));
        fieldsSegmentP.add(new FieldConstant<>(FORMA_CADASTRO_TITULO_BANCO,59, 59, 0));
        fieldsSegmentP.add(new FieldConstant<>(TIPO_DOCUMENTO,60, 60, 0));
        fieldsSegmentP.add(new FieldConstant<>(IDENTIFICACAO_EMISSAO_BOLETO,61, 61, 3));
        fieldsSegmentP.add(new FieldConstant<>(IDENTIFICACAO_DISTRIBUICAO_ENTREGA_BOLETO,62, 62, 0));
        fieldsSegmentP.add(new FieldDataConvenio<>(NOSSO_NUMERO,63, 69, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
        fieldsSegmentP.add(new FieldNumberAutoIncrementable(NOSSO_NUMERO_SEQ,70, 79, 1L, 9999999999L));
        fieldsSegmentP.add(new FieldDateTime(DATA_VENCIMENTO_TITULO,80, 87, PATTERN_DATE,"P10D"));
        // Propagate to VALOR_ABATIMENTO - SEGMENT_P / VALOR_NOMINAL_TITULO - SEGMENT_T / VALOR_PAGO_PELO_SACADO - SEGMENT_U
        fieldsSegmentP.add(new FieldRandomDecimalNumberValue(VALOR_NOMINAL_TITULO,88, 102, BigDecimal.valueOf(5.0D), BigDecimal.valueOf(5000D)));
        fieldsSegmentP.add(new FieldConstant<>(AGENCIA_COBRADORA_RECEBEDORA,103, 107, 0));
        fieldsSegmentP.add(new FieldConstant<>(DIGITO_VERIFICADOR_AGENCIA_COBRADORA_RECEBEDORA,108, 108, ""));
        fieldsSegmentP.add(new FieldConstant<>(ESPECIE_TITULO,109, 110, 1));
        fieldsSegmentP.add(new FieldConstant<>(IDENTIFICACAO_TITULO_ACEITA_NAO_ACEITA,111, 111, "A"));
        fieldsSegmentP.add(new FieldDateTime(DATA_EMISSAO_TITULO,112, 119, PATTERN_DATE));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_JUROS_MORA,120, 120, 3));
        fieldsSegmentP.add(new FieldDateTime(DATA_JUROS_MORA,121, 128, PATTERN_DATE));
        fieldsSegmentP.add(new FieldDecimal(JUROS_MORA_POR_DIA,129, 143, BigDecimal.valueOf(2.1D)));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_DESCONTO_1,144, 144, 0));
        fieldsSegmentP.add(new FieldNumber(DATA_DESCONTO_1,145, 152, 0L));
        fieldsSegmentP.add(new FieldDecimal(JUROS_MORA_POR_DIA,153, 167, BigDecimal.ZERO));
        fieldsSegmentP.add(new FieldDecimal(VALOR_IOF_RECOLHIDO,168, 182, BigDecimal.ZERO));
        fieldsSegmentP.add(new FieldDecimal(VALOR_ABATIMENTO,183, 197, BigDecimal.ZERO));
        fieldsSegmentP.add(new FieldNumberAutoIncrementable(NOSSO_NUMERO_SEQ,198, 222, 1L, 9999999999L));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_PARA_PROTESTO,223, 223, 3));
        fieldsSegmentP.add(new FieldConstant<>(NUMERO_DIAS_PARA_PROTESTO,224, 225, 0));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_PARA_BAIXA_DEVOLUCAO,226, 226, 0));
        fieldsSegmentP.add(new FieldConstant<>(NUMERO_DIAS_PARA_BAIXA_DEVOLUCAO,227, 229, 0));
        fieldsSegmentP.add(new FieldConstant<>(CODIGO_MOEDA,230, 231, 0));
        fieldsSegmentP.add(new FieldConstant<>(NRO_CONTRATO_OPERACAO_CREDITO,232, 239, 0));
        fieldsSegmentP.add(new FieldConstant<>(FEBRABAN_CNAB,240, 240, ""));

        return Collections.unmodifiableList(fieldsSegmentP);
    }

    public static List<IField<?>> getSegmentQ() {
        List<IField<?>> fieldsSegmentQ = new LinkedList<>();
        fieldsSegmentQ.add(new FieldNumber(CODIGO_BANCO_COMPENSACAO, 1, 3, 1L));
        fieldsSegmentQ.add(new FieldNumber(LOTE_SERVICO, 4, 7, 1L));
        fieldsSegmentQ.add(new FieldNumber(TIPO_REGISTRO, 8, 8, 1L));
        fieldsSegmentQ.add(new FieldNumberAutoIncrementable(SEQUENCIAL_REGISTRO_LOTE, 9, 13, 1L, 99999L));
        fieldsSegmentQ.add(new FieldConstant<>(CODIGO_SEGMENTO_REGISTRO_DETALHE, 14, 14, "Q"));
        fieldsSegmentQ.add(new FieldConstant<>(FEBRABAN_CNAB, 15, 15, ""));
        fieldsSegmentQ.add(new FieldConstant<>(CODIGO_MOVIMENTO_REMESSA, 16, 17, 1));
        fieldsSegmentQ.add(new FieldConstant<>(TIPO_INSCRICAO_PAGADOR, 18, 18, 1));
        // Propagate to NRO_INSCRICAO_PAGADOR - SEGMENT_T
        fieldsSegmentQ.add(new FieldCPFRandom(NRO_INSCRICAO_PAGADOR, 19, 33));

        // 3 campos compõe o nome generico do Pagador
        fieldsSegmentQ.add(new FieldConstant<>(NOME_PAGADOR, 34, 47, CLIENTE));
        fieldsSegmentQ.add(new FieldNumberAutoIncrementable(SEQUENCIAL_NOME_PAGADOR, 48, 57, 1L, 9999999999L));
        fieldsSegmentQ.add(new FieldConstant<>(SIMPLE_CONSTANT, 58, 73, ""));

        fieldsSegmentQ.add(new FieldConstant<>(ENDERECO_PAGADOR, 74, 113, ENDERECO));
        fieldsSegmentQ.add(new FieldConstant<>(BAIRRO_PAGADOR, 114, 128, BAIRRO));
        fieldsSegmentQ.add(new FieldConstant<>(CEP_PAGADOR, 129, 133, CEP_PREFIX));
        fieldsSegmentQ.add(new FieldConstant<>(SUFIX_CEP_PAGADOR, 134, 136, CEP_SUFFIX));
        fieldsSegmentQ.add(new FieldConstant<>(CIDADE_PAGADOR, 137, 151, CIDADE));
        fieldsSegmentQ.add(new FieldConstant<>(UNIDADE_FEDERACAO_PAGADOR, 152, 153, UF));
        fieldsSegmentQ.add(new FieldConstant<>(TIPO_INSCRICAO_EMPRESA, 154, 154, 2));
        fieldsSegmentQ.add(new FieldDataConvenio<>(NRO_INSCRICAO_EMPRESA, 155, 169, BankDataExternalDefinition.Convenio.CONVENIO_CNPJ));
        fieldsSegmentQ.add(new FieldDataConvenio<>(NOME_EMPRESA,170, 209, BankDataExternalDefinition.Convenio.CONVENIO_NOME));
        fieldsSegmentQ.add(new FieldConstant<>(CODIGO_BANCO_CORRESPONDENTE_COMPENSACAO, 210, 212, 0));
        fieldsSegmentQ.add(new FieldConstant<>(NOSSO_NUMERO_BANCO_CORRESPONDENTE, 213, 232, 0));
        fieldsSegmentQ.add(new FieldConstant<>(FEBRABAN_CNAB, 233, 240, ""));

        return Collections.unmodifiableList(fieldsSegmentQ);
    }

    public static List<IField<?>> getSegmentT() {
        List<IField<?>> fieldsSegmentT = new LinkedList<>();
        fieldsSegmentT.add(new FieldNumber(CODIGO_BANCO_COMPENSACAO,1, 3, 1L));
        fieldsSegmentT.add(new FieldNumber(LOTE_SERVICO,4, 7, 1L));
        fieldsSegmentT.add(new FieldConstant<>(TIPO_REGISTRO,8, 8, 1));
        fieldsSegmentT.add(new FieldNumberAutoIncrementable(SEQUENCIAL_REGISTRO_LOTE,9, 13, 1L, 99999L));
        fieldsSegmentT.add(new FieldConstant<>(CODIGO_SEGMENTO_REGISTRO_DETALHE,14,14,"T"));
        fieldsSegmentT.add(new FieldConstant<>(FEBRABAN_CNAB,15, 15, ""));
        // Propagate to CODIGO_MOVIMENTO_RETORNO - SEGMENT_U
        fieldsSegmentT.add(new FieldRandomPositionalPriority<>(CODIGO_MOVIMENTO_RETORNO,16,17, List.of(2L,6L,17L,61L), List.of(3L,30L),8));
        fieldsSegmentT.add(new FieldDataConvenio<>(NRO_AGENCIA_MANTENEDORA,18, 22, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA));
        fieldsSegmentT.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_AGENCIA_MANTENEDORA,23, 23, BankDataExternalDefinition.Convenio.CONVENIO_AGENCIA_DIGITO));
        fieldsSegmentT.add(new FieldDataConvenio<>(NRO_CONTA_CORRENTE,24, 35, BankDataExternalDefinition.Convenio.CONVENIO_CONTA));
        fieldsSegmentT.add(new FieldDataConvenio<>(DIGITO_VERIFICADOR_CONTA_CORRENTE,36, 36, BankDataExternalDefinition.Convenio.CONVENIO_CONTA_DIGITO));
        fieldsSegmentT.add(new FieldConstant<>(DIGITO_VERIFICADOR_AGENCIA_CONTA,37, 37, 0));
        fieldsSegmentT.add(new FieldDataConvenio<>(NOSSO_NUMERO,38, 47, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
        fieldsSegmentT.add(new FieldNumberAutoIncrementable(NOSSO_NUMERO_SEQ,48, 57, 1L, 99999999L));
        fieldsSegmentT.add(new FieldConstant<>(CODIGO_CARTEIRA,58, 58, 7));
        // NUMERO_DOCUMENTO_COBRANCA = Nosso Numero.
            fieldsSegmentT.add(new FieldDataConvenio<>(NUMERO_DOCUMENTO_COBRANCA,59, 65, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
            fieldsSegmentT.add(new FieldNumberAutoIncrementable(NOSSO_NUMERO_SEQ,66, 73, 1L, 99999999L));
        fieldsSegmentT.add(new FieldDateTime(DATA_VENCIMENTO_TITULO,74, 81, PATTERN_DATE,"P10D"));
        fieldsSegmentT.add(new FieldDecimal(VALOR_NOMINAL_TITULO,82, 96, BigDecimal.ZERO));
        fieldsSegmentT.add(new FieldRandomPositional<>(NUMERO_BANCO_AG_COB_REC,97, 99, Arrays.asList(001, 104, 237, 260, 336, 341)));
        fieldsSegmentT.add(new FieldConstant<>(AGENCIA_COBRADORA_RECEBEDORA,100, 104, 0));
        fieldsSegmentT.add(new FieldConstant<>(DIGITO_VERIFICADOR_AGENCIA_COBRADORA_RECEBEDORA,105, 105, ""));
        // IDENTIFICACAO_TITULO_EMPRESA = Nosso Numero.
            fieldsSegmentT.add(new FieldDataConvenio<>(IDENTIFICACAO_TITULO_EMPRESA,106, 112, BankDataExternalDefinition.Convenio.CONVENIO_CONTRATO));
            fieldsSegmentT.add(new FieldNumberAutoIncrementable(NOSSO_NUMERO_SEQ,113, 120, 1L, 99999999L));
            fieldsSegmentT.add(new FieldConstant<>(SIMPLE_CONSTANT,121, 130, ""));
        fieldsSegmentT.add(new FieldConstant<>(CODIGO_MOEDA,131, 132, 0));
        fieldsSegmentT.add(new FieldConstant<>(TIPO_INSCRICAO_PAGADOR,133, 133, 1));
        fieldsSegmentT.add(new FieldString(NRO_INSCRICAO_PAGADOR,134, 148, ""));
        // 3 campos compõe o nome generico do Pagador
            fieldsSegmentT.add(new FieldConstant<>(NOME_PAGADOR, 149, 162, CLIENTE));
            fieldsSegmentT.add(new FieldNumberAutoIncrementable(SEQUENCIAL_NOME_PAGADOR, 163, 172, 1L, 9999999999L));
            fieldsSegmentT.add(new FieldConstant<>(SIMPLE_CONSTANT, 173, 188, ""));
        fieldsSegmentT.add(new FieldConstant<>(NRO_CONTRATO_OPERACAO_CREDITO,189, 198 , 0));
        fieldsSegmentT.add(new FieldDecimal(VALOR_TARIFA_OU_CUSTAS,199, 213, BigDecimal.ZERO));
        fieldsSegmentT.add(new FieldConstant<>(IDENTIFICACAO_REJEICOES_TARIFAS_LIQUID_BAIXAS,214, 223, 0));
        fieldsSegmentT.add(new FieldConstant<>(FEBRABAN_CNAB,224, 240, ""));

        return Collections.unmodifiableList(fieldsSegmentT);
    }

    public static List<IField<?>> getSegmentU() {
        List<IField<?>> fieldsSegmentU = new LinkedList<>();
        fieldsSegmentU.add(new FieldNumber(CODIGO_BANCO_COMPENSACAO, 1, 3, 1L));
        fieldsSegmentU.add(new FieldNumber(LOTE_SERVICO, 4, 7, 1L));
        fieldsSegmentU.add(new FieldNumber(TIPO_REGISTRO, 8, 8, 1L));
        fieldsSegmentU.add(new FieldNumberAutoIncrementable(SEQUENCIAL_REGISTRO_LOTE, 9, 13, 1L, 99999L));
        fieldsSegmentU.add(new FieldConstant<>(CODIGO_SEGMENTO_REGISTRO_DETALHE, 14, 14, "U"));
        fieldsSegmentU.add(new FieldConstant<>(FEBRABAN_CNAB, 15, 15, ""));
        fieldsSegmentU.add(new FieldNumber(CODIGO_MOVIMENTO_RETORNO, 16, 17, 0L));
        fieldsSegmentU.add(new FieldConstant<>(JUROS_MULTAS_ENCARGOS, 18, 32, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldConstant<>(VALOR_DESCONTO_CONCEDIDO, 33, 47, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldConstant<>(VALOR_ABATIMENTO_APOS_CONCEDIDO, 48, 62, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldConstant<>(VALOR_IOF_RECOLHIDO, 63, 77, BigDecimal.ZERO));
        // Valor porcentual do VALOR DO TITULO - SEGMENT_P ---->> Valor % Random entre 10 e 100%
        fieldsSegmentU.add(new FieldDecimal(VALOR_PAGO_PELO_SACADO, 78, 92, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldConstant<>(VALOR_LIQUIDO_CREDITADO, 93, 107, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldConstant<>(VALOR_OUTRAS_DESPESAS, 108, 122, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldConstant<>(VALOR_OUTROS_CREDITOS, 123, 137, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldDateTime(DATA_OCORRENCIA_RETORNO,138, 145, PATTERN_DATE,"P9D"));
        fieldsSegmentU.add(new FieldConstant<>(DATA_EFETIVACAO_CREDITO_RETORNO, 146, 153, 0));
        fieldsSegmentU.add(new FieldConstant<>(CODIGO_OCORRENCIA_PAGADOR, 154, 157, 0));
        fieldsSegmentU.add(new FieldConstant<>(DATA_OCORRENCIA_PAGADOR, 158, 165, 0));
        fieldsSegmentU.add(new FieldConstant<>(VALOR_OCORRENCIA_PAGADOR, 166, 180, BigDecimal.ZERO));
        fieldsSegmentU.add(new FieldConstant<>(COMPLEMENTO_OCORRENCIA_PAGADOR, 181, 210, BigDecimal.ZERO));

        fieldsSegmentU.add(new FieldConstant<>(CODIGO_BANCO_CORRESPONDENTE_COMPENSACAO, 211, 213, 0));
        fieldsSegmentU.add(new FieldConstant<>(NOSSO_NUMERO_BANCO_CORRESPONDENTE, 213, 232, 0));
        fieldsSegmentU.add(new FieldConstant<>(FEBRABAN_CNAB, 233, 240, ""));

        return Collections.unmodifiableList(fieldsSegmentU);

    }

}
