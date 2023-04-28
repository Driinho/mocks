package ifpr.pgua.eic.tvs.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CarteiraTest {
    

    @Test
    public void verificaTamanhoCarteira() {
        
        // Cenaria
        Acao acao = AcaoBuilder.umaAcao().comQuantidade(10).agora();
        Acao acao2 = AcaoBuilder.umaAcao().comQuantidade(12).agora();
        List<Acao> acoes = new ArrayList<>();

        acoes.add(acao);
        acoes.add(acao2);

        Carteira carteira = new Carteira(null);

        carteira.setCarteira(acoes);

        // Ação
        int tamanhoObtido = carteira.tamanhoCarteira();

        // Verificação
        assertNotNull(carteira.getCarteira());
        assertEquals(22, tamanhoObtido);

        assertTrue(true);
    }

    @Test
    public void verificaValorMercado() {
        // Cenario        
        AcaoServiceStub acaoService = new AcaoServiceStub();

        Map<String, Double> bancoAcoes = new HashMap<>();

        bancoAcoes.put("Tesla",  15.0);
        bancoAcoes.put("Alphabet",  25.0);
        bancoAcoes.put("Microsoft",  10.0);
        bancoAcoes.put("Meta",  5.0);

        acaoService.setBancoAcoes(bancoAcoes);

        Carteira carteira = new Carteira(acaoService);

        List<Acao> acoes = new ArrayList<>();
        acoes.add(AcaoBuilder.umaAcao().comNomeEmpresa("Tesla").comQuantidade(2).agora());
        acoes.add(AcaoBuilder.umaAcao().comNomeEmpresa("Meta").comQuantidade(1).agora());
        acoes.add(AcaoBuilder.umaAcao().comNomeEmpresa("Microsoft").comQuantidade(3).agora());

        carteira.setCarteira(acoes);
        
        double valorEsperado = 65;

        // Ação
        double valorObtido = carteira.calculaValorMercado();

        // Verificação
        assertEquals(valorEsperado, valorObtido);


    }
}
