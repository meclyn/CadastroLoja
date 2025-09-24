package matheus.dev.CadastroLoja.Cliente;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClienteController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "boas vindas ao /cliente";
    }
}
