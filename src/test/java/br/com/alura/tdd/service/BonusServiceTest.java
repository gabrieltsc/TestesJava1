package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

public class BonusServiceTest {
    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class, () ->
                service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
                new BigDecimal("25000")))); // Valor tem que ser maior que 10000 para dar zero

        /*try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
                    new BigDecimal("25000")));
            fail("Não deu a exception"); // Só cairá nessa linha se não houver exception
        } catch (Exception e) {
            assertEquals("Funcionário com salário maior que R$10000 não pode receber bônus.", e.getMessage());
        }*/
    }

    @Test
    public void bonusDeveriaSerDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
                new BigDecimal("2500"))); // Valor tem que ser maior que 10000 para dar zero

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
                new BigDecimal("10000"))); // Valor tem que ser maior que 10000 para dar zero

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
