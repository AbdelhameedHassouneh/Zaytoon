package com.avo.avocado.utils.Exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class UserNotFoundException extends  Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException() {
        super();
    }


}
