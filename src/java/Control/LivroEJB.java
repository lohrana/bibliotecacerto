
package Control;

import Model.Livro;
import Model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LivroEJB {

    @PersistenceContext(unitName="testePU")
    EntityManager em;
    
    public void salvarLivro(Livro livro){
        try {
            em.merge(livro);
            System.out.println("salvou livro");
        } catch (Exception e) {
            System.out.println("nao salvou livro");
        }
    }
    
    public void apagaLivro(Livro livro){
        em.getTransaction().begin();
        em.remove(livro);
        em.getTransaction().commit();
    }
     
    public List<Livro> mostraLivros(){
        Query query = em.createQuery("select l from Livro l");
        return query.getResultList();
    }
}
