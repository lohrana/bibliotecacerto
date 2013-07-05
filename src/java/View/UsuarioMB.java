
package View;

import Control.UsuarioEJB;
import Model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UsuarioMB {

    @EJB
    UsuarioEJB usuarioEJB;
    Usuario usuario;
    
    public UsuarioMB() {
        usuario = new Usuario();
    }
    
    public void salvarUsuario(){
        usuarioEJB.salvarUsuario(usuario);
    }
    
    public List<Usuario> mostraUsuarios(){
        return usuarioEJB.mostraUsuarios();
    }
    
    public void apagaUsuario(){
        usuarioEJB.apagaUsuario(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
