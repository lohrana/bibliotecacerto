
package Control;

import Model.Emprestimo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EmprestimoEJB {
    
    @PersistenceContext(unitName="testePU")
    EntityManager em;
    
    public void salvarEmprestimo(Emprestimo emprestimo){
        try {
            em.merge(emprestimo);
            System.out.println("salvou emprestimo");
        } catch (Exception e) {
            System.out.println("nao salvou emprestimo");
        }
    }
    
    public List<Emprestimo> mostraEmprestimos(){
        Query query = em.createQuery("select e from Emprestimo e");
        return query.getResultList();
    }
    
    public void apagaEmprestimo(Emprestimo emprestimo){
        em.getTransaction().begin();
        em.remove(emprestimo);
        em.getTransaction().commit();
    }
}
