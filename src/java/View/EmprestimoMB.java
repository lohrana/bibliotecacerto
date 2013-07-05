
package View;

import Control.EmprestimoEJB;
import Model.Emprestimo;
import Model.Livro;
import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EmprestimoMB {

    @EJB
    EmprestimoEJB emprestimoEJB;
    Emprestimo emprestimo;
    Livro livro;
    List<Livro> livros;
    Usuario usuario;
    
    public EmprestimoMB() {
        emprestimo = new Emprestimo();
        livros = new ArrayList<Livro>();
        usuario = new Usuario();
        livro = new Livro();
    }
    
    public void salvarEmprestimo(){
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimoEJB.salvarEmprestimo(emprestimo);
    }
    
    public List<Emprestimo> mostraEmprestimos(){
        return emprestimoEJB.mostraEmprestimos();        
    }
    
    public void apagaEmprestimo(){
        emprestimoEJB.apagaEmprestimo(emprestimo);
    }
    
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
    
}
