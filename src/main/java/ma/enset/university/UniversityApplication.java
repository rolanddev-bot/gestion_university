package ma.enset.university;

import ma.enset.university.entities.Product;
import ma.enset.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

	@Autowired
	//Autowired permet de faire une injection de dependance
	private ProductRepository productRepository ;
	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}
	public  void run(String... args) throws Exception{
		//productRepository.save(new Product(null,"computer",3500,2));
		//productRepository.save(new Product(null,"printer",5000,10));
		//productRepository.save(new Product(null,"fourchette",1500,3));


		//ci-dessous c'est une methode qui permet d'afficher les products
		List<Product> products =productRepository.findAll();
		products.forEach(product -> {
			System.out.println(product.toString());
		});
		//si tu veux retourner une seule valeur
		Product product =productRepository.findById(Long.valueOf(1)).get();
		System.out.println("****************************");
		System.out.println(product.getId());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		System.out.println("montant ttc est :"+product.getPrice()*product.getQuantity());
		System.out.println("*********************");

		//AFFICHER LES PRODUITS QUI CONTIENNENT DES CARACTERES SPECIAUX
		List<Product> productList = productRepository.findByNameContains("com");
		productList.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("---------------------------------------------");

		//2eme maniere d'AFFICHER LES PRODUITS QUI CONTIENNENT DES CARACTERES SPECIAUX
		List<Product> productList2 = productRepository.search("%fourch%");
		productList2.forEach(p->{
			System.out.println(p.toString());
		});

		System.out.println("** *****premiere methode affiche recherche par prix ******");
		//2eme maniere d'AFFICHER LES PRODUITS QUI CONTIENNENT DES CARACTERES SPECIAUX
		List<Product> productList3 = productRepository.findByPriceGreaterThan(5000);
		productList3.forEach(p->{
			System.out.println(p.toString());
		});

		System.out.println("*********** deuxieme methode affiche recherche par prix ************");
		List<Product> productList4 = productRepository.searchByprice(4500);
		productList4.forEach(p->{
			System.out.println(p.toString());
		});

	}

}
