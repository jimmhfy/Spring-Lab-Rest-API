package example.cashcard;

import org.springframework.data.repository.CrudRepository;


interface UserRepository extends CrudRepository<Customer, Long> {
    Customer findUserByUsername(String username);
}
