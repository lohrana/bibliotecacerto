
package Control;

import Model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioEJB {

    @PersistenceContext(unitName="testePU")
    EntityManager em;
    
    public void salvarUsuario(Usuario usuario){
        try {
            em.merge(usuario);
            System.out.println("salvou usuario");
        } catch (Exception e) {
            System.out.println("nao salvou usuario");
        }
    }
    
    public List<Usuario> mostraUsuarios(){
        Query query = em.createQuery("select u from Usuario u");
        return query.getResultList();
    }
    
    public void apagaUsuario(Usuario usuario){
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }
}
