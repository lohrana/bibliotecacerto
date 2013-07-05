
package View;

import Control.LivroEJB;
import Control.UsuarioEJB;
import Model.Livro;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LivroMB {

    @EJB
    LivroEJB livroejb;
    Livro livro;
    
    public LivroMB() {
        livro = new Livro();
    }
    
    public void salvarLivro(){
        livroejb.salvarLivro(livro);
    }
    
    public void apagaLivro(){
        livroejb.apagaLivro(livro);
    }
    
    public List<Livro> mostraLivro(){
        return livroejb.mostraLivros();
        
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    
}
