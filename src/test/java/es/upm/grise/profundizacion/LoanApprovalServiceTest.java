package es.upm.grise.profundizacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import es.upm.grise.profundizacion.LoanApprovalService.Applicant;
import es.upm.grise.profundizacion.LoanApprovalService.Decision;

public class LoanApprovalServiceTest {
    
    private final LoanApprovalService service = new LoanApprovalService();

    

    @Test
    void caso_camino_basico_1(){
        Applicant applicant = new Applicant( 2401, 650, false, false);
        int amountRequested = -1;
        int termMonths = 12;
        Exception exception=assertThrows(IllegalArgumentException.class, () -> service.evaluateLoan(applicant, amountRequested, termMonths));
        assertNotNull(exception);

    }

    @Test
    void caso_camino_basico_2a(){
        Applicant applicant = new Applicant( 2401, 650, false, false);
        int amountRequested = 2000;
        int termMonths = 3;
        Exception exception=assertThrows(IllegalArgumentException.class, () -> service.evaluateLoan(applicant, amountRequested, termMonths));
        assertNotNull(exception);

    }

    @Test
    void caso_camino_basico_2b(){
        Applicant applicant = new Applicant( 2401, 650, false, false);
        int amountRequested = 2000;
        int termMonths = 85;
        Exception exception=assertThrows(IllegalArgumentException.class, () -> service.evaluateLoan(applicant, amountRequested, termMonths));
        assertNotNull(exception);

    }

    @Test
    void caso_camino_basico_3(){
        Applicant applicant = new Applicant( 0, 650, false, false);
        int amountRequested = 2000;
        int termMonths = 7;
        Exception exception=assertThrows(IllegalArgumentException.class, () -> service.evaluateLoan(applicant, amountRequested, termMonths));
        assertNotNull(exception);

    }

    @Test
    void caso_camino_basico_4a(){
        Applicant applicant = new Applicant( 2000, -1, false, false);
        int amountRequested = 2000;
        int termMonths = 7;
        Exception exception=assertThrows(IllegalArgumentException.class, () -> service.evaluateLoan(applicant, amountRequested, termMonths));
        assertNotNull(exception);

    }

    
    @Test
    void caso_camino_basico_4b(){
        Applicant applicant = new Applicant( 2000, 851, false, false);
        int amountRequested = 2000;
        int termMonths = 7;
        Exception exception=assertThrows(IllegalArgumentException.class, () -> service.evaluateLoan(applicant, amountRequested, termMonths));
        assertNotNull(exception);

    }
    @Test
    void caso_camino_basico_5() {
        
        
        Applicant applicant = new Applicant( 400, 450, false, false);
        int amountRequested = 10000;
        int termMonths = 12;
        assertEquals(Decision.REJECTED.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }

    @Test
    void caso_camino_basico_6a(){
        Applicant applicant = new Applicant( 2501, 601, false, true);
        int amountRequested = 20000;
        int termMonths = 12;
        assertEquals(Decision.APPROVED.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }
    

    @Test
    void caso_camino_basico_6b(){
        Applicant applicant = new Applicant( 2501, 601, false, false);
        int amountRequested = 20000;
        int termMonths = 12;
        assertEquals(Decision.MANUAL_REVIEW.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }

    @Test
    void caso_camino_basico_6c(){
        Applicant applicant = new Applicant( 2501, 500, false, true);
        int amountRequested = 20000;
        int termMonths = 12;
        assertEquals(Decision.MANUAL_REVIEW.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }

    
    @Test
    void caso_camino_basico_7(){
        Applicant applicant = new Applicant( 2501, 601, true, true);
        int amountRequested = 20000;
        int termMonths = 12;
        assertEquals(Decision.REJECTED.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }
    @Test
    void caso_camino_basico_8(){
        Applicant applicant = new Applicant( 2401, 601, false, true);
        int amountRequested = 20000;
        int termMonths = 12;
        assertEquals(Decision.REJECTED.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }

    @Test
    void caso_camino_basico_9a(){
        Applicant applicant = new Applicant( 2401, 650, false, true);
        int amountRequested = 2000;
        int termMonths = 12;
        assertEquals(Decision.APPROVED.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }
    @Test
    void caso_camino_basico_9b(){
        Applicant applicant = new Applicant( 2501, 651, true, true);
        int amountRequested = 250000;
        int termMonths = 12;
        assertEquals(Decision.MANUAL_REVIEW.toString(), service.evaluateLoan(applicant, amountRequested, termMonths).toString());
    }
    
}
