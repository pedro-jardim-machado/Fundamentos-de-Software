// package com.exemplo;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @CrossOrigin("*")
// public class ControllerJava {

//         Livro livro1 = new Livro(1, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
//         Livro livro2 = new Livro(2, "1984", "George Orwell", 1949);
//         Livro livro3 = new Livro(3, "Dom Quixote", "Miguel de Cervantes", 1605);
//         Livro livro4 = new Livro(4, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
//         Livro livro5 = new Livro(5, "A Arte da Guerra", "Sun Tzu", 500); 

//         List<Livro> listaDeLivros = new LinkedList<>();

//         listaDeLivros.add(livro1);
//         listaDeLivros.add(livro2);
//         listaDeLivros.add(livro3);
//         listaDeLivros.add(livro4);
//         listaDeLivros.add(livro5);

//         @GetMapping()
//         public String GetMapping() {
//             return "Está funcionando";
//         }

//         @GetMapping("livros")
//         public List<Livro> GetListaLivros(){
//             return listaDeLivros;
//         }

//         @GetMapping("LivroAutor")
//         public List<Livro> getLivrosDoAutor(@RequestParam(value="autor") String autor) {
//             String aux = autor.trim();
//             return listaDeLivros.stream()
//             .filter(livro -> livro.autor.equals(aux))
//             .toList();
//         }

        
//         @GetMapping("LivroAno")
//         public List<Livro> getLivrosDoAno(@RequestParam(value="ano") int ano) {
//             return listaDeLivros.stream()
//             .filter(livro -> livro.getAno() == ano)
//             .toList();
//         }

//         @Post()
//         public void CadadastraLivro(Livro livro){
//             listaLivro.add(livro);
//             return;
//         }
// }



package com.exemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin("*")
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getListaLivros() {
        return livroService.findAllLivros();
    }

    @GetMapping("/autor")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return livroService.findLivrosByAutor(autor);
    }

    @GetMapping("/ano")
    public List<Livro> getLivrosDoAno(@RequestParam(value = "ano") int ano) {
        return livroService.findLivrosByAno(ano);
    }

    @PostMapping
    public ResponseEntity<Void> cadastraLivro(@RequestBody Livro livro) {
        livroService.addLivro(livro);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
