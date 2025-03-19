package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (inhousePartRepository.count() == 0) {
            // Create an object from InhousePart class
            InhousePart ihp1 = new InhousePart();
            // Setting the values
            ihp1.setName("LED Light");
            ihp1.setInv(50);
            ihp1.setPrice(1.00);
            ihp1.setId(2);
            ihp1.setMinInv(1);
            ihp1.setMaxInv(100);
            //Saving in inhousepartrespository
            inhousePartRepository.save(ihp1);

            // Create an object from InhousePart class
            InhousePart ihp2 = new InhousePart();
            // Setting the values
            ihp2.setName("Resistor");
            ihp2.setInv(50);
            ihp2.setPrice(0.25);
            ihp2.setId(3);
            ihp2.setMinInv(1);
            ihp2.setMaxInv(200);
            //Saving in inhousepartrespository
            inhousePartRepository.save(ihp2);
        }

        if (outsourcedPartRepository.count() == 0) {
            //Creating an object in OutsourcedPart class
            OutsourcedPart osp1 = new OutsourcedPart();
            //Setting the values
            osp1.setCompanyName("HP");
            osp1.setName("Capacitor");
            osp1.setInv(50);
            osp1.setPrice(0.50);
            osp1.setId(1);
            osp1.setMinInv(1);
            osp1.setMaxInv(100);
            //Saving in outsourcedPartRepository
            outsourcedPartRepository.save(osp1);

            //Creating an object in OutsourcedPart class
            OutsourcedPart osp2 = new OutsourcedPart();
            //Setting the values
            osp2.setCompanyName("HP");
            osp2.setName("Transistor");
            osp2.setInv(50);
            osp2.setPrice(0.75);
            osp2.setId(4);
            osp2.setMinInv(1);
            osp2.setMaxInv(120);
            //Saving in outsourcedPartRepository
            outsourcedPartRepository.save(osp2);

            //Creating an object in OutsourcedPart class
            OutsourcedPart osp3 = new OutsourcedPart();
            //Setting the values
            osp3.setCompanyName("HP");
            osp3.setName("IC Chip");
            osp3.setInv(50);
            osp3.setPrice(2.50);
            osp3.setId(5);
            osp3.setMinInv(1);
            osp3.setMaxInv(100);
            //Saving in outsourcedPartRepository
            outsourcedPartRepository.save(osp3);
        }


        //Products

        if (productRepository.count() == 0) {
            // Create and save Products
            Product bluetooth_Speaker = new Product("Bluetooth Speaker", 25.00, 20);
            Product smartphone_Case = new Product("Smartphone Case", 10.00, 40);
            Product hdmi_Cable = new Product("HDMI Cable", 8.00, 30);
            Product power_Bank = new Product("Power Bank", 20.00, 15);
            Product wireless_Mouse = new Product("Wireless Mouse", 12.00, 25);

            productRepository.save(bluetooth_Speaker);
            productRepository.save(smartphone_Case);
            productRepository.save(hdmi_Cable);
            productRepository.save(power_Bank);
            productRepository.save(wireless_Mouse);
        }



       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
