package org.elms.dao;

import org.elms.model.Login;

public interface LoginDao {
    Login validate(Login login);
}
