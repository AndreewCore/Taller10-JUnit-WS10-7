/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorsmp;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author CltControl
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {

    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        private String formula1 = "3/4";
        private String formula2 = "100*100*100*100";
        private String formula3 = "4*3+2*4";
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    private boolean isInteger(String cadena) {
        try {
            Integer.valueOf(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Test of MakeFormula method, of class Operations.
     */
    @Test
    public void testMakeFormulaValidFormat() {
        System.out.println("MakeFormula Valid Format");
        String result = Operations.MakeFormula();
        ArrayList<Character> operators = new ArrayList<>(Arrays.asList('*', '+', '-', '/'));

        int i = 0;
        boolean expectNumber = true;

        while (i < result.length()) {
            if (expectNumber) {
                // Buscar número de 1 o 2 dígitos
                int start = i;
                while (i < result.length() && Character.isDigit(result.charAt(i))) {
                    i++;
                }
                String number = result.substring(start, i);
                assertTrue(isInteger(number));
                expectNumber = false;
            } else {
                // Validar operador
                char operator = result.charAt(i);
                assertTrue(operators.contains(operator));
                i++;
                expectNumber = true;
            }
        }

        // Asegura que la fórmula no termine con un operador
        assertFalse(expectNumber);
    }
@Test
@DisplayName("comprueba si se pueden realizar operaciones con resultados menores a 1")
public void TestSolve(){
    String resultado = Operations.Solve(formula1);
    assertTrue(Integer.valueOf(resultado) < 1);

}


@Test
@DisplayName("Comprueba para el maximo resultado posible")
public void TestSolve2(){
    String resultado = Operations.Solve(formula2);
    assertEquals(resultado, formula2+"=100000000");
}


@Test
@DisplayName("Comprueba si sigue orden de jerarquias")
public void TestSolve3(){
    String resultado = Operations.Solve(formula3);
    assertEquals(resultado, formula3+"=20");
}
    
}
