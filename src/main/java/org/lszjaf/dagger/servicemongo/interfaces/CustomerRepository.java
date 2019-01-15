package org.lszjaf.dagger.servicemongo.interfaces;

import org.lszjaf.dagger.servicemongo.bean.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}
