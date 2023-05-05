package com.neonatal.backend.models;

public class LoginObjectPOJO {
	
    String tokenString = new String();
    String roleIDString = new String();

    public LoginObjectPOJO(String tokenString, String roleIDString) {
        this.tokenString = tokenString;
        this.roleIDString = roleIDString;
    }

    public String getToken() {
        return tokenString;
    }

    public void setRuleName(String tokenString) {
        this.tokenString = tokenString;
    }

    public String getRoleID() {
        return roleIDString;
    }

    public void setRoleID(String roleIDString) {
        this.roleIDString = roleIDString;
    }
	
}