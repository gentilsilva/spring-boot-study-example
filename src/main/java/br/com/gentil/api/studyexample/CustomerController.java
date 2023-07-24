package br.com.gentil.api.studyexample;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer(request.name(), request.email(), request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        customerRepository.deleteById(id);
    }

    @PutMapping()
    public Customer updateCustomer(@RequestBody UpdateCustomerRequest request) {
        Customer customer = customerRepository.getReferenceById(request.id());

        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());

        customerRepository.save(customer);

        return customer;
    }

}
