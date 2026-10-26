package example.cashcard;

import org.springframework.data.annotation.Id;

record Customer(@Id Long id, String username, String password) {
}
